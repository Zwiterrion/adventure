package Adventure.ObjetsInventaire;


/**
 * Created by Etienne on 27/10/2015.
 */
public abstract class Potion extends ObjetInventaire {

    protected int value;

    public Potion(int value, int x, int y, Adventure.UIutilisateur ath) {
        super(x,y, ath);
        this.value = value;
    }

    public boolean estVide() {
        if(value == 0)
            return true;
        return false;
    }
}
