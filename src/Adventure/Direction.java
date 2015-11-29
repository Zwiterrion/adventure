package Adventure;

/**
 * Les directions des images
 */
public enum Direction {
    NORD, EST, SUD, OUEST, NORD_EST, NORD_OUEST, SUD_EST, SUD_OUEST, TOUTES;


    /**
     * Change une direction donnée
     * @param s
     *      La direction
     * @return
     *      Une direction
     */
    public static Direction change(String s) {
        Direction dir = Direction.TOUTES;
        /**
         * NORD
         */
        if(s.equals("NORD"))
             return Direction.NORD;
        /**
         * SUD
         */
        else if(s.equals("SUD"))
            return Direction.SUD;
        /**
         * OUEST
         */
        else if(s.equals("OUEST"))
            return Direction.OUEST;
        /**
         * EST
         */
        else if(s.equals("EST"))
            return Direction.EST;
        /**
         * NORD_EST
         */
        else if(s.equals("NORD_EST"))
            return Direction.NORD_EST;
        /**
         * NORD_OUEST
         */
        else if(s.equals("NORD_OUEST"))
            return Direction.NORD_OUEST;
        /**
         * SUD_EST
         */
        else if(s.equals("SUD_EST"))
            return Direction.SUD_EST;
        /**
         * SUD_OUEST
         */
        else if(s.equals("SUD_OUEST"))
            return Direction.SUD_OUEST;
        else
            return dir;
    }
}


