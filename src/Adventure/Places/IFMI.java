package Adventure.Places;

import Adventure.Direction;
import Adventure.Heros;
import Adventure.LecteurNiveau;
import Adventure.ObjetsCarte.Sortie;
import javafx.util.Pair;

/**
 * Created by Etienne on 10/11/2015.
 */
public class IFMI extends Place {

    public IFMI(Heros h) {
        super(h);
        LecteurNiveau l = new LecteurNiveau("ifmi");
        setLEVEL_OBJECTS(l.getLEVEL_OBJETS());
        setLEVEL_SOL(l.getLEVEL_SOL());
        initialisation();
        setNom("IFMI");
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
