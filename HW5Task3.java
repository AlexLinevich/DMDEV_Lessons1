package by.lav.home_work5;

/**
 * Программист Ваня сразу после окончания курсов dmdev устроился в IT компанию
 * на позицию Junior Java Developer с зарплатой 600$ в месяц.
 * Ему обещали, что будут поднимать зарплату на 400$ каждые 6 месяцев.
 * 300$ в месяц Ваня тратит на еду и развлечения.
 * 10% от зарплаты Ваня ежемесячно переводит на счет брокера, чтобы инвестировать в акции с доходностью 2% в месяц.
 * Посчитать, сколько Ваня будет иметь средств на своем счету и на счету брокера за 3 года и 2 месяца.
 * Для интереса: попробовать увеличить процент, которые Ваня инвестирует из своей зарплаты
 */
public class HW5Task3 {

    public static void main(String[] args) {
        int salary = 600;
        int salaryGrow = 400;
        int periodSalaryGrow = 6;
        int monthSpending = 300;
        int brokerPercent = 10;
        int brokerMarginPercent = 2;
        int periodYear = 3;
        int periodMonth = 2;
        int timePeriod = periodYear * 12 + periodMonth;

        double ivanAccount = 0;
        double brokerAccount = 0;
        double sumAccounts = 0;
        int monthCounter = 1;

        while (monthCounter <= timePeriod) {
            ivanAccount += salary - monthSpending - (double) salary * brokerPercent / 100;
            brokerAccount += brokerAccount * brokerMarginPercent / 100 + (double) salary * brokerPercent / 100;
            if (monthCounter % periodSalaryGrow == 0) {
                salary += salaryGrow;
            }
            monthCounter++;
        }

        System.out.println("На своем счету Иван будет иметь: " + ivanAccount);
        System.out.println("а на брокерским счету: " + brokerAccount);
        sumAccounts = ivanAccount + brokerAccount;
        System.out.println("Итого у Ивана будет: " + sumAccounts);
    }
}
