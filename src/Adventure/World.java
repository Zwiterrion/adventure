package Adventure;

import Adventure.ObjetsCarte.*;
import Adventure.Places.Place;
import Adventure.Places.Quartiergeneral;

import javax.swing.*;
import java.awt.*;
import java.util.*;

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


    public World(int X_MAX, int Y_MAX, int screen_size, UIutilisateur panel) {
        this.X_MAX = X_MAX;
        this.Y_MAX = Y_MAX;
        this.ath = panel;

        SCREEN_SIZE = screen_size;
        TILE_SIZE = SCREEN_SIZE / X_MAX;

        initImages();

        heros = new Heros();

        annonce = new Annonce(SCREEN_SIZE);

        this.ath.initialisation();
        initialisationNiveau();
    }

    void initImages() {
        Images.chargementImage();
    }

    @Override
    public void paint(Graphics g) {

        super.paint(g);
        g.setColor(new Color(10, 55, 51));
        g.fillRect(0, 0, SCREEN_SIZE, SCREEN_SIZE);

        repaintSol(g);
        repaintObjectsMap(g);

        g.dispose();
    }

    public void repaintSol(Graphics g) {

        /*for (int i = 0; i < X_MAX *2; i++) {
            for (int j = Y_MAX*2 - 1; j >= 0; j--) {
                Location point = IsometricHelper.point2DToIso(new Location(j,i));
                Random r = new Random();
                Random e = new Random();
                point.y += e.nextInt(160) + 100;
                point.x -= 400;
                if (r.nextInt(10) == 0)
                    g.drawImage(Images.NUAGE, point.x, point.y, TILE_SIZE, TILE_SIZE * 2, this);
            }
        }*/

        for (int i = 0; i < X_MAX; i++) {
            for (int j = Y_MAX-1; j >= 0; j--) {
                Location point = IsometricHelper.point2DToIso(new Location(j,i));
                point.y += 160;
                ObjetCarte object = mapSol.get(locations[i][j]);
                if(! (object instanceof Vide))
                    g.drawImage(object.getImage(), point.x, point.y, TILE_SIZE, TILE_SIZE * 2, this);
            }
        }

    }

    public void repaintObjectsMap(Graphics g) {

        for (int i = 0; i < X_MAX; i++) {
            for (int j = Y_MAX - 1; j >= 0; j--) {
                Location point = IsometricHelper.point2DToIso(new Location(j, i));
                point.y += 160;
                ObjetCarte object = mapObjects.get(locations[i][j]);

                if (!(object instanceof Vide))
                    g.drawImage(object.getImage(), point.x, point.y, TILE_SIZE, TILE_SIZE * 2, this);

                if( i == heros.getPos_in().x && j == heros.getPos_in().y)
                    g.drawImage(heros.getImage(), point.x, point.y, TILE_SIZE, TILE_SIZE * 2, this);
            }
        }
    }


    public Boolean freeOrNot(Location p, Direction dir, int x, int y) {

        if ((p.x >= 0 && p.x < X_MAX) && (p.y >= 0 && p.y < Y_MAX)) {

            ObjetCarte object = mapObjects.get(locations[p.x][p.y]);
            ObjetCarte objectSol = mapSol.get(locations[p.x][p.y]);

            if(objectSol instanceof Herbe) {

                if (object instanceof Vide)
                    return true;

                else if (object instanceof Sortie) {
                    niveauSuivant(x, y, dir);
                    return false;

                } else if (object instanceof Mur || object instanceof Tourelle) {
                    return false;

                } else if (object instanceof Vie || object instanceof Mana) {
                    ath.moreEnergy();
                    mapObjects.put(locations[p.x][p.y], new Vide());
                    return true;

                } else if (object instanceof Deplacable) {
                    moveWall(p, dir, x, y);
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

    public void moveWall(Location positionWall, Direction dir, int x, int y) {

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
        sleep(300);
        pageDeDescription();
        sleep(1000);
        initialisationNiveau();
        repaint();
    }

    public void pageDeDescription() {

        getGraphics().setColor(Color.BLACK);
        getGraphics().fillRect(0,0, SCREEN_SIZE, SCREEN_SIZE);
        annonce.setAnnonce(placeCourante.getNom());
        annonce.paint(getGraphics());
    }

    public void sleep(int time) {
        try {
            Thread.sleep(time);
        }catch ( InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void initialisationNiveau() {
        //placeCourante = new Place(heros);
        placeCourante = new Quartiergeneral(heros);
        annonce.setAnnonce("Bienvenue");

        mapObjects = placeCourante.getMapObjects();
        mapSol = placeCourante.getMapSol();

        locations = placeCourante.getLocations();

        heros.setPos_in(placeCourante.getHeros().getPos_in());
    }

    public void deplacementHeros(int x, int y, Direction dir) {

        Location nextPos = new Location(heros.getPos_in().x + x, heros.getPos_in().y + y);

        if (freeOrNot(nextPos, dir, x ,y))
            deplacement(x,y,dir);
    }

    public void deplacement(int x, int y, Direction dir) {

        mapObjects.put(locations[heros.getPos_in().x][heros.getPos_in().y], new Vide());
        heros.setPos_in(new Location(heros.getPos_in().x + x, heros.getPos_in().y + y));
        heros.changeImage(dir);
        paint(getGraphics());
    }
}










