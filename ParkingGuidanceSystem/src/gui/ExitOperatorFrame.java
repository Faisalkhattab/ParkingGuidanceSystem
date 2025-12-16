package gui;

import services.ParkingService;

import javax.swing.*;
import java.awt.*;

public class ExitOperatorFrame extends JFrame {
    public ExitOperatorFrame() {
        JTextField ticket = new JTextField();
        JButton calc = new JButton("Calculate & Exit");

        calc.addActionListener(e -> {
            try {
                double amount = ParkingService.exitAndPay(ticket.getText());
                JOptionPane.showMessageDialog(this, "Amount = " + amount);
                ParkingService.exitAndPay(ticket.getText());
            } catch (RuntimeException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage());
            }
        });

        add(new JLabel("Ticket ID"));
        add(ticket);
        add(calc);

        setLayout(new GridLayout(3,1));
        setSize(300,200);
        setVisible(true);
    }
}
