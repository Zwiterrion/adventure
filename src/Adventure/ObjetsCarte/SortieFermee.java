package Adventure.ObjetsCarte;

import Adventure.Direction;
import Adventure.Images;
import Adventure.Interface.Fixe;

/**
 * Crée une instance de SortieFermee
 */
public class SortieFermee extends Sortie implements Fixe {

    private boolean ouverte = false;

    /**
     * Construit la sortie
     * @param destination
     *          Lieu de destination
     * @param courante
     *          Lieu courant
     */
    public SortieFermee(String destination, String courante) {
        super(destination, courante);
    }

    /**
     * Appelle l'image qui corresponde a la sortie
     */
    @Override
    public void assigneImage() {
        if(dir == Direction.AUCUNE)
            image = Images.SORTIE_FERMEE;
        else if(dir == Direction.EST)
            image = Images.SORTIE;
        else
            image = Images.CLEF_PORTE;
    }

    /**
     *
     * @return
     *      Retourne vrai si la sortie est ouverte
     */
    public boolean isOuverte() {
        return ouverte;
    }

    /**
     * Ouvre la sortie s'elle est fermee
     */
    public void ouvre() {
        this.ouverte = true;
        this.dir = Direction.EST;
        assigneImage();
    }

    /**
     * Ferme la sortie s'elle est ouverte
     */
    public void ferme() {
        this.ouverte = false;
        this.dir = Direction.AUCUNE;
        assigneImage();
    }

    /**
     * Change la direction de l'image
     */
    public void enExplosion() {
        this.dir= Direction.OUEST;
        assigneImage();
    }
}

