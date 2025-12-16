package model;

import gui.AdminFrame;

public class Admin extends User {

    public Admin(String id, String username, String password) {
        super(id, username, password, Role.ADMIN);
    }

    @Override
    public void openDashboard() {
        new AdminFrame();
    }
}
