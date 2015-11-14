package Adventure.ObjetsCarte;

import Adventure.Images;
import Adventure.Interface.Fixe;

/**
 * Created by Etienne on 27/09/15.
 */
public class Sortie extends ObjetCarte implements Fixe {

    private boolean face;
    private String courante;
    private String destination;

    public Sortie(boolean i) {
        super();
        this.face = i;
        assignImage();
    }
    @Override
    public void assignImage() {
        if(face)
            image = Images.SORTIE;
        else
            image = Images.SORTIE2;
    }

    public String getNomPlace() {
        return courante;
    }

    public String getDestination() {
        return destination;
    }

    public void initialisation(String courante, String destination) {
        this.courante = courante;
        this.destination = destination;
    }
}
