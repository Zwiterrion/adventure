package Adventure.Places;

import Adventure.Heros;
import Adventure.ObjetsCarte.Clef;

import java.util.Random;

/**
 * Crée un nouveau lieu de type Place
 */
public class Bibliotheque extends Place {

    /**
     * Appelle le constructeur de la classe mère(Place) pour construire le lieu
     * @param h
     *          instance du héros
     */
    public Bibliotheque(Heros h) {
        super(h, "bibliotheque");

        cacherClef();
    }

    public void cacherClef() {

        Random r = new Random();
        int x = r.nextInt(2);
        int y = r.nextInt(7)+1;

        ajoutObjet(x, y, new Clef());

    }

}
