package Adventure;

import Adventure.ObjectOfMap.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.util.*;
import javax.swing.Timer;

/**
 * Created by Etienne on 23/09/15.
 */
public class World extends Canvas {

    // Map
    private Hashtable<Location, ObjectMap> mapObjects;
    private Hashtable<Location, ObjectMap> mapSol;

    private Location locations[][];

    private Heros heros;

    private Place placeCourante;

    public PanelGame panelGame;
    public Annonce annonce;

    // Constantes
    public static int TILE_SIZE;
    public static int SCREEN_SIZE;
    public static int X_MAX;
    public static int Y_MAX;


    public World(int X_MAX, int Y_MAX, int screen_size, PanelGame panel) {
        this.X_MAX = X_MAX;
        this.Y_MAX = Y_MAX;
        this.panelGame = panel;

        SCREEN_SIZE = screen_size;
        TILE_SIZE = SCREEN_SIZE / X_MAX;

        initImages();

        heros = new Heros();

        annonce = new Annonce(SCREEN_SIZE);

        initLevel();
        //gameLoop();
    }

    void initImages() {
        Images.chargementImage();
    }

    public void gameLoop() {
       /* int delay = 1;
        int interval = 1;
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            public void run() {
                impact();
                impactMissileRobot();
                repaint();
            }
        }, delay, interval);*/
    }

    public void impactMissileRobot() {

        for(Missile m : heros.getStockMissiles()) {
            int x = m.getX() / TILE_SIZE;
            int y = m.getY() / TILE_SIZE;

            Object object = mapObjects.get(locations[x][y]);

            if(object instanceof Mur) {
                m.setPower(false);
            }
            if(object instanceof Deplacable) {
                m.setPower(false);
                mapObjects.put(locations[x][y], new Herbe());
            }
        }
        heros.removeMissile();
    }

    public void impact() {

      /*  for(Tourelle tower : towers) {
            int x = tower.p.x / TILE_SIZE;
            int y = tower.p.y / TILE_SIZE;

            if (heros.getPos_in().x == x && heros.getPos_in().y == y) {
                tower.restartProjectile();
                heros.getPos_in().x = 1;
                heros.getPos_in().y = 1;
                System.out.println("You loose");
            }

            ObjectMap object = mapObjects.get(locations[x][y]);
            if (object instanceof Herbe || object instanceof Pile || object instanceof Tourelle) {
            } else
                tower.restartProjectile();
        }
*/
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

        for (int i = 0; i < X_MAX; i++) {
            for (int j = Y_MAX-1; j >= 0; j--) {
                Location point = IsometricHelper.point2DToIso(new Location(j,i));
                point.y += 160;
                ObjectMap object = mapSol.get(locations[i][j]);
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
                ObjectMap object = mapObjects.get(locations[i][j]);
                if (!(object instanceof Vide)) {
                    g.drawImage(object.getImage(), point.x, point.y, TILE_SIZE, TILE_SIZE * 2, this);
                }
                if( i == heros.getPos_in().x && j == heros.getPos_in().y) {
                    g.drawImage(heros.getImage(), point.x, point.y, TILE_SIZE, TILE_SIZE * 2, this);
                }
            }
        }
    }

    public void drawHeros(Location a) {

        Location depart = IsometricHelper.point2DToIso(a);
        Location arrivee = IsometricHelper.point2DToIso(new Location(heros.getPos_in().x, heros.getPos_in().y));

        Location offset = Location.diff(arrivee,depart);
        System.out.println(offset);


    }

    public Boolean freeOrNot(Location p, Direction dir, int x, int y) {

        if ((p.x >= 0 && p.x < X_MAX) && (p.y >= 0 && p.y < Y_MAX)) {

            ObjectMap object = mapObjects.get(locations[p.x][p.y]);
            ObjectMap objectSol = mapSol.get(locations[p.x][p.y]);

            if(objectSol instanceof Herbe) {

                if (object instanceof Vide)
                    return true;

                if (object instanceof Sortie) {
                    nextLevel(p);
                    return false;

                } else if (object instanceof Teleportation) {
                    teleportationRobot(p, dir);
                    return false;

                } else if (object instanceof Mur || object instanceof Tourelle) {
                    return false;

                } else if (object instanceof Pile) {
                    panelGame.moreEnergy();
                    mapObjects.put(locations[p.x][p.y], new Herbe());
                    return true;

                } else if (object instanceof Deplacable) {
                    moveWall(p, dir, x, y);
                    return false;

                } else
                    return true;
            }
            return false;
        }
        else
            return false;
    }

    public void moveWall(Location positionWall, Direction dir, int x, int y) {

        Location p = new Location(positionWall.x + x,positionWall.y + y);

        if ((p.x >= 0 && p.x < X_MAX) && (p.y >= 0 && p.y < Y_MAX)) {

            ObjectMap object = mapObjects.get(locations[p.x][p.y]);
            ObjectMap objectSol = mapSol.get(locations[p.x][p.y]);

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

                    mapSol.put(locations[p.x][p.y], new Herbe());

                    mapObjects.put(locations[positionWall.x][positionWall.y], new Vide());

                    heros.setPos_in(positionWall);

                    heros.changeImage(dir);
                    repaint();
                }
            }
        }
    }

    public void teleportationRobot(Location l, Direction dir)  {

        heros.setPos_in(l);

        repaint();

        try {
            Thread.sleep(200);
        }catch ( InterruptedException e) {
            e.printStackTrace();
        }

        Teleportation t = (Teleportation) mapObjects.get(locations[l.x][l.y]);

        heros.setPos_in(t.getEnd());

        heros.changeImage(dir);
        repaint();
    }

    public void newMissile(MouseEvent e) {

        int x = heros.getPos_in().x;
        int y = heros.getPos_in().y;

        if(e.getButton() == MouseEvent.BUTTON1) {
            heros.addMissile(x * TILE_SIZE + TILE_SIZE / 2, y * TILE_SIZE + TILE_SIZE / 2, 0, -1);
            heros.addMissile(x * TILE_SIZE + TILE_SIZE / 2, y * TILE_SIZE + TILE_SIZE / 2, 1, 0);
            heros.addMissile(x * TILE_SIZE + TILE_SIZE / 2, y * TILE_SIZE + TILE_SIZE / 2, 0, 1);
            heros.addMissile(x * TILE_SIZE + TILE_SIZE / 2, y * TILE_SIZE + TILE_SIZE / 2, -1, 0);
        }
        if(e.getButton() == MouseEvent.BUTTON3) {
            heros.addMissile(x * TILE_SIZE + TILE_SIZE / 2, y * TILE_SIZE + TILE_SIZE / 2, 1, -1);
            heros.addMissile(x * TILE_SIZE + TILE_SIZE / 2, y * TILE_SIZE + TILE_SIZE / 2, 1, 1);
            heros.addMissile(x * TILE_SIZE + TILE_SIZE / 2, y * TILE_SIZE + TILE_SIZE / 2, -1, 1);
            heros.addMissile(x * TILE_SIZE + TILE_SIZE / 2, y * TILE_SIZE + TILE_SIZE / 2, -1, -1);
        }

    }

    public void nextLevel(Location p) {

        mapObjects.put(locations[p.x][p.y], new Herbe());

        heros.setPos_in(p);

        repaint();

        try {
            Thread.sleep(300);
        }catch ( InterruptedException e) {
            e.printStackTrace();
        }


        initLevel();
        repaint();
    }

    public void initLevel() {
        placeCourante = new Place(heros);
        annonce.setAnnonce("Bienvenue");

        mapObjects = placeCourante.getMapObjects();
        mapSol = placeCourante.getMapSol();

        locations = placeCourante.getLocations();

        heros.setPos_in(placeCourante.getHeros().getPos_in());
    }

    public void moveRobotPixel(int x, int y, Direction dir) {

        int ax = heros.getPos_in().x;
        int ay = heros.getPos_in().y;

        Location nextPos = new Location(ax + x, ay + y);

        if (freeOrNot(nextPos, dir, x ,y)) {

            mapObjects.put(locations[ax][ay], new Vide());
            Location a = heros.getPos_in();
            heros.setPos_in(new Location(heros.getPos_in().x + x, heros.getPos_in().y + y));
            mapObjects.put(locations[heros.getPos_in().x][heros.getPos_in().y], new Vide());
            heros.changeImage(dir);

            drawHeros(a);
            repaint();
        }
    }
}










