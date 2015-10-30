package Adventure;

import Adventure.ObjetsCarte.*;
import Adventure.Places.Place;
import Adventure.Places.Quartiergeneral;

import javax.swing.*;
import java.awt.*;
import java.util.Hashtable;

public class World extends JPanel {

    // Map
    private Hashtable<Location, ObjetCarte> mapObjects;
    private Hashtable<Location, ObjetCarte> mapSol;

    private Location locations[][];

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


        heros = new Heros();
        ath = new UIutilisateur(heros);

        annonce = new Annonce(SCREEN_SIZE);

        initialisationNiveau();
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
            for (int j = Y_MAX-1; j >= 0; j--) {
                Location point = IsometricHelper.point2DToIso(new Location(j,i));
                ObjetCarte object = mapSol.get(locations[i][j]);
                if(! (object instanceof Vide))
                    g.drawImage(object.getImage(), point.x, point.y, TILE_SIZE, TILE_SIZE * 2, this);
            }
        }

    }


    public void dessineObjetsMap(Graphics g) {

        for (int i = 0; i < X_MAX; i++) {
            for (int j = Y_MAX - 1; j >= 0; j--) {
                Location point = IsometricHelper.point2DToIso(new Location(j, i));
                ObjetCarte object = mapObjects.get(locations[i][j]);

                if (!(object instanceof Vide))
                    g.drawImage(object.getImage(), point.x, point.y, TILE_SIZE, TILE_SIZE * 2, this);

                if( i == heros.getPos_in().x && j == heros.getPos_in().y)
                    g.drawImage(heros.getImage(), point.x, point.y, TILE_SIZE, TILE_SIZE * 2, this);
            }
        }
    }

    public void dessineATH(Graphics g) {
        ath.paint(g);
    }

    public Boolean videOuPas(Location p, Direction dir, int x, int y) {

        if ((p.x >= 0 && p.x < X_MAX) && (p.y >= 0 && p.y < Y_MAX)) {

            ObjetCarte object = mapObjects.get(locations[p.x][p.y]);
            ObjetCarte objectSol = mapSol.get(locations[p.x][p.y]);

            if(objectSol instanceof Herbe) {

                if (object instanceof Vide)
                    return true;

                else if (object instanceof Sortie) {
                    niveauSuivant(x, y, dir);
                    return false;

                } else if (object instanceof Mur) {
                    return false;

                } else if (object instanceof Vie || object instanceof Mana) {
                    mapObjects.put(locations[p.x][p.y], new Vide());
                    return true;

                } else if (object instanceof Deplacable) {
                    deplaceMur(p, dir, x, y);
                    return false;

                } else
                    return true;
            }
            else
                return false;
        }
        else
            return false;
    }

    public void deplaceMur(Location positionWall, Direction dir, int x, int y) {

        Location p = new Location(positionWall.x + x,positionWall.y + y);

        if ((p.x >= 0 && p.x < X_MAX) && (p.y >= 0 && p.y < Y_MAX)) {

            ObjetCarte object = mapObjects.get(locations[p.x][p.y]);
            ObjetCarte objectSol = mapSol.get(locations[p.x][p.y]);

            if(object instanceof  Vide ) {

                if (objectSol instanceof Herbe) {

                    Deplacable w = (Deplacable) mapObjects.get(locations[positionWall.x][positionWall.y]);
                    mapObjects.put(locations[p.x][p.y], w);

                    mapObjects.put(locations[positionWall.x][positionWall.y], new Vide());

                    heros.setPos_in(positionWall);

                    heros.changeImage(dir);
                    repaint();
                }

                if (objectSol instanceof Vide) {

                    mapSol.put(locations[p.x][p.y], new Herbe(-1));

                    mapObjects.put(locations[positionWall.x][positionWall.y], new Vide());

                    heros.setPos_in(positionWall);

                    heros.changeImage(dir);
                    repaint();
                }
            }
        }
    }

    public void niveauSuivant(int x, int y, Direction dir) {

        deplacement(x, y, dir);
        attente(300);
        pageDeDescription();
        attente(1000);
        initialisationNiveau();
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
        }catch ( InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void initialisationNiveau() {
        placeCourante = new Quartiergeneral(heros);
        annonce.setAnnonce("Bienvenue");

        mapObjects = placeCourante.getMapObjects();
        mapSol = placeCourante.getMapSol();

        locations = placeCourante.getLocations();

        heros.setPos_in(placeCourante.getHeros().getPos_in());
    }

    public void deplacementHeros(int x, int y, Direction dir) {

        Location nextPos = new Location(heros.getPos_in().x + x, heros.getPos_in().y + y);

        if (videOuPas(nextPos, dir, x, y))
            deplacement(x,y,dir);
    }

    public void deplacement(int x, int y, Direction dir) {

        mapObjects.put(locations[heros.getPos_in().x][heros.getPos_in().y], new Vide());
        heros.setPos_in(new Location(heros.getPos_in().x + x, heros.getPos_in().y + y));
        heros.changeImage(dir);
        paint(getGraphics());
    }
}










