package model;

import gui.EntryOperatorFrame;

public class EntryOperator extends User {

    public EntryOperator(String id, String username, String password) {
        super(id, username, password, Role.ENTRY_OPERATOR);
    }

    @Override
    public void openDashboard() {
        new EntryOperatorFrame();
    }
}
