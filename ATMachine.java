package by.lav.homework20;

public class ATMachine {

    private static final int BILL_NOMINAL_1 = 20;
    private static final int BILL_NOMINAL_2 = 50;
    private static final int BILL_NOMINAL_3 = 100;

    private int bill1;
    private int bill2;
    private int bill3;

    public ATMachine(int bill1, int bill2, int bill3) {
        this.bill1 = bill1;
        this.bill2 = bill2;
        this.bill3 = bill3;
    }

    public boolean isMoneyGet(int amount) {
        if (amount > sumMoney(bill1, bill2, bill3)) {
            showWarning(1);
            return false;
        } else if (amount % 10 != 0 || amount == 10 || amount == 30) {
            showWarning(2);
            return false;
        } else if ((amount / 10 % 10 % 2 != 0) && bill2 < 1) {
            showWarning(3);
            return false;
        } else {
            int withdrawBill1 = 0;
            int withdrawBill2 = 0;
            int withdrawBill3 = 0;
            int tempAmount = amount;

            if ((amount / 10 % 10 % 2 != 0)) {
                withdrawBill2 = 1;
                bill2 -= withdrawBill2;
                tempAmount -= withdrawBill2 * BILL_NOMINAL_2;
            }

            if (tempAmount >= BILL_NOMINAL_3) {
                int needWithdraw3 = tempAmount / BILL_NOMINAL_3;
                if (needWithdraw3 <= bill3) {
                    withdrawBill3 += needWithdraw3;
                    bill3 -= withdrawBill3;
                } else {
                    withdrawBill3 += bill3;
                    bill3 -= withdrawBill3;
                    int needWithdraw2 = (needWithdraw3 - withdrawBill3) * 2;
                    if (needWithdraw2 <= bill2) {
                        withdrawBill2 += needWithdraw2;
                        bill2 -= needWithdraw2;
                    } else {
                        withdrawBill2 += bill2 / 2 * 2;
                        bill2 -= withdrawBill2;
                        int needWithdraw1 = (needWithdraw3 - withdrawBill3 - withdrawBill2 / 2) * 5;
                        if (needWithdraw1 <= bill1) {
                            withdrawBill1 += needWithdraw1;
                            bill1 -= withdrawBill1;
                        } else {
                            withdrawBill1 += bill1;
                            bill1 -= withdrawBill1;
                        }
                    }
                }
                tempAmount = amount - sumMoney(withdrawBill1, withdrawBill2, withdrawBill3);
            }

            if (tempAmount >= BILL_NOMINAL_1 && tempAmount < BILL_NOMINAL_3) {
                if (tempAmount / BILL_NOMINAL_1 < bill1) {
                    withdrawBill1 += tempAmount / BILL_NOMINAL_1;
                    bill1 -= withdrawBill1;
                } else {
                    withdrawBill1 += bill1;
                    bill1 -= withdrawBill1;
                }
                tempAmount -= withdrawBill1 * BILL_NOMINAL_1;
            }
            if (tempAmount != 0) {
                showWarning(3);
                return false;
            } else {
                System.out.println("Выдано: " + sumMoney(withdrawBill1, withdrawBill2, withdrawBill3) +
                        " купюрами: 100х" + withdrawBill3 + ", 50x" + withdrawBill2 + ", 20x" + withdrawBill1);
                return true;
            }
        }
    }

    private int sumMoney(int bill1, int bill2, int bill3) {
        return BILL_NOMINAL_1 * bill1 + BILL_NOMINAL_2 * bill2 + BILL_NOMINAL_3 * bill3;
    }

    private void showWarning(int warning) {
        switch (warning) {
            case 1 -> {
                System.out.println("Не удалось снять. Недостаточно средств в банкомате.");
                System.out.println("Введите другую сумму.");
            }
            case 2 -> System.out.println("Не удалось снять. Введите сумму кратную 10 (за исключением 10 и 30)");
            case 3 -> {
                System.out.println("Не удалось снять. В банкомате недостаточно купюр необходимого номинала.");
                System.out.println("Введите другую сумму.");
            }
        }
    }

    public void setBill1(int bill1) {
        this.bill1 = bill1;
    }

    public void setBill2(int bill2) {
        this.bill2 = bill2;
    }

    public void setBill3(int bill3) {
        this.bill3 = bill3;
    }
}
