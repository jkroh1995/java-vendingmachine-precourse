package vendingmachine.view;

import java.util.List;
import vendingmachine.domain.CoinList;
import vendingmachine.domain.MachineCoins;

public class OutputView {

    public static final String PRINT_MACHINECOINS = "자판기가 보유한 동전";
    public static final String PRINT_500 = "500원 - ";
    public static final String PRINT_100 = "100원 - ";
    public static final String PRINT_50 = "50원 - ";
    public static final String PRINT_10 = "10원 - ";
    public static final String PRINT_INPUTMONEY = "투입 금액: ";

    public OutputView() {

    }

    public void printError(String errorMessage) {
        System.out.println(errorMessage);
    }

    public void printMachineCoins(MachineCoins machineCoins) {
        System.out.println(PRINT_MACHINECOINS);
        System.out.printf(PRINT_500 + "%d개\n", machineCoins.get(0));
        System.out.printf(PRINT_100 + "%d개\n", machineCoins.get(1));
        System.out.printf(PRINT_50 + "%d개\n", machineCoins.get(2));
        System.out.printf(PRINT_10 + "%d개\n", machineCoins.get(3));
    }

    public void printInputMoney(int inputMoney) {
        System.out.printf(PRINT_INPUTMONEY + "%d원\n", inputMoney);
    }

    public void printResult(CoinList coinList, int[] changeCoins) {
        System.out.println("잔돈");
        for (int i = 0; i < coinList.size(); i++) {
            if (changeCoins[i] != 0) {
                System.out.printf("%d원 - %d개\n", coinList.get(i), changeCoins[i]);
            }
        }
    }
}
