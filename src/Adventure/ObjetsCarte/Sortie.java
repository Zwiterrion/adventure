package Adventure.ObjetsCarte;

import Adventure.Images;
import Adventure.Interface.Fixe;


public class Sortie extends ObjetCarte implements Fixe {

    private String courante;
    private String destination;

    @Override
    public void assigneImage() {
        image = Images.SORTIE;
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
