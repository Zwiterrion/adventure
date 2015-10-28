package Adventure;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class UIutilisateur extends JPanel  {

    public JProgressBar progressBar;
    public JButton potionVie;
    public JButton potionMana;

    public void initialisation() {
        setBorder(BorderFactory.createMatteBorder(3, 0, 0, 0, Color.BLACK));

        progressBar = new JProgressBar();
        progressBar.setMinimum(0);
        progressBar.setMaximum(100);
        progressBar.setValue(100);
        progressBar.setPreferredSize(new Dimension(300, 20));
        progressBar.setStringPainted(true);

        potionVie = new JButton(new ImageIcon(Images.POTION_VIE));
        potionMana = new JButton(new ImageIcon(Images.POTION_MANA));

        setLayout(new BorderLayout());

        JPanel p1 = new JPanel(new GridLayout(1, 6));
        p1.add(potionMana);
        p1.add(potionVie);

        JPanel p2 = new JPanel(new GridLayout(4,1));
        p2.add(new JLabel("Vie"));
        p2.add(progressBar);
        p2.add(new JLabel("Mana"));
        p2.add(new JProgressBar(0, 100));

        add(p1, BorderLayout.LINE_START);
        add(p2, BorderLayout.LINE_END);
    }

   public void lessEnergy() {
        progressBar.setValue(progressBar.getValue()-2);
       if(progressBar.getValue() < 0) progressBar.setValue(0);
   }

    public void moreEnergy() {
        progressBar.setValue(progressBar.getValue()+40);
        if(progressBar.getValue() >= 100) progressBar.setValue(100);
    }

}
