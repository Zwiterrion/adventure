package Adventure.Runnable;

import Adventure.*;
import Adventure.ObjetsCarte.Personnage;

import java.util.Random;

public class RunnableMonstre implements Runnable {

    private Position p;
    private Position precedente;
    private Heros heros;
    private Personnage personnage;

    private boolean niveauFini = false;

    public RunnableMonstre(Position p, Heros h, Personnage personnage) {
        this.precedente = p;
        this.p = p;
        this.heros = h;
        this.personnage = personnage;
    }

    @Override
    public void run() {

        while (!niveauFini) {

            nouvellePosition();

            animation();

            try {
                Thread.sleep(500);
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

            personnage.x += offset.x;
            personnage.y += offset.y;
            heros.getWorld().repaint();

            try {
                Thread.sleep(25);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            i++;
        }

        this.personnage.x = 0;
        this.personnage.y = 0;
        heros.getWorld().changePositionPersonnage(p, precedente, personnage);

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
            if (!(heros.getWorld().estUnVide(nextPos, personnage)))
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

    public void setNiveauFini(boolean niveauFini) {
        this.niveauFini = niveauFini;
    }
}
