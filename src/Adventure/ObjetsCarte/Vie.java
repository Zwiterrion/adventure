package Adventure.ObjetsCarte;

import Adventure.Images;

public class Vie extends ObjetCarte {

    private int value = 100;

    @Override
    public void assignImage() {
        image = Images.VIE;
    }


    public int getValue() {
        return value;
    }
}
