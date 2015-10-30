package Adventure;

public class Main {

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {

                int width = 1040;
                int height = 650;

                Images.chargementImage();
                World gameModel = new World(10, 10, width);
                GameView view = new GameView(gameModel, width, height);
                view.getGameModel().requestFocus();
                GameController controller = new GameController(view, gameModel);

                view.getGameModel().addMouseListener(controller);
                view.getGameModel().addKeyListener(controller);
            }
        });

    }
}
