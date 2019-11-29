package camp.nextstep.edu.calculator.splitter;

import org.springframework.util.StringUtils;

public class DefaultSplitter implements Splitter {

    private static final String DEFAULT_DELIMITER_REGEX = "[,:]";

    @Override
    public boolean supports(String value) {
        return true;
    }

    @Override
    public String[] split(String value) {
        if (StringUtils.isEmpty(value)) {
            return EMPTY_ARRAY;
        }
        return value.split(DEFAULT_DELIMITER_REGEX);
    }
}
