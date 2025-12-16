package gui;

import services.ParkingService;
import javax.swing.*;

public class CustomerFrame extends JFrame {

    public CustomerFrame() {
        setTitle("Customer Module");
        setLayout(new java.awt.GridLayout(5,2));

        JTextField plate = new JTextField();
        JTextField ticket = new JTextField();

        JButton entry = new JButton("Print Entry Ticket");
        JButton pay = new JButton("Pay & Exit");

        add(new JLabel("Plate Number"));
        add(plate);
        add(entry);
        add(new JLabel());
        add(new JLabel("Ticket ID"));
        add(ticket);
        add(pay);

        entry.addActionListener(e -> {
            try {
                JOptionPane.showMessageDialog(this, ParkingService.createTicket(plate.getText()));

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage());
            }
        });

        pay.addActionListener(e -> {
            try {
                double amount = ParkingService.exitAndPay(ticket.getText());
                JOptionPane.showMessageDialog(this, "Paid: " + amount);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage());
            }
        });

        setSize(400,300);
        setVisible(true);
    }
}
