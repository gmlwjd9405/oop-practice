package camp.nextstep.edu.calculator;

import camp.nextstep.edu.calculator.number.Number;
import camp.nextstep.edu.calculator.splitter.Splitter;
import camp.nextstep.edu.calculator.splitter.SplitterSelector;
import org.springframework.util.StringUtils;

import java.util.Arrays;

public class StringCalculator {

    public int add(final String text) {
        if (isEmptyOrNull(text)) {
            return Number.ZERO_VALUE;
        }
        Splitter splitter = SplitterSelector.of().matchedSplitter(text);
        return sum(splitter.split(text));
    }

    private boolean isEmptyOrNull(final String text) {
        return StringUtils.isEmpty(text);
    }

    private int sum(final String[] operands) {
        return Arrays.stream(operands)
                .map(Number::of)
                .reduce(Number.ZERO, Number::plus)
                .toInt();
    }

}
