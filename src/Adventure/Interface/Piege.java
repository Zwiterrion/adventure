package Adventure.Interface;

/**
 * Interface des objets de type piege
 */

public interface Piege {

    /**
     *
     * @return
     *      Le nombre par defaut des degats est de 5
     */
    default int degat() {
        return 25;
    }
}
