package Adventure.Places;

import Adventure.Direction;
import Adventure.Location;
import Adventure.ObjetsCarte.*;
import Adventure.World;

import java.awt.*;
import java.util.Hashtable;

/**
 * Created by Etienne on 30/09/15.
 */
public class Place {

    private int LEVEL_SOL[][];
    private int LEVEL_OBJECTS[][];

    private Hashtable<Location,ObjetCarte> mapObjects;
    private Hashtable<Location,ObjetCarte> mapSol;
    private String nom = "Place Basique";

    private Location locations[][];
    private Heros heros;

    public Place(Heros h) {
        this.heros = h;
        mapObjects = new Hashtable<Location, ObjetCarte>();
        mapSol = new Hashtable<Location, ObjetCarte>();
        locations = new Location[World.X_MAX][World.Y_MAX];
    }

    public void initialisation() {
        initLocations();
        chargementNiveau();
    }

    public void initLocations() {
        for(int i=0; i< World.X_MAX; i++)
            for(int j=0; j< World.Y_MAX; j++)
                locations[i][j] = new Location(i, j);

    }

    public void chargementNiveau() {
        for(int i=0; i< World.X_MAX;i++)
            for(int j=0; j< World.Y_MAX; j++)
                creerSol(i, j, LEVEL_SOL[i][j]);


        for(int i=0; i< World.X_MAX;i++)
            for(int j=0; j< World.Y_MAX; j++)
                creerObjet(i, j, LEVEL_OBJECTS[i][j]);
    }

    public void creerSol(int i, int j, int num) {
        switch (num) {
            case 0: mapSol.put(locations[i][j], new Herbe(0)); break;
            case 1: mapSol.put(locations[i][j], new Herbe(1)); break;
            case 2: mapSol.put(locations[i][j], new Herbe(2)); break;
            case 3: mapSol.put(locations[i][j], new Herbe(3)); break;
            case 4: mapSol.put(locations[i][j], new Herbe(4)); break;
            case 5: mapSol.put(locations[i][j], new Herbe(5)); break;
            case 6: mapSol.put(locations[i][j], new Herbe(6)); break;
            case 7: mapSol.put(locations[i][j], new Vide());  break;

            default:
                mapSol.put(locations[i][j], new Herbe(0));
        }
    }

    public void creerObjet(int i, int j, int num) {
        switch (num){
            case 0 : mapObjects.put(locations[i][j], new Vide()); break;
            case 1 : mapObjects.put(locations[i][j], new Mur()); break;
            case 2 : mapObjects.put(locations[i][j], new Deplacable()); break;
            case 3 : mapObjects.put(locations[i][j], new Vie()); break;
            case 4 : mapObjects.put(locations[i][j], new Mana()); break;
            case 5 : mapObjects.put(locations[i][j], new Teleportation()); break;
            case 6 : mapObjects.put(locations[i][j], new Tourelle(Direction.DOWN, i, j)); break;
            case 7 : mapObjects.put(locations[i][j], new Sortie(true)); break;
            case 8 : mapObjects.put(locations[i][j], new Sortie(false)); break;
            case 9 :
                mapObjects.put(locations[i][j], new Vide());
                heros.setPos_in(locations[i][j]);
                break;

        }
    }

    public Heros getHeros() {
        return heros;
    }

    public Location[][] getLocations() {
        return locations;
    }

    public Hashtable<Location, ObjetCarte> getMapSol() {
        return mapSol;
    }

    public Hashtable<Location, ObjetCarte> getMapObjects() {
        return mapObjects;
    }

    public String getNom() {
        return nom;
    }

    public void setLEVEL_SOL(int[][] LEVEL_SOL) {
        this.LEVEL_SOL = LEVEL_SOL;
    }

    public void setLEVEL_OBJECTS(int[][] LEVEL_OBJECTS) {
        this.LEVEL_OBJECTS = LEVEL_OBJECTS;
    }
}

