package Adventure.Runnable;

import Adventure.*;

import java.awt.*;
import java.util.Random;

public class RunnableMonstre implements Runnable {

    private Position p;
    private Position precedente;
    private World w;
    private Personnage personnage;

    public RunnableMonstre(Position p, World w, Personnage personnage) {
        this.precedente = p;
        this.p = p;
        this.w = w;
        this.personnage = personnage;
    }

    @Override
    public void run() {

        boolean nonFin = false;

        while (!nonFin) {

            nouvellePosition();
            w.changePositionPersonnage(p, precedente);

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
        if ((nextPos.x >= 0 && nextPos.x < World.X_MAX) && (nextPos.y >= 0 && nextPos.y < World.Y_MAX)) {
            if (!(w.videOuPas(nextPos, Direction.AUCUNE, x, y)))
                nouvellePosition();
            else {
                precedente = new Position(p.x, p.y);
                if(x == 1)
                    personnage.setDir(Direction.EST);
                else if(x == -1)
                    personnage.setDir(Direction.OUEST);
                else if(y == 1)
                    personnage.setDir(Direction.NORD);
                else
                    personnage.setDir(Direction.SUD);

                personnage.assigneImage();
                p = new Position(nextPos.x, nextPos.y);
            }
        }
        else
            nouvellePosition();
    }

}
