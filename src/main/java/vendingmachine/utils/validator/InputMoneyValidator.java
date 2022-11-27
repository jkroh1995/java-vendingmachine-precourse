package vendingmachine.utils.validator;

public class InputMoneyValidator {

    private static final String ERROR_TYPE = "[ERROR] 투입 금액은 숫자만 입력해야 합니다.";
    private static final String ERROR_BLANK = "[ERROR] 투입 금액을 입력해야 합니다..";

    String money;

    public InputMoneyValidator(String money){
        this.money = money;
        validate(money);
    }

    private void validate(String money) {
        validateBlank(money);
        validateType(money);
    }

    private void validateType(String money){
        try{
            Integer.parseInt(money);
        } catch (NumberFormatException e){
            throw new IllegalArgumentException(ERROR_TYPE);
        }
    }

    private void validateBlank(String products) {
        if(products.equals("")){
            throw new IllegalArgumentException(ERROR_BLANK);
        }
    }
}
