package Adventure.ObjetsCarte;


import java.awt.*;

public abstract class ObjetCarte {

    protected Image image;

    public ObjetCarte() {
        assignImage();
    }

    public abstract void assignImage();

    public Image getImage() {
        return image;
    }
}
