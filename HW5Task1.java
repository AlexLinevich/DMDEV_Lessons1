package by.lav.home_work5;

/**
 * Посчитать четные и нечетные цифры целого числа и вывести их на консоль.
 * Для решения написать 2 функции, которые будут принимать введенное целое
 * число, а возвращать количество четных цифр (вторая функция - нечетных).
 * Например: если введено число 228910,
 * то у него 4 четные цифры (2, 2, 8, 0) и 2 нечетные (9, 1).
 */
public class HW5Task1 {

    public static void main(String[] args) {
        int number = 22891083;

        System.out.print("Во введенном числе " + number + " четных цифр: " + countEvenNumbers(number) + " (");
        printEvenNumbers(number);
        System.out.print(") и нечетных цифр: " + countOddNumbers(number) + " (");
        printOddNumbers(number);
        System.out.println(").");
    }

    public static int countEvenNumbers(int number) {
        int counter = 0;
        int value = number;
        int tempValue = 0;
        while (value > 0) {
            tempValue = value % 10;
            if (tempValue % 2 == 0) {
                counter++;
            }
            value /= 10;
        }
        return counter;
    }

    public static int countOddNumbers(int number) {
        int counter = 0;
        int value = number;
        int tempValue = 0;
        while (value > 0) {
            tempValue = value % 10;
            if (tempValue % 2 != 0) {
                counter++;
            }
            value /= 10;
        }
        return counter;
    }

    public static void printEvenNumbers(int number) {
        int value = number;
        int tempValue = 0;
        boolean b = false;
        while (value > 0) {
            tempValue = value % 10;
            if (tempValue % 2 == 0) {
                if (b) {
                    System.out.print(", " + tempValue);
                } else {
                    System.out.print(tempValue);
                    b = true;
                }
            }
            value /= 10;
        }
    }

    public static void printOddNumbers(int number) {
        int value = number;
        int tempValue = 0;
        boolean b = false;
        while (value > 0) {
            tempValue = value % 10;
            if (tempValue % 2 != 0) {
                if (b) {
                    System.out.print(", " + tempValue);
                } else {
                    System.out.print(tempValue);
                    b = true;
                }
            }
            value /= 10;
        }
    }
}
