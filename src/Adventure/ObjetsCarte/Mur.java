package Adventure.ObjetsCarte;

import Adventure.Images;

/**
 * Created by Etienne on 27/09/15.
 */
public class Mur extends ObjetCarte {

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
        else
            image = Images.MUR_ANGLE;
    }
}
