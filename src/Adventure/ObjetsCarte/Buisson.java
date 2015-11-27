package Adventure.ObjetsCarte;


import Adventure.Direction;
import Adventure.Images;
import Adventure.Interface.Fixe;

/**
 * Crée une instance de Buisson
 */
public class Buisson extends ObjetCarte implements Fixe {

    /**
     * Construit le Buisson
     * @param d
     *          La direction de l'image
     */
    public Buisson(Direction d) {
        super(d);
    }

    /**
     * Appelle l'image qui correspond au Buisson, celon la direction à dessiner
     */
    @Override
    public void assigneImage() {
        switch (dir) {
            case AUCUNE:
                image = Images.BUISSON_SUD;
                break;
            case SUD:
                image = Images.BUISSON_SUD;
                break;
            case NORD:
                image = Images.BUISSON_SUD;
                break;
            case EST:
                image = Images.BUISSON_EST;
                break;
            case OUEST:
                image = Images.BUISSON_EST;
                break;
            default:
                image = Images.BUISSON_SUD;
        }
    }
}
