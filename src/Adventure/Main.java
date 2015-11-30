package Adventure;

public class Main {

    /**
     * Thread principal du jeu
     * @param args
     */
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(() -> {

            int width = 1040;
            int height = 650;

            Images.chargementImage();

            Monde gameModel = new Monde(10, 10, width);
            GameView view = new GameView(gameModel, width, height);
            GameController controller = new GameController(gameModel);

            view.getGameModel().requestFocus();
            view.getGameModel().addKeyListener(controller);
            view.getGameModel().addMouseListener(controller);
            view.getGameModel().addMouseMotionListener(controller);
        });
    }
}

