package Adventure.ObjetsInventaire;

import Adventure.Heros;
import Adventure.Images;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Inventaire extends JPanel {

    private Image image;
    private List<Potion> stock;

    private int nbPotionVie = 0;
    private int nbPotionMana = 0;
    private int nbClefs = 0;

    private Heros heros;

    public Inventaire(Heros h) {
        image = Images.INVENTAIRE;
        stock = new ArrayList<Potion>();
        this.heros = h;
        calculPotions();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        g.setColor(new Color(0, 0, 0));
        g.drawImage(image, 2, 8, this);

        dessineIndices(g);
    }

    public void dessineIndices(Graphics g) {

        g.setColor(new Color(9, 128, 1));
        g.setFont(new Font("Verdana", Font.PLAIN, 20));
        g.drawString(String.valueOf(nbPotionVie), 102, 80);
        g.setColor(new Color(44, 148, 204));
        g.drawString(String.valueOf(nbPotionMana), 175, 80);
        g.setColor(new Color(0, 0, 0));
        g.drawString(String.valueOf(nbClefs), 245, 81);
    }

    public void calculPotions() {
        nbPotionMana = 0;
        nbPotionVie = 0;
        nbClefs = 0;

        for(Potion p : stock) {
            if(p instanceof PotionMana)
                nbPotionMana++;
            else if(p instanceof PotionVie)
                nbPotionVie++;
            else
                nbClefs++;
        }
    }

    public void ajouterElement(Potion p) {
        if(nbClefs == 0 && p instanceof PotionClef)
            ajouter(p);
        if(nbPotionMana < 3 && p instanceof PotionMana)
            ajouter(p);
        if(nbPotionVie < 3 && p instanceof PotionVie)
            ajouter(p);
    }

    public void ajouter(Potion p){
        this.stock.add(p);
        calculPotions();
        repaint();
    }

    public void utiliser(int i) {

        if(i == 0) {
            if(nbPotionVie > 0)
                supprimerElement(0);
        }
        else if(i == 1) {
            if(nbPotionMana > 0)
                supprimerElement(1);
        }
        else {
            if(nbClefs > 0)
                supprimerElement(2);
        }
    }
    public void supprimerElement(int i) {

        int a = 0;
        while(a < stock.size()) {
            Potion p = stock.get(a);
            if(p instanceof PotionVie && i == 0) {
                heros.setVie(p.value);
                this.stock.remove(p);
            }
            if(p instanceof PotionMana && i == 1 ) {
                heros.setMana(p.value);
                this.stock.remove(p);
            }
            if(p instanceof PotionClef && i == 2) {
                this.stock.remove(p);
            }
            a++;
        }
        calculPotions();
        repaint();
    }
}
