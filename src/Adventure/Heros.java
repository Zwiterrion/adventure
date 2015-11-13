package Adventure;

import Adventure.ObjetsCarte.Clef;
import Adventure.ObjetsCarte.Mana;
import Adventure.ObjetsCarte.ObjetCarte;
import Adventure.ObjetsCarte.Vie;
import Adventure.ObjetsInventaire.*;

import java.awt.*;

public class Heros {

    private Image image;
    public Direction dir = Direction.DROITE;
    private Location pos_in;
    private Inventaire inventaire;
    private World world;

    private int vie = 10;
    private int mana = 10;

    public Heros(World w)  {
        image = Images.HEROS_E;
        inventaire = new Inventaire(this);
        this.world = w;
    }

    public void ramasserObjet(ObjetCarte p) {
        if(p instanceof Vie)
            inventaire.ajouterElement(new PotionVie(50));
        else if(p instanceof Mana)
            inventaire.ajouterElement(new PotionMana(50));
        else if(p instanceof Clef)
            inventaire.ajouterElement(new PotionClef());
    }

    public void utiliserObjet(int i) {
        inventaire.utiliser(i);
        world.repaint();
    }

    public void changeImage(Direction dir) {
        this.dir = dir;
        switch (dir) {
            case HAUT:
                image = Images.HEROS_N;
                break;
            case DROITE:
                image = Images.HEROS_E;
                break;
            case BAS:
                image = Images.HEROS_S;
                break;
            case GAUCHE:
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

    public int getVie() {
        return vie;
    }

    public int getMana() {
        return mana;
    }

    public void setVie(int vie) {
        if(this.vie < 100) {
            this.vie += vie;
        }
        if(this.vie > 100)
            this.vie = 100;
    }

    public void setMana(int mana) {
        if(this.mana < 100) {
            this.mana += mana;
        }
        if(this.mana > 100)
            this.mana = 100;
    }

    public World getWorld() {
        return world;
    }
}






















