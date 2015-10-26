package Adventure.ObjectOfMap;


import java.awt.*;

public abstract class ObjectMap {

    protected Image image;

    public ObjectMap() {
        assignImage();
    }

    public abstract void assignImage();

    public Image getImage() {
        return image;
    }
}
