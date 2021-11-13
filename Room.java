package by.lav.homework9;

public class Room {

    private boolean isWalkThroughRoom;

    public Room(boolean isWalkThroughRoom) {
        this.isWalkThroughRoom = isWalkThroughRoom;
    }

    public boolean isWalkThroughRoom() {
        return isWalkThroughRoom;
    }

    public void print() {
        if (isWalkThroughRoom()) {
            System.out.println("проходная");
        } else {
            System.out.println("непроходная");
        }
    }
}
