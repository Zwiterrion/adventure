package Adventure.ObjetsInventaire;

import Adventure.Images;

public class PotionMana extends Potion {

    @Override
    public void assign() {
        image = Images.POTION_MANA;
    }

    public PotionMana(int value) {
        super(value);
    }
}
