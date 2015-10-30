package Adventure;

import java.awt.*;

public class UIutilisateur extends Canvas {

    public Heros heros;

    public UIutilisateur(Heros r) {
        this.heros = r;
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        heros.getInventaire().paint(g);
        dessineBarres(g);
    }

    public void dessineBarres(Graphics g) {
        Location point = calculPositionBarres();
        g.setColor(Color.GREEN);
        g.fillRect(point.x + 28, point.y + World.TILE_SIZE / 2 - 6, 40, 5);
        g.setColor(Color.CYAN);
        g.fillRect(point.x + 28, point.y + World.TILE_SIZE/2, 40, 3);
        g.setColor(new Color(16, 173, 255));
        g.drawRect(point.x + 26, point.y + World.TILE_SIZE/2 - 8, 43, 12);
    }

    public Location calculPositionBarres() {
        Location point = IsometricHelper.point2DToIso(heros.getPos_in());
        return point;
    }
}
