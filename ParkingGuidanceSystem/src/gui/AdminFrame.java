package gui;

import services.AdminService;
import javax.swing.*;

public class AdminFrame extends JFrame {

    public AdminFrame() {
        setTitle("Admin Module");
        setLayout(new java.awt.GridLayout(5,1));

        JButton addSpot = new JButton("Add Parking Spot");
        JButton viewSpots = new JButton("View Total Spots");
        JButton addUser = new JButton("Add User");
        JButton payments = new JButton("View Payments");
        JButton parked = new JButton("View Parked Cars");

        add(addSpot);
        add(viewSpots);
        add(addUser);
        add(payments);
        add(parked);

        addSpot.addActionListener(e -> {
            String id = JOptionPane.showInputDialog("Spot ID");
            AdminService.addSpot(id);
        });

        viewSpots.addActionListener(e ->
                JOptionPane.showMessageDialog(this, "Total Spots: " + AdminService.totalSpots())
        );

        addUser.addActionListener(e -> {
            AdminService.addUser(
                    JOptionPane.showInputDialog("ID"),
                    JOptionPane.showInputDialog("Username"),
                    JOptionPane.showInputDialog("Password"),
                    JOptionPane.showInputDialog("Role")
            );
        });

        payments.addActionListener(e ->
                JOptionPane.showMessageDialog(this, AdminService.payments())
        );

        parked.addActionListener(e ->
                JOptionPane.showMessageDialog(this, AdminService.parkedCars())
        );

        setSize(400,400);
        setVisible(true);
    }
}
