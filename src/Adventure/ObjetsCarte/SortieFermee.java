package Adventure.ObjetsCarte;

import Adventure.Direction;
import Adventure.Images;
import Adventure.Interface.Fixe;

/**
 * Cree une instance de SortieFermee
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
     * Assigne l'image qui correspond a la sortie
     */
    @Override
    public void assigneImage() {
        if(dir == Direction.TOUTES)
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
     * Ouvre la sortie si elle est fermee
     */
    public void ouvre() {
        this.ouverte = true;
        this.dir = Direction.EST;
        assigneImage();
    }

    /**
     * Ferme la sortie si elle est ouverte
     */
    public void ferme() {
        this.ouverte = false;
        this.dir = Direction.TOUTES;
        assigneImage();
    }

    /**
     * Change l'image pendant l'explosion de la porte
     */
    public void enExplosion() {
        this.dir= Direction.OUEST;
        assigneImage();
    }
}

