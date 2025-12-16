package services;

import java.util.*;

public class AdminService {

    public static void addSpot(String id) {
        FileManager.append("data/parking_spots.txt", id + ",true");
    }

    public static int totalSpots() {
        return FileManager.read("data/parking_spots.txt").size();
    }

    public static void addUser(String id, String u, String p, String r) {
        FileManager.append("data/users.txt", id + "," + u + "," + p + "," + r);
    }

    public static List<String> payments() {
        return FileManager.read("data/payments.txt");
    }

    public static List<String> parkedCars() {
        List<String> list = new ArrayList<>();
        for (String t : FileManager.read("data/tickets.txt")) {
            if (t.endsWith("false")) list.add(t);
        }
        return list;
    }
}
