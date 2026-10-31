package ThreeProblems.NumberCounter;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NumberCounter extends JFrame{
    private JPanel panel1;
    private JButton increaseButton;
    private JButton decreaseButton;
    private JLabel countLabel;

    public NumberCounter() {
        setTitle("Number Counter");

        countLabel.setName("countLabel");
        increaseButton.setName("increaseButton");
        decreaseButton.setName("decreaseButton");

        setContentPane(panel1);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(300,200);
        setLocationRelativeTo(null);


        decreaseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int currentval = Integer.parseInt(countLabel.getText());
                currentval--;
                countLabel.setText(Integer.toString(currentval));
            }
        });
        increaseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int currentval = Integer.parseInt(countLabel.getText());
                currentval++;
                countLabel.setText(Integer.toString(currentval));
            }
        });
    }

    static void main() {
        SwingUtilities.invokeLater(()->{
            new NumberCounter().setVisible(true);
        });
    }
}
