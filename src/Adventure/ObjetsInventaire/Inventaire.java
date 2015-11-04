package Adventure.ObjetsInventaire;

import Adventure.Images;
import Adventure.World;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Inventaire extends JPanel {

    private Image image;
    private List<Potion> stock;
    private int TILE_SIZE = World.TILE_SIZE;

    private int nbPotionVie = 0;
    private int nbPotionMana = 0;
    private int nbClefs = 0;

    public Inventaire() {
        image = Images.INVENTAIRE;
        stock = new ArrayList<Potion>();
        calculPotions();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        g.setColor(new Color(0, 0, 0));
        g.drawImage(image, 10, 10, this);

        int offset = 20;
        int x = (offset + 10) + (TILE_SIZE / 2);
        int y = TILE_SIZE/5;
        int tailleX = TILE_SIZE/2 - 5;
        int tailleY = TILE_SIZE/2 - 10;
        int x2 = (offset + 15) + (TILE_SIZE / 2) * 2;

        dessineStocks(g, x, x2, y,tailleX, tailleY);
        dessineIndices(g, x, x2, y);
    }

    public void dessineStocks(Graphics g, int x, int x2, int y, int tailleX, int tailleY) {
        int offset = 20;
        g.drawImage(Images.POTION_MANA, x2, y, tailleX, tailleY, this);
        g.drawLine(x2 - 5, 15, x2 - 5, 68);
        g.drawImage(Images.POTION_VIE, x, y, tailleX, tailleY, this);

        g.drawLine(x2 + tailleX + 5, 15, x2 + tailleX + 5, 68);

        g.drawImage(Images.CLEF, x2 + 40, y - 46, tailleX + tailleX/2, tailleY*3, this);

        g.drawRoundRect(offset + TILE_SIZE/2, 15, tailleX*4 - TILE_SIZE/5, 54, 2, 2);
    }

    public void dessineIndices(Graphics g, int x, int x2, int y) {
        int offset = 20;

        g.setColor(new Color(20, 100, 30));
        g.fillOval(x, y + 35, offset, offset);
        g.setColor(new Color(16, 173, 255));
        g.fillOval(x2, y + 35, offset, offset);
        g.setColor(new Color(0, 0, 0));
        g.fillOval(x2 +55, y + 35, offset, offset);

        g.setColor(new Color(255,245,255));
        g.setFont(new Font("Verdana", Font.BOLD, 15));
        g.drawString(String.valueOf(nbPotionVie), x + 5, y + 51);
        g.drawString(String.valueOf(nbPotionMana), x2 + 5, y + 51);
        g.drawString(String.valueOf(nbClefs), x2 + 60, y + 51);
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
            else if(p instanceof PotionClef)
                nbClefs++;
        }
    }

    public void ajouterElement(Potion p ){
        this.stock.add(p);
        calculPotions();
        repaint();
    }

    public void supprimerElement(Potion p) {
        this.stock.remove(p);
        calculPotions();
        repaint();
    }
}
