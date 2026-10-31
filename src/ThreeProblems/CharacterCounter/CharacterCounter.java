package ThreeProblems.CharacterCounter;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CharacterCounter extends JFrame {
    private JTextField characterTextField;
    private JButton countButton;
    private JLabel countLabel;
    private JTextArea messageTextArea;
    private JPanel MainMenu;

    public CharacterCounter() {
        setTitle("Character Counter");
        setContentPane(MainMenu);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        setSize(500,500);

        characterTextField.setName("characterTextField");
        countButton.setName("countButton");
        countLabel.setName("countLabel");
        messageTextArea.setName("messageTextArea");


        countButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String message =  messageTextArea.getText().toLowerCase();
                String charinput = characterTextField.getText();

                if(charinput.isEmpty()){
                    return;
                }


                char target = Character.toLowerCase(charinput.charAt(0));
                int count = 0;
                for(int i = 0;i<message.length();i++){
                    if(message.charAt(i)==target){
                        count++;
                    }
                }
                countLabel.setText(String.valueOf(count));
            }
        });
    }

    static void main() {
        SwingUtilities.invokeLater(()->{
            new CharacterCounter().setVisible(true);
        });
    }
}
