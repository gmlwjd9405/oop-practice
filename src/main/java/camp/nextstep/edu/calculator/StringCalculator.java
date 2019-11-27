package camp.nextstep.edu.calculator;

import org.springframework.util.StringUtils;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {

    public static final String DEFAULT_DELIMITER_REGEX = "[,:]";
    public static final String CUSTOM_DELIMITER_REGEX = "//(.)\n(.*)";

    public int add(final String text) {
        if (isEmptyOrNull(text)) {
            return 0;
        }
        return sum(split(text));
    }

    private boolean isEmptyOrNull(final String text) {
        return StringUtils.isEmpty(text);
    }

    private String[] split(final String text) {
        Matcher matcher = Pattern.compile(CUSTOM_DELIMITER_REGEX).matcher(text);
        if (matcher.find()) {
            return matcher.group(2).split(matcher.group(1));
        }
        return text.split(DEFAULT_DELIMITER_REGEX);
    }

    private int sum(final String[] operands) {
        return Arrays.stream(operands)
                .mapToInt(PositiveNumber::toInt)
                .sum();
    }

}
