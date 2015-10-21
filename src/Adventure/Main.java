package Adventure;


public class Main {

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {

                int width = 740;
                int height = 790;

                PanelGame panel = new PanelGame();
                World gameModel = new World(10,10, width, panel);
                GameView view = new GameView(gameModel, width, height, panel);
                view.getGameModel().requestFocus();
                GameController controller = new GameController(view, gameModel);

                view.getGameModel().addMouseListener(controller);
                view.getGameModel().addKeyListener(controller);
                panel.addMouseListener(controller);
                panel.gameModel = gameModel;
            }
        });

    }
}
