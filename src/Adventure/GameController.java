package Adventure;

import javax.swing.event.MouseInputAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;

public class GameController extends MouseInputAdapter implements KeyListener {

    private GameView gameView;
    private World gameModel;

    public GameController(GameView view, World model) {
        this.gameView = view;
        this.gameModel = model;
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_RIGHT:
                gameModel.deplacementHeros(1, 0, Direction.DROITE);
                break;
            case KeyEvent.VK_LEFT:
                gameModel.deplacementHeros(-1, 0, Direction.GAUCHE);
                break;
            case KeyEvent.VK_UP:
                gameModel.deplacementHeros(0, 1, Direction.HAUT);
                break;
            case KeyEvent.VK_DOWN:
                gameModel.deplacementHeros(0, -1, Direction.BAS);
                break;
            case KeyEvent.VK_A:
                gameModel.getHeros().utiliserObjet(0);
                break;
            case KeyEvent.VK_Z:
                gameModel.getHeros().utiliserObjet(1);
                break;
            case KeyEvent.VK_E:
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

}
