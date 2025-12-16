package model;

import gui.CustomerFrame;

public class Customer extends User {

    public Customer(String id, String username, String password) {
        super(id, username, password, Role.CUSTOMER);
    }

    @Override
    public void openDashboard() {
        new CustomerFrame();
    }
}
