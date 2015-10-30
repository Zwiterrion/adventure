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

    public Inventaire() {
        image = Images.INVENTAIRE;
        stock = new ArrayList<Potion>();
        ajouterElement(new PotionVie(100));
        ajouterElement(new PotionMana(100));
        ajouterElement(new PotionMana(100));
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

        g.drawImage(Images.POTION_MANA, x2, y, tailleX, tailleY, this);
        g.drawLine(x2 - 5, 15, x2 - 5, 68);
        g.drawImage(Images.POTION_VIE, x, y, tailleX, tailleY, this);

        g.drawRoundRect(offset + TILE_SIZE/2, 15, x2 - TILE_SIZE/5, 54, 2, 2);

        g.setColor(new Color(20,100,30));
        g.fillOval(x, y + 35, 20, 20);
        g.setColor(new Color(16, 173, 255));
        g.fillOval(x2, y + 35, 20, 20);
        g.setColor(Color.WHITE);
        g.drawString("3", x + 6, y + 50);
        g.drawString("4", x2 + 6, y + 50);
    }

    public void ajouterElement(Potion p ){
        this.stock.add(p);
    }

    public void supprimerElement(Potion p) {
        this.stock.remove(p);
    }
}
