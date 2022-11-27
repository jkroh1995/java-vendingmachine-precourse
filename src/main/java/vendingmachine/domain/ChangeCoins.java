package vendingmachine.domain;

import java.util.ArrayList;
import java.util.List;

public class ChangeCoins {

    List<Integer> changeCoins;

    public ChangeCoins(int change, MachineCoins machineCoins, CoinList coinList) {
        List<Integer> changeCoins = new ArrayList<>();
        for (int i = 0; i < machineCoins.size(); i++) {
            if(machineCoins.get(i)==0){
                changeCoins.add(0);
                continue;
            }
            changeCoins.add(change / (coinList.get(i)));
            change = change % (coinList.get(i)*machineCoins.get(i));
        }
        this.changeCoins = changeCoins;
    }

    public List<Integer> getList() {
        return changeCoins;
    }
}
