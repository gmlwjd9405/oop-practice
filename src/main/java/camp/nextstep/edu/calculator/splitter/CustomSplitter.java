package camp.nextstep.edu.calculator.splitter;

import org.springframework.util.StringUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CustomSplitter implements Splitter {

    private static final String CUSTOM_DELIMITER_REGEX = "//(.*)\n(.*)";
    private static final int INDEX_OF_DELIMITER = 1;
    private static final int INDEX_OF_VALUE = 2;

    private final Pattern CUSTOM_PATTERN = Pattern.compile(CUSTOM_DELIMITER_REGEX);

    @Override
    public boolean supports(String value) {
        return isMatchedPattern(value);
    }

    @Override
    public String[] split(String value) {
        if (StringUtils.isEmpty(value)) {
            return EMPTY_ARRAY;
        }
        Matcher matcher = CUSTOM_PATTERN.matcher(value);
        if (matcher.find()) {
            String customDelimiter = matcher.group(INDEX_OF_DELIMITER);
            return matcher.group(INDEX_OF_VALUE).split(customDelimiter);
        }
        return EMPTY_ARRAY;
    }

    private boolean isMatchedPattern(final String value) {
        return CUSTOM_PATTERN.matcher(value).find();
    }
}
