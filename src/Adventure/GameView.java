package Adventure;

import javax.swing.*;

/**
 * Crée une instance de la vue
 */
public class GameView {

    private Monde gameModel;

    /**
     * Construit la vue
     * @param gameModel
     *      Instance du Monde
     * @param w
     *      La longueur de la fenetre a construire
     * @param h
     *      La hauteur de la fenetre a construire
     */
    public GameView(Monde gameModel, int w, int h) {

        JFrame window = new JFrame("Adventure");

        this.gameModel = gameModel;

        window.setBounds(0, 0, w, h);
        window.setVisible(true);
        window.setResizable(false);

        window.add(gameModel);
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }


    /**
     *
     * @return
     *      Le Monde
     */
    public Monde getGameModel() {
        return gameModel;
    }

}