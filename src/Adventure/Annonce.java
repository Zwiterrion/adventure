package Adventure;

import java.awt.*;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Crée une instance de la classe Annonce, qui a comme but afficher le nom du lieu courant a l'ecran
 */
public class Annonce extends Canvas {

    private String texteAAfficher;
    private int SCREEN_SIZE;
    private Font font;

    /**
     * Construit l'Annonce
     * @param SCREEN_SIZE
     *          Longueur de la fenetre
     * @param size
     *          Longueur du nom du lieu
     */
    public Annonce(int SCREEN_SIZE, int size) {
        this.SCREEN_SIZE = SCREEN_SIZE;

        try {
            InputStream myStream = new BufferedInputStream(new FileInputStream("res/font/RedZone.ttf"));
            font = Font.createFont(Font.TRUETYPE_FONT, myStream);
            font = font.deriveFont(Font.PLAIN, size);
        } catch (FontFormatException | IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Dessine le nom du lieu et l'affiche a l'cran
     * @param g
     *      Utilise les methodes de dessins propre à la classe abstraite Graphics
     */
    @Override
    public void paint(Graphics g) {
        super.paint(g);

        g.setColor(new Color(255, 255, 255, 125));

        int stringLen = (int) g.getFontMetrics().getStringBounds(texteAAfficher, g).getWidth();
        g.setFont(font);
        if(g.getFont().getSize() == 50)
            g.drawString(texteAAfficher, SCREEN_SIZE/2 - stringLen * 4, SCREEN_SIZE / 2 - SCREEN_SIZE / 4);
        else
            g.drawString(texteAAfficher, 30, 590);
    }

    /**
     * Prend le texte(nom du lieu) a afficher
     * @param texteAAfficher
     *          le nom du lieu
     */
    public void setTexteAAfficher(String texteAAfficher) {
        this.texteAAfficher = texteAAfficher;
    }
}
