package camp.nextstep.edu.calculator;

import org.springframework.util.StringUtils;

public class StringCalculator {

    public int add(final String text) {
        if (isEmptyOrNull(text)) {
            return 0;
        }
        return -1;
    }

    private boolean isEmptyOrNull(final String text) {
        return StringUtils.isEmpty(text);
    }

}
