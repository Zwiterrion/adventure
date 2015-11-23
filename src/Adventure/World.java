package Adventure;

import Adventure.Interface.Deplacable;
import Adventure.Interface.Fixe;
import Adventure.Interface.Piege;
import Adventure.Interface.Ramassable;
import Adventure.ObjetsCarte.*;
import Adventure.Places.*;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.util.List;

public class World extends JPanel {

    // Map
    private Hashtable<Position, ObjetCarte> mapObjects;
    private Hashtable<Position, ObjetCarte> mapSol;

    private Position positions[][];

    private Heros heros;
    private List<Personnage> personnages;

    private Place placeCourante;

    public UIutilisateur ath;
    private Annonce annonce;

    // Constantes
    public static int TILE_SIZE;
    public static int SCREEN_SIZE;
    public static int X_MAX;
    public static int Y_MAX;

    public World(int X_MAX, int Y_MAX, int screen_size) {
        World.X_MAX = X_MAX;
        World.Y_MAX = Y_MAX;

        SCREEN_SIZE = screen_size;
        TILE_SIZE = (SCREEN_SIZE / X_MAX );

        heros = new Heros(this);
        ath = new UIutilisateur(heros);

        annonce = new Annonce(SCREEN_SIZE, 50);

        initialisationNiveau(null);
    }

    @Override
    public void paint(Graphics g) {

        super.paint(g);
        g.setColor(new Color(10, 55, 51));
        g.fillRect(0, 0, SCREEN_SIZE, SCREEN_SIZE);

        dessineSol(g);
        dessineObjetsMap(g);
        dessineATH(g);
    }

    public void dessineSol(Graphics g) {

        for (int i = 0; i < X_MAX; i++) {
            for (int j = Y_MAX - 1; j >= 0; j--) {
                Position point = IsometricHelper.point2DToIso(new Position(j, i));
                ObjetCarte object = mapSol.get(positions[i][j]);
                if (!(object instanceof Vide))
                    g.drawImage(object.getImage(), point.x, point.y, TILE_SIZE, (TILE_SIZE * 2), this);
            }
        }

    }

    public void dessineObjetsMap(Graphics g) {

        for (int i = 0; i < X_MAX; i++) {
            for (int j = Y_MAX - 1; j >= 0; j--) {
                Position point = IsometricHelper.point2DToIso(new Position(j, i));
                ObjetCarte object = mapObjects.get(positions[i][j]);

                if(object instanceof Personnage) {
                    g.drawImage(object.getImage(),point.x + ((Personnage) object).x, point.y + ((Personnage) object).y, TILE_SIZE, TILE_SIZE*2, this);
                }
                else {
                    if (!(object instanceof Vide))
                        g.drawImage(object.getImage(), point.x, point.y, TILE_SIZE, TILE_SIZE * 2, this);

                    if (i == heros.getPos_in().x && j == heros.getPos_in().y)
                        g.drawImage(heros.getImage(), point.x, point.y, TILE_SIZE, TILE_SIZE * 2, this);
                }
            }
        }
    }

    public void dessineATH(Graphics g) {
        ath.paint(g);
    }

    public Boolean videOuPas(Position p, Direction dir, int x, int y) {

        ObjetCarte object = mapObjects.get(positions[p.x][p.y]);
        ObjetCarte objectSol = mapSol.get(positions[p.x][p.y]);

        if (objectSol instanceof Fixe) {

            if (objectSol instanceof Piege) {
                heros.perdVie(((Piege) objectSol).degat());
                return true;
            }
            else if (object instanceof Piege) {
                heros.perdVie(((Piege) object).degat());
                return false;
            }
            else if (object instanceof Sortie) {
                niveauSuivant(x, y, dir, (Sortie) object);
                return false;
            } else if (object instanceof Ramassable) {
                heros.ramasserObjet((Ramassable) object);
                mapObjects.put(positions[p.x][p.y], new Vide());
                return true;
            } else if (object instanceof Deplacable) {
                deplaceObjet(p, dir, x, y);
                return false;
            } else
                return !(object instanceof Fixe);
        } else
            return false;
    }

    public void deplaceObjet(Position positionWall, Direction dir, int x, int y) {

        Position p = new Position(positionWall.x + x, positionWall.y + y);

        if ((p.x >= 0 && p.x < X_MAX) && (p.y >= 0 && p.y < Y_MAX)) {

            ObjetCarte object = mapObjects.get(positions[p.x][p.y]);
            ObjetCarte objectSol = mapSol.get(positions[p.x][p.y]);

            if (object instanceof Vide) {

                if (objectSol instanceof Fixe) {
                    Deplacable w = (Deplacable) mapObjects.get(positions[positionWall.x][positionWall.y]);
                    mapObjects.put(positions[p.x][p.y], (ObjetCarte) w);
                } else
                    mapSol.put(positions[p.x][p.y], new Herbe(Direction.AUCUNE));

                mapObjects.put(positions[positionWall.x][positionWall.y], new Vide());
                heros.setPos_in(positionWall);
                heros.changeImage(dir);
                repaint();
            }
        }
    }

    public void niveauSuivant(int x, int y, Direction dir, Sortie s) {

        personnages.forEach(Personnage::stop);
        deplacement(x, y, dir);
        attente(300);

        if(s instanceof SortieFermee) {
            if(((SortieFermee) s).isOuverte())
                teleportation(s);
        }
        else
            teleportation(s);
    }

    public void teleportation(Sortie s) {
        initialisationNiveau(s);
        pageDeDescription();
        attente(1000);
        repaint();
    }

    public void pageDeDescription() {

        Graphics g = getGraphics();
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, SCREEN_SIZE, SCREEN_SIZE);
        annonce.setAnnonce(placeCourante.getNom());
        annonce.paint(g);
    }

    public void attente(int time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void initialisationNiveau(Sortie s) {

        if (s == null)
            placeCourante = new Parking(heros);
        else
            placeCourante = placeCorrespondante(s.getDestination());

        mapObjects = placeCourante.getMapObjects();
        mapSol = placeCourante.getMapSol();
        personnages = placeCourante.getPersonnages();
        positions = placeCourante.getPositions();

        heros.setPos_in(placeCourante.getHeros().getPos_in());

        placeCourante.lancePersonnage();
    }

    public Place placeCorrespondante(String s) {

        if (s.equals("SP2MI"))
            return new SP2MI(heros);
        else if(s.equals("IFMI"))
            return new IFMI(heros);
        else if(s.equals("SALLE TP"))
            return new TP(heros);
        else if(s.equals("BIBLIOTHEQUE"))
            return new BU(heros);
        else
            return new Parking(heros);
    }

    public void deplacementHeros(int x, int y, Direction dir) {

        Position nextPos = new Position(heros.getPos_in().x + x, heros.getPos_in().y + y);

        if(positionInGrille(nextPos))
            if (videOuPas(nextPos, dir, x, y))
                deplacement(x, y, dir);
    }

    public void deplacement(int x, int y, Direction dir) {

        heros.setPos_in(new Position(heros.getPos_in().x + x, heros.getPos_in().y + y));
        heros.changeImage(dir);
        paint(getGraphics());
    }

    public Heros getHeros() {
        return heros;
    }

    public void changePositionPersonnage(Position e, Position precedente, Personnage personnage) {

        mapObjects.put(positions[precedente.x][precedente.y], new Vide());
        mapObjects.put(positions[e.x][e.y], personnage);
        paint(getGraphics());
    }

    public boolean estUnVide(Position nextPos, Personnage p) {
        if(positionInGrille(nextPos)) {
            if(nextPos.x == heros.getPos_in().x && nextPos.y == heros.getPos_in().y) {
                heros.perdVie(p.degat());
                return false;
            }
            else
                return (mapObjects.get(positions[nextPos.x][nextPos.y]) instanceof Vide &&
                        !(mapSol.get(positions[nextPos.x][nextPos.y]) instanceof Vide));
        }
        return false;
    }

    public boolean poseBombe() {

        if(heros.getMana() >= 10 && heros.getInventaire().nbClefs > 0) {
            heros.perdMana(10);
            ObjetCarte c = mapObjects.get(positions[heros.getPos_in().x][heros.getPos_in().y]);
            if(c instanceof SortieFermee) {
                ((SortieFermee) c).enExplosion();
                repaint();
                attente(500);
                lanceAnimationOuverture();
                repaint();
                attente(500);
                ((SortieFermee) c).ouvre();
            }
            else
                mapObjects.put(positions[heros.getPos_in().x][heros.getPos_in().y], new Clef());

            repaint();
            return true;
        }else
            return false;
    }

    public boolean positionInGrille(Position nextPos) {
        return ((nextPos.x >= 0 && nextPos.x < X_MAX) && (nextPos.y >= 0 && nextPos.y < Y_MAX));
    }

    public boolean lanceAnimationOuverture() {

        Position pHeros = new Position(heros.getPos_in().x, heros.getPos_in().y);

        if(positionInGrille(new Position(pHeros.x+1, pHeros.y))) {
            if(mapObjects.get(positions[pHeros.x+1][pHeros.y]) instanceof Vide) {
                deplacement(1, 0, Direction.OUEST);
                return true;
            }

        }
        if(positionInGrille(new Position(pHeros.x-1, pHeros.y))) {
            if(mapObjects.get(positions[pHeros.x-1][pHeros.y]) instanceof Vide) {
                deplacement(-1, 0, Direction.EST);
                return true;
            }
        }
        if(positionInGrille(new Position(pHeros.x, pHeros.y+1))) {
            if(mapObjects.get(positions[pHeros.x][pHeros.y+1]) instanceof Vide) {
                deplacement(0, 1, Direction.NORD);
                return true;
            }
        }
        else {
            deplacement(0,-1,Direction.SUD);
            return true;
        }

        return true;

    }
}

