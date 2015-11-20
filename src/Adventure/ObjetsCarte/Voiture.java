package Adventure.ObjetsCarte;

import Adventure.Direction;
import Adventure.Images;
import Adventure.Interface.Fixe;

/**
 * Created by Etienne on 19/11/2015.
 */
public class Voiture extends ObjetCarte implements Fixe {

    public Voiture(Direction dir) {
        super(dir);
    }

    @Override
    public void assigneImage() {
        if(dir == Direction.SUD)
            image = Images.VOITURE_ARRIERE;
        else
            image = Images.VOITURE_AVANT;
    }
}
