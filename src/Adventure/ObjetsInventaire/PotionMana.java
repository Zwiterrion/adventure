package Adventure.ObjetsInventaire;

import Adventure.UIutilisateur;
import Adventure.Images;

public class PotionMana extends Potion {

    public PotionMana(int value, int x, int y, UIutilisateur ath) {
        super(value, x, y, ath);
    }

    @Override
    public void assignImage() {
        image = Images.MANA;
    }

    @Override
    public void activationObjet() {

    }
}
