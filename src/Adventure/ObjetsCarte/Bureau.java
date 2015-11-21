package Adventure.ObjetsCarte;

import Adventure.Direction;
import Adventure.Images;
import Adventure.Interface.Fixe;

public class Bureau extends ObjetCarte implements Fixe {

    public Bureau(Direction d) {
        super(d);
    }

    @Override
    public void assigneImage() {
        if(dir == Direction.SUD || dir == Direction.NORD)
            image = Images.BUREAU;
        else
            image = Images.BUREAU_BIS;
    }
}
