package Adventure.ObjetsCarte;


/**
 * Crée une instance du Vide
 */
public class Vide extends ObjetCarte {

    /**
     * Appelle l'image qui corresponde au Vide
     */
    @Override
    public void assigneImage() {
        image = null;
    }
}
