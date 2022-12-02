package vendingmachine.domain;

public class ChangeCoins {

    int[] changeCoins;
    int amount = 0;

    public ChangeCoins(int change, MachineCoins machineCoins, CoinList coinList) {
        int[] changeCoins = {0, 0, 0, 0};
        for (int index = 0; index < machineCoins.size(); index++) {
            while (amount < machineCoins.get(index) && change >= coinList.get(index)) {
                change = change - coinList.get(index);
                amount++;
            }
            changeCoins[index] = amount;
            amount = 0;
        }
        this.changeCoins = changeCoins;
    }

    public int[] getList() {
        return changeCoins;
    }
}
