package Adventure.Runnable;

import Adventure.Heros;

import java.awt.*;

/**
 * Created by Etienne on 13/11/2015.
 */
public class RunnableEstEnVie implements Runnable{

    private Heros heros;

    public RunnableEstEnVie(Heros h) {
        this.heros = h;
    }

    @Override
    public void run() {

        while (heros.getVie() > 0) {

            if (heros.getVie() > 20)
                heros.setCouleurVie(Color.GREEN);
            else {
                if (heros.getCouleurVie() == Color.ORANGE)
                    heros.setCouleurVie(Color.RED);
                else
                    heros.setCouleurVie(Color.ORANGE);

            }

            heros.getWorld().repaint();

            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
