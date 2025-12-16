package services;

import java.time.*;
import java.util.*;

public class ParkingService implements Payable {

    private static final String SPOTS = "data/parking_spots.txt";
    private static final String TICKETS = "data/tickets.txt";
    private static final String PAYMENTS = "data/payments.txt";

    private static int counter = 1;

    private static String ticketId() {
        return "T-" + (counter++);
    }

    public static String createTicket(String plate) {
        List<String> spots = FileManager.read(SPOTS);
        for (int i = 0; i < spots.size(); i++) {
            String[] s = spots.get(i).split(",");
            if (s[1].equals("true")) {
                spots.set(i, s[0] + ",false");
                FileManager.write(SPOTS, spots);

                String id = ticketId();
                FileManager.append(TICKETS,
                        id + "," + plate + "," + LocalDateTime.now() + "," + s[0] + ",false");

                return "Ticket: " + id + " Spot: " + s[0];
            }
        }
        throw new RuntimeException("Parking Full");
    }

    public static double exitAndPay(String ticketId) {
        List<String> tickets = FileManager.read(TICKETS);

        for (int i = 0; i < tickets.size(); i++) {
            String[] t = tickets.get(i).split(",");
            if (t[0].equals(ticketId) && t[4].equals("false")) {
                long hours = Math.max(1,
                        Duration.between(LocalDateTime.parse(t[2]), LocalDateTime.now()).toHours());

                double amount = hours * 10;
                FileManager.append(PAYMENTS, ticketId + "," + amount + "," + LocalDateTime.now());

                tickets.set(i, t[0] + "," + t[1] + "," + t[2] + "," + t[3] + ",true");
                FileManager.write(TICKETS, tickets);

                freeSpot(t[3]);
                return amount;
            }
        }
        throw new RuntimeException("Invalid Ticket");
    }

    private static void freeSpot(String spot) {
        List<String> spots = FileManager.read(SPOTS);
        for (int i = 0; i < spots.size(); i++)
            if (spots.get(i).startsWith(spot))
                spots.set(i, spot + ",true");
        FileManager.write(SPOTS, spots);
    }

    @Override
    public double calculatePayment(long hours) {
        return hours * 10;
    }
}
