package ThreeProblems.PizzaOrderSystem;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultComboBoxModel;

public class PizzaOrderSystem extends JFrame {
    private JPanel MainMenu;
    private JComboBox<sizeChoice> pizzaSizeChoice;
    private JComboBox<toppingsChoice> pizzaToppingChoice;
    private JComboBox<cheeseChoice> extraCheeseChoice;
    private JButton calculateButton;
    private JLabel totalLabel;

    public PizzaOrderSystem() {
        setTitle("Pizza Order System");
        setContentPane(MainMenu);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(350,320);
        setLocationRelativeTo(null);
        setVisible(true);

        pizzaSizeChoice.setName("pizzaSizeChoice");
        pizzaToppingChoice.setName("pizzaToppingChoice");
        extraCheeseChoice.setName("extraCheeseChoice");
        totalLabel.setName("totalLabel");
        calculateButton.setName("calculateButton");
        totalLabel.setVisible(true);




        pizzaSizeChoice.setModel(new DefaultComboBoxModel<>(sizeChoice.values()));
        pizzaToppingChoice.setModel(new DefaultComboBoxModel<>(toppingsChoice.values()));
        extraCheeseChoice.setModel(new DefaultComboBoxModel<>(cheeseChoice.values()));

        //combobox test
        pizzaSizeChoice.setSelectedIndex(-1);
        pizzaToppingChoice.setSelectedIndex(-1);
        extraCheeseChoice.setSelectedIndex(-1);

        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sizeChoice size = (sizeChoice) pizzaSizeChoice.getSelectedItem();
                toppingsChoice toppings = (toppingsChoice) pizzaToppingChoice.getSelectedItem();
                cheeseChoice cheese = (cheeseChoice) extraCheeseChoice.getSelectedItem();

                int total = 0;

                if(size != null){
                    switch (size){
                        case SMALL: total += 10;
                        break;
                        case MEDIUM: total += 15;
                        break;
                        case LARGE: total += 20;
                        break;
                    }
                }

                if(toppings != null){
                    total += 2;
                }

                if(cheese != null && cheese.name().equals("YES")){
                    total += 3;
                }
//                    totalLabel.setVisible(true);
                    totalLabel.setText(String.valueOf(total));
            }
        });
    }

    static void main() {
        SwingUtilities.invokeLater(()->{
                new PizzaOrderSystem().setVisible(true);
        });
    }
}
