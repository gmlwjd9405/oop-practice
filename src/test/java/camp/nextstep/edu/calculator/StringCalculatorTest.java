package camp.nextstep.edu.calculator;

import camp.nextstep.edu.calculator.exception.NegativeNumberException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;

public class StringCalculatorTest {

    private StringCalculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new StringCalculator();
    }

    @DisplayName("빈 문자열 또는 null 값을 입력할 경우 0을 반환해야 한다.")
    @ParameterizedTest
    @NullAndEmptySource
    void emptyOrNull(final String text) {
        assertThat(calculator.add(text)).isZero();
    }

    @DisplayName(value = "숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환한다.")
    @ParameterizedTest
    @ValueSource(strings = {"10000", "100", "1"})
    void oneNumber(final String text) {
        assertThat(calculator.add(text)).isEqualTo(Integer.parseInt(text));
    }

    @DisplayName(value = "숫자 두 개를 쉼표(,) 구분자로 입력할 경우 두 숫자의 합을 반환한다.")
    @ParameterizedTest
    @CsvSource(value = {"1,2,3=6", "10,100=110", "0,0=0"}, delimiter = '=')
    void twoNumbers(final String text, final int expected) {
        assertThat(calculator.add(text)).isSameAs(expected);
    }

    @DisplayName("구분자를 쉼표(,) 이외에 콜론(:)을 사용할 수 있다.")
    @ParameterizedTest
    @MethodSource("defaultDelimiterCase")
    void defaultDelimiterSum(final String text, final int expected) {
        assertThat(calculator.add(text)).isEqualTo(expected);
    }

    private static Stream<Arguments> defaultDelimiterCase() {
        return Stream.of(
                Arguments.of("1,2,3", 6),
                Arguments.of("2:3:1000", 1005),
                Arguments.of("100,101:102", 303),
                Arguments.of("1:2,3:4,5", 15)
        );
    }

    @DisplayName(value = "//와 \n 문자 사이에 커스텀 구분자를 지정할 수 있다.")
    @ParameterizedTest
    @MethodSource
    void customDelimiterSum(final String text, final int expected) {
        assertThat(calculator.add(text)).isEqualTo(expected);
    }

    private static Stream<Arguments> customDelimiterSum() {
        return Stream.of(
                // ; : & @ # %   = - ! ] }
                Arguments.of("//;\n0", 0),
                Arguments.of("//;\n10000", 10000),
                Arguments.of("//;\n1;2;3", 6),
                // |
                Arguments.of("//|\n999", 999),
                Arguments.of("//|\n1|2|3", 6),
                // .
                Arguments.of("//.\n1", 1),
                Arguments.of("//.\n10011.2.3", 10016),
                // ^ $
                Arguments.of("//^\n200^22", 222),
                // * + { [ ? ( )
                Arguments.of("//*\n1*2*3*", 6)
        );
    }

    @DisplayName(value = "커스텀 구분자를 사용하는 경우 빈 문자열을 입력하면 NumberFormatException 발생")
    @ParameterizedTest
    @ValueSource(strings = {";", "-", "^", "*", "|", "."})
    void emptyStringWhenCustomDelimiter(String customDelimiter) {
        assertThatExceptionOfType(NumberFormatException.class)
                .isThrownBy(() -> calculator.add("//" + customDelimiter + "\n"));
    }

    @DisplayName(value = "문자열 계산기에 음수를 전달하는 경우 NegativeNumberException 발생")
    @Test
    void negative() {
        assertThatThrownBy(() -> calculator.add("-1"))
                .isInstanceOf(NegativeNumberException.class)
                .hasMessageContaining("음수는 허용하지 않습니다.");
    }

    @DisplayName(value = "문자열 계산기에 숫자가 아닌 문자를 전달하는 경우 NumberFormatException 발생")
    @ParameterizedTest
    @ValueSource(strings = {"//\\;\n1;a;3", "b", "*", "1:c,2", "1,^"})
    void notNumeric(String text) {
        assertThatExceptionOfType(NumberFormatException.class)
                .isThrownBy(() -> calculator.add(text));
    }
}
