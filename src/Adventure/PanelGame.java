package Adventure;

import javax.swing.*;
import java.awt.*;

public class PanelGame extends JPanel  {

    public JProgressBar energy;
    public World gameModel;

    public PanelGame() {
        setBorder(BorderFactory.createMatteBorder(3, 0, 0, 0, Color.BLACK));

        energy = new JProgressBar();
        energy.setString("Energie");
        energy.setStringPainted(true);
        energy.setValue(100);
        energy.setDoubleBuffered(true);
        energy.setPreferredSize(new Dimension(400, 20));
        add(energy);
    }

   public void lessEnergy() {
        energy.setValue(energy.getValue()-2);
       if(energy.getValue() < 0) energy.setValue(0);
   }

    public void moreEnergy() {
        energy.setValue(energy.getValue()+40);
        if(energy.getValue() > 100) energy.setValue(100);
    }

}
