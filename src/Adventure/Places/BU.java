package Adventure.Places;

import Adventure.Heros;
import Adventure.ObjetsCarte.Sortie;

/**
 * Created by Etienne on 10/11/2015.
 */
public class BU extends Place {

    private int LEVEL_SOL[][] = {
            {8, 8, 8, 8, 8, 8, 8, 8, 8, 8},
            {8, 8, 8, 8, 8, 8, 8, 8, 8, 8},
            {8, 8, 8, 8, 8, 8, 8, 8, 8, 8},
            {8, 8, 8, 8, 8, 8, 8, 8, 8, 8},
            {8, 8, 8, 8, 8, 8, 8, 8, 8, 8},
            {8, 8, 8, 8, 8, 8, 8, 8, 8, 8},
            {8, 8, 8, 8, 8, 9, 8, 8, 8, 8},
            {8, 8, 8, 8, 8, 8, 8, 8, 8, 8},
            {8, 8, 8, 8, 8, 8, 8, 8, 8, 8},
            {8, 8, 8, 8, 8, 8, 8, 8, 8, 8}};

    private int LEVEL_OBJECTS[][] = {
            {16, 16, 16, 16, 16, 16, 16, 16, 16, 18},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 17},
            {6, 8, 17, 0, 17, 0, 17, 0, 0, 17},
            {0, 0, 17, 0, 17, 0, 17, 0, 0, 17},
            {0, 0, 17, 0, 17, 0, 17, 0, 0, 17},
            {0, 0, 17, 0, 17, 0, 17, 0, 0, 17},
            {0, 0, 17, 0, 17, 0, 17, 0, 0, 17},
            {0, 0, 17, 0, 17, 0, 17, 0, 0, 17},
            {0, 0, 17, 0,  17, 0, 17, 0, 0, 17},
            {0, 0, 0, 0,  17, 0, 0, 0, 0, 17}};


    public BU(Heros h) {
        super(h);
        setLEVEL_OBJECTS(LEVEL_OBJECTS);
        setLEVEL_SOL(LEVEL_SOL);
        initialisation();
        setNom("BIBLIOTHEQUE");
        initSorties();
    }

    @Override
    public void initSorties() {

        int i = 0;
        for (Sortie s : this.sorties) {

            switch (i) {
                case 0:
                    s.initialisation(this.getNom(), "FUTUROSCOPE");
                    break;
            }
            i++;
        }
    }
}
