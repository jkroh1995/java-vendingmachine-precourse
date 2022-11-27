package vendingmachine.utils;

import vendingmachine.domain.VendingMachine;
import vendingmachine.utils.validator.BuyValidator;
import vendingmachine.utils.validator.InputMoneyValidator;
import vendingmachine.utils.validator.MachineMoneyValidator;
import vendingmachine.utils.validator.ProductsValidator;
import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

public class InputHandler {

    InputView inputView = new InputView();
    OutputView outputView = new OutputView();

    public int getMoney() {
        try {
            String money = inputView.readMachineMoney();
            new MachineMoneyValidator(money);
            return Integer.parseInt(money);
        } catch (IllegalArgumentException e) {
            outputView.printError(e.getMessage());
            return getMoney();
        }
    }

    public String[] getProducts() {
        try {
            String products = inputView.readProducts();
            new ProductsValidator(products);
            return products.split(";");
        } catch (IllegalArgumentException e) {
            outputView.printError(e.getMessage());
            return getProducts();
        }
    }

    public int getInput() {
        try {
            String money = inputView.readInputMoney();
            new InputMoneyValidator(money);
            return Integer.parseInt(money);
        } catch (IllegalArgumentException e) {
            outputView.printError(e.getMessage());
            return getInput();
        }
    }

    public String getBuy(VendingMachine vendingMachine) {
        try {
            String buy = inputView.readBuy();
            new BuyValidator(buy, vendingMachine);
            return buy;
        } catch (IllegalArgumentException e) {
            outputView.printError(e.getMessage());
            return getBuy(vendingMachine);
        }
    }
}
