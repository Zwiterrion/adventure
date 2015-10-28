package Adventure.ObjetsInventaire;

import Adventure.Location;
import Adventure.UIutilisateur;

import javax.swing.*;
import java.awt.*;

public abstract class ObjetInventaire extends JPanel {

    protected Image image;
    protected UIutilisateur ath;

    private Location position;
    public static int TILE_SIZE;

    public ObjetInventaire(int x, int y, UIutilisateur ath) {
        assignImage();
        position = new Location(x,y);
        this.ath = ath;
    }

    public abstract void assignImage();

    public abstract void activationObjet();

    public Image getImage() { return image; }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.drawRect(position.x, position.y, TILE_SIZE, TILE_SIZE);
        g.drawImage(image, position.x, position.y, this);
    }
}
