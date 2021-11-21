package by.lav.homework33;

public abstract class SpaceObject implements Representing {

    public String name;
    public double mass;

    public SpaceObject(String name, double mass) {
        this.name = name;
        this.mass = mass;
    }

    @Override
    public void introduceSpaceObject() {
        System.out.println("Это объект по имени " + getName() + " с массой " + getMass());
    }

    public void massEquality(SpaceObject spaceObject) {
        if (mass < spaceObject.mass) {
            System.out.println("Масса объекта " + name + " меньше массы объекта " + spaceObject.name);
        } else if (mass > spaceObject.mass) {
            System.out.println("Масса объекта " + name + " больше массы объекта " + spaceObject.name);
        } else {
            System.out.println("Масса объекта " + name + " равна массе объекта " + spaceObject.name);
        }
    }

    public double calculateDiameter() {
        return Math.sqrt((mass * 4) / Math.PI);
    }

    public String getName() {
        return name;
    }

    public double getMass() {
        return mass;
    }
}
