package vendingmachine.utils.validator;

public class ProductsValidator {

    private static final String ERROR_DIVIDE = "[ERROR] 상품을 ;으로 분류해주세요";
    private static final String ERROR_COMMA = "[ERROR] 상품명, 가격, 수량을 ','로 구분해주세요";
    private static final String ERROR_PRICE = "[ERROR] 상품 가격은 100원 이상이어야 합니다.";
    private static final String ERROR_UNIT = "[ERROR] 상품 가격은 10원 단위여야 합니다.";
    private static final String ERROR_TYPE = "[ERROR] 상품의 가격과 갯수는 정수로만 입력해야 합니다.";
    private static final String ERROR_BLANK = "[ERROR] 상품, 가격, 수량을 입력해주세요.";
    public static final String ERROR_COVER = "[ERROR] 각 상품은 대괄호로 감싸야 합니다.";

    String products;

    public ProductsValidator(String products) {
        this.products = removeCover(products);
        validateBlank(products);
        validateDivide(products);
        validateCover(products);
        products = removeCover(products);
        String[] productsArray = products.split(";");
        validateArray(productsArray);
    }

    private void validateCover(String products) {
        String[] tmpArray = products.split(";");
        for (String s : tmpArray) {
            if (s.charAt(0) != '[' || s.charAt(s.length() - 1) != ']') {
                throw new IllegalArgumentException(ERROR_COVER);
            }
        }
    }

    private String removeCover(String products) {
        products = products.replace("[", "");
        products = products.replace("]", "");
        return products;
    }

    private void validateBlank(String products) {
        if (products.equals("")) {
            throw new IllegalArgumentException(ERROR_BLANK);
        }
    }

    private void validateArray(String[] products) {
        for (String product : products) {
            validateComma(product);
            validateType(product);
            validatePrice(product);
            validateUnit(product);
        }
    }

    private void validateType(String product) {
        String[] tmpArray = product.split(",");
        try {
            Integer.parseInt(tmpArray[1]);
            Integer.parseInt(tmpArray[2]);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_TYPE);
        }
    }

    private void validateUnit(String product) {
        String[] tmpArray = product.split(",");
        if (Integer.parseInt(tmpArray[1]) % 10 != 0) {
            throw new IllegalArgumentException(ERROR_UNIT);
        }
    }

    private void validatePrice(String product) {
        String[] tmpArray = product.split(",");
        if (Integer.parseInt(tmpArray[1]) < 100) {
            throw new IllegalArgumentException(ERROR_PRICE);
        }
    }

    private void validateComma(String product) {
        String[] tmpArray = product.split(",");
        if (countChar(product, ',') + 1 != tmpArray.length) {
            throw new IllegalArgumentException(ERROR_COMMA);
        }
    }

    private void validateDivide(String products) {
        String[] tmpArray = products.split(";");
        if (countChar(products, ';') + 1 != tmpArray.length) {
            throw new IllegalArgumentException(ERROR_DIVIDE);
        }
    }

    private static long countChar(String str, char ch) {
        return str.chars()
                .filter(c -> c == ch)
                .count();
    }
}
