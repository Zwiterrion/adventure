package Adventure;

import Adventure.Interface.Piege;
import Adventure.ObjetsCarte.ObjetCarte;
import Adventure.Runnable.RunnableMonstre;


public class Personnage extends ObjetCarte implements Piege {

    public Position p;

    public int x = 0;
    public int y = 0;

    private World w;
    private Thread t;

    public Personnage(Position p, World w) {
        this.p = p;
        this.w = w;
        t = new Thread(new RunnableMonstre(p,w, this));
    }

    public void active() {
        t.start();
    }

    public void assigneImage() {
        switch (dir) {
            case AUCUNE:
                image = Images.LAPIN_EST;
                break;
            case SUD:
                image = Images.LAPIN_SUD;
                break;
            case NORD:
                image = Images.LAPIN_NORD;
                break;
            case EST:
                image = Images.LAPIN_EST;
                break;
            case OUEST:
                image = Images.LAPIN_OUEST;
                break;
            default:
                image = Images.LAPIN_EST;
        }
    }
}
