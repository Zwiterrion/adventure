package Adventure.Runnable;

import Adventure.Heros;
import Adventure.ObjetsCarte.Vide;
import Adventure.Position;

/**
 * Created by Etienne on 01/12/2015.
 */
public class RunnableCheckPrison implements Runnable {

    private boolean end = false;
    private boolean stop = false;
    private Heros h;

    public RunnableCheckPrison(Heros h) {
        this.h = h;
    }

    @Override
    public void run() {


        while(!stop) {
            while (!end) {

                check();

                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void check() {

        Position pHeros = new Position(h.getPos_in().x, h.getPos_in().y);

        if(pHeros.x == 4 && pHeros.y == 2) {
            System.out.println(h.getInventaire().getNbClefs());
            if(h.getInventaire().getNbClefs() != 0) {
                h.getWorld().getPlace().ajoutObjet(4, 3, new Vide());
                h.getWorld().repaint();
                end = true;
                stop = true;
            }
        }
    }

    public void setEnd(boolean end) {
        this.end = end;
    }
}
