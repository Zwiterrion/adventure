package Adventure.Places;

import Adventure.Direction;
import Adventure.Heros;
import Adventure.ObjetsCarte.Sortie;

/**
 * Created by Etienne on 10/11/2015.
 */
public class SP2MI extends Place {

    private int LEVEL_SOL[][]  = {
            { 8, 8, 8, 8, 8, 8, 8, 8, 8, 8 },
            { 8, 8, 8, 8, 8, 8, 8, 8, 8, 8 },
            { 8, 8, 8, 8, 8, 8, 8, 8, 8, 8 },
            { 8, 8, 8, 8, 8, 8, 8, 8, 8, 8 },
            { 8, 8, 8, 8, 8, 8, 8, 8, 8, 8 },
            { 8, 8, 8, 8, 8, 8, 8, 8, 8, 8 },
            { 8, 8, 8, 8, 8, 9, 8, 8, 8, 8 },
            { 8, 8, 8, 8, 8, 8, 8, 8, 8, 8 },
            { 8, 8, 8, 8, 8, 8, 8, 8, 8, 8 },
            { 8, 8, 8, 8, 8, 8, 8, 8, 8, 8 }};

    private int LEVEL_OBJECTS[][]  = {
            { 1, 1, 1, 1, 1, 1, 1, 1, 1, 12 },
            { 0, 0, 0, 0, 0, 0, 0, 0, 0, 11 },
            { 6, 8, 0, 0, 0, 0, 0, 0, 0, 11 },
            { 0, 0, 3, 0, 4, 0, 0, 9, 0, 11 },
            { 0, 0, 0, 0, 0, 0, 0, 0, 0, 11 },
            { 0, 0, 0, 0, 4, 0, 0, 0, 0, 11 },
            { 0, 0, 0, 0, 0, 0, 0, 0, 0, 11 },
            { 0, 0, 0, 0, 0, 0, 0, 0, 0, 11 },
            { 0, 0, 3, 0, 0, 0, 0, 0, 0, 11 },
            { 0, 0, 0, 0, 0, 0, 0, 0, 0, 11 }};


    public SP2MI(Heros h) {
        super(h);
        setLEVEL_OBJECTS(LEVEL_OBJECTS);
        setLEVEL_SOL(LEVEL_SOL);
        initialisation();
        setNom("SP2MI");
        initSorties();
    }

    @Override
    public void initSorties() {

        int i = 0;
        for(Sortie s : this.sorties) {

            switch (i) {
                case 0:
                    s.initialisation(this.getNom(), "FUTUROSCOPE");
                    break;
            }
            i++;
        }
    }
}
