package Adventure.ObjetsCarte;

import Adventure.Direction;
import Adventure.Images;
import Adventure.Interface.Fixe;

public class Etagere extends ObjetCarte implements Fixe {

    public Etagere(Direction d) {
        super(d);
    }

    @Override
    public void assigneImage() {
        if(dir == Direction.SUD || dir == Direction.NORD)
            image = Images.ETAGERE;
        else if (dir == Direction.EST || dir == Direction.OUEST)
            image = Images.ETAGERE_BIS;
        else
            image = Images.ETAGERE_ANGLE;
    }
}
