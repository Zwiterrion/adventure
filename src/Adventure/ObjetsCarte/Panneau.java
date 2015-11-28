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
        else if (dir == Direction.TOUTES)
            image = Images.PARKING_NORD;
        else
            image = Images.PARKING;
    }

    /**
     * Assigne la bonne direction en fonction de la destination du heros
     * @param s
     *      Nom du lieu
     * @param inverser
     *      Booleen pour savoir si le panneau PARKING doit etre vers le nord ou le sud
     */
    public void assigneImageAvecDestination(String s, boolean inverser) {

        if(s.equalsIgnoreCase("parking") && inverser)
            setDir(Direction.TOUTES);
        else if(s.equalsIgnoreCase("bibliotheque"))
            setDir(Direction.NORD);
        else if(s.equalsIgnoreCase("ifmi"))
            setDir(Direction.SUD_EST);
        else if(s.equalsIgnoreCase("sp2mi"))
            setDir(Direction.SUD);
        else if(s.equalsIgnoreCase("salletp"))
            setDir(Direction.NORD_EST);
        else
            setDir(Direction.EST);

        assigneImage();
    }
}
