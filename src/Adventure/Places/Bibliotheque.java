package Adventure.Places;

import Adventure.Heros;

/**
 * Crée un nouveau lieu de type Place
 */
public class Bibliotheque extends Place {

    /**
     * Appelle le constructeur de la classe mère(Place) pour construire le lieu
     * @param h
     *          instance du héros
     */
    public Bibliotheque(Heros h) {
        super(h, "bibliotheque");
    }

}
