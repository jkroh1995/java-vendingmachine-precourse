package vendingmachine.domain;

import java.util.ArrayList;
import java.util.List;

public class CoinList {

    List<Integer> coinList;

    public CoinList() {
        List<Integer> coinList = new ArrayList<>();
        coinList.add(Coin.COIN_500.getAmount());
        coinList.add(Coin.COIN_100.getAmount());
        coinList.add(Coin.COIN_50.getAmount());
        coinList.add(Coin.COIN_10.getAmount());
        this.coinList = coinList;
    }

    public int size() {
        return coinList.size();
    }

    public int get(int index) {
        return coinList.get(index);
    }
}
