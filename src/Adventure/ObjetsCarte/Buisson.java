package Adventure.ObjetsCarte;


import Adventure.Direction;
import Adventure.Images;
import Adventure.Interface.Fixe;

public class Buisson extends ObjetCarte implements Fixe {

    public Buisson(Direction d) {
        super(d);
    }

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
