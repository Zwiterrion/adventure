package Adventure.Places;

import Adventure.Heros;
import Adventure.ObjetsCarte.*;
import Adventure.Position;
import Adventure.World;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;


public abstract class Place {

    private int LEVEL_SOL[][];
    private int LEVEL_OBJECTS[][];

    private Hashtable<Position, ObjetCarte> mapObjects;
    private Hashtable<Position, ObjetCarte> mapSol;
    protected List<Sortie> sorties;

    private String nom = "Place Basique";

    private Position positions[][];
    private Heros heros;

    public Place(Heros h) {
        this.heros = h;
        mapObjects = new Hashtable<Position, ObjetCarte>();
        mapSol = new Hashtable<Position, ObjetCarte>();
        positions = new Position[World.X_MAX][World.Y_MAX];
        sorties = new ArrayList<Sortie>();
    }

    public void initialisation() {
        initLocations();
        chargementNiveau();
    }

    public abstract void initSorties();

    public void initLocations() {
        for (int i = 0; i < World.X_MAX; i++)
            for (int j = 0; j < World.Y_MAX; j++)
                positions[i][j] = new Position(i, j);

    }

    public void chargementNiveau() {
        for (int i = 0; i < World.X_MAX; i++)
            for (int j = 0; j < World.Y_MAX; j++)
                creerSol(i, j, LEVEL_SOL[i][j]);


        for (int i = 0; i < World.X_MAX; i++)
            for (int j = 0; j < World.Y_MAX; j++)
                creerObjet(i, j, LEVEL_OBJECTS[i][j]);
    }

    public void creerSol(int i, int j, int num) {
        switch (num) {
            case 0: mapSol.put(positions[i][j], new Herbe(0)); break;
            case 1:
                mapSol.put(positions[i][j], new Herbe(1));
                break;
            case 2:
                mapSol.put(positions[i][j], new Herbe(2));
                break;
            case 3:
                mapSol.put(positions[i][j], new Herbe(3));
                break;
            case 4:
                mapSol.put(positions[i][j], new Herbe(4));
                break;
            case 5:
                mapSol.put(positions[i][j], new Herbe(5));
                break;
            case 6:
                mapSol.put(positions[i][j], new Herbe(6));
                break;
            case 7:
                mapSol.put(positions[i][j], new Vide());
                break;
            case 8:
                mapSol.put(positions[i][j], new Carrelage());
                break;
            case 9:
                mapSol.put(positions[i][j], new Trap());
                break;
            case 10:
                mapSol.put(positions[i][j], new Beton());
                break;

            default:
                mapSol.put(positions[i][j], new Herbe(0));
        }
    }

    public void creerObjet(int i, int j, int num) {
        switch (num) {
            case 0:
                mapObjects.put(positions[i][j], new Vide());
                break;
            case 1:
                mapObjects.put(positions[i][j], new Mur(0));
                break;
            case 2:
                mapObjects.put(positions[i][j], new MurDeplacable());
                break;
            case 3:
                mapObjects.put(positions[i][j], new Vie());
                break;
            case 4:
                mapObjects.put(positions[i][j], new Mana());
                break;
            case 5:
                mapObjects.put(positions[i][j], new Bureau(0));
                break;
            case 6:
                Sortie s = new Sortie(true);
                mapObjects.put(positions[i][j], s);
                sorties.add(s);
                break;
            case 7:
                Sortie s2 = new Sortie(false);
                mapObjects.put(positions[i][j], s2);
                sorties.add(s2);
                break;
            case 8:
                mapObjects.put(positions[i][j], new Vide());
                heros.setPos_in(positions[i][j]);
                break;
            case 9:
                mapObjects.put(positions[i][j], new Clef());
                break;
            case 10:
                mapObjects.put(positions[i][j], new Maison());
                break;
            case 11:
                mapObjects.put(positions[i][j], new Mur(1));
                break;
            case 12:
                mapObjects.put(positions[i][j], new Mur(2));
                break;
            case 13:
                mapObjects.put(positions[i][j], new Bureau(1));
                break;
            case 14:
                mapObjects.put(positions[i][j], new Mur(3));
                break;
            case 15: mapObjects.put(positions[i][j], new Mur(4)); break;
            case 16: mapObjects.put(positions[i][j], new Etagere(0)); break;
            case 17: mapObjects.put(positions[i][j], new Etagere(1));break;
            case 18: mapObjects.put(positions[i][j], new Etagere(2));break;

            case 19: mapObjects.put(positions[i][j], new Tree());break;

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

    public void setLEVEL_SOL(int[][] LEVEL_SOL) {
        this.LEVEL_SOL = LEVEL_SOL;
    }

    public void setLEVEL_OBJECTS(int[][] LEVEL_OBJECTS) {
        this.LEVEL_OBJECTS = LEVEL_OBJECTS;
    }
}

