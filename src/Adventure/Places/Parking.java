package Adventure.Places;

import Adventure.Heros;
import Adventure.LecteurNiveau;
import Adventure.ObjetsCarte.Sortie;


public class Parking extends Place {

    public Parking(Heros h) {
        super(h);
        LecteurNiveau l = new LecteurNiveau("parking");
        setLEVEL_OBJECTS(l.getLEVEL_OBJETS());
        setLEVEL_SOL(l.getLEVEL_SOL());
        initialisation();
        setNom("PARKING");
        initSorties();
    }

    @Override
    public void initSorties() {

        int i = 0;
        for (Sortie s : this.sorties) {

            switch (i) {
                case 0:
                    s.initialisation(this.getNom(), "SP2MI");
                    break;
                case 1:
                    s.initialisation(this.getNom(), "BIBLIOTHEQUE");
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
