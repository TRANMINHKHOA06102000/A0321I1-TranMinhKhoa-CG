package case_study.models;

import java.io.Serializable;

public class Room extends Facility implements Serializable {
    private String freeService;

    public Room() {
    }

    public Room(String freeService) {
        this.freeService = freeService;
    }

    public Room(String id,String name, int area, double price, int amount, String typeRents, String freeService) {
        super(id,name, area, price, amount, typeRents);
        this.freeService = freeService;
    }

    public String getFreeService() {
        return freeService;
    }

    public void setFreeService(String freeService) {
        this.freeService = freeService;
    }

    @Override
    public String toString() {
        return "Room{" +
                "freeService='" + freeService + '\'' +
                '}' + ", which is a subclass of " +
                super.toString();
    }
}
