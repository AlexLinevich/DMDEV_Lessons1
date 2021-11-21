package by.lav.homework33;

public final class SpaceUtils {

    private static final int GRAVITY_FACTOR = 100;

    private SpaceUtils() {
    }

    public static void calculateGravitation(SpaceObject firstObject, SpaceObject secondObject, int distance) {
        double gravity = GRAVITY_FACTOR * (firstObject.getMass() / secondObject.getMass()) / distance;
        System.out.println("Сила гравитации между объектом " + firstObject.getName() +
                " и объектом " + secondObject.getName() + " равняется: " + gravity);
    }

    public static boolean isStar(SpaceObject spaceObject) {
        return spaceObject instanceof Star;
    }
}
