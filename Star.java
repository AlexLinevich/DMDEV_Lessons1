package by.lav.homework33;

public class Star extends SpaceObject implements Luminous {

    private int light;

    public Star(String name, double mass, int light) {
        super(name, mass);
        this.light = light;
    }

    @Override
    public void introduceSpaceObject() {
        System.out.println("Это ЗВЕЗДА по имени " + getName() + " с массой " + getMass());
    }

    @Override
    public double lightPower() {
        return light * mass * Luminous.LIGHT_FACTOR;
    }

    @Override
    public String toString() {
        return "Star{" +
                "light=" + light +
                ", name='" + name + '\'' +
                ", mass=" + mass +
                "} " + super.toString();
    }
}
