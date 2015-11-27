package Adventure.Places;

import Adventure.Heros;

/**
 * Crée un nouveau lieu de type Place, le couloir contient deux sorties, par consequence deux destinations devant le héros
 */
public class Couloir extends Place {

    /**
     * Appelle le constructeur de la classe mère(Place) pour construire le lieu
     * @param h
     *          instance du héros
     */
    public Couloir(Heros h) {
        super(h, "couloir");
    }

}
