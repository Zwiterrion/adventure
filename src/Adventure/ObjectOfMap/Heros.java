package Adventure.ObjectOfMap;

import Adventure.Images;

import java.awt.image.BufferedImage;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class Heros {

    public static BufferedImage image;

    public Direction dir = Direction.RIGHT;

    private CopyOnWriteArrayList<Missile> stockMissiles = new CopyOnWriteArrayList<Missile>();

    public Heros() {
        image = Images.HEROS_E;
    }


    public void changeImage(Direction dir){
        this.dir = dir;
        switch (dir) {
            case UP:    image = Images.HEROS_N; break;
            case RIGHT: image = Images.HEROS_E; break;
            case DOWN: image = Images.HEROS_S;  break;
            case LEFT: image = Images.HEROS_O;  break;
        }
    }

    public void addMissile(int x1, int y1, int ajoutX, int ajoutY){
        stockMissiles.add(new Missile(ajoutX,ajoutY,x1,y1));
    }

    public void removeMissile() {
        Iterator<Missile> iter = stockMissiles.iterator();
        while (iter.hasNext()) {
            Missile m = iter.next();
            if (!m.getPower())
                stockMissiles.remove(m);
        }

    }

    public CopyOnWriteArrayList<Missile> getStockMissiles() {
        return stockMissiles;
    }
}






















