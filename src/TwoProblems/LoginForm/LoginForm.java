package TwoProblems.LoginForm;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Insets;

public class LoginForm extends JFrame {
    private JTextField userNameTextField;
    private JButton loginButton;
    private JPasswordField passwordTextField;
    private JPanel mainpanel;

    public LoginForm() {

        setTitle("Login Form");
        setContentPane(mainpanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(250,200);
        setLocationRelativeTo(null);
        setVisible(true);

        userNameTextField.setName("UsernameTextField");
        passwordTextField.setName("PasswordTextField");
        loginButton.setName("LoginButton");
        passwordTextField.setEchoChar('*');

        //usernameborder test
        userNameTextField.setMargin(new Insets(0,0,0,0));

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = userNameTextField.getText();
                String password = String.valueOf(passwordTextField.getPassword());

                String statusmsg;
                if(username.equals("admin") && password.equals("admin")){
                    statusmsg = "Login Successful!";
                }else{
                    statusmsg = "Login Failed!";
                }

                JDialog statusDialog = new JDialog(LoginForm.this,statusmsg,true);
                statusDialog.setName("StatusDialog");
                statusDialog.setLocationRelativeTo(LoginForm.this);
                statusDialog.setSize(200,100);

                JLabel messageLabel = new JLabel(statusmsg);
                messageLabel.setName("messageLabel");

                statusDialog.add(messageLabel);
                statusDialog.setVisible(true);

            }
        });

    }


     static void main() {
        SwingUtilities.invokeLater(()->{
            new LoginForm().setVisible(true);
        });
    }
}
