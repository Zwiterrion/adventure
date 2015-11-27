package Adventure.Places;

import Adventure.Direction;
import Adventure.Heros;

/**
 * Crée un nouveau lieu de type Place
 */
public class IFMI extends Place {

    /**
     * Appelle le constructeur de la classe mère(Place) pour construire le lieu
     * @param h
     *          instance du héros
     */
    public IFMI(Heros h) {
        super(h, "ifmi");
        h.changeImage(Direction.SUD);
    }

}
