package Adventure.ObjetsCarte;

import Adventure.Images;
import Adventure.Interface.Fixe;
import Adventure.Interface.Piege;

public class Trap extends ObjetCarte implements Fixe, Piege {

    @Override
    public void assigneImage() {
        image = Images.TRAP;
    }

    @Override
    public int degat() {
        return 10;
    }
}
