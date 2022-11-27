package vendingmachine.Controller;

import vendingmachine.domain.ChangeCoins;
import vendingmachine.domain.CoinList;
import vendingmachine.domain.MachineCoins;
import vendingmachine.domain.VendingMachine;
import vendingmachine.utils.InputHandler;
import vendingmachine.view.OutputView;

public class MachineController {

    InputHandler inputHandler = new InputHandler();
    OutputView outputView  = new OutputView();
    CoinList coinList = new CoinList();

    public void run(){
        int money = inputHandler.getMoney();
        MachineCoins machineCoins = new MachineCoins(money, coinList);
        outputView.printMachineCoins(machineCoins);
        String [] products = inputHandler.getProducts();
        int input = inputHandler.getInput();
        VendingMachine vendingMachine = new VendingMachine(products, input);
        int cheapest = vendingMachine.getCheapest();
        while(vendingMachine.getMoney()> cheapest){
            outputView.printInputMoney(vendingMachine.getMoney());
            String buy = inputHandler.getBuy(vendingMachine);
            vendingMachine.sell(buy);
        }
        outputView.printInputMoney(vendingMachine.getMoney());
        ChangeCoins changeCoins = new ChangeCoins(vendingMachine.getMoney(), machineCoins, coinList);
        outputView.printResult(coinList, changeCoins.getList());
    }

}
