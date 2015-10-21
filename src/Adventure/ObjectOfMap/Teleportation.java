package Adventure.ObjectOfMap;

import Adventure.Images;
import Adventure.Location;

public class Teleportation extends ObjectMap {

    private Location end;

    // Getters et Setters pour la téléportation associée
    public Location getEnd() {
        return end;
    }
    public void setEnd(Location end) {
        this.end = end;
    }

    @Override
    public void assignImage() {
        image = Images.TELEPORTATION;
    }
}
