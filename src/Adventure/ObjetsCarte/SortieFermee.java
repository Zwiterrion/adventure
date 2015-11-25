package Adventure.ObjetsCarte;

import Adventure.Direction;
import Adventure.Images;
import Adventure.Interface.Fixe;


public class SortieFermee extends Sortie implements Fixe {

    private String courante;
    private String destination;
    private boolean ouverte = false;

    public SortieFermee(String destination, String courante) {
        super(destination, courante);
    }


    @Override
    public void assigneImage() {
        if(dir == Direction.AUCUNE)
            image = Images.SORTIE_FERMEE;
        else if(dir == Direction.EST)
            image = Images.SORTIE;
        else
            image = Images.CLEF_PORTE;
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

    public void ouvre() {
        this.ouverte = true;
        this.dir = Direction.EST;
        assigneImage();
    }

    public void ferme() {
        this.ouverte = false;
        this.dir = Direction.AUCUNE;
        assigneImage();
    }

    public void enExplosion() {
        this.dir= Direction.OUEST;
        assigneImage();
    }
}

