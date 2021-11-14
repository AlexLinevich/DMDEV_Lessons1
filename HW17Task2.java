package by.lav.homework17;

/**
 * Дана строка с текстом, в котором есть цифры от 0 до 9.
 * Написать 2 метода:
 * - возвращающий массив цифр из переданной строки
 * - возвращающий сумму цифр из переданного целочисленного массива
 * Посчитать сумму всех чисел из строки
 * Например:
 * “Привет 8, как 1 2 твои дела? Может4, сделать 3 дело?” -> 18 (8+1+2+4+3)
 */
public class HW17Task2 {

    public static void main(String[] args) {
        String value = "Привет 8, как 1 2 твои дела? Может4, сделать 3 дело?";
        int[] resultArray = extractIntFromString(value);
        System.out.print("\"" + value + "\" -> " + sum(resultArray) + " ");
        printArray(resultArray);
    }

    public static int[] extractIntFromString(String value) {
        char[] numberArray = {'1', '2', '3', '4', '5', '6', '7', '8', '9', '0'};
        int counter = 0;
        for (int i = 0; i < value.length(); i++) {
            for (int j = 0; j < numberArray.length; j++) {
                if (value.charAt(i) == numberArray[j]) {
                    counter++;
                }
            }
        }
        int[] result = new int[counter];
        counter = 0;
        for (int i = 0; i < value.length(); i++) {
            for (int j = 0; j < numberArray.length; j++) {
                if (value.charAt(i) == numberArray[j]) {
                    result[counter++] = Character.getNumericValue(value.charAt(i));
                }
            }
        }
        return result;
    }

    public static int sum(int[] values) {
        int result = 0;
        for (int value : values) {
            result += value;
        }
        return result;
    }

    public static void printArray(int[] values) {
        System.out.print("(");
        boolean flag = false;
        for (int i = 0; i < values.length; i++) {
            if (flag) {
                System.out.print("+" + values[i]);
            } else {
                System.out.print(values[i]);
                flag = true;
            }
        }
        System.out.println(")");
    }
}
