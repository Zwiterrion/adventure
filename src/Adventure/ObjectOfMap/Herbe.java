package Adventure.ObjectOfMap;


import Adventure.Images;

public class Herbe extends ObjectMap {

    public Herbe() {
        super();
        this.poidsArete = 1;
    }

    @Override
    public void assignImage() {
        image = Images.HERBE;
    }
}
