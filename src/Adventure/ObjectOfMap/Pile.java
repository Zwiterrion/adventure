package Adventure.ObjectOfMap;

import Adventure.Images;

public class Pile extends ObjectMap {

    private int capacite;

    public Pile() {
        this.capacite = 1;
    }

    @Override
    public void assignImage() {
        image = Images.PILE;
    }

}
