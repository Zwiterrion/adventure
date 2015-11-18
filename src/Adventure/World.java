package Adventure;

import Adventure.Interface.Deplacable;
import Adventure.Interface.Fixe;
import Adventure.Interface.Piege;
import Adventure.Interface.Ramassable;
import Adventure.ObjetsCarte.Herbe;
import Adventure.ObjetsCarte.ObjetCarte;
import Adventure.ObjetsCarte.Sortie;
import Adventure.ObjetsCarte.Vide;
import Adventure.Places.Futuroscope;
import Adventure.Places.Place;
import Adventure.Places.SP2MI;

import javax.swing.*;
import java.awt.*;
import java.util.Hashtable;

public class World extends JPanel {

    // Map
    private Hashtable<Position, ObjetCarte> mapObjects;
    private Hashtable<Position, ObjetCarte> mapSol;

    private Position positions[][];

    private Heros heros;

    private Place placeCourante;

    public UIutilisateur ath;
    public Annonce annonce;

    // Constantes
    public static int TILE_SIZE;
    public static int SCREEN_SIZE;
    public static int X_MAX;
    public static int Y_MAX;

    public World(int X_MAX, int Y_MAX, int screen_size) {
        this.X_MAX = X_MAX;
        this.Y_MAX = Y_MAX;

        SCREEN_SIZE = screen_size;
        TILE_SIZE = SCREEN_SIZE / X_MAX;

        heros = new Heros(this);
        ath = new UIutilisateur(heros);

        annonce = new Annonce(SCREEN_SIZE);

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
                    g.drawImage(object.getImage(), point.x, point.y, TILE_SIZE, TILE_SIZE * 2, this);
            }
        }

    }

    public void dessineObjetsMap(Graphics g) {

        for (int i = 0; i < X_MAX; i++) {
            for (int j = Y_MAX - 1; j >= 0; j--) {
                Position point = IsometricHelper.point2DToIso(new Position(j, i));
                ObjetCarte object = mapObjects.get(positions[i][j]);

                if (!(object instanceof Vide))
                    g.drawImage(object.getImage(), point.x, point.y, TILE_SIZE, TILE_SIZE * 2, this);

                if (i == heros.getPos_in().x && j == heros.getPos_in().y)
                    g.drawImage(heros.getImage(), point.x, point.y, TILE_SIZE, TILE_SIZE * 2, this);
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
            } else if (object instanceof Sortie) {
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
                    mapSol.put(positions[p.x][p.y], new Herbe(-1));

                mapObjects.put(positions[positionWall.x][positionWall.y], new Vide());
                heros.setPos_in(positionWall);
                heros.changeImage(dir);
                repaint();
            }
        }
    }

    public void niveauSuivant(int x, int y, Direction dir, Sortie s) {

        deplacement(x, y, dir);
        attente(300);
        pageDeDescription();
        attente(1000);
        initialisationNiveau(s);
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
            placeCourante = new Futuroscope(heros);
        else {
            placeCourante = placeCorrespondante(s.getDestination());
            placeCourante.setNom(s.getNomPlace());
        }


        annonce.setAnnonce(placeCourante.getNom());

        mapObjects = placeCourante.getMapObjects();
        mapSol = placeCourante.getMapSol();

        positions = placeCourante.getPositions();

        heros.setPos_in(placeCourante.getHeros().getPos_in());
    }

    public Place placeCorrespondante(String s) {

        if (s.equals("SP2MI"))
            return new SP2MI(heros);
        /*else if(s.equals("IFMI"))
            return new IFMI(heros);
        else if(s.equals("TP"))
            return new TP(heros);
        else if(s.equals("BU"))
            return new BU(heros);*/
        else
            return new Futuroscope(heros);
    }

    public void deplacementHeros(int x, int y, Direction dir) {

        Position nextPos = new Position(heros.getPos_in().x + x, heros.getPos_in().y + y);

        if ((nextPos.x >= 0 && nextPos.x < X_MAX) && (nextPos.y >= 0 && nextPos.y < Y_MAX))
            if (videOuPas(nextPos, dir, x, y))
                deplacement(x, y, dir);
    }

    public void deplacement(int x, int y, Direction dir) {

        mapObjects.put(positions[heros.getPos_in().x][heros.getPos_in().y], new Vide());
        heros.setPos_in(new Position(heros.getPos_in().x + x, heros.getPos_in().y + y));
        heros.changeImage(dir);
        paint(getGraphics());
    }

    public Heros getHeros() {
        return heros;
    }
}
