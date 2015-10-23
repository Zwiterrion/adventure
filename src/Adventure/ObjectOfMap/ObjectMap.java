package Adventure.ObjectOfMap;


import Adventure.Location;

import java.awt.image.BufferedImage;
import java.util.Hashtable;

public abstract class ObjectMap {

    protected BufferedImage image;

    public int poidsArete;
    public int poidsNoeud;
    public boolean parcouru;
    public Hashtable<Location, ObjectMap> objetAdjacent;

    public ObjectMap() {
        this.parcouru = false;
        this.poidsNoeud = -1;
        this.poidsArete = 4;
        assignImage();
    }

    public abstract void assignImage();

    public BufferedImage getImage() {
        return image;
    }
}
