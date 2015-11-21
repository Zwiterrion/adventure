package Adventure.Runnable;

import Adventure.*;

import java.awt.*;
import java.util.Random;
import java.util.concurrent.Semaphore;

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

            animation();

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void animation() {

        Position before = IsometricHelper.point2DToIso(new Position(precedente.y, precedente.x));
        Position after = IsometricHelper.point2DToIso(new Position(p.y, p.x));

        Position offset = Position.diff(after, before);

        offset.x /= 20;
        offset.y /= 20;

        int i = 0;
        while(i < 20) {

            this.personnage.x += offset.x;
            this.personnage.y += offset.y;
            this.w.repaint();

            try {
                Thread.sleep(25);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            i++;
        }

        this.personnage.x = 0;
        this.personnage.y = 0;
        w.changePositionPersonnage(p, precedente);

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
            if (!(w.estUnVide(nextPos)))
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
