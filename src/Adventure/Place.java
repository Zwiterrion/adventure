package Adventure;

import Adventure.ObjectOfMap.*;

import java.util.ArrayList;
import java.util.Hashtable;

/**
 * Created by Etienne on 30/09/15.
 */
public class Place {

    private static int LEVEL_SOL[][]  = {
            { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
            { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
            { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
            { 2, 2, 2, 2, 1, 1, 2, 2, 2, 2 },
            { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
            { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
            { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
            { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
            { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
            { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
            { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 }};

    private static int LEVEL_OBJECTS[][]  = {
            { 0, 0, 1, 1, 0, 0, 0, 0, 0, 0 },
            { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
            { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
            { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
            { 0, 0, 3, 3, 0, 7, 0, 0, 0, 0 },
            { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
            { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
            { 0, 0, 0, 0, 0, 0, 0, 0, 2, 0 },
            { 0, 0, 0, 0, 0, 0, 0, 0, 2, 0 },
            { 1, 0, 0, 0, 0, 0, 0, 0, 0, 0 }};

    private Hashtable<Location,ObjectMap> mapObjects;
    private Hashtable<Location,ObjectMap> mapSol;

    private Location locations[][];
    private Heros heros;

    public Place(Heros h) {
        this.heros = h;
        mapObjects = new Hashtable<Location, ObjectMap>();
        mapSol = new Hashtable<Location, ObjectMap>();
        locations = new Location[World.X_MAX][World.Y_MAX];

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
            case 1: mapSol.put(locations[i][j], new Herbe()); break;
            case 2: mapSol.put(locations[i][j], new Vide());  break;
            default:
                mapSol.put(locations[i][j], new Herbe());
        }
    }

    public void creerObjet(int i, int j, int num) {
        switch (num){
            case 0 : mapObjects.put(locations[i][j], new Vide()); break;
            case 1 : mapObjects.put(locations[i][j], new Mur()); break;
            case 2 : mapObjects.put(locations[i][j], new Deplacable()); break;
            case 3 : mapObjects.put(locations[i][j], new Pile()); break;
            case 4 : mapObjects.put(locations[i][j], new Teleportation()); break;
            case 5 : mapObjects.put(locations[i][j], new Tourelle(Direction.DOWN, i, j)); break;
            case 6 : mapObjects.put(locations[i][j], new Sortie()); break;
            case 7 :
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

    public Hashtable<Location, ObjectMap> getMapSol() {
        return mapSol;
    }

    public Hashtable<Location, ObjectMap> getMapObjects() {
        return mapObjects;
    }


}

