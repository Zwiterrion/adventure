package Adventure.ObjetsCarte;

import Adventure.Images;
import Adventure.Interface.Fixe;

/**
 * Created by Etienne on 27/09/15.
 */
public class Mur extends ObjetCarte implements Fixe {

    int face;

    public Mur(int f) {
        super();
        this.face = f;
        assignImage();
    }
    @Override
    public void assignImage() {
        if(this.face == 0)
            image = Images.MUR;
        else if(this.face == 1)
            image = Images.MUR_BIS;
        else if(this.face == 2)
            image = Images.MUR_ANGLE;
        else if(this.face == 3)
            image = Images.MUR_PALISSADE;
        else
            image = Images.TABLEAU;
    }
}
