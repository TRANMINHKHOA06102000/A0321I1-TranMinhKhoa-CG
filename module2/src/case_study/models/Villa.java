package case_study.models;

import java.io.Serializable;

public class Villa extends Facility implements Serializable {
    private String standardRoom;
    private int areaPool;
    private int numberOfFloors;

    public Villa() {
    }

    public Villa(String standardRoom, int areaPool, int numberOfFloors) {
        this.standardRoom = standardRoom;
        this.areaPool = areaPool;
        this.numberOfFloors = numberOfFloors;
    }

    public Villa(String id,String name, int area, double price, int amount, String typeRents, String standardRoom, int areaPool, int numberOfFloors) {
        super(id,name, area, price, amount, typeRents);
        this.standardRoom = standardRoom;
        this.areaPool = areaPool;
        this.numberOfFloors = numberOfFloors;
    }

    public String getStandardRoom() {
        return standardRoom;
    }

    public void setStandardRoom(String standardRoom) {
        this.standardRoom = standardRoom;
    }

    public int getAreaPool() {
        return areaPool;
    }

    public void setAreaPool(int areaPool) {
        this.areaPool = areaPool;
    }

    public int getNumberOfFloors() {
        return numberOfFloors;
    }

    public void setNumberOfFloors(int numberOfFloors) {
        this.numberOfFloors = numberOfFloors;
    }

    @Override
    public String toString() {
        return "Villa{" +
                "standardRoom='" + standardRoom + '\'' +
                ", areaPool=" + areaPool +
                ", numberOfFloors=" + numberOfFloors +
                '}' + ", which is a subclass of " +
                super.toString();
    }
}
