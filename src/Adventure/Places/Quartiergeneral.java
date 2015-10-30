package Adventure.Places;

import Adventure.Heros;

/**
 * Created by Etienne on 27/10/2015.
 */
public class Quartiergeneral extends Place {

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
            { 8, 0, 0, 0, 7, 0, 0, 0, 0, 0 },
            { 0, 0, 0, 0, 0, 0, 0, 0, 0, 6 },
            { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
            { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
            { 0, 0, 0, 0, 3, 4, 0, 0, 0, 0 },
            { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
            { 6, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
            { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
            { 6, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
            { 0, 0, 0, 0, 0, 0, 0, 0, 6, 0 }};


    public Quartiergeneral(Heros h) {
        super(h);
        setLEVEL_OBJECTS(LEVEL_OBJECTS);
        setLEVEL_SOL(LEVEL_SOL);
        initialisation();
    }
}
