package by.lav.homework9;

public class Floor {

    private int floorNumber;
    private Apartment[] apartments;

    public Floor(int floorNumber, Apartment[] apartments) {
        this.floorNumber = floorNumber;
        this.apartments = apartments;
    }

    public int getFloorNumber() {
        return floorNumber;
    }

    public Apartment[] getApartments() {
        return apartments;
    }

    public void print() {
        System.out.println("Этаж: " + getFloorNumber() + ", количество квартир: " + apartments.length);
    }
}
