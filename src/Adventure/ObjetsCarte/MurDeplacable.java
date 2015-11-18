package Adventure.ObjetsCarte;

import Adventure.Direction;
import Adventure.Images;
import Adventure.Interface.Deplacable;

public class MurDeplacable extends Mur implements Deplacable {

    public MurDeplacable(Direction d) {
        super(d);
    }

    @Override
    public void assigneImage() {
        image = Images.MUR_BOUGEABLE;
    }

}
