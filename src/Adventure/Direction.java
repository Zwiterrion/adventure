package Adventure;

public enum Direction {
    NORD, EST, SUD, OUEST, NORD_EST, NORD_OUEST, SUD_EST, SUD_OUEST, AUCUNE;


    public static Direction change(String s) {
        Direction dir = Direction.AUCUNE;
        if(s.equals("NORD"))
             return Direction.NORD;
        else if(s.equals("SUD"))
            return Direction.SUD;
        else if(s.equals("OUEST"))
            return Direction.SUD;
        else if(s.equals("EST"))
            return Direction.SUD;
        else if(s.equals("NORD_EST"))
            return Direction.SUD;
        else if(s.equals("NORD_OUEST"))
            return Direction.SUD;
        else if(s.equals("SUD_EST"))
            return Direction.SUD;
        else if(s.equals("SUD_OUEST"))
            return Direction.SUD;
        else
            return dir;
    }
}


