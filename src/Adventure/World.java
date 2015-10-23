package Adventure;

import Adventure.ObjectOfMap.*;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.*;

/**
 * Created by Etienne on 23/09/15.
 */
public class World extends Canvas {

    // Map
    private Hashtable<Location, ObjectMap> mapObjects;
    private Location locations[][];

    private Heros mainRobot;
    private Location locationMainRobot;

    private ArrayList<Tourelle> towers;

    private Place levelCourant;

    public PanelGame panelGame;
    public Annonce annonce;

    // Constantes
    public static int TILE_SIZE;
    public static int SCREEN_SIZE;
    private int X_MAX;
    private int Y_MAX;


    public World(int X_MAX, int Y_MAX, int screen_size, PanelGame panel) {
        this.X_MAX = X_MAX;
        this.Y_MAX = Y_MAX;
        this.panelGame = panel;

        SCREEN_SIZE = screen_size;
        TILE_SIZE = SCREEN_SIZE / X_MAX;

        mainRobot = new Heros();
        locationMainRobot = new Location(0,0);

        annonce = new Annonce(SCREEN_SIZE);

        initImages();
        initLevel();
        //gameLoop();
    }

    void initImages() {
        Images.chargementImage();
    }

    public void gameLoop() {
        int delay = 1;
        int interval = 1;
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            public void run() {
                impact();
                impactMissileRobot();
                repaint();
            }
        }, delay, interval);
    }

    public void impactMissileRobot() {

        for(Missile m : mainRobot.getStockMissiles()) {
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
        mainRobot.removeMissile();
    }

    public void impact() {

        for(Tourelle tower : towers) {
            int x = tower.p.x / TILE_SIZE;
            int y = tower.p.y / TILE_SIZE;

            if (locationMainRobot.x == x && locationMainRobot.y == y) {
                tower.restartProjectile();
                locationMainRobot.x = 1;
                locationMainRobot.y = 1;
                System.out.println("You loose");
            }

            ObjectMap object = mapObjects.get(locations[x][y]);
            if (object instanceof Herbe || object instanceof Pile || object instanceof Tourelle) {
            } else
                tower.restartProjectile();
        }

    }


    @Override
    public void paint(Graphics g) {

        super.paint(g);
        g.setColor(new Color(10, 55, 51));
        g.fillRect(0, 0, SCREEN_SIZE, SCREEN_SIZE);

        for (int i = 0; i < X_MAX; i++) {
            for (int j = Y_MAX-1; j >= 0; j--) {
                Location point = IsometricHelper.point2DToIso(new Location(j * TILE_SIZE/2, (i * TILE_SIZE/2)));
                point.y += 120;
                ObjectMap object = mapObjects.get(locations[i][j]);
                if(object instanceof Tourelle || object instanceof Mur || object instanceof Pile || object instanceof Herbe)
                    g.drawImage(object.getImage(), point.x, point.y, TILE_SIZE, TILE_SIZE*2, null);
            }
        }

       //annonce.paint(g);

     /*   for(Tourelle tower : towers)
            g.drawImage(Images.BULLET, tower.p.x, tower.p.y, TILE_SIZE/3, TILE_SIZE/3, null);

        for(Missile p : mainRobot.getStockMissiles()) {
            g.drawImage(Images.BULLET, p.getX(), p.getY(), TILE_SIZE/4, TILE_SIZE/4, null);
        }

        g.drawImage(Heros.image, locationMainRobot.x * TILE_SIZE, locationMainRobot.y * TILE_SIZE , TILE_SIZE, TILE_SIZE, null);
    */
    }

    public Boolean freeOrNot(Location p, Direction dir, int x, int y) {

        if ((p.x >= 0 && p.x < X_MAX) && (p.y >= 0 && p.y < Y_MAX)) {

            ObjectMap object = mapObjects.get(locations[p.x][p.y]);

            if (object instanceof Sortie) {
                nextLevel(p);
                return false;
            }
            else if (object instanceof Teleportation) {
                teleportationRobot(p, dir);
                return false;
            }
            else if (object instanceof Mur || object instanceof Tourelle) {
                return false;
            }
            else if (object instanceof Pile) {
                panelGame.moreEnergy();
                mapObjects.put(locations[p.x][p.y], new Herbe());
                return true;
            }
            else if( object instanceof Deplacable) {
                moveWall(p,dir, x,y);
                return false;
            }
            else
                return true;
        }
        else
            return false;
    }

    public void moveWall(Location positionWall, Direction dir, int x, int y) {

        Location p = locations[positionWall.x + x][positionWall.y + y];

        if ((p.x >= 1 && p.x < X_MAX-1) && (p.y >= 1 && p.y < Y_MAX-1)) {

            ObjectMap object = mapObjects.get(locations[p.x][p.y]);

            if(object instanceof Herbe) {

                Deplacable w = (Deplacable) mapObjects.get(locations[positionWall.x][positionWall.y]);
                mapObjects.put(locations[p.x][p.y], w);

                mapObjects.put(locations[positionWall.x][positionWall.y], new Herbe());

                locationMainRobot.x = positionWall.x;
                locationMainRobot.y = positionWall.y;

                mainRobot.changeImage(dir);
                draw();
            }
        }
    }

    public void teleportationRobot(Location l, Direction dir)  {

        locationMainRobot.x = l.x;
        locationMainRobot.y = l.y;

        draw();

        try {
            Thread.sleep(200);
        }catch ( InterruptedException e) {
            e.printStackTrace();
        }

        Teleportation t = (Teleportation) mapObjects.get(locations[l.x][l.y]);

        locationMainRobot.x = t.getEnd().x;
        locationMainRobot.y = t.getEnd().y;

        mainRobot.changeImage(dir);
        repaintRobot();
    }

    public void draw() {
        this.paint(getGraphics());
    }

    public void repaintRobot() {
        repaint(locationMainRobot.x * TILE_SIZE, locationMainRobot.y * TILE_SIZE, TILE_SIZE, TILE_SIZE);
    }

    public void moveMainRobot(int x, int y, Direction dir) {

        annonce.setAnnonce("");

        int a = locationMainRobot.x;
        int b = locationMainRobot.y;

        Location nextPos = locations[a + x][b + y];

        if (freeOrNot(nextPos, dir, x ,y)) {

            locationMainRobot.x += x;
            locationMainRobot.y += y;

            mainRobot.changeImage(dir);
            repaintRobot();
        }
    }

    public void newMissile(MouseEvent e) {

        int x = locationMainRobot.x;
        int y = locationMainRobot.y;

        if(e.getButton() == MouseEvent.BUTTON1) {
            mainRobot.addMissile(x * TILE_SIZE + TILE_SIZE/2, y * TILE_SIZE + TILE_SIZE/2, 0, -1);
            mainRobot.addMissile(x * TILE_SIZE + TILE_SIZE/2, y * TILE_SIZE + TILE_SIZE/2, 1, 0);
            mainRobot.addMissile(x * TILE_SIZE + TILE_SIZE/2, y * TILE_SIZE + TILE_SIZE/2, 0, 1);
            mainRobot.addMissile(x * TILE_SIZE + TILE_SIZE/2, y * TILE_SIZE + TILE_SIZE/2, -1, 0);
        }
        if(e.getButton() == MouseEvent.BUTTON3) {
            mainRobot.addMissile(x * TILE_SIZE + TILE_SIZE/2, y * TILE_SIZE + TILE_SIZE/2, 1, -1);
            mainRobot.addMissile(x * TILE_SIZE + TILE_SIZE/2, y * TILE_SIZE + TILE_SIZE/2, 1, 1);
            mainRobot.addMissile(x * TILE_SIZE + TILE_SIZE/2, y * TILE_SIZE + TILE_SIZE/2, -1, 1);
            mainRobot.addMissile(x * TILE_SIZE + TILE_SIZE/2, y * TILE_SIZE + TILE_SIZE/2, -1, -1);
        }

    }

    public void nextLevel(Location p) {
        mapObjects.put(locations[p.x][p.y], new Herbe());

        locationMainRobot.x  = p.x;
        locationMainRobot.y  = p.y;

        draw();

        try {
            Thread.sleep(300);
        }catch ( InterruptedException e) {
            e.printStackTrace();
        }


        initLevel();
    }

    public void initLevel() {
        levelCourant = new Place(X_MAX, Y_MAX);
        annonce.setAnnonce("" + Place.getLevelCourant());
        mapObjects = levelCourant.getLevel();
        locations = levelCourant.getLocations();
        towers = levelCourant.getTowers();

        locationMainRobot.x  = levelCourant.getLocationMainRobot().x;
        locationMainRobot.y  = levelCourant.getLocationMainRobot().y;
    }
}










