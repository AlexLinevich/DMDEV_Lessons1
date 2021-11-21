package by.lav.homework33;

public class Comet extends SpaceObject implements Luminous {

    private int light;

    public Comet(String name, double mass, int light) {
        super(name, mass);
        this.light = light;
    }

    @Override
    public void introduceSpaceObject() {
        System.out.println("Это КОМЕТА по имени " + getName() + " с массой " + getMass());
    }

    @Override
    public String toString() {
        return "Comet{" +
                "name='" + name + '\'' +
                ", mass=" + mass +
                "} " + super.toString();
    }

    @Override
    public double lightPower() {
        return light * Luminous.LIGHT_FACTOR;
    }
}
