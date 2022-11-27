package vendingmachine.domain;

import java.util.ArrayList;
import java.util.List;

public class MachineCoins {

    List<Integer> machineCoins;

    public MachineCoins(int money, CoinList coinList) {
        List<Integer> machineCoins = new ArrayList<>();
        for (int i = 0; i < coinList.size(); i++) {
            machineCoins.add(money / coinList.get(i));
            money = money % coinList.get(i);
        }
        this.machineCoins = machineCoins;
    }

    public int size() {
        return machineCoins.size();
    }

    public int get(int index) {
        return machineCoins.get(index);
    }
}
