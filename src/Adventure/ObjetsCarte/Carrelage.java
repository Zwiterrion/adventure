package Adventure.ObjetsCarte;


import Adventure.Images;
import Adventure.Interface.Fixe;

public class Carrelage extends ObjetCarte implements Fixe {

    @Override
    public void assignImage() {
        image = Images.CARRELAGE;
    }
}
