package Adventure.ObjetsCarte;

import Adventure.Images;
import Adventure.Interface.Fixe;

/**
 * Created by Etienne on 14/11/2015.
 */
public class Bureau extends ObjetCarte implements Fixe {

    private int face;

    public Bureau(int face) {
        super();
        this.face = face;
    }

    @Override
    public void assignImage() {
        if (face == 0)
            image = Images.BUREAU;
        else
            image = Images.BUREAU_BIS;
    }
}
