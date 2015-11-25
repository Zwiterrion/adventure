package Adventure.Places;

import Adventure.Direction;
import Adventure.Heros;
import Adventure.LecteurNiveau;
import Adventure.ObjetsCarte.Sortie;
import javafx.util.Pair;


public class Couloir extends Place {

    public Couloir(Heros h) {
        super(h);
        LecteurNiveau l = new LecteurNiveau("couloir");
        setLEVEL_OBJECTS(l.getLEVEL_OBJETS());
        setLEVEL_SOL(l.getLEVEL_SOL());
        initialisation();
        setNom("COULOIR");
        initSorties();
    }

    @Override
    public void initSorties() {

        int i = 0;
        for (Sortie s : this.sorties) {

            switch (i) {
                case 0:
                    s.initialisation(this.getNom(), "FUTUROSCOPE");
                    break;
                case 1:
                    s.initialisation(this.getNom(), "PARKING");
                    break;
            }
            i++;
        }
    }
}
