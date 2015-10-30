package Adventure;

import javax.swing.*;


public class GameView {

    private JFrame window;
    private World gameModel;

    public GameView(World gameModel, int w, int h) {

        window = new JFrame("Adventure");

        this.gameModel = gameModel;

        window.setBounds(100, 50, w, h);
        window.setVisible(true);
        window.setResizable(false);

        window.add(gameModel);
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }


    public World getGameModel() {
        return gameModel;
    }

}