package Adventure.ObjetsCarte;


import Adventure.Images;
import Adventure.Interface.Fixe;

public class Maison extends ObjetCarte implements Fixe {

    @Override
    public void assigneImage() {
        image = Images.TOURELLE;
    }
}
