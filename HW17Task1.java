package by.lav.homework17;

/**
 * Дана строка.
 * Удалить из нее все повторяющиеся символы без учета регистра, если они идут друг за другом.
 * Также удалить пробелы.
 * Результат привести к верхнему регистру.
 * Например:
 * “abc Cpddd Dio OsfWw” -> “ABCPDIOSFW”
 */
public class HW17Task1 {

    public static void main(String[] args) {
        String value = "abc Cpddd Dio OsfWw";
        System.out.println("\"" + value + "\" -> " + "\"" + changeString(value) + "\"");
    }

    public static String changeString(String inputString) {
        String outputString = inputString.toUpperCase();
        for (int i = 1; i < outputString.length(); i++) {
            if (outputString.charAt(i) == ' ') {
                outputString = outputString.substring(0, i) + outputString.substring(i + 1, outputString.length());
            }
        }
        for (int i = 1; i < outputString.length(); i++) {
            if (outputString.charAt(i) == outputString.charAt(i - 1)) {
                outputString = outputString.substring(0, i) + outputString.substring(i + 1, outputString.length());
            }
        }
        return outputString;
    }
}
