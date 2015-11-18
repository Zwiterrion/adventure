package Adventure;

import java.awt.*;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class Annonce extends Canvas {

    private String annonce;
    private int SCREEN_SIZE;
    private Font font;

    public Annonce(int SCREEN_SIZE) {
        this.SCREEN_SIZE = SCREEN_SIZE;


        try {
            InputStream myStream = new BufferedInputStream(new FileInputStream("res/font/RedZone.ttf"));
            font = Font.createFont(Font.TRUETYPE_FONT, myStream);
            font = font.deriveFont(Font.PLAIN, 50);
        } catch (FontFormatException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setAnnonce(String annonce) {
        this.annonce = annonce;
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        g.setColor(new Color(255, 255, 255, 125));

        int stringLen = (int) g.getFontMetrics().getStringBounds(annonce, g).getWidth();
        g.setFont(font);
        g.drawString(annonce, SCREEN_SIZE / 2 - stringLen * 4, SCREEN_SIZE / 2 - SCREEN_SIZE / 4);
    }
}
