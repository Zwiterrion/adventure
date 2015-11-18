package Adventure.ObjetsCarte;

import Adventure.Direction;

import java.awt.*;

public abstract class ObjetCarte {

    protected Image image;
    protected Direction dir = Direction.AUCUNE;

    public ObjetCarte() {
        assigneImage();
    }

    public ObjetCarte(Direction d) {
        super();
        setDir(d);
    }

    public void setDir(Direction dir) {
        this.dir = dir;
        assigneImage();
    }

    public abstract void assigneImage();

    public Image getImage() {
        return image;
    }
}
