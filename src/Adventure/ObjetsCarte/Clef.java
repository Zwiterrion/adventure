package Adventure.ObjetsCarte;

import Adventure.Direction;
import Adventure.Images;
import Adventure.Interface.Fixe;
import Adventure.Interface.Ramassable;


public class Clef extends ObjetCarte implements Ramassable, Fixe {

    @Override
    public void assigneImage() {
        image = Images.CLEF;
    }

}
