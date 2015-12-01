package Adventure.ObjetsCarte;

import Adventure.Direction;
import Adventure.Heros;
import Adventure.Images;
import Adventure.Interface.Animable;
import Adventure.Interface.Fixe;
import Adventure.Runnable.RunnableCheckFin;
import Adventure.Runnable.RunnableCheckPrison;

/**
 * Crée une instance de Princesse
 */
public class PrisonFinale extends Prison implements Fixe, Animable {

    private Thread t;
    private RunnableCheckPrison m;

    public PrisonFinale(Direction d, Heros h) {
        super(d);
        m = new RunnableCheckPrison(h);
        t = new Thread(m);
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
