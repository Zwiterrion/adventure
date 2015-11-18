package Adventure.ObjetsCarte;

import Adventure.Images;
import Adventure.Interface.Fixe;
import Adventure.Interface.Ramassable;

public class Mana extends ObjetCarte implements Ramassable, Fixe {

    @Override
    public void assigneImage() {
        image = Images.MANA;
    }
}
