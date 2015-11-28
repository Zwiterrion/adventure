package Adventure.Places;

import Adventure.Direction;
import Adventure.Heros;
import Adventure.ObjetsCarte.PiegeSol;
import Adventure.ObjetsCarte.Sortie;

/**
 * Crée un nouveau lieu de type Place
 */
public class CouloirPiege extends Couloir {

    /**
     * Crée un couloir avec un piège
     * @param h
     *          Instance du héros
     * @param destination
     *          La première destination face au héros
     * @param destinationBis
     *          La deuxième destination
     */
    public CouloirPiege(Heros h, String destination, String destinationBis, boolean inverser) {
        super(h, destination, destinationBis, inverser);
        posePiege();
        h.changeImage(Direction.NORD);
    }

    /**
     * Ajoute le piège dans mapSol à la position (i,j)
     */
    public void posePiege(){
        ajoutSol(4,4,new PiegeSol());
    }

}
