package camp.nextstep.edu.caculator2.util;

import camp.nextstep.edu.caculator2.exception.ErrorMessage;
import org.thymeleaf.util.StringUtils;

public class StringUtil {

    public static int toInt(final String operand) {
        if (StringUtils.isEmpty(operand)) {
            throw new IllegalArgumentException(ErrorMessage.NOT_SUPPORTED_FORMAT);
        }

        try {
            return Integer.parseInt(operand);
        } catch (NumberFormatException nfe) {
            throw new NumberFormatException(ErrorMessage.NOT_SUPPORTED_FORMAT);
        }
    }
}
