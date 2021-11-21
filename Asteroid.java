package by.lav.homework33;

public class Asteroid extends SpaceObject {

    public Asteroid(String name, double mass) {
        super(name, mass);
    }

    @Override
    public void introduceSpaceObject() {
        System.out.println("Это АСТЕРОИД по имени " + getName() + " с массой " + getMass());
    }

    @Override
    public String toString() {
        return "Asteroid{" +
                "name='" + name + '\'' +
                ", mass=" + mass +
                "} " + super.toString();
    }
}
