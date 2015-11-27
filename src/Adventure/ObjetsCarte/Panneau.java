package Adventure.ObjetsCarte;

import Adventure.Direction;
import Adventure.Images;
import Adventure.Interface.Fixe;

/**
 * Crée une instance de la classe Panneau
 */
public class Panneau extends ObjetCarte implements Fixe{


    public Panneau(Direction dir) {
        super(dir);
    }

    /**
     * Affecte l'image du panneau
     */
    @Override
    public void assigneImage() {
        if(dir == Direction.NORD)
            image = Images.PANNEAU_BU;
        else if (dir == Direction.SUD)
            image = Images.PANNEAU_SP2MI;
        else if (dir == Direction.SUD_EST)
            image = Images.PANNEAU_IFMI;
        else
            image = Images.PANNEAU_TP;
    }
}
