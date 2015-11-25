package Adventure.ObjetsCarte;

import Adventure.Images;
import Adventure.Interface.Fixe;

/**
 * Created by Etienne on 25/11/2015.
 */
public class Princesse extends ObjetCarte implements Fixe {

    @Override
    public void assigneImage() {
        image = Images.PRINCESSE;
    }
}
