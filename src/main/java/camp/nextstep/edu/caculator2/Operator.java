package camp.nextstep.edu.caculator2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Operator {

    private static final String PLUS = "+";
    private static final String MINUS = "-";
    private static final String MULTIPLY = "*";
    private static final String DIVIDE = "/";
    public static final String NOT_SUPPORTED_OPERATOR = "지원하지 않는 연산자입니다.";

    private final List<String> arithmetic = new ArrayList<>();

    public static Operator of() {
        return new Operator();
    }

    private Operator() {
        arithmetic.addAll(Arrays.asList(PLUS, MINUS, MULTIPLY, DIVIDE));
    }

    int operate(String operator, int num1, int num2) {
        switch (validate(operator)) {
            case PLUS:
                return plus(num1, num2);
            case MINUS:
                return minus(num1, num2);
            case MULTIPLY:
                return multiply(num1, num2);
            case DIVIDE:
                return divide(num1, num2);
        }
        return num1;
    }

    private String validate(final String operator) {
        if (!contains(operator)) {
            throw new RuntimeException(NOT_SUPPORTED_OPERATOR);
        }
        return operator;
    }

    private boolean contains(String value) {
        return arithmetic.contains(value);
    }

    private int plus(int a, int b) {
        return a + b;
    }

    private int multiply(int a, int b) {
        return a * b;
    }

    private int minus(int a, int b) {
        return a - b;
    }

    private int divide(int a, int b) {
        return a / b;
    }
}
