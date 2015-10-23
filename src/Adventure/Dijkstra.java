package Adventure;


import Adventure.ObjectOfMap.Herbe;
import Adventure.ObjectOfMap.ObjectMap;

import java.util.Hashtable;
import java.util.Map;

public class Dijkstra {

    private Hashtable<Location, ObjectMap> noeuds;

    Location sommetDepart = new Location(0,0);

    public Dijkstra(Hashtable<Location, ObjectMap> noeuds) {
        this.noeuds = noeuds;
        init();
    }

    void init() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                ObjectMap o = noeuds.get(new Location(i,j));
                o.parcouru = false;
                o.poidsNoeud = -1;
                o.objetAdjacent = new Hashtable<Location, ObjectMap>();
                ajouterAdjacent(i,j,o);

                if(o instanceof Herbe) {
                    o.poidsArete = 1;
                }
                else {
                    o.poidsArete = 2;
                }
            }
        }
        ObjectMap depart = noeuds.get(sommetDepart);
        depart.parcouru = true;
    }

    void ajouterAdjacent(int i, int j, ObjectMap o) {

        Location up = new Location(i, j+1);
        Location down = new Location(i, j-1);
        Location left = new Location(i-1, j);
        Location right = new Location(i+1, j);

        if(estCorrecte(up))
            o.objetAdjacent.put(up, noeuds.get(up));
        if(estCorrecte(down))
            o.objetAdjacent.put(down, noeuds.get(down));
        if(estCorrecte(left))
            o.objetAdjacent.put(left, noeuds.get(left));
        if(estCorrecte(right))
            o.objetAdjacent.put(right, noeuds.get(right));
    }

    boolean estCorrecte(Location l) {
        return ((l.x >= 0 && l.x < 10) && (l.y >= 0 && l.y < 10));
    }


    Location trouve_min(ObjectMap o) {

        Location min = null;
        int minimum = o.poidsNoeud;
        for(Map.Entry<Location, ObjectMap> entry : o.objetAdjacent.entrySet()) {
            Location key = entry.getKey();
            ObjectMap value = entry.getValue();

            if(value.poidsArete + value.poidsNoeud < minimum) {
                minimum = value.poidsArete + value.poidsNoeud;
                min = key;
            }
        }
        return min;
    }

    boolean estParcouruEntierement() {

        for(Map.Entry<Location, ObjectMap> entry : noeuds.entrySet()) {
            ObjectMap value = entry.getValue();

            if(!value.parcouru)
                return false;

        }

        return true;
    }

    void mainDij(Location l) {

        while(!estParcouruEntierement()) {

        }
    }

}














