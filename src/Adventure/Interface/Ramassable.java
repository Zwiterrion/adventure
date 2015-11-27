package Adventure.Interface;

/**
 * Interface des objets ramasables
 */
public interface Ramassable {

    /**
     *
     * @return
     *      Le nombre par defaut d'un objet ramassable est de 30
     */
    public default int quantite() {
        return 30;
    }
}
