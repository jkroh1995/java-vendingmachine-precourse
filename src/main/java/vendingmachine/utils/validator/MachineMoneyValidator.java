package vendingmachine.utils.validator;

public class MachineMoneyValidator {

    private static final String ERROR_TYPE = "[ERROR] 숫자만 입력해야 합니다.";
    private static final String ERROR_UNIT = "[ERROR] 10원 단위로 입력해야 합니다.";
    private static final String ERROR_BLANK = "[ERROR] 자판기가 보유한 금액을 입력해야 합니다.";

    String money;

    public MachineMoneyValidator(String money){
        this.money = money;
        validate(money);
    }

    private void validate(String money){
        validateBlank(money);
        validateType(money);
        validateUnit(money);
    }

    private void validateBlank(String products) {
        if(products.equals("")){
            throw new IllegalArgumentException(ERROR_BLANK);
        }
    }

    private void validateType(String money){
        try{
            Integer.parseInt(money);
        } catch (NumberFormatException e){
            throw new IllegalArgumentException(ERROR_TYPE);
        }
    }

    private void validateUnit(String money){
        if(Integer.parseInt(money)%10!=0){
            throw new IllegalArgumentException(ERROR_UNIT);
        }
    }
}
