package Adventure.Places;

import Adventure.Direction;
import Adventure.Heros;
import Adventure.LecteurNiveau;
import Adventure.ObjetsCarte.Sortie;
import Adventure.Tuple;
import javafx.util.Pair;


public class BU extends Place {

    public BU(Heros h) {
        super(h);
        LecteurNiveau l = new LecteurNiveau("bu");
        setLEVEL_OBJECTS(l.getLEVEL_OBJETS());
        setLEVEL_SOL(l.getLEVEL_SOL());
        initialisation();
        setNom("BIBLIOTHEQUE");
        initSorties();
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
