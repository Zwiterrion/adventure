package Adventure.ObjetsCarte;

import Adventure.Images;
import Adventure.Interface.Deplacable;
import Adventure.Interface.Fixe;

public class Etagere extends ObjetCarte implements Fixe {

    private int face;

    public Etagere(int face) {
        super();
        this.face = face;
        assignImage();
    }

    @Override
    public void assignImage() {
        if (face == 0)
            image = Images.ETAGERE;
        else if( face == 1)
            image = Images.ETAGERE_BIS;
        else
            image = Images.ETAGERE_ANGLE;
    }
}
