package camp.nextstep.edu.calculator;

import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {

    public static final String DEFAULT_DELIMITER = ",|:";

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
            list.add(i);
        }
        return list;
    }

    private int[] splitByDelimiter(final String text, final String delimiter) {
        return Arrays.stream(text.split(delimiter))
                .mapToInt(Integer::parseInt)
                .toArray();
    }

    private int[] convertIntArray(final String text) {
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(text);
        if (m.find()) {
            return splitByDelimiter(m.group(2), m.group(1));
        }
        return splitByDelimiter(text, DEFAULT_DELIMITER);
    }

}
