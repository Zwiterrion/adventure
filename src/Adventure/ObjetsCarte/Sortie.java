package Adventure.ObjetsCarte;

import Adventure.Direction;
import Adventure.Images;
import Adventure.Interface.Fixe;


public class Sortie extends ObjetCarte implements Fixe {

    private String courante;
    private String destination;

    public Sortie(Direction d) {
        super(d);
    }

    @Override
    public void assigneImage() {
        if (dir == Direction.NORD || dir == Direction.SUD)
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
