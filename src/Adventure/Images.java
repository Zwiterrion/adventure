package Adventure;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * Created by Etienne on 21/10/2015.
 */
public class Images {

    public static BufferedImage HERBE;
    public static BufferedImage TOURELLE;
    public static BufferedImage HEROS_N;
    public static BufferedImage HEROS_S;
    public static BufferedImage HEROS_E;
    public static BufferedImage HEROS_O;
    public static BufferedImage MUR;
    public static BufferedImage MUR_BOUGEABLE;
    public static BufferedImage PILE;
    public static BufferedImage BULLET;
    public static BufferedImage TELEPORTATION;
    public static BufferedImage SORTIE;


    public static void chargementImage() {
        try {
            HERBE = ImageIO.read(new FileInputStream("res/herbe.png"));
            TOURELLE = ImageIO.read(new FileInputStream("res/maison.png"));
            HEROS_N = ImageIO.read(new FileInputStream("res/haut.png"));
            HEROS_S = ImageIO.read(new FileInputStream("res/bas.png"));
            HEROS_E = ImageIO.read(new FileInputStream("res/droite.png"));
            HEROS_O = ImageIO.read(new FileInputStream("res/gauche.png"));
            MUR = ImageIO.read(new FileInputStream("res/rocher.png"));
            MUR_BOUGEABLE = ImageIO.read(new FileInputStream("res/deplacable.png"));
            PILE = ImageIO.read(new FileInputStream("res/maison.png"));
            BULLET = ImageIO.read(new FileInputStream("res/bullet.png"));
            TELEPORTATION = ImageIO.read(new FileInputStream("res/teleport.png"));
            SORTIE = ImageIO.read(new FileInputStream("res/sortie.png"));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
