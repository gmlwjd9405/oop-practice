package camp.nextstep.edu.calculator;

import camp.nextstep.edu.calculator.number.Number;
import org.springframework.util.StringUtils;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {

    private static final String DEFAULT_DELIMITER_REGEX = "[,:]";
    private static final String CUSTOM_DELIMITER_REGEX = "//(.)\n(.*)";
    private static final int INDEX_OF_DELIMITER = 1;
    private static final int INDEX_OF_VALUE = 2;

    private static final Pattern CUSTOM_PATTERN = Pattern.compile(CUSTOM_DELIMITER_REGEX);

    public int add(final String text) {
        if (isEmptyOrNull(text)) {
            return Number.ZERO_VALUE;
        }
        return sum(split(text));
    }

    private boolean isEmptyOrNull(final String text) {
        return StringUtils.isEmpty(text);
    }

    private String[] split(final String text) {
        Matcher matcher = CUSTOM_PATTERN.matcher(text);
        if (matcher.find()) {
            String customDelimiter = matcher.group(INDEX_OF_DELIMITER);
            return matcher.group(INDEX_OF_VALUE).split(customDelimiter);
        }
        return text.split(DEFAULT_DELIMITER_REGEX);
    }

    private int sum(final String[] operands) {
        return Arrays.stream(operands)
                .mapToInt(Number::toInt)
                .sum();
    }

}
