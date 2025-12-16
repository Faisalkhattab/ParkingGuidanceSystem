package model;

import gui.*;

public abstract class User {
    protected String id;
    protected String username;
    protected String password;
    protected Role role;

    public User(String id, String username, String password, Role role) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public Role getRole() {
        return role;
    }

    // POLYMORPHISM (IMPORTANT)
    public abstract void openDashboard();
}
