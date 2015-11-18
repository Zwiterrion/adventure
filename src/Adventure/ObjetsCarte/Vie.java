package Adventure.ObjetsCarte;

import Adventure.Images;
import Adventure.Interface.Fixe;
import Adventure.Interface.Ramassable;

public class Vie extends ObjetCarte implements Ramassable, Fixe {

    @Override
    public void assigneImage() {
        image = Images.VIE;
    }

    @Override
    public int quantite() {
        return 40;
    }
}
