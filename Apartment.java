package by.lav.homework9;

public class Apartment {

    private int apartmentNumber;
    private Room[] rooms;

    public Apartment(int apartmentNumber, Room[] rooms) {
        this.apartmentNumber = apartmentNumber;
        this.rooms = rooms;
    }

    public int getApartmentNumber() {
        return apartmentNumber;
    }

    public Room[] getRooms() {
        return rooms;
    }

    public void print() {
        System.out.println("Квартира: " + getApartmentNumber() + ", количество комнат: " + rooms.length);
    }
}
