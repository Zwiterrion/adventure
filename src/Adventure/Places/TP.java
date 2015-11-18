package Adventure.Places;

import Adventure.Direction;
import Adventure.Heros;
import Adventure.LecteurNiveau;
import Adventure.ObjetsCarte.Sortie;
import javafx.util.Pair;

/**
 * Created by Etienne on 10/11/2015.
 */
public class TP extends Place {

    public TP(Heros h) {
        super(h);
        LecteurNiveau l = new LecteurNiveau("tp");
        setLEVEL_OBJECTS(l.getLEVEL_OBJETS());
        setLEVEL_SOL(l.getLEVEL_SOL());
        initialisation();
        setNom("SALLE TP");
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
            }
            i++;
        }
    }
}
