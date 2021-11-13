package by.lav.homework9;

/**
 * Представить в виде классов и их композиции следующую модель.
 *
 * - Каждый дом содержит свой номер (int), и множество этажей (массив).
 *
 * - Каждый этаж содержит номер этажа (int), и множество квартир (массив).
 *
 * - Каждая квартира содержит свой номер (int), и множество комнат (массив).
 *
 * - Каждая комната содержит поле проходная она или нет (boolean).
 *
 * В каждом классе реализовать метод print, который на консоль выводит информацию
 * об объекте (должны присутствовать все поля объекта!).
 *
 * Например, метод print класса этаж должен выводить на консоль:
 *
 * “Этаж 2, количество квартир 18”
 *
 * Создание всех объектов вынести в отдельный класс с методом main.
 *
 * Там же реализовать метод printAllInformation, который на вход принимает объект типа дом,
 * и выводит информацию о нем, его этажах, квартирах и комнатах, вызывая методы print.
 */
public class BuildingCreator {

    public static void main(String[] args) {
        Room room1 = new Room(true);
        Room room2 = new Room(false);
        Room[] rooms1 = {room1, room1, room2};
        Room[] rooms2 = {room1, room2};
        Room[] rooms3 = {room2, room2};

        Apartment apartment1 = new Apartment(1, rooms1);
        Apartment apartment2 = new Apartment(2, rooms2);
        Apartment apartment3 = new Apartment(3, rooms3);
        Apartment apartment4 = new Apartment(4, rooms1);
        Apartment apartment5 = new Apartment(5, rooms3);
        Apartment[] appartments1 = {apartment1, apartment2, apartment3};
        Apartment[] appartments2 = {apartment4, apartment5};

        Floor floor1 = new Floor(1, appartments1);
        Floor floor2 = new Floor(2, appartments2);
        Floor[] floors1 = {floor1, floor2};

        Building building1 = new Building(1, floors1);

        printAllInformation(building1);
    }

    public static void printAllInformation(Building building) {
        building.print();
        Floor[] floors = building.getFloors();
        for (Floor floor : floors) {
            floor.print();
            Apartment[] apartments = floor.getApartments();
            for (Apartment apartment : apartments) {
                apartment.print();
                Room[] rooms = apartment.getRooms();
                for (Room room : rooms) {
                    room.print();
                }
            }
        }
    }
}
