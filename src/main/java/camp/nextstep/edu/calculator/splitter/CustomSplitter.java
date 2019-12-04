package camp.nextstep.edu.calculator.splitter;

import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CustomSplitter implements Splitter {

    private static final String CUSTOM_DELIMITER_REGEX = "//(.*)\n(.*)";
    private static final int INDEX_OF_DELIMITER = 1;
    private static final int INDEX_OF_VALUE = 2;
    private static final List<String> REGEX_META_CHAR = new ArrayList<>(
            Arrays.asList(".", "|", "^", "$", "*", "+", "?", "(", "[", "{", ")")
    );

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
            String customDelimiter = convertEscapedString(matcher.group(INDEX_OF_DELIMITER));
            return matcher.group(INDEX_OF_VALUE).split(customDelimiter);
        }
        return EMPTY_ARRAY;
    }

    private boolean isMatchedPattern(final String value) {
        return CUSTOM_PATTERN.matcher(value).find();
    }

    private String convertEscapedString(final String customDelimiter) {
        if (REGEX_META_CHAR.contains(customDelimiter)) {
            return "\\" + customDelimiter;
        }
        return customDelimiter;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomSplitter that = (CustomSplitter) o;
        return Objects.equals(CUSTOM_PATTERN, that.CUSTOM_PATTERN);
    }

    @Override
    public int hashCode() {
        return Objects.hash(CUSTOM_PATTERN);
    }
}
