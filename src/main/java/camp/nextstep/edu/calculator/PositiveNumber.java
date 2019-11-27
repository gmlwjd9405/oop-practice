package camp.nextstep.edu.calculator;

public class PositiveNumber {

    private int number;

    public static int toInt(final String number) {
        return new PositiveNumber(number).number;
    }

    private PositiveNumber(final String number) throws NumberFormatException {
        this.number = Integer.parseInt(number);
        checkNegativeNumber(this.number);
    }

    private void checkNegativeNumber(final int number) {
        if (number < 0) {
            throw new NumberFormatException();
        }
    }

}
