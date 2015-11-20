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
            return Direction.OUEST;
        else if(s.equals("EST"))
            return Direction.EST;
        else if(s.equals("NORD_EST"))
            return Direction.NORD_EST;
        else if(s.equals("NORD_OUEST"))
            return Direction.NORD_OUEST;
        else if(s.equals("SUD_EST"))
            return Direction.SUD_EST;
        else if(s.equals("SUD_OUEST"))
            return Direction.SUD_OUEST;
        else
            return dir;
    }
}


