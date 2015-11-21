package Adventure.ObjetsCarte;

import Adventure.Direction;
import Adventure.Images;
import Adventure.Interface.Fixe;

public class Mur extends ObjetCarte implements Fixe {

    public Mur(Direction d) {
        super(d);
    }

    @Override
    public void assigneImage() {
        switch (dir) {
            case NORD:
                image = Images.MUR;
                break;
            case SUD:
                image = Images.MUR;
                break;
            case EST:
                image = Images.MUR_BIS;
                break;
            case OUEST:
                image = Images.MUR_BIS;
                break;
            case NORD_EST:
                image = Images.MUR_ANGLE;
                break;
            case AUCUNE:
                image = Images.MUR_PALISSADE;
                break;
            default:
                image = Images.MUR;
        }
    }
}
