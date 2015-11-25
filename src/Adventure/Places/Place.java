package Adventure.Places;

import Adventure.*;
import Adventure.Interface.Animable;
import Adventure.ObjetsCarte.*;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

/**
 * Place est une classe permetant de créer un lieu
 */
public abstract class Place {

    private Triple LEVEL_SOL[][];
    private Triple LEVEL_OBJECTS[][];

    private Hashtable<Position, ObjetCarte> mapObjects;
    private Hashtable<Position, ObjetCarte> mapSol;

    private  List<Animable> animables;
    private String nom;

    private Position positions[][];
    private Heros heros;

    /**
     * Construit un nouveau lieu
     *
     * @param h
     *          Instance du héros
     * @param nom
     *          Nom du lieu à créer
     */
    public Place(Heros h, String nom) {
        this.heros = h;
        mapObjects = new Hashtable<Position, ObjetCarte>();
        mapSol = new Hashtable<Position, ObjetCarte>();
        positions = new Position[World.X_MAX][World.Y_MAX];
        animables = new ArrayList<Animable>();

        initialisation(nom);
    }

    /**
     * Charge le niveau depuis un fichier XML
     * @param nom
     *          Nom du lieu à construire, et du fichier XML correspondant
     */
    public void initialisation(String nom) {

        this.nom = nom;
        LecteurNiveau l = new LecteurNiveau(this.nom);
        setLEVEL_OBJECTS(l.getLEVEL_OBJETS());
        setLEVEL_SOL(l.getLEVEL_SOL());

        initLocations();
        constructionNiveau();
    }

    /**
     * Active tous les objets animables du lieu
     */
    public void lancePersonnage() {
        animables.forEach(Animable::active);
    }

    /**
     * Initialise les positions des deux matrices: Sol et Objets
     */
    public void initLocations() {
        for (int i = 0; i < World.X_MAX; i++)
            for (int j = 0; j < World.Y_MAX; j++)
                positions[i][j] = new Position(i, j);
    }

    /**
     * Construit le niveau à partir des matrices Sol et Objets
     */
    public void constructionNiveau() {
        for (int i = 0; i < World.X_MAX; i++)
            for (int j = 0; j < World.Y_MAX; j++) {
                creerSol(i, j, LEVEL_SOL[i][j]);
                creerObjet(i, j, LEVEL_OBJECTS[i][j]);
            }
    }

    /**
     * Distingue les différents types de sol et appelle la fonction ajoutSol
     * @param i
     *          Ligne i
     * @param j
     *          Colonne j
     * @param num
     *          Instance de la classe Triple qui correspondant à une case de la carte
     */
    public void creerSol(int i, int j, Triple num) {

        switch (num.type) {
            case 0: ajoutSol(i, j, new Herbe(num.dir)); break;
            case 1: ajoutSol(i, j, new Vide()); break;
            case 2: ajoutSol(i, j, new Carrelage()); break;
            case 3: ajoutSol(i, j, new Trap()); break;
            case 4: ajoutSol(i, j, new Beton()); break;
            default: ajoutSol(i, j, new Beton());
        }
    }

    /**
     * Distingue les différents types d'Objets et appelle la fonction @link ajoutObjet()
     * @param i
     *          Ligne i
     * @param j
     *          Colonne j
     * @param num
     *          Instance de la classe Triple qui correspondant à une case de la carte
     */
    public void creerObjet(int i, int j, Triple num) {

        switch (num.type) {
            case 0: ajoutObjet(i,j,new Vide());break;
            case 1: ajoutObjet(i,j,new Mur(num.dir)); break;
            case 2: ajoutObjet(i, j, new MurDeplacable(num.dir)); break;
            case 3: ajoutObjet(i, j, new Vie()); break;
            case 4: ajoutObjet(i,j,new Mana()); break;
            case 5: ajoutObjet(i, j, new Bureau(num.dir)); break;
            case 6: ajoutObjet(i, j, new Sortie(num.destination, this.getClass().getSimpleName())); break;
            case 7:
                ajoutObjet(i, j, new Vide());
                heros.setPos_in(positions[i][j]);
                break;
            case 8: ajoutObjet(i, j, new Clef()); break;
            case 9: ajoutObjet(i, j, new Maison()); break;
            case 10: ajoutObjet(i, j, new Etagere(num.dir)); break;
            case 11: ajoutObjet(i, j, new Tree());break;
            case 12: ajoutObjet(i, j, new Tableau());break;
            case 13: ajoutObjet(i, j, new Voiture(num.dir));break;
            case 14: ajoutObjet(i, j, new Buisson(num.dir));break;
            case 15: ajoutObjet(i, j, new SortieFermee(num.destination, this.getClass().getSimpleName())); break;
            case 16:
                Personnage personnage = new Personnage(positions[i][j],heros);
                ajoutObjet(i, j, personnage);
                animables.add(personnage);
                break;
            case 17:
                Piece p = new Piece(positions[i][j], heros);
                ajoutObjet(i, j, p);
                animables.add(p);
                break;
            case 18 : ajoutObjet(i,j, new Princesse()); break;
            case 19 : ajoutObjet(i,j, new Prison(num.dir)); break;

            default: ajoutObjet(i, j, new Vide());break;

        }
    }

    /**
     * Ajoute un objet à la matrice mapObjects
     * @param i
     *          Ligne i
     * @param j
     *          Colonne j
     * @param oc
     *          L'objet à ajouter
     */
    public void ajoutObjet(int i, int j, ObjetCarte oc) {
        mapObjects.put(positions[i][j], oc);
    }

    /**
     * Ajoute un objet dans la matrice mapSol
     * @param i
     *          Ligne i
     * @param j
     *          Colonne j
     * @param oc
     *          L'objet à insérer
     */
    public void ajoutSol(int i, int j, ObjetCarte oc){
        mapSol.put(positions[i][j], oc);
    }

    /**
     * @param i
     *          Ligne i
     * @param j
     *          Colonne j
     * @return
     *          Objet à la case (i,j)
     */
    public ObjetCarte getObjet(int i, int j){
        return mapObjects.get(positions[i][j]);
    }

    /**
     * @return
     *        Instance du héro
     */
    public Heros getHeros() {
        return heros;
    }

    /**
     * @return
     *          La matrice des positions
     */
    public Position[][] getPositions() {
        return positions;
    }

    /**
     * @return
     *          Les Objets du Sol
     */
    public Hashtable<Position, ObjetCarte> getMapSol() {
        return mapSol;
    }

    /**
     *
     * @return
     *          Les objets au dessus du sol
     */
    public Hashtable<Position, ObjetCarte> getMapObjects() {
        return mapObjects;
    }

    public String getNom() {
        return nom;
    }


    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setLEVEL_SOL(Triple[][] LEVEL_SOL) {
        this.LEVEL_SOL = LEVEL_SOL;
    }

    public void setLEVEL_OBJECTS(Triple[][] LEVEL_OBJECTS) {
        this.LEVEL_OBJECTS = LEVEL_OBJECTS;
    }

    public List<Animable> getAnimables() {
        return animables;
    }
}

