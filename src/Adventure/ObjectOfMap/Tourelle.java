package Adventure.ObjectOfMap;

import Adventure.Images;
import Adventure.Location;
import Adventure.Projectile;
import Adventure.World;

/**
 * Created by Etienne on 28/09/15.
 */
public class Tourelle extends ObjectMap implements Runnable {

    private Thread t;
    private int DELAY = 5;
    private Boolean power = true;
    private Direction dir;
    private Location l;
    public Projectile p;

    public Tourelle(Direction dir, int x, int y) {
        this.dir = dir;
        t = new Thread(this);
        p = new Projectile();
        l = new Location(x,y);
        p.y = (y * World.TILE_SIZE) + World.TILE_SIZE/2;
        p.x = x * World.TILE_SIZE + World.TILE_SIZE/2;
        t.start();
    }

    public void restartProjectile(){
        p.y = l.y * World.TILE_SIZE + World.TILE_SIZE/3;
    }

    @Override
    public void run() {
        while (power) {
            if(p.y < World.SCREEN_SIZE - World.TILE_SIZE)
                p.y++;
            else
                p.y = l.y * World.TILE_SIZE + World.TILE_SIZE/3;
            try {
                Thread.sleep(DELAY);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public void assignImage() {
        image = Images.TOURELLE;
    }
}
