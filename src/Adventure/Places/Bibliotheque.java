package Adventure.Places;

import Adventure.Heros;
import Adventure.ObjetsCarte.Sortie;

public class Bibliotheque extends Place {

    public Bibliotheque(Heros h) {
        super(h);
    }

    @Override
    public void initSorties() {

        int i = 0;
        for (Sortie s : this.sorties) {

            switch (i) {
                case 0:
                    s.initialisation(this.getNom(), "PARKING");
                    break;
            }
            i++;
        }
    }
}
