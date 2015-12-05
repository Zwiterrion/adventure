package Adventure;

public class Launcher {

    /**
     * Thread principal du jeu
     * @param args
     */
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(() -> {

            int width = 1040;
            int height = 650;

            Images i = new Images();
            i.chargementImage();

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

