package Adventure.Places;

import Adventure.*;
import Adventure.Interface.Animable;
import Adventure.ObjetsCarte.*;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;


public abstract class Place {

    private Tuple LEVEL_SOL[][];
    private Tuple LEVEL_OBJECTS[][];

    private Hashtable<Position, ObjetCarte> mapObjects;
    private Hashtable<Position, ObjetCarte> mapSol;
    protected List<Sortie> sorties;

    private  List<Animable> animables;

    private String nom;

    private Position positions[][];
    private Heros heros;

    public Place(Heros h) {
        this.heros = h;
        mapObjects = new Hashtable<Position, ObjetCarte>();
        mapSol = new Hashtable<Position, ObjetCarte>();
        positions = new Position[World.X_MAX][World.Y_MAX];
        sorties = new ArrayList<Sortie>();
        animables = new ArrayList<Animable>();

        initialisation();
    }


    public void initialisation() {

        this.nom = this.getClass().getSimpleName().toLowerCase();
        LecteurNiveau l = new LecteurNiveau(this.nom);
        setLEVEL_OBJECTS(l.getLEVEL_OBJETS());
        setLEVEL_SOL(l.getLEVEL_SOL());

        initLocations();
        chargementNiveau();
        initSorties();
    }

    public void lancePersonnage() {
        animables.forEach(Animable::active);
    }

    public abstract void initSorties();

    public void initLocations() {
        for (int i = 0; i < World.X_MAX; i++)
            for (int j = 0; j < World.Y_MAX; j++)
                positions[i][j] = new Position(i, j);

    }

    public void chargementNiveau() {
        for (int i = 0; i < World.X_MAX; i++)
            for (int j = 0; j < World.Y_MAX; j++) {
                creerSol(i, j, LEVEL_SOL[i][j]);
                creerObjet(i, j, LEVEL_OBJECTS[i][j]);
            }
    }

    public void creerSol(int i, int j, Tuple num) {

        switch (num.type) {
            case 0: mapSol.put(positions[i][j], new Herbe(num.dir)); break;
            case 1: mapSol.put(positions[i][j], new Vide()); break;
            case 2: mapSol.put(positions[i][j], new Carrelage()); break;
            case 3: mapSol.put(positions[i][j], new Trap()); break;
            case 4: mapSol.put(positions[i][j], new Beton()); break;
            default: mapSol.put(positions[i][j], new Beton());
        }
    }

    public void creerObjet(int i, int j, Tuple num) {

        switch (num.type) {
            case 0: mapObjects.put(positions[i][j], new Vide());break;
            case 1: mapObjects.put(positions[i][j], new Mur(num.dir)); break;
            case 2: mapObjects.put(positions[i][j], new MurDeplacable(num.dir)); break;
            case 3: mapObjects.put(positions[i][j], new Vie()); break;
            case 4: mapObjects.put(positions[i][j], new Mana()); break;
            case 5: mapObjects.put(positions[i][j], new Bureau(num.dir)); break;
            case 6:
                Sortie s = new Sortie();
                mapObjects.put(positions[i][j], s);
                sorties.add(s);
                break;
            case 7:
                mapObjects.put(positions[i][j], new Vide());
                heros.setPos_in(positions[i][j]);
                break;
            case 8: mapObjects.put(positions[i][j], new Clef()); break;
            case 9: mapObjects.put(positions[i][j], new Maison()); break;
            case 10: mapObjects.put(positions[i][j], new Etagere(num.dir)); break;
            case 11: mapObjects.put(positions[i][j], new Tree());break;
            case 12: mapObjects.put(positions[i][j], new Tableau());break;
            case 13: mapObjects.put(positions[i][j], new Voiture(num.dir));break;
            case 14: mapObjects.put(positions[i][j], new Buisson(num.dir));break;
            case 15:
                SortieFermee e = new SortieFermee();
                mapObjects.put(positions[i][j], e);
                sorties.add(e);
                break;
            case 16:
                Personnage personnage = new Personnage(positions[i][j],heros);
                mapObjects.put(positions[i][j], personnage);
                animables.add(personnage);
                break;
            case 17:
                Piece p = new Piece(positions[i][j], heros);
                mapObjects.put(positions[i][j], p);
                animables.add(p);
                break;
            default: mapObjects.put(positions[i][j], new Vide());break;

        }
    }

    public Heros getHeros() {
        return heros;
    }

    public Position[][] getPositions() {
        return positions;
    }

    public Hashtable<Position, ObjetCarte> getMapSol() {
        return mapSol;
    }

    public Hashtable<Position, ObjetCarte> getMapObjects() {
        return mapObjects;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setLEVEL_SOL(Tuple[][] LEVEL_SOL) {
        this.LEVEL_SOL = LEVEL_SOL;
    }

    public void setLEVEL_OBJECTS(Tuple[][] LEVEL_OBJECTS) {
        this.LEVEL_OBJECTS = LEVEL_OBJECTS;
    }

    public List<Animable> getAnimables() {
        return animables;
    }
}

