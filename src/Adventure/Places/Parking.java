package Adventure.Places;

import Adventure.Heros;

/**
 * Crée un nouveau lieu de type Place
 * */
public class Parking extends Place {

    /**
     * Appelle le constructeur de la classe mère(Place) pour construire le lieu
     * @param h
     *          instance du héros
     * @param String
     *          le nom du lieu à construire
     */
    public Parking(Heros h) {
        super(h, "parking");
    }



}
