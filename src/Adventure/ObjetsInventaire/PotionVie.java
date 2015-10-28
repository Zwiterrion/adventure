package Adventure.ObjetsInventaire;


import Adventure.Images;
import Adventure.UIutilisateur;

public class PotionVie extends Potion {

    public PotionVie(int value, int x, int y, UIutilisateur ath) {
        super(value, x, y, ath);
    }

    @Override
    public void assignImage() {
        image = Images.VIE;
    }

    @Override
    public void activationObjet() {

    }
}
