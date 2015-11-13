package Adventure.ObjetsCarte;

import Adventure.Images;
import Adventure.Interface.Deplacable;

public class MurDeplacable extends ObjetCarte implements Deplacable {

    @Override
    public void assignImage() {
        image = Images.MUR_BOUGEABLE;
    }

}
