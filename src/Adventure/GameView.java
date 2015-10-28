package Adventure;

import javax.swing.*;
import java.awt.*;


public class GameView {

    private JFrame window;
    private World gameModel;
    public UIutilisateur UIutilisateur;

    public GameView(World gameModel, int w, int h, UIutilisateur panel) {

        window = new JFrame("Adventure");

        UIutilisateur = panel;
        this.gameModel = gameModel;
        window.add(gameModel);

        window.setBounds(100, 50, w, h);
        window.setVisible(true);
        window.setResizable(false);

        window.setLayout(new BorderLayout());

        window.add(gameModel, BorderLayout.CENTER);
        window.add(UIutilisateur, BorderLayout.SOUTH);
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }


    public World getGameModel() {
        return gameModel;
    }

}