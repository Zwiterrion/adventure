package Adventure.Runnable;

import Adventure.Heros;

import java.util.concurrent.Semaphore;

/**
 * Created by Etienne on 13/11/2015.
 */
public class RunnableVie implements Runnable {

    private Heros heros;

    private static final int MAX_CONCURRENT_THREADS = 1;
    private final Semaphore lock = new Semaphore(MAX_CONCURRENT_THREADS, true);

    public RunnableVie(Heros h) {
        this.heros = h;
    }

    @Override
    public void run() {

        try {
            lock.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        int potion = 50;

        while(potion > 0) {
            heros.setVie(5);
            heros.getWorld().repaint();
            potion -= 5;
            try {
                Thread.sleep(250);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        lock.release();
    }
}
