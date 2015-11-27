package Adventure.Runnable;

import Adventure.Heros;

import java.util.concurrent.Semaphore;

/**
 * Crée une instance de RunnableMana
 */
public class RunnableMana implements Runnable {

    private Heros heros;

    private static final int MAX_CONCURRENT_THREADS = 1;
    private final Semaphore lock = new Semaphore(MAX_CONCURRENT_THREADS, true);

    private int potion;

    /**
     * Construit RunnableMana
     * @param h
     *      Instance du héros
     */
    public RunnableMana(Heros h) {
        this.heros = h;
    }

    /**
     * Le processus test la situation des points de Mana chez le héros, et change en faire et à mesure la couleur de laPotion
     */
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

    /**
     * Change la potion
     * @param potion
     *         Nombre de points de la potion
     */
    public void setPotion(int potion) {
        this.potion = potion;
    }
}
