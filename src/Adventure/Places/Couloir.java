package Adventure.Places;

import Adventure.Heros;
import Adventure.ObjetsCarte.Panneau;
import Adventure.ObjetsCarte.Sortie;

/**
 * Crée un nouveau lieu de type Place, le couloir contient deux sorties, par consequence deux destinations devant le héros
 */
public class Couloir extends Place {

    /**
     * Appelle le constructeur de la classe mère(Place) pour construire le lieu
     * @param h
     *          instance du héros
     * @param destination
     *          La première destination face au héros
     * @param destinationBis
     *          La deuxième destination
     * @param inverser
     *          inverser la position du panneau ou non
     */
    public Couloir(Heros h, String destination, String destinationBis, boolean inverser) {
        super(h, "couloir");

        Sortie s = (Sortie)getObjet(4,0);
        s.setDestination(destination);

        Sortie s2 = (Sortie)getObjet(4,9);
        s2.setDestination(destinationBis);

        Panneau p1 = (Panneau)getObjet(6,1);
        p1.assigneImageAvecDestination(destination, inverser);

        Panneau p2 = (Panneau)getObjet(2,7);
        p2.assigneImageAvecDestination(destinationBis, inverser);
    }
}
