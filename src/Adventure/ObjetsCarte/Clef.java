package Adventure.ObjetsCarte;

import Adventure.Images;
import Adventure.Interface.Fixe;
import Adventure.Interface.Ramassable;


public class Clef extends ObjetCarte implements Ramassable, Fixe {

    @Override
    public void assignImage() {
        image = Images.CLEF;
    }

}
