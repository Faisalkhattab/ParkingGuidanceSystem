package gui;

import model.User;
import services.AuthService;
import javax.swing.*;

public class LoginFrame extends JFrame {

    public LoginFrame() {
        JTextField u = new JTextField();
        JPasswordField p = new JPasswordField();
        JButton login = new JButton("Login");

        setLayout(new java.awt.GridLayout(3,2));
        add(new JLabel("Username")); add(u);
        add(new JLabel("Password")); add(p);
        add(login);

        login.addActionListener(e -> {
            User user = AuthService.login(u.getText(), new String(p.getPassword()));
            if (user == null) JOptionPane.showMessageDialog(this, "Invalid Login");
            else {
                dispose();
                user.openDashboard(); // POLYMORPHISM
            }
        });

        setSize(300,200);
        setVisible(true);
    }
}
