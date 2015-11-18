package Adventure.ObjetsInventaire;


/**
 * Created by Etienne on 27/10/2015.
 */
public abstract class Potion {

    protected int value;

    public Potion() {
    }

    public Potion(int value) {
        this.value = value;
    }

    public boolean estVide() {
        if (value == 0)
            return true;
        return false;
    }
}
