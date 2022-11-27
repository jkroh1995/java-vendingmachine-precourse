package vendingmachine.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private static final String PRINT_MACHINEMONEY = "자판기가 보유하고 있는 금액을 입력해 주세요.";
    private static final String PRINT_PRODUCTS = "상품명과 가격, 수량을 입력해 주세요.";
    private static final String PRINT_INPUT = "투입 금액을 입력해 주세요.";
    private static final String PRINT_BUY = "구입할 상품명을 입력해 주세요.";

    public InputView(){

    }

    public String readMachineMoney(){
        System.out.println(PRINT_MACHINEMONEY);
        String money = Console.readLine();
        return money;
    }

    public String readProducts(){
        System.out.println(PRINT_PRODUCTS);
        String products = Console.readLine();
        return products;
    }

    public String readInputMoney(){
        System.out.println(PRINT_INPUT);
        String inputMoney = Console.readLine();
        return inputMoney;
    }

    public String readBuy(){
        System.out.println(PRINT_BUY);
        String buy = Console.readLine();
        return buy;
    }


}
