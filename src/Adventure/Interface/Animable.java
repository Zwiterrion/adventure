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
     *      La position horizentale sur la carte
     */
    int getX();

    /**
     *
     * @return
     *      La position verticale sur la carte
     */
    int getY();
}
