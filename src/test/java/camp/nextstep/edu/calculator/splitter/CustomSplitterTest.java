package camp.nextstep.edu.calculator.splitter;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class CustomSplitterTest {

    private CustomSplitter customSplitter;

    @BeforeEach
    void setUp() {
        customSplitter = new CustomSplitter();
    }

    @DisplayName("커스텀 구분자를 분리하는 정규식 표현을 가지고 있는지 확인한다.")
    @ParameterizedTest
    @MethodSource("customDelimiterCase")
    void supports(final String customDelimiter, final boolean expected) {
        assertThat(customSplitter.supports(customDelimiter)).isSameAs(expected);
    }

    private static Stream<Arguments> customDelimiterCase() {
        return Stream.of(
                Arguments.of("//;\n1;2;3", true),
                Arguments.of("//\\^\n10000", true),
                Arguments.of("//\\|\n1|4", true),
                Arguments.of("//|\n10000", true),
                Arguments.of("//*\n10*20", true),
                Arguments.of("//\\*\n10000", true),
                Arguments.of("//++\n10++20", true),
                Arguments.of("//?\n", true),
                Arguments.of("4,6", false),
                Arguments.of("", false)
        );
    }

    @DisplayName("빈 문자열이나 매칭이 안되는 정규표현식이면 빈 String 배열을 반환한다.")
    @ParameterizedTest
    @EmptySource
    @ValueSource(strings = {"3,4", "//1", "\n1"})
    void failureSplit(String value) {
        assertThat(customSplitter.split(value))
                .isEqualTo(new String[0]);
    }

    @DisplayName("커스텀 구분자에 따라 입력값들 중 숫자를 분리한 String 배열을 반환한다.")
    @ParameterizedTest
    @MethodSource("splitSuccessCase")
    void successSplit(final String input, final String[] expected) {
        assertThat(customSplitter.split(input)).isEqualTo(expected);
    }

    private static Stream<Arguments> splitSuccessCase() {
        return Stream.of(
                Arguments.of("//;\n0", new String[]{"0"}),
                Arguments.of("//;\n10000", new String[]{"10000"}),
                Arguments.of("//;\n1;2;3", new String[]{"1", "2", "3"}),
                Arguments.of("//|\n999", new String[]{"999"}),
                Arguments.of("//|\n0|1|2", new String[]{"0", "1", "2"}),
                Arguments.of("//\\|\n0|1|2", new String[]{"0", "1", "2"}),
                Arguments.of("//.\n1", new String[]{"1"}),
                Arguments.of("//.\n10011.2.3", new String[]{"10011", "2", "3"}),
                Arguments.of("//^\n200^22", new String[]{"200", "22"}),
                Arguments.of("//*\n1*2*3*", new String[]{"1", "2", "3"}),
                Arguments.of("//\\*\n1*2*3*", new String[]{"1", "2", "3"})
        );
    }
}
