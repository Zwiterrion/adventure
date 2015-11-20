package Adventure;

import Adventure.Runnable.RunnableMonstre;

import java.awt.*;


public class Personnage extends Canvas {

    private Position p;
    private World w;
    private Thread t;
    private Image image = Images.TOURELLE;

    public Personnage(Position p, World w) {
        this.p = p;
        this.w = w;
        t = new Thread(new RunnableMonstre(p,this,w));
    }

    public void active() {
        t.start();
    }

    @Override
    public void paint(Graphics g) {
        Position pos = IsometricHelper.point2DToIso(new Position(p.y, p.x));
        g.drawImage(image, pos.x, pos.y, World.TILE_SIZE, World.TILE_SIZE*2, this);
        w.repaint();
    }
}
