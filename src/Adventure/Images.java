package Adventure;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * Created by Etienne on 21/10/2015.
 */
public class Images {

    public static Image HERBE;
    public static Image HERBE_DROITE_GAUCHE;
    public static Image HERBE_BAS_HAUT;

    public static Image COIN_DROITE_BAS;
    public static Image COIN_DROITE_HAUT;
    public static Image COIN_GAUCHE_BAS;
    public static Image COIN_GAUCHE_HAUT;

    public static Image POTION_VIE;
    public static Image POTION_MANA;
    public static Image INVENTAIRE;

    public static Image TOURELLE;

    public static Image HEROS_N;
    public static Image HEROS_S;
    public static Image HEROS_E;
    public static Image HEROS_O;

    public static Image MUR;
    public static Image MUR_BIS;
    public static Image MUR_ANGLE;
    public static Image MUR_BOUGEABLE;

    public static Image VIE;
    public static Image MANA;

    public static Image TELEPORTATION;
    public static Image SORTIE;
    public static Image SORTIE2;

    public static Image CLEF;
    public static Image CARRELAGE;

    public static void chargementImage() {
        try {

            HERBE = ImageIO.read(new FileInputStream("res/parquet.png"));
            HERBE_BAS_HAUT = ImageIO.read(new FileInputStream("res/herbeBas.png"));
            HERBE_DROITE_GAUCHE = ImageIO.read(new FileInputStream("res/herbeDroite.png"));

            COIN_DROITE_BAS = ImageIO.read(new FileInputStream("res/coinDroiteBas.png"));
            COIN_DROITE_HAUT = ImageIO.read(new FileInputStream("res/coinDroiteHaut.png"));
            COIN_GAUCHE_BAS = ImageIO.read(new FileInputStream("res/coinGaucheBas.png"));
            COIN_GAUCHE_HAUT = ImageIO.read(new FileInputStream("res/coinGaucheHaut.png"));

            TOURELLE = ImageIO.read(new FileInputStream("res/maison.png"));

            HEROS_N = ImageIO.read(new FileInputStream("res/nord.png"));
            HEROS_S = ImageIO.read(new FileInputStream("res/bas.png"));
            HEROS_E = Toolkit.getDefaultToolkit().createImage("res/droite.png");
            HEROS_O = ImageIO.read(new FileInputStream("res/gauche.png"));

            //MUR = ImageIO.read(new FileInputStream("res/rocher.png"));
            MUR = ImageIO.read(new FileInputStream("res/mur.png"));
            MUR_BIS = ImageIO.read(new FileInputStream("res/murBis.png"));
            MUR_ANGLE = ImageIO.read(new FileInputStream("res/murAngle.png"));

            MUR_BOUGEABLE = ImageIO.read(new FileInputStream("res/bloc.png"));

            VIE = ImageIO.read(new FileInputStream("res/vie.png"));
            MANA = ImageIO.read(new FileInputStream("res/mana.png"));
            TELEPORTATION = ImageIO.read(new FileInputStream("res/teleport.png"));

            SORTIE = ImageIO.read(new FileInputStream("res/sortie.png"));
            SORTIE2 = ImageIO.read(new FileInputStream("res/sortie2.png"));

            POTION_VIE = ImageIO.read(new FileInputStream("res/potionVie.png"));
            POTION_MANA = ImageIO.read(new FileInputStream("res/potionMana.png"));

            INVENTAIRE = ImageIO.read(new FileInputStream("res/inventaire.png"));

            CLEF = ImageIO.read(new FileInputStream("res/bombe.png"));
            CARRELAGE = ImageIO.read(new FileInputStream("res/interieur.png"));


        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Impossible de charger tout le contenu : Images.chargementImage()");
        }
    }

}
