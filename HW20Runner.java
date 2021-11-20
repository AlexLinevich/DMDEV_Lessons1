package by.lav.homework20;

/**
 * Создать класс, описывающий банкомат.
 * Банкомат задается тремя свойствами:
 * - количеством купюр номиналом 20, 50 и 100.
 * Сделать методы для добавления денег в банкомат.
 * Сделать метод, снимающий деньги: он принимает сумму денег,
 * а возвращает булево значение - успешность выполнения операции.
 * При снятии денег метод должен распечатывать каким количеством купюр какого номинала выдаётся сумма.
 * Создать конструктор с тремя параметрами - количеством купюр каждого номинала.
 */
public class HW20Runner {

    public static void main(String[] args) {
        ATMachine atMachine = new ATMachine(10, 6, 3);

        System.out.println(atMachine.isMoneyGet(110));
        System.out.println(atMachine.isMoneyGet(170));
        System.out.println(atMachine.isMoneyGet(20));
        System.out.println(atMachine.isMoneyGet(270));
        System.out.println(atMachine.isMoneyGet(50));
        System.out.println(atMachine.isMoneyGet(40));
        System.out.println(atMachine.isMoneyGet(150));
    }
}
