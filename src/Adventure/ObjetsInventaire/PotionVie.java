package Adventure.ObjetsInventaire;

import Adventure.Images;

public class PotionVie extends Potion {

    @Override
    public void assign() {
        image = Images.POTION_VIE;
    }

    public PotionVie(int value) {
        super(value);
    }
}
