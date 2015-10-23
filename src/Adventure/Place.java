package Adventure;

import Adventure.ObjectOfMap.*;

import java.util.ArrayList;
import java.util.Hashtable;

/**
 * Created by Etienne on 30/09/15.
 */
public class Place {

    private static int LEVEL_1[][]  = {
            { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
            { 0, 8, 1, 1, 1, 1, 1, 1, 5, 0 },
            { 0, 1, 1, 1, 1, 1, 1, 3, 1, 0 },
            { 0, 1, 1, 1, 1, 1, 1, 1, 1, 0 },
            { 0, 1, 1, 3, 1, 1, 1, 0, 1, 0 },
            { 0, 1, 1, 1, 1, 1, 1, 0, 1, 0 },
            { 0, 1, 1, 1, 1, 1, 1, 0, 1, 0 },
            { 0, 1, 1, 1, 1, 1, 3, 0, 1, 0 },
            { 0, 1, 1, 1, 1, 3, 1, 0, 1, 0 },
            { 0, 0, 0, 0, 0, 0, 0, 0, 6, 0 }};

    private static int LEVEL_2[][]  = {
            { 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
            { 0, 1, 1, 1, 1, 1, 1, 1, 8, 1 },
            { 0, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
            { 0, 1, 1, 1, 1, 5, 1, 1, 1, 1 },
            { 0, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
            { 0, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
            { 0, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
            { 0, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
            { 0, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
            { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }};

    public static int levelCourant = 0;
    private Hashtable<Location,ObjectMap> level;
    private Location locations[][];
    private Location locationMainRobot;
    private int X_MAX;
    private int Y_MAX;

    private ArrayList<Tourelle> towers;


    public Place(int max_x, int max_y) {
        level = new Hashtable<Location, ObjectMap>();
        this.X_MAX = max_x;
        this.Y_MAX = max_y;
        towers = new ArrayList<Tourelle>();
        locations = new Location[X_MAX][Y_MAX];
        initLocations();
        loadLevel();
        levelCourant++;
    }

    public void initLocations() {
        for(int i=0; i<X_MAX; i++)
            for(int j=0; j<Y_MAX; j++)
                locations[i][j] = new Location(i, j);

    }

    public void loadLevel() {
        if(levelCourant == 1){
            for(int i=0; i<X_MAX;i++)
                for(int j=0; j<Y_MAX; j++)
                    addInMap(i,j,LEVEL_1[j][i]);
        }
        else {
            for(int i=0; i<X_MAX;i++)
                for(int j=0; j<Y_MAX; j++)
                    addInMap(i,j,LEVEL_2[j][i]);
        }

    }

    public void addInMap(int i, int j, int num) {
        switch (num){
            case 0 : level.put(locations[i][j], new Mur()); break;
            case 1 : level.put(locations[i][j], new Herbe()); break;
            case 2 : level.put(locations[i][j], new Deplacable()); break;
            case 3 : level.put(locations[i][j], new Pile()); break;
            case 4 :
                if(i == 1 && j == 2) {
                    Teleportation t = new Teleportation();
                    t.setEnd(locations[2][6]);
                    level.put(locations[i][j], t);
                }else {
                    Teleportation t = new Teleportation();
                    t.setEnd(locations[1][2]);
                    level.put(locations[i][j], t);
                }
                break;
            case 5 :
                Tourelle t = new Tourelle(Direction.DOWN, i,j);
                towers.add(t);
                level.put(locations[i][j], t);
                break;
            case 6 : level.put(locations[i][j], new Sortie()); break;
            case 8 :
                level.put(locations[i][j], new Herbe());
                locationMainRobot = locations[i][j];
                break;
        }
    }

    public Hashtable<Location, ObjectMap> getLevel() {
        return level;
    }

    public static int getLevelCourant() {
        return levelCourant;
    }

    public Location[][] getLocations() {
        return locations;
    }

    public Location getLocationMainRobot() {
        return locationMainRobot;
    }

    public ArrayList<Tourelle> getTowers() {
        return towers;
    }
}

