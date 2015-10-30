package Adventure.ObjetsInventaire;


import java.awt.*;

/**
 * Created by Etienne on 27/10/2015.
 */
public abstract class Potion  {

    protected int value;
    protected Image image;

    public abstract void assign();

    public Potion(int value) {
        this.value = value;
        assign();
    }

    public boolean estVide() {
        if(value == 0)
            return true;
        return false;
    }

    public Image getImage() {
        return image;
    }
}
