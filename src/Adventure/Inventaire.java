package Adventure;

import Adventure.Interface.Ramassable;
import Adventure.ObjetsCarte.Bombe;
import Adventure.ObjetsCarte.Mana;
import Adventure.ObjetsCarte.Piece;
import Adventure.ObjetsCarte.Vie;
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
    private List<Ramassable> stock;

    private int nbVie;
    private int nbMana;
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
        stock = new ArrayList<Ramassable>();
        recommencer();
        calculPotions();

        runnableVie = new AnimationPotionVie(heros);
        runnableMana = new AnimationPotionMana(heros);
    }

    public void recommencer() {
        this.nbVie = 0;
        this.nbPieces = 0;
        this.nbBombes = 0;
        this.nbMana = 0;
        stock.clear();
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
        g.drawString(String.valueOf(nbVie), 102, 80);
        g.setColor(new Color(44, 148, 204));
        g.drawString(String.valueOf(nbMana), 175, 80);
        g.setColor(new Color(0, 0, 0));
        g.drawString(String.valueOf(nbBombes), 245, 81);
    }

    /**
     * Calcule le nombre de points pour chaque élément de l'inventaire
     */
    public void calculPotions() {
        this.nbVie = 0;
        this.nbBombes = 0;
        this.nbMana = 0;
        this.nbClefs = 0;

        for (Ramassable p : stock) {
            if (p instanceof Mana)
                nbMana++;
            else if (p instanceof Vie)
                nbVie++;
            else if (p instanceof Bombe)
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
    public void ajouterElement(Ramassable p) {

        if(nbBombes == 0 && p instanceof Bombe)
            ajouter(p);
        else if (nbMana < 3 && p instanceof Mana)
            ajouter(p);
        else if (nbVie < 3 && p instanceof Vie)
            ajouter(p);
        else if(p instanceof Piece)
            remplirCompteurCle();
        else
            ajouter(p);
    }


    /**
     * Ajout la potion à la liste des potions de l'inventaire
     * @param p
     *        Instance de Potion
     */
    public void ajouter(Ramassable p) {
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
            if (nbVie > 0)
                supprimerElement(0);
        } else if (i == 1) {
            if (nbMana > 0)
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

        Ramassable p = null;

        while (a < stock.size() && nonTrouve) {
            p = stock.get(a);
            if (p instanceof Vie && i == 0) {
                nextThread(true, p);
                nonTrouve = false;
            }
            if (p instanceof Mana && i == 1) {
                nextThread(false, p);
                nonTrouve = false;
            }
            if (p instanceof Bombe && i == 2) {
                nonTrouve = false;
            }
            a++;
        }

        if(!nonTrouve && p != null)
            this.stock.remove(p);

        calculPotions();
    }

    /**
     * Démarre l'animation de décrémentation de la potion
     * @param lequel
     *              détérmine la potion à enlever(false-> potionMana, true-> potionVie)
     * @param p
     *          Instance de la Potion en question
     */
    public void nextThread(boolean lequel, Ramassable p) {

        Thread t;
        if (lequel) {
            runnableVie.setPotion(p.quantite());
            t = new Thread(runnableVie);
        } else {
            runnableMana.setPotion(p.quantite());
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
            ajouterElement(new Bombe());
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

    public int getNbClefs() {
        return nbClefs;
    }
}



















