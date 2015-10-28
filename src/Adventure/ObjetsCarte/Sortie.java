package Adventure.ObjetsCarte;

import Adventure.Images;

import java.util.Hashtable;

/**
 * Created by Etienne on 27/09/15.
 */
public class Sortie extends ObjetCarte {

    private boolean face;
    private Hashtable<String, Sortie> lieuxVoisins;

    public Sortie(boolean i ) {
        super();
        this.face = i;
        assignImage();
    }
    @Override
    public void assignImage() {
        if(face)
            image = Images.SORTIE;
        else
            image = Images.SORTIE2;
    }

}
