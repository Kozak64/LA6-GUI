package TwoProblems.SimpleCalculator;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultComboBoxModel;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;

public class SimpleCalculator extends JFrame{
    private JButton btnCompute;
    private JTextField tfNumber1;
    private JComboBox<Operations> cbOperations;
    private JTextField tfNumber2;
    private JPanel MainMenu;
    private JLabel lblResult;

    public SimpleCalculator() {
        setTitle("Simple Calculator");
        setContentPane(MainMenu);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500,200);
        setLocationRelativeTo(null);
        setVisible(true);

        btnCompute.setName("btnCompute");
        cbOperations.setName("cbOperations");
        tfNumber1.setName("tfNumber1");
        tfNumber2.setName("tfNumber2");
        lblResult.setName("lblResult");

        cbOperations.setModel(new DefaultComboBoxModel<>(Operations.values()));
        cbOperations.setSelectedIndex(-1);

        btnCompute.addActionListener(e -> {
            try {
                int number1 = Integer.parseInt(tfNumber1.getText());
                int number2 = Integer.parseInt(tfNumber2.getText());
                Operations op = (Operations) cbOperations.getSelectedItem();

                if (op == null) {
                    return;
                }
                if (op == Operations.DIVIDE && number2 == 0) {
                    lblResult.setText("Cannot be divided by 0");
                    SaveCalculation(tfNumber1.getText() + " " + op + " " + tfNumber2.getText() + " = " + lblResult.getText());
                    return;
                }

                double result = 0;
                switch (op) {
                    case PLUS:
                        result = number1 + number2;
                        break;
                    case MULTIPLY:
                        result = number1 * number2;
                        break;
                    case DIVIDE:
                        result = (double) number1 / number2;
                        break;
                    case MINUS:
                        result = number1 - number2;
                        break;
                }

                if (result % 1 == 0) {    //include or not, not sure
                    lblResult.setText(String.valueOf((int) result));
                } else {
                    lblResult.setText(String.format("%.2f", result));
                }

                SaveCalculation(tfNumber1.getText() + " " + op + " " + tfNumber2.getText() + " = " + lblResult.getText());
            }catch(NumberFormatException ex){
                lblResult.setText("");
            }
        });
    }

    private void SaveCalculation(String calc){
        String filename = "src/TwoProblems/SimpleCalculator/Calculation_history.txt";
        try{
            BufferedWriter bw = new BufferedWriter(new FileWriter(filename, true));

            String entry = tfNumber1.getText() + " " + cbOperations.getSelectedItem() + " " + tfNumber2.getText() + " = " + lblResult.getText();

            bw.write(entry);
            bw.newLine();
            bw.close();

        }catch (IOException e){
            JOptionPane.showMessageDialog(null,"Error saving to file.");
        }
    }

     static void main() {
        SwingUtilities.invokeLater(()->{
            new SimpleCalculator().setVisible(true);
        });
    }
}
