package model;

import java.time.LocalDateTime;

public class Ticket {
    private String id;
    private String plate;
    private LocalDateTime entryTime;
    private String spotId;
    private boolean paid;

    public Ticket(String id, String plate, LocalDateTime entryTime, String spotId, boolean paid) {
        this.id = id;
        this.plate = plate;
        this.entryTime = entryTime;
        this.spotId = spotId;
        this.paid = paid;
    }
}
