package by.lav.home_work5;

/**
 * Дано целое число.
 * Написать функцию, которая принимает целое число, а возвращает целое число обратное этому (не строку!).
 * Результат вывести на консоль.
 * Например: 4508 -> 8054, 4700 -> 74, 1234567 -> 7654321
 * Примечание: для решения может понадобится функция возведение числа в степень: Math.pow(число, степень)
 */
public class HW5Task2 {

    public static void main(String[] args) {
        int value = 4508;
        System.out.println(value + " -> " + reversNumber(value));
        int value1 = 4700;
        System.out.println(value1 + " -> " + reversNumber(value1));
        int value2 = 1234567;
        System.out.println(value2 + " -> " + reversNumber(value2));
    }

    public static int reversNumber(int value) {
        int tempValue = value;
        int number = 0;
        int result = 0;
        int counter = 0;
        while (tempValue > 0) {
            tempValue /= 10;
            counter++;
        }
        tempValue = value;
        while (tempValue > 0) {
            number = tempValue % 10;
            result += number * Math.pow(10, counter - 1);
            tempValue /= 10;
            counter--;
        }
        return result;
    }
}
