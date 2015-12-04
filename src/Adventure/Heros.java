package Adventure;

import Adventure.Interface.Ramassable;
import Adventure.ObjetsCarte.Bombe;
import Adventure.ObjetsCarte.Clef;
import Adventure.ObjetsCarte.Mana;
import Adventure.ObjetsCarte.Vie;
import Adventure.Runnable.RunnableEstEnVie;

import java.awt.*;

/**
 * Instance du héros
 */
public class Heros {

    private Image image;
    public Direction dir;
    private Position pos_in;

    private Inventaire inventaire;
    private Monde world;

    private Color couleurVie;
    private int vie;
    private int mana;

    /**
     * Construit le héros avec son monde
     * @param w
     *      Instance du Monde, le héros connais son monde
     */
    public Heros(Monde w) {
        image = Images.HEROS_E;
        inventaire = new Inventaire(this);
        this.world = w;
        this.vie = 100;
        this.mana = 10;
        this.couleurVie = Color.GREEN;
        this.dir = Direction.EST;
        demarreThread();
    }

    /**
     * Recommence le jeu, mise au point du depart
     */
    public void recommenceNiveau() {
        this.vie = 100;
        this.mana = 100;
        image = Images.HEROS_E;
        this.vie = 100;
        this.mana = 100;
        this.couleurVie = Color.GREEN;
        this.dir = Direction.EST;
    }

    /**
     * Ramasse un objet, une potion: Vie, Mana ou Cle
     * @param p
     *      L'objet a ramasser
     */
    public void ramasserObjet(Ramassable p) {
            inventaire.ajouterElement(p);
    }

    /**
     * Utilise un des objets ramasse, et redessine le monde
     * @param i
     */
    public void utiliserObjet(int i) {
        inventaire.utiliser(i);
        world.repaint();
    }

    /**
     * Change la direction du heros, par consequence son image
     * @param dir
     *      La nouvelle direction
     */
    public void changeImage(Direction dir) {
        this.dir = dir;
        switch (dir) {
            case NORD:
                image = Images.HEROS_N;
                break;
            case EST:
                image = Images.HEROS_E;
                break;
            case SUD:
                image = Images.HEROS_S;
                break;
            case OUEST:
                image = Images.HEROS_O;
                break;
        }
    }

    public Position getPos_in() {
        return pos_in;
    }

    public void setPos_in(Position pos_in) {
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
        if (this.vie < 100) {
            this.vie += vie;
        }
        if (this.vie > 100)
            this.vie = 100;
    }

    public void perdVie(int vie) {
        this.vie -= vie;
        if (this.vie <= 0)
            this.vie = 0;
    }

    public void setMana(int mana) {
        if (this.mana < 100) {
            this.mana += mana;
        }
        if (this.mana > 100)
            this.mana = 100;
    }

    public void perdMana(int mana) {
        this.mana -= mana;
        if (this.mana <= 0)
            this.mana = 0;
    }

    public Monde getWorld() {
        return world;
    }

    /**
     * Demarre le processus de la barre d'inventaire du héros
     */
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