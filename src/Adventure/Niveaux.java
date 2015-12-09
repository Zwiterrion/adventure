package Adventure;

import Adventure.Places.*;

/**
 * Cree les niveaux du jeu
 */
public class Niveaux {

    public Place PARKING;
    public Place BU;
    public Place IFMI;
    public Place SP2MI;
    public Place SALLETP;

    public Niveaux(Heros h) {
        PARKING = new Parking(h);
        BU = new Bibliotheque(h);
        IFMI = new IFMI(h);
        SP2MI = new SP2MI(h);
        SALLETP = new SalleTp(h);
    }

    public Place niveauSuivant(String dest) {

        if (dest.equalsIgnoreCase("SP2MI"))
            return SP2MI;
        else if(dest.equalsIgnoreCase("IFMI"))
            return IFMI;
        else if(dest.equalsIgnoreCase("SALLETP"))
            return SALLETP;
        else if(dest.equalsIgnoreCase("BIBLIOTHEQUE"))
            return BU;
        else
            return PARKING;
    }

    public void sauvegarde(Place place) {

        String dest = place.nom;

        if(!dest.contains("couloir")) {

            if (dest.equalsIgnoreCase("SP2MI"))
                SP2MI = (SP2MI) place.clone();
            else if (dest.equalsIgnoreCase("IFMI"))
                IFMI = (IFMI) place.clone();
            else if (dest.equalsIgnoreCase("SALLETP"))
                SALLETP = (SalleTp) place.clone();
            else if (dest.equalsIgnoreCase("BIBLIOTHEQUE"))
                BU = (Bibliotheque) place.clone();
            else
                PARKING = (Parking) place.clone();
        }
    }

}
