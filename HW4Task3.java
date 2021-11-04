package by.lav.home_work4;

/**
 * Даны два прямоугольных треугольника. Каждый из них задается
 * двумя целочисленными переменными a и b - стороны треугольника.
 * Написать код, в котором вычисляется площадь каждого треугольника
 * и затем эти площади сравниваются друг с другом.
 *
 * Для этого понадобится написать 2 функции.
 * Первая: по двум сторонам прямоугольного треугольника возвращает его площадь.
 * Вторая: сравнивает переданные площади двух треугольников и выводит на консоль
 * первый треугольник больше, меньше или равен второму.
 *
 * Учитывать, что площадь может быть вещественным числом.
 */
public class HW4Task3 {

    public static void main(String[] args) {
        int a1 = 10;
        int b1 = 20;
        int a2 = 5;
        int b2 = 40;
        double area1 = area(a1, b1);
        double area2 = area(a2, b2);
        checkEqualityAndPrint(area1, area2);
    }

    public static double area(int a, int b) {
        return (double) a * b / 2;
    }

    public static void checkEqualityAndPrint(double p1, double p2) {
        if (p1 > p2) {
            System.out.println("Первый треугольник больше второго.");
        } else if (p1 < p2) {
            System.out.println("Первый треугольник меньше второго.");
        } else {
            System.out.println("Первый треугольник равен второму.");
        }
    }
}
