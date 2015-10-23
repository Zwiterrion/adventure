package Adventure.ObjectOfMap;

import Adventure.Images;

/**
 * Created by Etienne on 27/09/15.
 */
public class Mur extends ObjectMap {

    public Mur() {
        super();
        this.poidsArete = 2;
    }

    @Override
    public void assignImage() {
        image = Images.MUR;
    }
}
