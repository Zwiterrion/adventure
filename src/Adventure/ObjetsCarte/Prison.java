package Adventure.ObjetsCarte;


import Adventure.Direction;
import Adventure.Images;
import Adventure.Interface.Fixe;

/**
 * Crée une instance de Maison
 */
public class Prison extends ObjetCarte implements Fixe {

    /**
     * Construit le Herbe
     * @param d
     *          La direction de l'image
     */
    public Prison(Direction d) {
        super(d);
    }

    /**
     * Appelle l'image qui correspond a la Maison
     */
    @Override
    public void assigneImage() {
        if(dir == Direction.SUD || dir == Direction.NORD)
            image = Images.PRISON_NORD;
        else
            image = Images.PRISON_EST;
    }
}
