package by.lav.home_work4;

/**
 * Даны 3 переменные:
 * - operand1 (double)
 * - operand2 (double)
 * - operation (char ‘+’, ‘-’, ‘*’, ‘/’, ‘%’)
 * Написать функцию, которая принимает в качестве параметров
 * эти три переменные и возвращает результат операции.
 * Протестировать функцию в main.
 * Например:
 * Параметры: operand1 = 24.4, operand2 = 10.1, operation = ‘+’
 * Результат: 34.5 (24.4 + 10.1)
 */
public class HW4Task2 {

    public static void main(String[] args) {
        double operand1 = 24.4;
        double operand2 = 10.1;
        char operation = '+';
        double result = operationResult(operand1, operand2, operation);
        System.out.println(result + " (" + operand1 + " " + operation + " " + operand2 + ")");
    }

    public static double operationResult(double o1, double o2, char operation) {
        double result = 0;
        if (operation == '+') {
            result = o1 + o2;
        } else if (operation == '-') {
            result = o1 - o2;
        } else if (operation == '*') {
            result = o1 * o2;
        } else if (operation == '/') {
            result = o1 / o2;
        } else if (operation == '%') {
            result = o1 % o2;
        }
        return result;
    }
}
