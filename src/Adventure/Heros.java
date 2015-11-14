package Adventure;

import Adventure.Interface.Ramassable;
import Adventure.ObjetsCarte.Clef;
import Adventure.ObjetsCarte.Mana;
import Adventure.ObjetsCarte.Vie;
import Adventure.ObjetsInventaire.Inventaire;
import Adventure.ObjetsInventaire.PotionClef;
import Adventure.ObjetsInventaire.PotionMana;
import Adventure.ObjetsInventaire.PotionVie;
import Adventure.Runnable.RunnableEstEnVie;

import java.awt.*;

public class Heros {

    private Image image;
    public Direction dir = Direction.DROITE;
    private Location pos_in;

    private Inventaire inventaire;
    private World world;

    private Color couleurVie = Color.GREEN;
    private int vie = 100;
    private int mana = 60;

    public Heros(World w)  {
        image = Images.HEROS_E;
        inventaire = new Inventaire(this);
        this.world = w;
        demarreThread();
    }

    public void ramasserObjet(Ramassable p) {
        if(p instanceof Vie)
            inventaire.ajouterElement(new PotionVie(p.quantite()));
        else if(p instanceof Mana)
            inventaire.ajouterElement(new PotionMana(p.quantite()));
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
    
    public void perdVie(int vie){
        this.vie -= vie;
        if(this.vie <= 0)
            this.vie = 0;
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

    public void demarreThread() {
        Thread t = new Thread(new RunnableEstEnVie(this));
        t.start();
    }

    public Color getCouleurVie() {
        return couleurVie;
    }

    public void setCouleurVie(Color couleurVie) {
        this.couleurVie = couleurVie;
    }
}






















