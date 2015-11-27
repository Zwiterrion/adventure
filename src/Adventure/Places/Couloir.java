package Adventure.Places;

import Adventure.Heros;

/**
 * Crée un nouveau lieu de type Place, le couloir contient deux sortie, par conséquence deux destination devant le héros
 */
public class Couloir extends Place {

    /**
     * Appelle le constructeur de la classe mère(Place) pour construire le lieu
     * @param h
     *          instance du héros
     * @param String
     *          le nom du lieu à construire
     */
    public Couloir(Heros h) {
        super(h, "couloir");
    }

}
