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
    public void mouseClicked(MouseEvent e){

    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode())
        {
            case KeyEvent.VK_D:
                gameModel.deplacementHeros(1, 0, Direction.RIGHT);
                break;
            case KeyEvent.VK_Q:
                gameModel.deplacementHeros(-1, 0, Direction.LEFT);
                break;
            case KeyEvent.VK_Z:
                gameModel.deplacementHeros(0, 1, Direction.UP);
                break;
            case KeyEvent.VK_S:
                gameModel.deplacementHeros(0, -1, Direction.DOWN);
                break;
        }
    }

    @Override
    public void keyTyped(KeyEvent e){}
    @Override
    public void keyReleased(KeyEvent e){
    }
}
