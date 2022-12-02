package vendingmachine.utils.validator;

import vendingmachine.domain.VendingMachine;

public class BuyValidator {
    private static final String ERROR_BLANK = "[ERROR] 구매할 상품을 입력해야 합니다.";
    private static final String ERROR_PRODUCT = "[ERROR] 존재하지 않는 상품입니다.";
    public static final String ERROR_AMOUNT = "[ERROR] 해당 상품은 남은 수량이 없습니다.";

    String buy;

    public BuyValidator(String buy, VendingMachine vendingMachine) {
        this.buy = buy;
        validateBlank(buy);
        validateProduct(buy, vendingMachine);
        validateAmount(buy, vendingMachine);
    }

    private void validateAmount(String buy, VendingMachine vendingMachine) {
        for (int i = 0; i < vendingMachine.size(); i++) {
            throwing(buy, vendingMachine, i);
        }
    }

    private void throwing(String buy, VendingMachine vendingMachine, int i) {
        if (vendingMachine.getString(i).contains(buy)) {
            String[] tmpArray = vendingMachine.getString(i).split(",");
            if (Integer.parseInt(tmpArray[2]) == 0) {
                throw new IllegalArgumentException(ERROR_AMOUNT);
            }
        }
    }

    private void validateProduct(String buy, VendingMachine vendingMachine) {
        int index = 0;
        for (int i = 0; i < vendingMachine.size(); i++) {
            if (vendingMachine.getString(i).contains(buy)) {
                index = 1;
            }
        }
        if (index == 0) {
            throw new IllegalArgumentException(ERROR_PRODUCT);
        }
    }

    private void validateBlank(String buy) {
        if (buy.equals("")) {
            throw new IllegalArgumentException(ERROR_BLANK);
        }
    }
}
