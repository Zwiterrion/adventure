package Adventure;

import javax.swing.*;


public class GameView {

    private Monde gameModel;

    public GameView(Monde gameModel, int w, int h) {

        JFrame window = new JFrame("Adventure");

        this.gameModel = gameModel;

        window.setBounds(300, 100, w, h);
        window.setVisible(true);
        window.setResizable(false);

        window.add(gameModel);
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }


    public Monde getGameModel() {
        return gameModel;
    }

}