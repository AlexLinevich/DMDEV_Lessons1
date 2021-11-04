package by.lav.home_work4;

/**
 * В переменной minutes лежит число от 0 до 59.
 * Написать функцию, которая принимает в качестве параметра
 * значение переменной minutes и выводит на консоль в какую
 * четверть часа попадает это число (в первую, вторую, третью или четвертую).
 * Протестировать функцию в main.
 */
public class HW4Task1 {

    public static void main(String[] args) {
        int minutes = 0;
        whatQuarter(minutes);
        minutes = 10;
        whatQuarter(minutes);
        minutes = 25;
        whatQuarter(minutes);
        minutes = 40;
        whatQuarter(minutes);
        minutes = 59;
        whatQuarter(minutes);
        minutes = 60;
        whatQuarter(minutes);
    }

    public static void whatQuarter(int minutes) {
        if (minutes >= 0 && minutes <= 15) {
            System.out.println("Число " + minutes + " попадает в первую четверть.");
        } else if (minutes > 15 && minutes <= 30) {
            System.out.println("Число " + minutes + " попадает во вторую четверть.");
        } else if (minutes > 30 && minutes <= 45) {
            System.out.println("Число " + minutes + " попадает в третью четверть.");
        } else if (minutes > 45 && minutes < 60) {
            System.out.println("Число " + minutes + " попадает в четвертую четверть.");
        } else {
            System.out.println("Введенное число находится за пределами допустимого диапазона 0 .. 59.");
        }
    }
}
