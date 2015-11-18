package Adventure.ObjetsCarte;

import Adventure.Images;
import Adventure.Interface.Fixe;

public class Tableau extends ObjetCarte implements Fixe {

    @Override
    public void assigneImage() {
        image = Images.TABLEAU;
    }
}
