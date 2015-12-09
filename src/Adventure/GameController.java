package Adventure;

import javax.swing.event.MouseInputAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;

/**
 * Crée une instance du Controlleur: GameController
 */
public class GameController extends MouseInputAdapter implements KeyListener {

    private Monde gameModel;

    /**
     * Construit le GameController
     * @param model
     *      Instance du Monde: la carte du jeu
     */
    public GameController(Monde model) {
        this.gameModel = model;
    }

    /**
     * Recupere les frapes de clavier et les traites
     * @param e
     *      Instance de l'evenement clavier
     */
    @Override
    public void keyPressed(KeyEvent e) {

        switch (e.getKeyCode()) {
            case KeyEvent.VK_RIGHT:
                gameModel.deplacementHeros(1, 0, Direction.EST);
                break;
            case KeyEvent.VK_LEFT:
                gameModel.deplacementHeros(-1, 0, Direction.OUEST);
                break;
            case KeyEvent.VK_UP:
                gameModel.deplacementHeros(0, 1, Direction.NORD);
                break;
            case KeyEvent.VK_DOWN:
                gameModel.deplacementHeros(0, -1, Direction.SUD);
                break;
            case KeyEvent.VK_A:
                gameModel.getHeros().utiliserObjet(0);
                break;
            case KeyEvent.VK_Z:
                gameModel.getHeros().utiliserObjet(1);
                break;
            case KeyEvent.VK_E:
                if (gameModel.poseBombe())
                    gameModel.getHeros().utiliserObjet(2);
                break;
        }
    }


    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    /**
     * Recupere les touches de souris et les traites
     * @param e
     *      Instance de l'evenement souris
     */
    @Override
    public void mouseClicked(MouseEvent e) {
        super.mouseClicked(e);

        if((e.getX() > 840 && e.getX() < 1040) && (e.getY() > 10 && e.getY() < 60)) {
            gameModel.relance();
        }
    }

    /**
     * Recupere les mouvements de la souris et les traites
     * @param e
     *      Instance de l'evenement souris
     */
    @Override
    public void mouseMoved(MouseEvent e) {
        super.mouseMoved(e);

        if((e.getX() > 840 && e.getX() < 1040) && (e.getY() > 10 && e.getY() < 60))
            gameModel.setMouse(true);
        else
            gameModel.setMouse(false);

    }
}
