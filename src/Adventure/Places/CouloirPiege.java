package Adventure.Places;

import Adventure.Direction;
import Adventure.Heros;
import Adventure.ObjetsCarte.Sortie;
import Adventure.ObjetsCarte.Trap;

/**
 * Crée un nouveau lieu de type Place
 */
public class CouloirPiege extends Couloir {

    /**
     * Crée un couloir avec un piège
     * @param h
     *          Instance du héros
     * @param destination
     *          La première déstination face au héros
     * @param destinationBis
     *          La deuxième déstination
     */
    public CouloirPiege(Heros h, String destination, String destinationBis) {
        super(h);

        Sortie s = (Sortie)getObjet(4,0);
        s.setDestination(destination);

        Sortie s2 = (Sortie)getObjet(4,9);
        s2.setDestination(destinationBis);
        posePiege();
        h.changeImage(Direction.NORD);
    }

    /**
     * Ajoute le piège dans mapSol à la position (i,j)
     */
    public void posePiege(){
        ajoutSol(4,4,new Trap());
    }

}
