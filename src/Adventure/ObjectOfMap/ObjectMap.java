package Adventure.ObjectOfMap;


import java.awt.image.BufferedImage;

public abstract class ObjectMap {

    protected BufferedImage image;

    public ObjectMap() {
        assignImage();
    }

    public abstract void assignImage();

    public BufferedImage getImage() {
        return image;
    }
}
