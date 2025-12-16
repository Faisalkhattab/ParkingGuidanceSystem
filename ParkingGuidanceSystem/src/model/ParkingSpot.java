package model;

public class ParkingSpot {
    private String id;
    private boolean free;

    public ParkingSpot(String id, boolean free) {
        this.id = id;
        this.free = free;
    }

    public String getId() {
        return id;
    }

    public boolean isFree() {
        return free;
    }
}
