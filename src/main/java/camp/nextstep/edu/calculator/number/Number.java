package camp.nextstep.edu.calculator.number;

import camp.nextstep.edu.calculator.exception.NegativeNumberException;

import java.util.Objects;

public class Number {

    public static final Number ZERO = new Number(Number.ZERO_VALUE);
    public static final int ZERO_VALUE = 0;

    private int value;

    public static Number of(final String number) {
        return new Number(number);
    }

    private Number(final int number) {
        validateNegativeNumber(number);
        this.value = number;
    }

    private Number(final String number) throws NumberFormatException {
        this.value = Integer.parseInt(number);
        validateNegativeNumber(this.value);
    }

    private void validateNegativeNumber(final int number) {
        if (isNegative(number)) {
            throw new NegativeNumberException(number);
        }
    }

    private boolean isNegative(final int number) {
        return number < ZERO_VALUE;
    }

    public int toInt() {
        return this.value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Number number = (Number) o;
        return value == number.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    public Number plus(final Number number) {
        return new Number(this.value + number.value);
    }

}
