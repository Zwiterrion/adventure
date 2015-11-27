package Adventure.Places;

import Adventure.Direction;
import Adventure.Heros;

/**
 * Crée un nouveau lieu de type Place
 */
public class SalleTp extends Place {

    /**
     * Appelle le constructeur de la classe mère(Place) pour construire le lieu
     * @param h
     *          instance du héros
     * @param String
     *          le nom du lieu à construire
     */
    public SalleTp(Heros h) {
        super(h,"salletp");
        h.changeImage(Direction.SUD);
    }


}
