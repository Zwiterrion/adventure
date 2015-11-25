package Adventure.Places;

import Adventure.Heros;
import Adventure.LecteurNiveau;
import Adventure.ObjetsCarte.Sortie;


public class Parking extends Place {

    public Parking(Heros h) {
        super(h);
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
                    s.initialisation(this.getNom(), "SALLE SalleTp");
                    break;
            }
            i++;
        }
    }


}
