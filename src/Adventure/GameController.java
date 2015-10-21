package Adventure;

import Adventure.ObjectOfMap.Direction;

import javax.swing.event.MouseInputAdapter;
import java.awt.event.*;

public class GameController extends MouseInputAdapter implements KeyListener {

    private GameView gameView;
    private World gameModel;

    public GameController(GameView view, World model) {
        this.gameView = view;
        this.gameModel = model;
    }
    @Override
    public void mouseClicked(MouseEvent e){
        gameModel.newMissile(e);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode())
        {
            case KeyEvent.VK_D:
                gameModel.moveMainRobot(1,0, Direction.RIGHT);
                break;
            case KeyEvent.VK_Q:
                gameModel.moveMainRobot(-1,0,Direction.LEFT);
                break;
            case KeyEvent.VK_Z:
                gameModel.moveMainRobot(0,-1,Direction.UP);
                break;
            case KeyEvent.VK_S:
                gameModel.moveMainRobot(0,1,Direction.DOWN);
                break;
        }

        gameView.panelGame.lessEnergy();
    }

    @Override
    public void keyTyped(KeyEvent e){}
    @Override
    public void keyReleased(KeyEvent e){}
}
