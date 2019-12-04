package camp.nextstep.edu.calculator.splitter;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class CommaAndColonSplitterTest {

    private CommaAndColonSplitter commaAndColonSplitter;

    @BeforeEach
    void setUp() {
        commaAndColonSplitter = new CommaAndColonSplitter();
    }

    @DisplayName("항상 true 값을 반환한다.")
    @ParameterizedTest
    @NullAndEmptySource
    @MethodSource("anyValueCase")
    void supports(final String customDelimiter) {
        assertThat(commaAndColonSplitter.supports(customDelimiter)).isTrue();
    }

    private static Stream<Arguments> anyValueCase() {
        return Stream.of(
                Arguments.of("//;\n1;2;3"),
                Arguments.of("//?\n"),
                Arguments.of("4,6")
        );
    }

    @DisplayName("빈 문자열을 입력하면 빈 String 배열을 반환한다.")
    @ParameterizedTest
    @EmptySource
    void failureSplit(final String value) {
        assertThat(commaAndColonSplitter.split(value))
                .isEqualTo(new String[0]);
    }

    @DisplayName("콜론(:) 또는 콤마(,)를 구분자로 분리한 String 배열을 반환한다.")
    @ParameterizedTest
    @MethodSource("splitSuccessCase")
    void successSplit(final String value, final String[] expected) {
        assertThat(commaAndColonSplitter.split(value)).isEqualTo(expected);

    }

    private static Stream<Arguments> splitSuccessCase() {
        return Stream.of(
                Arguments.of("3*4", new String[]{"3*4"}),
                Arguments.of("//1", new String[]{"//1"}),
                Arguments.of("\n1", new String[]{"\n1"}),
                Arguments.of("0", new String[]{"0"}),
                Arguments.of("10011,2,3", new String[]{"10011", "2", "3"}),
                Arguments.of("200:22", new String[]{"200", "22"}),
                Arguments.of("1,2:3", new String[]{"1", "2", "3"})
        );
    }
}
