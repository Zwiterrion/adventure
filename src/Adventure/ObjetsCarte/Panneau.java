package Adventure.ObjetsCarte;

import Adventure.Direction;
import Adventure.Images;
import Adventure.Interface.Fixe;
import Adventure.Places.Couloir;

/**
 * Crée une instance de la classe Panneau
 */
public class Panneau extends ObjetCarte implements Fixe{


    public Panneau(Direction dir) {
        super(dir);
    }

    /**
     * Affecte l'image du panneau en fonction de la direction saisie
     */
    @Override
    public void assigneImage() {
        if(dir == Direction.NORD)
            image = Images.PANNEAU_BU;
        else if (dir == Direction.SUD)
            image = Images.PANNEAU_SP2MI;
        else if (dir == Direction.SUD_EST)
            image = Images.PANNEAU_IFMI;
        else if (dir == Direction.NORD_EST)
            image = Images.PANNEAU_TP;
        else if (dir == Direction.NORD_OUEST)
            image = Images.PANNEAU_SP2MI_NORD;
        else if (dir == Direction.SUD_OUEST)
            image = Images.PANNEAU_IFMI_NORD;
        else
            image = Images.PARKING;
    }

    public void assigneImageAvecDestination(String s, boolean couloir) {

        if(s.equalsIgnoreCase("bibliotheque"))
            setDir(Direction.NORD);
        else if(s.equalsIgnoreCase("ifmi") && !couloir)
            setDir(Direction.SUD_EST);
        else if(s.equalsIgnoreCase("ifmi"))
            setDir(Direction.SUD_OUEST);
        else if(s.equalsIgnoreCase("sp2mi") && !couloir)
            setDir(Direction.SUD);
        else if(s.equalsIgnoreCase("sp2mi"))
            setDir(Direction.NORD_OUEST);
        else if(s.equalsIgnoreCase("salletp"))
            setDir(Direction.NORD_EST);
        else
            setDir(Direction.TOUTES);

        assigneImage();
    }
}
