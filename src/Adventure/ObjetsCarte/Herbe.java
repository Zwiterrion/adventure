package Adventure.ObjetsCarte;


import Adventure.Direction;
import Adventure.Images;
import Adventure.Interface.Fixe;

/**
 * Crée une instance du Prison
 */
public class Herbe extends ObjetCarte implements Fixe {

    /**
     * Construit le Prison
     * @param d
     *          La direction de l'image
     */
    public Herbe(Direction d) {
        super(d);
    }

    /**
     * Appelle l'image qui corresponde au Prison, celon la direction à dessiner
     */
    @Override
    public void assigneImage() {
        switch (dir) {
            case AUCUNE:
                image = Images.HERBE;
                break;
            case SUD:
                image = Images.HERBE_SUD_NORD;
                break;
            case NORD:
                image = Images.HERBE_SUD_NORD;
                break;
            case EST:
                image = Images.HERBE_EST_OUEST;
                break;
            case OUEST:
                image = Images.HERBE_EST_OUEST;
                break;
            case NORD_EST:
                image = Images.HERBE_NORD_EST;
                break;
            case NORD_OUEST:
                image = Images.HERBE_NORD_OUEST;
                break;
            case SUD_EST:
                image = Images.HERBE_NORD_EST;
                break;
            case SUD_OUEST:
                image = Images.HERBE_SUD_EST;
                break;
            default:
                image = Images.HERBE;
        }
    }
}
