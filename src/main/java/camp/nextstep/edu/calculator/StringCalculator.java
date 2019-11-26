package camp.nextstep.edu.calculator;

import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {

    public static final String DEFAULT_DELIMITER_REGEX = ",|:";
    public static final String CUSTOM_DELIMITER_REGEX = "//(.)\n(.*)";

    public int add(final String text) {
        if (isEmptyOrNull(text)) {
            return 0;
        }
        return sum(text);
    }

    private boolean isEmptyOrNull(final String text) {
        return StringUtils.isEmpty(text);
    }

    private int sum(final String text) {
        List<Integer> numbers = convertIntArrayToList(convertIntArray(text));
        return numbers.stream()
                .mapToInt(Integer::intValue)
                .sum();
    }

    private List<Integer> convertIntArrayToList(int[] input) {
        List<Integer> list = new ArrayList<>();
        for (int i : input) {
            checkNegativeNumber(i);
            list.add(i);
        }
        return list;
    }

    private void checkNegativeNumber(int number) {
        if (number < 0) {
            throw new RuntimeException();
        }
    }

    private int[] convertIntArray(final String text) {
        Matcher m = Pattern.compile(CUSTOM_DELIMITER_REGEX).matcher(text);
        if (m.find()) {
            return splitByDelimiter(m.group(2), m.group(1));
        }
        return splitByDelimiter(text, DEFAULT_DELIMITER_REGEX);
    }

    private int[] splitByDelimiter(final String text, final String delimiter) throws NumberFormatException {
        return Arrays.stream(text.split(delimiter))
                .mapToInt(Integer::parseInt)
                .toArray();
    }

}
