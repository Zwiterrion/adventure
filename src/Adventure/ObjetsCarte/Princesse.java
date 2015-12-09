package Adventure.ObjetsCarte;

import Adventure.Heros;
import Adventure.Images;
import Adventure.Interface.Animable;
import Adventure.Interface.Fixe;
import Adventure.Runnable.RunnableCheckFin;

/**
 * Cree une instance de Princesse
 */
public class Princesse extends ObjetCarte implements Fixe, Animable {

    private Thread t;
    private RunnableCheckFin m;

    public Princesse(Heros h) {
        super();
        m = new RunnableCheckFin(h);
        t = new Thread(m);
    }

    /**
     * Assigne l'image qui correspond a la Maison
     */
    @Override
    public void assigneImage() {
        image = Images.PRINCESSE;
    }


    @Override
    public void active() {
        m.setEnd(false);
        if(t.getState() == Thread.State.NEW)
            t.start();
    }

    @Override
    public void stop() {
        m.setEnd(true);
    }

    @Override
    public int getX() {
        return 0;
    }

    @Override
    public int getY() {
        return 0;
    }
}
