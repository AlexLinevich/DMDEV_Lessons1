package by.lav.homework9;

public class Building {

    private int buildingNumber;
    private Floor[] floors;

    public Building(int buildingNumber, Floor[] floors) {
        this.buildingNumber = buildingNumber;
        this.floors = floors;
    }

    public int getBuildingNumber() {
        return buildingNumber;
    }

    public Floor[] getFloors() {
        return floors;
    }

    public void print() {
        System.out.println("Дом: " + getBuildingNumber() + ", количество этажей: " + floors.length);
    }
}
