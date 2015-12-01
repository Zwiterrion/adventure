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
public abstract class Place implements Cloneable {

    public Triple LEVEL_SOL[][];
    public Triple LEVEL_OBJECTS[][];

    public Hashtable<Position, ObjetCarte> mapObjects;
    public Hashtable<Position, ObjetCarte> mapSol;

    public List<Animable> animables;
    public String nom;

    public Position positions[][];
    public Heros heros;

    private LecteurNiveau l;

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
        positions = new Position[Monde.X_MAX][Monde.Y_MAX];
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
        l = new LecteurNiveau(this.nom);
        LEVEL_OBJECTS = l.getLEVEL_OBJETS();
        LEVEL_SOL = l.getLEVEL_SOL();

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
        for (int i = 0; i < Monde.X_MAX; i++)
            for (int j = 0; j < Monde.Y_MAX; j++)
                positions[i][j] = new Position(i, j);
    }

    /**
     * Construit le niveau à partir des matrices Sol et Objets
     */
    public void constructionNiveau() {
        for (int i = 0; i < Monde.X_MAX; i++)
            for (int j = 0; j < Monde.Y_MAX; j++) {
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

        switch (num.getType()) {
            case 0: ajoutSol(i, j, new Herbe(num.getDir())); break;
            case 1: ajoutSol(i, j, new Vide()); break;
            case 2: ajoutSol(i, j, new Carrelage()); break;
            case 3: ajoutSol(i, j, new PiegeSol()); break;
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

        switch (num.getType()) {
            case 0: ajoutObjet(i,j,new Vide());break;
            case 1: ajoutObjet(i,j,new Mur(num.getDir())); break;
            case 2: ajoutObjet(i, j, new MurDeplacable(num.getDir())); break;
            case 3: ajoutObjet(i, j, new Vie()); break;
            case 4: ajoutObjet(i,j,new Mana()); break;
            case 5: ajoutObjet(i, j, new Bureau(num.getDir())); break;
            case 6: ajoutObjet(i, j, new Sortie(num.getDestination(), this.getClass().getSimpleName())); break;
            case 7:
                ajoutObjet(i, j, new Vide());
                heros.setPos_in(positions[i][j]);
                break;
            case 8: ajoutObjet(i, j, new Bombe()); break;
            case 9: ajoutObjet(i, j, new Maison()); break;
            case 10: ajoutObjet(i, j, new Etagere(num.getDir())); break;
            case 11: ajoutObjet(i, j, new Tree());break;
            case 12: ajoutObjet(i, j, new Tableau());break;
            case 13: ajoutObjet(i, j, new Voiture(num.getDir()));break;
            case 14: ajoutObjet(i, j, new Buisson(num.getDir()));break;
            case 15: ajoutObjet(i, j, new SortieFermee(num.getDestination(), this.getClass().getSimpleName())); break;
            case 17: ajoutAnimable(new Piece(positions[i][j], heros), i, j); break;
            case 18 : ajoutAnimable(new Princesse(heros), i, j); break;
            case 19 : ajoutObjet(i,j, new Prison(num.getDir())); break;
            case 20 : ajoutObjet(i,j, new Panneau(num.getDir())); break;
            case 21 : ajoutObjet(i,j, new Clef()); break;
            case 22 : ajoutAnimable(new PrisonFinale(num.getDir(),heros), i, j); break;
            default: ajoutObjet(i, j, new Vide());break;

        }
    }

    public void ajoutAnimable(Animable m, int i, int j) {
        ajoutObjet(i,j, (ObjetCarte) m);
        animables.add(m);
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


    @Override
    public Object clone() {
        Object o = null;
        try {
            o =  super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return o;
    }
}

