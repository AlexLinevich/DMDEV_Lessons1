package by.lav.homework6;

/**
 * Дан одномерный массив целых чисел.
 * Написать функцию, которая принимает этот массив и разбивает на 3 других:
 * с только отрицательными числами, только положительными и только нули.
 * Если для какого-то из массивов не будет значений, то должен быть создан пустой массив.
 * Возвращает функция эти три массива в виде одного двумерного.
 *
 * Пример:
 *                             [-4, -18]
 *
 * [-4, 0, 1, 9, 0, -18, 3] -> [0, 0]
 *
 *                             [1, 9, 3]
 */
public class HW6Task3 {

    public static void main(String[] args) {
        int[] values = {-4, 0, 1, 9, 0, -18, 3};
        int[][] resultArray = divideArray(values);
        printArray(resultArray);
    }

    public static int[][] divideArray(int[] values) {
        int counterNegativeNumbers = 0;
        int counterZeroNumbers = 0;
        int counterPositiveNumbers = 0;
        for (int value : values) {
            if (value < 0) {
                counterNegativeNumbers++;
            } else if (value == 0) {
                counterZeroNumbers++;
            } else {
                counterPositiveNumbers++;
            }
        }
        int[][] result = new int[3][];
        result[0] = new int[counterNegativeNumbers];
        result[1] = new int[counterZeroNumbers];
        result[2] = new int[counterPositiveNumbers];

        counterNegativeNumbers = 0;
        counterZeroNumbers = 0;
        counterPositiveNumbers = 0;
        for (int value : values) {
            if (value < 0) {
                result[0][counterNegativeNumbers++] = value;
            } else if (value == 0) {
                result[1][counterZeroNumbers++] = value;
            } else {
                result[2][counterPositiveNumbers++] = value;
            }
        }
        return result;
    }

    public static void printArray(int[][] values) {
        for (int i = 0; i < values.length; i++) {
            for (int j = 0; j <values[i].length ; j++) {
                System.out.print(values[i][j] + " ");
            }
            System.out.println();
        }
    }
}
