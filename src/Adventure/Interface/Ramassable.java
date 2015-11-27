package Adventure.Interface;

/**
 * Interface des objets ramasables
 */
public interface Ramassable {

    /**
     *
     * @return
     *      le nombre par defaut des points de vie est de 30
     */
    public default int quantite() {
        return 30;
    }
}
