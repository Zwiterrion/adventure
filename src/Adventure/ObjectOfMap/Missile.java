package Adventure.ObjectOfMap;

import Adventure.World;

import java.awt.*;

public class Missile implements Runnable {

    private int ajoutX;
    private int ajoutY;
    private int x;
    private int y;
    private Boolean power;
    private Thread t;
    private int DELAY = 2;

    public Missile(int ajoutX, int ajoutY, int x, int y) {
        this.ajoutX = ajoutX;
        this.ajoutY = ajoutY;
        this.x = x;
        this.y = y;
        power = true;
        t = new Thread(this);
        t.start();
    }

    @Override
    public void run() {

        while (power) {

            this.x += ajoutX;
            this.y += ajoutY;

            try {
                Thread.sleep(DELAY);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Boolean getPower() {
        return power;
    }

    public void setPower(Boolean b) {
        this.power = false;
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, World.TILE_SIZE/4, World.TILE_SIZE/4);
    }
}
