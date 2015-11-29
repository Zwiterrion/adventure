package Adventure;


import java.awt.*;

/**
 * Instance de l'Itilisateur
 */
public class UIutilisateur extends Canvas {

    private Heros heros;

    public UIutilisateur(Heros r) {
        this.heros = r;
    }

    /**
     * Dessine le héros avec sa barre d'inventaire
     * @param g
     */
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        heros.getInventaire().paint(g);
        dessineBarres(g);
    }

    /**
     * Dessine la barre d'inventaire du heros
     * @param g
     */
    public void dessineBarres(Graphics g) {
        Position point = calculPositionBarres();

        g.setColor(heros.getCouleurVie());
        g.fillRect(point.x + 28, point.y + Monde.TILE_SIZE / 2 - 6, (int) (0.4 * heros.getVie()), 5);

        g.setColor(new Color(16, 173, 255));

        g.fillRect(point.x + 28, point.y + Monde.TILE_SIZE / 2, (int) (0.4 * heros.getMana()), 3);
        g.drawRect(point.x + 26, point.y + Monde.TILE_SIZE / 2 - 8, 43, 12);
    }

    /**
     *
     * @return
     *      La position de la barre
     */
    public Position calculPositionBarres() {
        return IsometricHelper.point2DToIso(new Position(heros.getPos_in().y, heros.getPos_in().x));
    }

}
