package camp.nextstep.edu.calculator.number;

public class Number {

    public static final int ZERO_VALUE = 0;

    private int value;

    public static int toInt(final String number) {
        return new Number(number).value;
    }

    private Number(final String number) throws NumberFormatException {
        this.value = Integer.parseInt(number);
        validateNegativeNumber(this.value);
    }

    private void validateNegativeNumber(final int number) {
        if (isNegative(number)) {
            throw new NumberFormatException();
        }
    }

    private boolean isNegative(final int number) {
        return number < ZERO_VALUE;
    }

}
