package model;

import gui.ExitOperatorFrame;

public class ExitOperator extends User {

    public ExitOperator(String id, String username, String password) {
        super(id, username, password, Role.EXIT_OPERATOR);
    }

    @Override
    public void openDashboard() {
        new ExitOperatorFrame();
    }
}
