package vendingmachine.Controller;

import vendingmachine.domain.ChangeCoins;
import vendingmachine.domain.CoinList;
import vendingmachine.domain.MachineCoins;
import vendingmachine.domain.VendingMachine;
import vendingmachine.utils.InputHandler;
import vendingmachine.view.OutputView;

public class MachineController {

    InputHandler inputHandler = new InputHandler();
    OutputView outputView = new OutputView();
    CoinList coinList = new CoinList();

    public void run() {
        MachineCoins machineCoins = getMachineCoins();
        VendingMachine vendingMachine = getVendingMachine();
        doSell(vendingMachine);
        printResult(machineCoins, vendingMachine);
    }

    private void printResult(MachineCoins machineCoins, VendingMachine vendingMachine) {
        outputView.printInputMoney(vendingMachine.getMoney());
        ChangeCoins changeCoins = new ChangeCoins(vendingMachine.getMoney(), machineCoins, coinList);
        outputView.printResult(coinList, changeCoins.getList());
    }

    private VendingMachine getVendingMachine() {
        String[] products = inputHandler.getProducts();
        int input = inputHandler.getInput();
        return new VendingMachine(products, input);
    }

    private void doSell(VendingMachine vendingMachine) {
        int cheapest = vendingMachine.getCheapest();
        while (vendingMachine.getMoney() > cheapest) {
            outputView.printInputMoney(vendingMachine.getMoney());
            String buy = inputHandler.getBuy(vendingMachine);
            vendingMachine.sell(buy);
        }
    }

    private MachineCoins getMachineCoins() {
        int money = inputHandler.getMoney();
        MachineCoins machineCoins = new MachineCoins(money, coinList);
        outputView.printMachineCoins(machineCoins);
        return machineCoins;
    }

}
