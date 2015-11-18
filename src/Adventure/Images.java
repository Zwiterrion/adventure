package Adventure;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.FileInputStream;
import java.io.IOException;

public class Images {

    public static Image CARRELAGE;
    public static Image HERBE;
    public static Image HERBE_DROITE_GAUCHE;
    public static Image HERBE_BAS_HAUT;

    public static Image COIN_DROITE_BAS;
    public static Image COIN_DROITE_HAUT;
    public static Image COIN_GAUCHE_BAS;
    public static Image COIN_GAUCHE_HAUT;

    public static Image INVENTAIRE;
    public static Image VIE;
    public static Image MANA;
    public static Image CLEF;

    public static Image TOURELLE;

    public static Image HEROS_N;
    public static Image HEROS_S;
    public static Image HEROS_E;
    public static Image HEROS_O;

    public static Image MUR;
    public static Image MUR_BIS;
    public static Image MUR_ANGLE;
    public static Image MUR_PALISSADE;
    public static Image MUR_BOUGEABLE;

    public static Image TELEPORTATION;
    public static Image SORTIE;
    public static Image SORTIE2;

    public static Image BUREAU;
    public static Image BUREAU_BIS;

    public static Image TRAP;

    public static Image TABLEAU;

    public static Image ETAGERE;
    public static Image ETAGERE_BIS;
    public static Image ETAGERE_ANGLE;

    public static Image TREE;

    public static Image BETON;

    public static void chargementImage() {
        try {

            HERBE = ImageIO.read(new FileInputStream("res/herbe.png"));
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

            MUR = ImageIO.read(new FileInputStream("res/mur.png"));
            MUR_BIS = ImageIO.read(new FileInputStream("res/murBis.png"));
            MUR_ANGLE = ImageIO.read(new FileInputStream("res/murAngle.png"));

            MUR_BOUGEABLE = ImageIO.read(new FileInputStream("res/bloc.png"));
            MUR_PALISSADE = ImageIO.read(new FileInputStream("res/murPalissade.png"));

            VIE = ImageIO.read(new FileInputStream("res/vie.png"));
            MANA = ImageIO.read(new FileInputStream("res/mana.png"));
            TELEPORTATION = ImageIO.read(new FileInputStream("res/teleport.png"));

            SORTIE = ImageIO.read(new FileInputStream("res/sortie.png"));
            SORTIE2 = ImageIO.read(new FileInputStream("res/sortie2.png"));

            INVENTAIRE = ImageIO.read(new FileInputStream("res/inventaire.png"));

            CLEF = ImageIO.read(new FileInputStream("res/bombe.png"));
            CARRELAGE = ImageIO.read(new FileInputStream("res/interieur.png"));

            TRAP = ImageIO.read(new FileInputStream("res/piege.png"));

            BUREAU = ImageIO.read(new FileInputStream("res/bureau.png"));
            BUREAU_BIS = ImageIO.read(new FileInputStream("res/bureauBis.png"));

            TABLEAU = ImageIO.read(new FileInputStream("res/tableau.png"));

            ETAGERE = ImageIO.read(new FileInputStream("res/etagere.png"));
            ETAGERE_BIS = ImageIO.read(new FileInputStream("res/etagere_bis.png"));
            ETAGERE_ANGLE = ImageIO.read(new FileInputStream("res/etagere_angle.png"));

            TREE = ImageIO.read(new FileInputStream("res/tree.png"));

            BETON = ImageIO.read(new FileInputStream("res/beton.png"));


        } catch (IOException e) {
            System.err.println("Impossible de charger tout le contenu : Images.chargementImage()");
            e.printStackTrace();
        }
    }

}
