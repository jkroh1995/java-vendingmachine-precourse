package vendingmachine.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class VendingMachine {

    List<String>vendingMachine;
    int inputMoney;

    public VendingMachine(String[] products, int inputMoney) {
        List<String>vendingMachine = new ArrayList<>();
        String [] sortedProducts = makeSortedArrayByPrice(products);
        removeCover(sortedProducts, vendingMachine);
        this.vendingMachine=vendingMachine;
        this.inputMoney=inputMoney;
    }

    private String[] makeSortedArrayByPrice(String[] products) {
        int[] sortedPrice = sortPrice(products);
        for(int priceIndex=0;priceIndex<sortedPrice.length;priceIndex++){
            String tmpString = products[priceIndex];
            String price = String.valueOf(sortedPrice[priceIndex]);
            sortProductsByPrice(products, priceIndex, tmpString, price);
        }
        return products;
    }

    private void sortProductsByPrice(String[] products, int priceIndex, String tmpString, String price) {
        for(int productIndex = 0; productIndex< products.length; productIndex++){
            if(products[productIndex].contains(price)){
                products[priceIndex]= products[productIndex];
                products[productIndex]= tmpString;
            }
        }
    }

    private int[] sortPrice(String[] products) {
        int [] sortedPrice = new int[products.length];
        for(int i = 0; i< products.length; i++){
            String [] tmpArray = products[i].split(",");
            sortedPrice[i]=Integer.parseInt(tmpArray[1]);
        }
        Arrays.sort(sortedPrice);
        return sortedPrice;
    }

    private void removeCover(String[] products, List<String> vendingMachine) {
        for(int i = 0; i< products.length; i++){
            products[i]= products[i].replace("[","");
            products[i]= products[i].replace("]","");
            vendingMachine.add(products[i]);
        }
    }

    public void sell(String buy) {
        for(int i=0;i<vendingMachine.size();i++){
            if(vendingMachine.get(i).contains(buy)){
                String [] tmpArray = vendingMachine.get(i).split(",");
                sellingProduct(i, tmpArray);
                break;
            }
        }
    }

    private void sellingProduct(int index, String[] tmpArray) {
        inputMoney -= Integer.parseInt(tmpArray[1]);
        tmpArray[2]=String.valueOf(Integer.parseInt(tmpArray[2])-1);
        String product = Arrays.toString(tmpArray);
        vendingMachine.remove(index);
        vendingMachine.add(index,product);
    }

    public boolean contains(String buy) {
        return vendingMachine.contains(buy);
    }

    public int getMoney() {
        return inputMoney;
    }

    public int getCheapest(){
        return Integer.parseInt(vendingMachine.get(0).split(",")[1]);
    }

    public String getString(int index){
        return vendingMachine.get(index);
    }

    public int indexOf(String buy) {
        return vendingMachine.indexOf(buy);
    }

    public List<String>getList(){
        return vendingMachine;
    }

    public int size() {
        return vendingMachine.size();
    }
}
