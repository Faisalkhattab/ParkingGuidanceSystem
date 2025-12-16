package gui;

import services.ParkingService;

import javax.swing.*;
import java.awt.*;

public class EntryOperatorFrame extends JFrame {
    public EntryOperatorFrame() {
        JTextField plate = new JTextField();
        JButton create = new JButton("Print Entry Ticket");

        create.addActionListener(e -> {
            try {
                String msg = ParkingService.createTicket(plate.getText());
                JOptionPane.showMessageDialog(this, msg);
            } catch (RuntimeException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage());
            }
        });

        add(new JLabel("Plate Number"));
        add(plate);
        add(create);

        setLayout(new GridLayout(3,1));
        setSize(300,200);
        setVisible(true);
    }
}
