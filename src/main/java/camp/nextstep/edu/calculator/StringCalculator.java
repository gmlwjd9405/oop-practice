package camp.nextstep.edu.calculator;

import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringCalculator {

    public static final String COLONS = ",";

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
        List<Integer> numbers = convertIntArrayToList(splitByDelimiter(text, COLONS));
        return numbers.stream()
                .mapToInt(Integer::intValue
                ).sum();
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

}
