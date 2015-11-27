package Adventure.Runnable;

import Adventure.Heros;

import java.util.concurrent.Semaphore;

/**
 * Crée une instance de AnimationPotionVie
 */
public class AnimationPotionVie implements Runnable {

    private Heros heros;

    private static final int MAX_CONCURRENT_THREADS = 1;
    private final Semaphore lock = new Semaphore(MAX_CONCURRENT_THREADS, true);

    private int potion;

    /**
     * Construit AnimationPotionVie
     * @param h
     *      Instance du héros
     */
    public AnimationPotionVie(Heros h) {
        this.heros = h;
    }

    /**
     * Lance l'animation de la prise d'une potion de vie. Un mutex est placee sur la fonction
     * pour eviter d'utiliser deux potions au meme moment.
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
     * Change la quantite de la potion de mana
     * @param potion
     *          La quantite de la potion
     */
    public void setPotion(int potion) {if(potion > 100 && potion < 0)
        this.potion = potion;
    }
}
