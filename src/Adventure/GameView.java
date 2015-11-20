package Adventure;

import javax.swing.*;


public class GameView {

    private World gameModel;

    public GameView(World gameModel, int w, int h) {

        JFrame window = new JFrame("Adventure");

        this.gameModel = gameModel;

        window.setBounds(300, 100, w, h);
        window.setVisible(true);
        window.setResizable(false);

        window.add(gameModel);
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }


    public World getGameModel() {
        return gameModel;
    }

}