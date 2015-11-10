package Adventure.Places;

import Adventure.Heros;


public class Futuroscope extends Place {

    private int LEVEL_SOL[][]  = {
            { 1, 1, 3, 7, 2, 7, 7, 7, 7, 7 },
            { 7, 7, 2, 7, 2, 7, 7, 4, 1, 1 },
            { 7, 7, 2, 7, 2, 7, 7, 2, 7, 7 },
            { 7, 7, 2, 7, 2, 7, 7, 2, 7, 7 },
 /*B*/      { 7, 7, 6, 0, 0, 0, 0, 5, 7, 7 },   /*H*/
            { 7, 7, 7, 0, 0, 0, 0, 7, 7, 7 },
            { 1, 1, 1, 0, 0, 0, 0, 7, 7, 7 },
            { 7, 7, 7, 2, 7, 7, 6, 3, 7, 7 },
            { 1, 1, 1, 5, 7, 7, 7, 6, 3, 7 },
            { 7, 7, 7, 7, 7, 7, 7, 7, 2, 7 }};

    private int LEVEL_OBJECTS[][]  = {
            { 8, 0, 0, 0, 7,  0,  0, 0, 0, 0 },
            { 0, 0, 0, 0, 0,  0,  0, 0, 0, 6 },
            { 0, 0, 0, 0, 0,  0,  0, 0, 0, 0 },
            { 0, 0, 0, 0, 10, 0,  0, 0, 0, 0 },
            { 0, 0, 0, 0, 0,  0,  0, 0, 0, 0 },
            { 0, 0, 0, 0, 0,  0,  0, 0, 0, 0 },
            { 6, 0, 0, 0, 0,  10, 0, 0, 0, 0 },
            { 0, 0, 0, 0, 0,  0,  0, 0, 0, 0 },
            { 6, 0, 0, 0, 0,  0,  0, 0, 0, 0 },
            { 0, 0, 0, 0, 0,  0,  0, 0, 6, 0 }};


    public Futuroscope(Heros h) {
        super(h);
        setLEVEL_OBJECTS(LEVEL_OBJECTS);
        setLEVEL_SOL(LEVEL_SOL);
        initialisation();
        setNom("Futuroscope");
    }
}
