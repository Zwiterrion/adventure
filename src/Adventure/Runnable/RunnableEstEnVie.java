package Adventure.Runnable;

import Adventure.Heros;

import java.awt.*;

/**
 * Crée une instance de RunnableEstEnVie
 */
public class RunnableEstEnVie implements Runnable {

    private Heros heros;

    /**
     * Construit RunnableEstEnVie
     * @param h
     *      Instance du héros
     */
    public RunnableEstEnVie(Heros h) {
        this.heros = h;
    }

    /**
     * Le processus test la situation des points de vie chez le héros, et change au fur et à mesure la couleur de la vie
     */
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

            if(heros.getWorld() != null)
                heros.getWorld().repaint();

            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
