package camp.nextstep.edu.caculator2;

import org.springframework.util.StringUtils;

public class Calculator {

    public static final String IS_NULL_OR_EMPTY = "입력 값이 null 이거나 빈 공백 문자입니다.";
    public static final String NOT_SUPPORTED_FORMAT = "형식에 맞지 않는 문자열입니다.";
    private static final String DELIMITER = " ";

    private Operator operators = Operator.of();

    public static Calculator of() {
        return new Calculator();
    }

    public Integer calculate(String input) {
        if (StringUtils.isEmpty(input)) {
            throw new RuntimeException(IS_NULL_OR_EMPTY);
        }

        String[] values = input.split(DELIMITER);
        return operate(values);
    }

    private int operate(final String[] values) {
        int num1 = toInt(values[0]);
        for (int i = 1; i < values.length; i += 2) {
            String operator = values[i];
            int num2 = toInt(values[i + 1]);

            num1 = operators.operate(operator, num1, num2);
        }
        return num1;
    }

    private int toInt(final String operand) {
        if (isNumeric(operand)) {
            return Integer.parseInt(operand);
        }
        return 0; // ?
    }

    private boolean isNumeric(String value) {
        if (value == null) {
            return false;
        }
        try {
            Integer.parseInt(value);
        } catch (NumberFormatException nfe) {
            throw new NumberFormatException(NOT_SUPPORTED_FORMAT);
        }
        return true;
    }
}
