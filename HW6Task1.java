package by.lav.homework6;

import java.util.Arrays;

/**
 * Дан одномерный массив целых чисел.
 * Написать функцию, удаляющую из него все отрицательные элементы
 * (удалить - значит создать новый массив с только положительными элементами).
 * После удаления - умножить каждый элемент массива на его длину.
 * Например: [3, 5, -6, 3, 2, -9, 0, -123] -> [15, 25, 15, 10, 0]
 *
 * Не забывать, что всю логику приложения нужно выносить в отдельные функции.
 * main - только для тестирования написанного функционала
 */
public class HW6Task1 {

    public static void main(String[] args) {
        int[] values = {3, 5, -6, 3, 2, -9, 0, -123};
        System.out.println(Arrays.toString(deleteOddNumbersAndMultiply(values)));
    }

    public static int[] deleteOddNumbersAndMultiply(int[] values) {
        int arrayLength = calculateArrayLength(values);
        int[] resultArray = new int[arrayLength];
        int counter = 0;
        for (int value : values) {
            if (value >= 0) {
                resultArray[counter++] = value * arrayLength;
            }
        }
        return resultArray;
    }

    public static int calculateArrayLength(int[] values) {
        int counter = 0;
        for (int value : values) {
            if (value >= 0) {
                counter++;
            }
        }
        return counter;
    }
}
