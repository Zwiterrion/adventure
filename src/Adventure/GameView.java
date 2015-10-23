package Adventure;

import javax.swing.*;
import java.awt.*;


public class GameView extends JFrame {

    private JFrame window;
    private World gameModel;
    public PanelGame panelGame;

    public GameView(World gameModel, int w, int h, PanelGame panel) {

        window = new JFrame("Adventure");

        panelGame = panel;
        this.gameModel = gameModel;
        window.add(gameModel);

        window.setBounds(475, 150, w, h);
        window.setVisible(true);
        window.setResizable(false);

        window.setLayout(new BorderLayout());

        window.add(gameModel, BorderLayout.CENTER);
        window.add(panelGame, BorderLayout.SOUTH);
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }


    public World getGameModel() {
        return gameModel;
    }

}