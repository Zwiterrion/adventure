package Adventure.Places;

import Adventure.Heros;
import Adventure.ObjetsCarte.Sortie;
import Adventure.ObjetsCarte.Trap;


public class CouloirPiege extends Couloir {

    public CouloirPiege(Heros h, String destination, String destinationBis) {
        super(h);

        Sortie s = (Sortie)getObjet(4,0);
        s.setDestination(destination);

        Sortie s2 = (Sortie)getObjet(4,9);
        s2.setDestination(destinationBis);
        posePiege();
    }

    public void posePiege(){
        ajoutSol(4,4,new Trap());
    }

}
