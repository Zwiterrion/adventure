package Adventure;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * Charge toutes les images du jeu
 */
public class Images {

    public static Image CARRELAGE;
    public static Image HERBE;
    public static Image HERBE_EST_OUEST;
    public static Image HERBE_SUD_NORD;

    public static Image HERBE_SUD_EST;
    public static Image HERBE_NORD_EST;
    public static Image HERBE_SUD_OUEST;
    public static Image HERBE_NORD_OUEST;

    public static Image INVENTAIRE;
    public static Image VIE;
    public static Image MANA;
    public static Image CLEF;
    public static Image CLEF_PORTE;

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
    public static Image SORTIE_FERMEE;

    public static Image BUREAU;
    public static Image BUREAU_BIS;

    public static Image TRAP;

    public static Image TABLEAU;

    public static Image ETAGERE;
    public static Image ETAGERE_BIS;
    public static Image ETAGERE_ANGLE;

    public static Image TREE;
    public static Image BETON;

    public static Image VOITURE_AVANT;
    public static Image VOITURE_ARRIERE;

    public static Image BUISSON_SUD;
    public static Image BUISSON_EST;

    public static Image SELECTION;

    public static Image PIECE;
    public static Image PRINCESSE;

    public static Image PRISON_EST;
    public static Image PRISON_NORD;

    public static Image PANNEAU_BU;
    public static Image PANNEAU_TP;
    public static Image PANNEAU_IFMI;
    public static Image PANNEAU_SP2MI;
    public static Image PARKING;
    public static Image PARKING_NORD;

    public static Image RESET;
    public static Image RESET_APPUYE;

    public static Image CLEF_FIN;

    /**
     * Charge les images depuis leur repertoire /, si une image n'est pas charge, le jeu est bloque et une exception est levee
     */
    public void chargementImage() {
        try {

            PANNEAU_BU = ImageIO.read(getClass().getResource("/bibliotheque.png"));
            PANNEAU_TP = ImageIO.read(getClass().getResource("/salletp.png"));
            PANNEAU_IFMI = ImageIO.read(getClass().getResource("/ifmi.png"));
            PANNEAU_SP2MI = ImageIO.read(getClass().getResource("/sp2mi.png"));
            PARKING = ImageIO.read(getClass().getResource("/parking.png"));
            PARKING_NORD = ImageIO.read(getClass().getResource("/parkingNord.png"));

            RESET = ImageIO.read(getClass().getResource("/reset.png"));
            RESET_APPUYE = ImageIO.read(getClass().getResource("/resetAppuye.png"));

            HERBE = ImageIO.read(getClass().getResource("/herbe.png"));
            HERBE_SUD_NORD = ImageIO.read(getClass().getResource("/herbeDroite.png"));
            HERBE_EST_OUEST = ImageIO.read(getClass().getResource("/herbeBas.png"));

            HERBE_SUD_EST = ImageIO.read(getClass().getResource("/coinDroiteBas.png"));
            HERBE_NORD_EST = ImageIO.read(getClass().getResource("/coinDroiteHaut.png"));
            HERBE_SUD_OUEST = ImageIO.read(getClass().getResource("/coinGaucheBas.png"));
            HERBE_NORD_OUEST = ImageIO.read(getClass().getResource("/coinGaucheHaut.png"));

            TOURELLE = ImageIO.read(getClass().getResource("/maison.png"));

            HEROS_N = ImageIO.read(getClass().getResource("/nord.png"));
            HEROS_S = ImageIO.read(getClass().getResource("/bas.png"));
            HEROS_E = Toolkit.getDefaultToolkit().createImage("/droite.png");
            HEROS_O = ImageIO.read(getClass().getResource("/gauche.png"));

            MUR = ImageIO.read(getClass().getResource("/mur.png"));
            MUR_BIS = ImageIO.read(getClass().getResource("/murBis.png"));
            MUR_ANGLE = ImageIO.read(getClass().getResource("/murAngle.png"));

            MUR_BOUGEABLE = ImageIO.read(getClass().getResource("/bloc.png"));
            MUR_PALISSADE = ImageIO.read(getClass().getResource("/murPalissade.png"));

            VIE = ImageIO.read(getClass().getResource("/vie.png"));
            MANA = ImageIO.read(getClass().getResource("/mana.png"));
            TELEPORTATION = ImageIO.read(getClass().getResource("/teleport.png"));

            SORTIE = ImageIO.read(getClass().getResource("/sortie.png"));
            SORTIE_FERMEE = ImageIO.read(getClass().getResource("/sortieFermee.png"));

            INVENTAIRE = ImageIO.read(getClass().getResource("/inventaire.png"));

            CLEF = ImageIO.read(getClass().getResource("/bombe.png"));
            CLEF_PORTE = ImageIO.read(getClass().getResource("/bombePorte.png"));
            CARRELAGE = ImageIO.read(getClass().getResource("/interieur.png"));

            TRAP = ImageIO.read(getClass().getResource("/piege.png"));

            BUREAU = ImageIO.read(getClass().getResource("/bureau.png"));
            BUREAU_BIS = ImageIO.read(getClass().getResource("/bureauBis.png"));

            TABLEAU = ImageIO.read(getClass().getResource("/tableau.png"));

            ETAGERE = ImageIO.read(getClass().getResource("/etagere.png"));
            ETAGERE_BIS = ImageIO.read(getClass().getResource("/etagere_bis.png"));
            ETAGERE_ANGLE = ImageIO.read(getClass().getResource("/etagere_angle.png"));

            BETON = ImageIO.read(getClass().getResource("/beton.png"));
            TREE = ImageIO.read(getClass().getResource("/tree.png"));

            VOITURE_AVANT = ImageIO.read(getClass().getResource("/voitureAvant.png"));
            VOITURE_ARRIERE = ImageIO.read(getClass().getResource("/voitureArriere.png"));

            BUISSON_SUD = ImageIO.read(getClass().getResource("/buisson_sud.png"));
            BUISSON_EST = ImageIO.read(getClass().getResource("/buisson_est.png"));

            SELECTION = ImageIO.read(getClass().getResource("/selection.png"));

            PIECE = ImageIO.read(getClass().getResource("/piece.png"));

            PRINCESSE = ImageIO.read(getClass().getResource("/princesse.png"));

            PRISON_EST = ImageIO.read(getClass().getResource("/prison.png"));
            PRISON_NORD = ImageIO.read(getClass().getResource("/prisonNord.png"));

            CLEF_FIN = ImageIO.read(getClass().getResource("/clef.png"));

        } catch (IOException e) {
            System.err.println("Impossible de charger tout le contenu : Images.chargementImage()");
            e.printStackTrace();
        }
    }

}
