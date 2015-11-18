package Adventure.ObjetsCarte;

import Adventure.Images;
import Adventure.Interface.Fixe;

public class Beton extends ObjetCarte implements Fixe {

    @Override
    public void assigneImage() {
        image = Images.BETON;
    }
}
