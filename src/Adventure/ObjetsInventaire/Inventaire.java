package Adventure.ObjetsInventaire;

import Adventure.Heros;
import Adventure.Images;
import Adventure.Runnable.AnimationPotionMana;
import Adventure.Runnable.AnimationPotionVie;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Calcule et dessine l'inventaire(points de vie, clefs, bombe...)
 */
public class Inventaire extends JPanel {

    private Image image;
    private List<Potion> stock;

    private int nbPotionVie;
    private int nbPotionMana;
    private int nbBombes;
    private int nbPieces;
    private int nbClefs;

    private boolean mouse = false;

    private AnimationPotionVie runnableVie;
    private AnimationPotionMana runnableMana;

    /**
     * Crée une instance d'inventaire
     * @param heros
     *          Instance du héros
     */
    public Inventaire(Heros heros) {
        image = Images.INVENTAIRE;
        stock = new ArrayList<Potion>();
        recommencer();
        calculPotions();

        runnableVie = new AnimationPotionVie(heros);
        runnableMana = new AnimationPotionMana(heros);
    }

    public void recommencer() {
        this.nbPotionVie = 0;
        this.nbPieces = 0;
        this.nbBombes = 0;
        this.nbPotionMana = 0;
    }

    /**
     * Dessine l'inventaire
     * @param g
     *        Utilise les methodes de dessins propre à la classe abstraite Graphics
     */
    @Override
    public void paint(Graphics g) {
        super.paint(g);

        g.setColor(new Color(9, 128, 1));
        g.fillRect(230, 15, 65, ((nbPieces))*20);

        g.setColor(new Color(0, 0, 0));
        g.drawImage(image, 2, 8, this);

        dessineBoutons(g);
        dessineIndices(g);
    }

    public void dessineBoutons(Graphics g) {
        if(mouse)
            g.drawImage(Images.RESET, 840, 10, 200, 50, this);
        else
            g.drawImage(Images.RESET_APPUYE, 840, 10, 200, 50, this);
    }

    /**
     * Dessine les indices(les nombres) associés à chaque élément de l'inventaire(Vie,bombe,clef...)
     * @param g
     *        Utilise les methodes de dessins propre à la classe abstraite Graphics
     */
    public void dessineIndices(Graphics g) {

        g.setColor(new Color(9, 128, 1));
        g.setFont(new Font("Verdana", Font.PLAIN, 20));
        g.drawString(String.valueOf(nbPotionVie), 102, 80);
        g.setColor(new Color(44, 148, 204));
        g.drawString(String.valueOf(nbPotionMana), 175, 80);
        g.setColor(new Color(0, 0, 0));
        g.drawString(String.valueOf(nbBombes), 245, 81);
    }

    /**
     * Calcule le nombre de points pour chaque élément de l'inventaire
     */
    public void calculPotions() {
        recommencer();

        for (Potion p : stock) {
            if (p instanceof PotionMana)
                nbPotionMana++;
            else if (p instanceof PotionVie)
                nbPotionVie++;
            else if (p instanceof PotionBombe)
                nbBombes++;
            else
                nbClefs++;
        }
    }

    /**
     * Ajoute l'objet pris par le héros à sa liste d'inventaire
     * @param p
     *        Instance de Potion
     */
    public void ajouterElement(Potion p) {
        if (nbBombes == 0 && p instanceof PotionBombe)
            ajouter(p);
        else if (nbPotionMana < 3 && p instanceof PotionMana)
            ajouter(p);
        else if (nbPotionVie < 3 && p instanceof PotionVie)
            ajouter(p);
        else
            ajouter(p);
    }


    /**
     * Ajout la potion à la liste des potions de l'inventaire
     * @param p
     *        Instance de Potion
     */
    public void ajouter(Potion p) {
        this.stock.add(p);
        calculPotions();
        repaint();
    }

    /**
     * Diminue le nombre de la potion utilisée par le héros
     * @param i
     *         Numéro associé à la potion(0->potionVie, 1->PotionMana, 2->Clefs)
     */
    public void utiliser(int i) {

        if (i == 0) {
            if (nbPotionVie > 0)
                supprimerElement(0);
        } else if (i == 1) {
            if (nbPotionMana > 0)
                supprimerElement(1);
        } else {
            if (nbBombes > 0)
                supprimerElement(2);
        }
    }

    /**
     * Enlève la potion de la liste des potions du héros
     * @param i
     *      Numéro associé à la potion(0->potionVie, 1->PotionMana, 2->Clefs)
     */
    public void supprimerElement(int i) {

        int a = 0;
        boolean nonTrouve = true;
        while (a < stock.size() && nonTrouve) {
            Potion p = stock.get(a);
            if (p instanceof PotionVie && i == 0) {
                nextThread(true, p);
                this.stock.remove(p);
                nonTrouve = false;
            }
            if (p instanceof PotionMana && i == 1) {
                nextThread(false, p);
                this.stock.remove(p);
                nonTrouve = false;
            }
            if (p instanceof PotionBombe && i == 2) {
                this.stock.remove(p);
                nonTrouve = false;
            }
            a++;
        }
        calculPotions();
    }

    /**
     * Démarre l'animation de décrémentation de la potion
     * @param lequel
     *              détérmine la potion à enlever(false-> potionMana, true-> potionVie)
     * @param p
     *          Instance de la Potion en question
     */
    public void nextThread(boolean lequel, Potion p) {

        Thread t;
        if (lequel) {
            runnableVie.setPotion(p.value);
            t = new Thread(runnableVie);
        } else {
            runnableMana.setPotion(p.value);
            t = new Thread(runnableMana);
        }

        demarreAnimation(t);
    }

    /**
     * Lance l'animation
     * @param t
     *      Instance de Thread
     */
    public void demarreAnimation(Thread t) {
        t.start();
    }

    /**
     * Ajoute la clé à la liste des potions après la collection de 4 pièces
     */
    public void remplirCompteurCle() {

        nbPieces++;
        if(nbPieces >= 4) {
            nbPieces = 0;
            ajouterElement(new PotionBombe());
        }

        repaint();
    }

    /**
     *
     * @return
     *         Le nombre de clés
     */
    public int getNbBombes() {
        return nbBombes;
    }


    public void setMouse(boolean mouse) {
        this.mouse = mouse;
    }
}



















