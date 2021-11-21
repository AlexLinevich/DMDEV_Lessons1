package by.lav.homework33;

public class Satellite extends SpaceObject {

    public Satellite(String name, double mass) {
        super(name, mass);
    }

    @Override
    public void introduceSpaceObject() {
        System.out.println("Это СПУТНИК по имени " + getName() + " с массой " + getMass());
    }

    @Override
    public String toString() {
        return "Satellite{" +
                "name='" + name + '\'' +
                ", mass=" + mass +
                "} " + super.toString();
    }
}
