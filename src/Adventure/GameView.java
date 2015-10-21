package Adventure;

import javax.swing.*;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by Etienne on 11/11/14.
 */
public class GameView extends JFrame implements Observer {

    private JFrame window;
    private World gameModel;
    public PanelGame panelGame;

    public GameView(World gameModel, int w, int h, PanelGame panel) {

        window = new JFrame("Adventure");

        panelGame = panel;
        this.gameModel = gameModel;
        gameModel.setSize(new Dimension(569,569));
        window.add(gameModel);

        window.setBounds(475, 150, w, h);
        window.setVisible(true);
        window.setResizable(false);

        window.setLayout(new BorderLayout());


        window.add(gameModel, BorderLayout.LINE_START);
        window.add(panelGame, BorderLayout.SOUTH);
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }


    @Override
    public void update(Observable o, Object arg) {

    }

    public String addRobot() {

        JTextField firstName = new JTextField();
        final JComponent[] inputs = new JComponent[] {
                new JLabel("Robot : "),
                firstName
        };
        JOptionPane.showMessageDialog(null, inputs, "Nom de votre robot", JOptionPane.PLAIN_MESSAGE);
        if(!firstName.getText().equals("")) {
            return firstName.getText();
        }
        else
            return "";
    }

    public World getGameModel() {
        return gameModel;
    }

}














































