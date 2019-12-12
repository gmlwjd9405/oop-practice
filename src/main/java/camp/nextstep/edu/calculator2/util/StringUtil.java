package camp.nextstep.edu.calculator2.util;

import camp.nextstep.edu.calculator2.exception.ErrorMessage;
import org.thymeleaf.util.StringUtils;

public class StringUtil {

    public static int toInt(final String value) {
        if (StringUtils.isEmpty(value)) {
            throw new IllegalArgumentException(ErrorMessage.NOT_SUPPORTED_FORMAT);
        }

        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException nfe) {
            throw new NumberFormatException(ErrorMessage.NOT_SUPPORTED_FORMAT);
        }
    }
}
