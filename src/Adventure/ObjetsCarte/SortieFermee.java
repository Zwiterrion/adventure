package Adventure.ObjetsCarte;

import Adventure.Images;
import Adventure.Interface.Fixe;


public class SortieFermee extends Sortie implements Fixe {

    private String courante;
    private String destination;
    private boolean ouverte = false;

    @Override
    public void assigneImage() {
        image = Images.SORTIE_FERMEE;
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

    public boolean isOuverte() {
        return ouverte;
    }

    public void setOuverte(boolean ouverte) {
        this.ouverte = ouverte;
    }
}
