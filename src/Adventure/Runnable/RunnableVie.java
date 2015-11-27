package Adventure.Runnable;

import Adventure.Heros;

import java.util.concurrent.Semaphore;

/**
 * Crée une instance de RunnableVie
 */
public class RunnableVie implements Runnable {

    private Heros heros;

    private static final int MAX_CONCURRENT_THREADS = 1;
    private final Semaphore lock = new Semaphore(MAX_CONCURRENT_THREADS, true);

    private int potion;

    /**
     * Construit RunnableVie
     * @param h
     *      Instance du héros
     */
    public RunnableVie(Heros h) {
        this.heros = h;
    }

    /**
     * Le processus fait diminuer ou augmenter le nombre de vie du héros 'animation'
     */
    @Override
    public void run() {

        try {
            lock.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        while (potion > 0) {
            heros.setVie(1);
            heros.getWorld().repaint();
            potion -= 1;
            try {
                Thread.sleep(80);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        lock.release();
    }

    /**
     * Change le nombre de potion
     * @param potion
     *          le nombre de potion
     */
    public void setPotion(int potion) {
        this.potion = potion;
    }
}
