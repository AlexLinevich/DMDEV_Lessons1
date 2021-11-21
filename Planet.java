package by.lav.homework33;

public class Planet extends SpaceObject {

    private int quantitySatellite;

    public Planet(String name, double mass, int quantitySatellite) {
        super(name, mass);
        this.quantitySatellite = quantitySatellite;
    }

    @Override
    public void introduceSpaceObject() {
        System.out.println("Это ПЛАНЕТА по имени " + getName() + " с массой " + getMass());
    }

    public boolean hasSatellite() {
        return quantitySatellite > 0;
    }

    public int getQuantitySatellite() {
        return quantitySatellite;
    }

    @Override
    public String toString() {
        return "Planet{" +
                "name='" + name + '\'' +
                ", mass=" + mass +
                "} " + super.toString();
    }
}
