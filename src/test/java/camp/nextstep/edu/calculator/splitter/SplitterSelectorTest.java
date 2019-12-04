package camp.nextstep.edu.calculator.splitter;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

public class SplitterSelectorTest {

    private SplitterSelector splitterSelector;
//    private SplitterSelector2 splitterSelector;

    @BeforeEach
    void setUp() {
        splitterSelector = SplitterSelector.of();
    }

    @DisplayName(value = "생성 성공")
    @Test
    void create() {
        assertThatCode(SplitterSelector::of)
                .doesNotThrowAnyException();
    }

    @DisplayName(value = "커스텀 구분자에 매칭되는 문자열이면 CustomSplitter 를 반환한다.")
    @ParameterizedTest
    @MethodSource("customSplitterCase")
    void customSplitter(String value) {
        assertThat(splitterSelector.matchedSplitter(value))
                .isInstanceOf(CustomSplitter.class);
    }

    private static Stream<Arguments> customSplitterCase() {
        return Stream.of(
                Arguments.of("//;\n0"),
                Arguments.of("//;\n10000"),
                Arguments.of("//;\n1;2;3"),
                Arguments.of("//|\n999"),
                Arguments.of("//|\n0|1|2"),
                Arguments.of("//\\|\n0|1|2"),
                Arguments.of("//.\n1"),
                Arguments.of("//.\n10011.2.3"),
                Arguments.of("//^\n200^22"),
                Arguments.of("//*\n1*2*3*"),
                Arguments.of("//\\*\n1*2*3*")
        );
    }

    @DisplayName(value = "커스텀 구분자에 매칭되는 문자열이 아니면 CommaAndColonSplitter 를 반환한다.")
    @ParameterizedTest
    @MethodSource("commaAndColonSplitterCase")
    void commaAndColonSplitter(String value) {
        assertThat(splitterSelector.matchedSplitter(value))
                .isInstanceOf(CommaAndColonSplitter.class);
    }

    private static Stream<Arguments> commaAndColonSplitterCase() {
        return Stream.of(
                Arguments.of("3*4"),
                Arguments.of("//1"),
                Arguments.of("\n1"),
                Arguments.of("0"),
                Arguments.of("10011,2,3"),
                Arguments.of("200:22"),
                Arguments.of("1,2:3")
        );
    }
}
