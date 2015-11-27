package Adventure.Interface;

/**
 * Interface des objets bougeables avec des Threads
 */
public interface Animable {

    /**
     * Active le processus
     */
    void active();

    /**
     * Arrete le processus
     */
    void stop();

    /**
     *
     * @return
     *      Decalage de l'image horizontalement pour l'animation entre deux cases
     */
    int getX();

    /**
     *
     * @return
     *      Decalage de l'image verticalement pour l'animation entre deux cases
     */
    int getY();
}
