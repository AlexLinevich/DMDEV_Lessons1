package by.lav.homework33;

public class SpaceRunner {

    public static void main(String[] args) {

        Star star = new Star("СОЛНЦЕ", 1000, 100);
        Planet planet = new Planet("ЗЕМЛЯ", 200, 2);
        Satellite satellite = new Satellite("ЛУНА", 50);
        Asteroid asteroid = new Asteroid("ГРОМАДА", 2);
        Comet comet = new Comet("СТЕЛЛА", 5, 20);

        introduce(star, planet, satellite, asteroid, comet);

        showDiameter(planet, satellite, star, comet, asteroid);

        planet.massEquality(asteroid);

        Planet planet1 = new Planet("МАРС", 150, 0);
        showPlanetSatellite(planet, planet1);

        SpaceUtils.calculateGravitation(star, planet, 10000);

        showObjectType(satellite, star, planet);

        showLuminousStrength(star, comet, planet);
    }

    public static void introduce(Representing... spaceObjects) {
        for (Representing spaceObject : spaceObjects) {
            spaceObject.introduceSpaceObject();
        }
    }

    public static void showObjectType(SpaceObject... spaceObjects) {
        for (SpaceObject spaceObject : spaceObjects) {
            if (SpaceUtils.isStar(spaceObject)) {
                System.out.println("Объект " + spaceObject.getName() + " является звездой.");
            } else {
                System.out.println("Объект " + spaceObject.getName() + " не является звездой.");
            }
        }
    }

    public static void showDiameter(SpaceObject... spaceObjects) {
        for (SpaceObject spaceObject : spaceObjects) {
            System.out.println("Диаметр объекта " + spaceObject.getName() + " равен: " +
                    spaceObject.calculateDiameter());
        }
    }

    public static void showLuminousStrength(SpaceObject... spaceObjects) {
        for (SpaceObject spaceObject : spaceObjects) {
            if (spaceObject instanceof Luminous) {
                System.out.println("Сила света объекта " + spaceObject.getName() + " равняется " +
                        ((Luminous)spaceObject).lightPower());
            } else {
                System.out.println("Объект " + spaceObject.getName() + " не излучает свет.");
            }
        }
    }

    public static void showPlanetSatellite(Planet... planets) {
        for (Planet planet : planets) {
            if (planet.hasSatellite()) {
                System.out.println("У планеты " + planet.getName() + " есть спутники в количестве: " +
                        planet.getQuantitySatellite());
            } else {
                System.out.println("У планеты " + planet.getName() + " нет спутников.");
            }
        }
    }
}
