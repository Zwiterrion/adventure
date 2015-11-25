package Adventure.ObjetsCarte;

import Adventure.Images;
import Adventure.Interface.Fixe;


public class Sortie extends ObjetCarte implements Fixe {

    private String courante;
    private String destination;

    public Sortie(String destination, String courante) {
        super();
        this.destination = destination;
        this.courante = courante;
    }

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

    public void setDestination(String destination) {
        this.destination = destination;
    }
}
