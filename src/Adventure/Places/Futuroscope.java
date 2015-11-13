package Adventure.Places;

import Adventure.Heros;
import Adventure.ObjetsCarte.Sortie;


public class Futuroscope extends Place {

    private int LEVEL_SOL[][]  = {
            { 1, 1, 3, 7, 7, 7, 7, 7, 7, 7 },
            { 7, 7, 2, 7, 7, 7, 7, 4, 1, 1 },
            { 7, 7, 2, 7, 7, 7, 7, 2, 7, 7 },
            { 7, 7, 6, 0, 0, 0, 0, 5, 7, 7 },
 /*B*/      { 7, 7, 7, 0, 0, 0, 0, 7, 7, 7 },   /*H*/
            { 7, 7, 7, 0, 0, 0, 0, 7, 7, 7 },
            { 1, 1, 1, 0, 0, 0, 0, 7, 7, 7 },
            { 7, 7, 7, 2, 7, 7, 6, 3, 7, 7 },
            { 1, 1, 1, 5, 7, 7, 7, 6, 3, 7 },
            { 7, 7, 7, 7, 7, 7, 7, 7, 2, 7 }};

    private int LEVEL_OBJECTS[][]  = {
            { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
            { 0, 0, 0, 0, 0, 0, 0, 0, 8, 6 },
            { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
            { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
            { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
            { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
            { 6, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
            { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
            { 6, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
            { 0, 0, 0, 0, 0, 0, 0, 0, 6, 0 }};


    public Futuroscope(Heros h) {
        super(h);
        setLEVEL_OBJECTS(LEVEL_OBJECTS);
        setLEVEL_SOL(LEVEL_SOL);
        initialisation();
        setNom("FUTUROSCOPE");
        initSorties();
    }

    @Override
    public void initSorties() {

        int i = 0;
        for(Sortie s : this.sorties) {

            switch (i) {
                case 0:
                    s.initialisation(this.getNom(), "SP2MI");
                    break;
                case 1:
                    s.initialisation(this.getNom(), "BU");
                    break;
                case 2:
                    s.initialisation(this.getNom(), "IFMI");
                    break;
                case 3:
                    s.initialisation(this.getNom(), "SALLE TP");
                    break;
            }
            i++;
        }
    }


}
