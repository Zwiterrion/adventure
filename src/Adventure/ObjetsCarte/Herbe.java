package Adventure.ObjetsCarte;


import Adventure.Images;
import Adventure.Interface.Fixe;

public class Herbe extends ObjetCarte implements Fixe {

    int face;

    public Herbe(int i ) {
        super();
        this.face = i;
        assignImage();
    }
    @Override
    public void assignImage() {
        switch (face) {
            case 0: image = Images.HERBE; break;
            case 1: image = Images.HERBE_BAS_HAUT; break;
            case 2: image = Images.HERBE_DROITE_GAUCHE; break;
            case 3: image = Images.COIN_DROITE_BAS; break;
            case 4: image = Images.COIN_DROITE_HAUT; break;
            case 5: image = Images.COIN_GAUCHE_BAS; break;
            case 6: image = Images.COIN_GAUCHE_HAUT; break;
        }
    }
}
