package by.lav.homework6;

import java.util.Arrays;

/**
 * Дан одномерный массив символов.
 * Преобразовать его в одномерный массив чисел, где число - это код символа
 * (любой символ - это число в памяти компьютера).
 * Например: [‘a’, ‘6’, ‘y’, ‘P’, ‘T’, ‘q’, ‘9’, ‘+’] -> [97, 54, 121, 80, 84, 113, 57, 43]
 *
 * Далее определить среднее арифметическое всех элементов целочисленного массива и вывести
 * на консоль только те элементы, которые больше этого среднего арифметического.
 */
public class HW6Task2 {

    public static void main(String[] args) {
        char[] charValues = {'a', '6', 'y', 'P', 'T', 'q', '9', '+'};
        int[] intValues = convertToInt(charValues);
        System.out.println(Arrays.toString(intValues));
        System.out.println(calculateAverage(intValues));
        print(intValues);

    }

    public static int[] convertToInt(char[] values) {
        int[] result = new int[values.length];
        for (int i = 0; i < values.length; i++) {
            result[i] = (int) values[i];
        }
        return result;
    }

    public static double calculateAverage(int[] values) {
        double result = 0;
        for (int value : values) {
            result += value;
        }
        return result / values.length;
    }

    public static void print(int[] values) {
        double averageValue = calculateAverage(values);
        for (int value : values) {
            if (value > averageValue) {
                System.out.print(value + " ");
            }
        }
    }
}
