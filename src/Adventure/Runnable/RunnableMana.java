package Adventure.Runnable;

import Adventure.Heros;

import java.util.concurrent.Semaphore;

/**
 * Created by Etienne on 13/11/2015.
 */
public class RunnableMana implements Runnable {

    private Heros heros;

    private static final int MAX_CONCURRENT_THREADS = 1;
    private final Semaphore lock = new Semaphore(MAX_CONCURRENT_THREADS, true);

    private int potion;

    public RunnableMana(Heros h) {
        this.heros = h;
    }

    @Override
    public void run() {

        try {
            lock.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        while (potion > 0) {
            heros.setMana(1);
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

    public void setPotion(int potion) {
        this.potion = potion;
    }
}
