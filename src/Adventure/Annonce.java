package Adventure;

import java.awt.*;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class Annonce extends Canvas {

    private String texteAAfficher;
    private int SCREEN_SIZE;
    private Font font;

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

    public void setTexteAAfficher(String texteAAfficher) {
        this.texteAAfficher = texteAAfficher;
    }
}
