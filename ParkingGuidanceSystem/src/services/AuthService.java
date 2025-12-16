package services;

import model.*;
import java.util.*;

public class AuthService {

    public static User login(String username, String password) {
        for (String line : FileManager.read("data/users.txt")) {
            String[] d = line.split(",");
            if (d[1].equals(username) && d[2].equals(password)) {
                Role role = Role.valueOf(d[3]);

                switch (role) {
                    case ADMIN: return new Admin(d[0], d[1], d[2]);
                    case CUSTOMER: return new Customer(d[0], d[1], d[2]);
                    case ENTRY_OPERATOR: return new EntryOperator(d[0], d[1], d[2]);
                    case EXIT_OPERATOR: return new ExitOperator(d[0], d[1], d[2]);
                }
            }
        }
        return null;
    }
}
