package camp.nextstep.edu.caculator2.calculator;

import camp.nextstep.edu.caculator2.exception.ErrorMessage;
import camp.nextstep.edu.caculator2.operation.ArithmeticOperationStrategy;
import camp.nextstep.edu.caculator2.operation.OperationStrategy;
import camp.nextstep.edu.caculator2.util.StringUtil;
import org.springframework.util.StringUtils;

public class Calculator {

    private static final String DELIMITER = " ";

    public static Calculator of() {
        return new Calculator();
    }

    public Integer run(String input) {
        if (StringUtils.isEmpty(input)) {
            throw new IllegalArgumentException(ErrorMessage.IS_NULL_OR_EMPTY);
        }

        String[] values = input.split(DELIMITER);
        try {
            return calculate(values);
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new IllegalArgumentException(ErrorMessage.NOT_SUPPORTED_FORMAT);
        }
    }

    private int calculate(final String[] values) throws ArrayIndexOutOfBoundsException {
        int operandA = StringUtil.toInt(values[0]);

        for (int i = 1; i < values.length; i += 2) {
            OperationStrategy operator = ArithmeticOperationStrategy.of(values[i]);
            int operandB = StringUtil.toInt(values[i + 1]);

            operandA = operator.operate(operandA, operandB);
        }
        return operandA;
    }
}
