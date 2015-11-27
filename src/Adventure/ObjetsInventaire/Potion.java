package Adventure.ObjetsInventaire;



public abstract class Potion {

    protected int value;

    public Potion(){}
    public Potion(int value) {
        this.value = value;
    }

    public boolean estVide() {
        if (value == 0)
            return true;
        return false;
    }
}
