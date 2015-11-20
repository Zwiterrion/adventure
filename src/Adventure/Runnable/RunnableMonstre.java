package Adventure.Runnable;

import Adventure.*;

import java.awt.*;
import java.util.Random;

/**
 * Created by Etienne on 13/11/2015.
 */
public class RunnableMonstre implements Runnable {

    private Position p;
    private Personnage pers;
    private World w;

    public RunnableMonstre(Position p, Personnage pers, World w) {
        this.p = p;
        this.pers = pers;
        this.w = w;
    }

    @Override
    public void run() {

        boolean nonFin = false;

        while (!nonFin) {

            nouvellePosition();

            pers.repaint();

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void nouvellePosition() {

        Random r = new Random();
        int direction = r.nextInt(4);
        int x = 0;
        int y = 0;

        switch (direction) {
            case 0:
                x++;
                break;
            case 1:
                x--;
                break;
            case 2:
                y++;
                break;
            case 3:
                y--;
                break;
        }

        Position nextPos = new Position(p.x + x, p.y + y);
        if ((nextPos.x >= 0 && nextPos.x < World.X_MAX) && (nextPos.y >= 0 && nextPos.y < World.Y_MAX))
            if(!(w.videOuPas(nextPos, Direction.AUCUNE,x,y)))
                nouvellePosition();
            else {
                p.x = nextPos.x;
                p.y = nextPos.y;
            }
    }

}
