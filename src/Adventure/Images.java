package Adventure;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;

/**
 * Created by Etienne on 21/10/2015.
 */
public class Images {

    public static Image HERBE;
    public static Image TOURELLE;
    public static Image HEROS_N;
    public static Image HEROS_S;
    public static Image HEROS_E;
    public static Image HEROS_O;
    public static Image MUR;
    public static Image MUR_BOUGEABLE;
    public static Image PILE;
    public static Image BULLET;
    public static Image TELEPORTATION;
    public static Image SORTIE;

    public static void chargementImage() {
        try {
            HERBE = ImageIO.read(new FileInputStream("res/herbe.png"));
            TOURELLE = ImageIO.read(new FileInputStream("res/maison.png"));
            HEROS_N = ImageIO.read(new FileInputStream("res/nord.png"));
            HEROS_S = ImageIO.read(new FileInputStream("res/bas.png"));
            HEROS_E = Toolkit.getDefaultToolkit().createImage("res/droite.png");
            HEROS_O = ImageIO.read(new FileInputStream("res/left.png"));
            MUR = ImageIO.read(new FileInputStream("res/rocher.png"));
            MUR_BOUGEABLE = ImageIO.read(new FileInputStream("res/bloc.png"));
            PILE = ImageIO.read(new FileInputStream("res/vie.png"));
            BULLET = ImageIO.read(new FileInputStream("res/bullet.png"));
            TELEPORTATION = ImageIO.read(new FileInputStream("res/teleport.png"));
            SORTIE = ImageIO.read(new FileInputStream("res/sortie.png"));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
