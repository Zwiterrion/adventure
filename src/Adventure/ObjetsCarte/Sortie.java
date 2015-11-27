package Adventure.ObjetsCarte;

import Adventure.Images;
import Adventure.Interface.Fixe;

/**
 * Crée une instance de Sortie
 */
public class Sortie extends ObjetCarte implements Fixe {

    private String courante;
    private String destination;

    /**
     * Construit la sortie
     * @param destination
     *          Lieu de destination
     * @param courante
     *          Lieu courant
     */
    public Sortie(String destination, String courante) {
        super();
        this.destination = destination;
        this.courante = courante;
    }

    /**
     * Appelle l'image qui correspond a la Sortie
     */
    @Override
    public void assigneImage() {
        image = Images.SORTIE;
    }

    /**
     *
     * @return
     *      La Place courante
     */
    public String getNomPlace() {
        return courante;
    }

    /**
     *
     * @return
     *      La Place de destination
     */
    public String getDestination() {
        return destination;
    }

    /**
     * Change le lieu de destination
     * @param destination
     *      La Place de destination
     */
    public void setDestination(String destination) {
        this.destination = destination;
    }

    /**
     *
     * @return
     *      Retourne vrai si la place courante est un couloir
     */
    public boolean dansUnCouloir() {
        String a = courante.toLowerCase();
        return a.contains("couloir");
    }
}
