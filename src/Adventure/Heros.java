package Adventure;

import Adventure.ObjetsInventaire.Inventaire;
import Adventure.ObjetsInventaire.Potion;

import java.awt.*;

public class Heros {

    private Image image;
    public Direction dir = Direction.RIGHT;
    private Location pos_in;
    private Inventaire inventaire;

    public Heros()  {
        image = Images.HEROS_E;
        inventaire = new Inventaire();
    }

    public void ramasserObjet(Potion p) {
        inventaire.ajouterElement(p);
    }

    public void utiliserObjet(Potion p) {
        inventaire.supprimerElement(p);
    }

    public void changeImage(Direction dir) {
        this.dir = dir;
        switch (dir) {
            case UP:
                image = Images.HEROS_N;
                break;
            case RIGHT:
                image = Images.HEROS_E;
                break;
            case DOWN:
                image = Images.HEROS_S;
                break;
            case LEFT:
                image = Images.HEROS_O;
                break;
        }
    }

    public Location getPos_in() {
        return pos_in;
    }

    public void setPos_in(Location pos_in) {
        this.pos_in = pos_in;
    }

    public Image getImage() {
        return image;
    }

    public Inventaire getInventaire() {
        return inventaire;
    }
}






















