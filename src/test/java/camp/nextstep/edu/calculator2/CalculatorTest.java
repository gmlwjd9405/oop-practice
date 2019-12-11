package camp.nextstep.edu.calculator2;

import camp.nextstep.edu.caculator2.calculator.Calculator;
import camp.nextstep.edu.caculator2.exception.ErrorMessage;
import camp.nextstep.edu.caculator2.exception.IllegalInputValueException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;

public class CalculatorTest {

    private Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = Calculator.of();
    }

    @DisplayName("입력 값이 null 이거나 빈 공백 문자일 경우 에러 발생")
    @ParameterizedTest
    @NullAndEmptySource
    void isNullOrEmpty(final String value) {
        assertThatExceptionOfType(RuntimeException.class)
                .isThrownBy(() -> calculator.run(value))
                .withMessageContaining(ErrorMessage.IS_NULL_OR_EMPTY);
    }

    @DisplayName("0을 입력하면 0을 반환")
    @Test
    void zeroValue() {
        assertThat(calculator.run("0")).isZero();
    }

    @DisplayName("덧셈 테스트")
    @ParameterizedTest
    @CsvSource(value = {"2 + 3=5", "1 + 1 + 10000=10002", "0 + 999=999", "1=1"}, delimiter = '=')
    void plus(final String value, final int expected) {
        assertThat(calculator.run(value)).isEqualTo(expected);
    }

    @DisplayName("뺄셈 테스트")
    @ParameterizedTest
    @CsvSource(value = {"3 - 2=1", "10000 - 9999=1", "-100 - -50=-50", "3 - 100=-97"}, delimiter = '=')
    void minus(final String value, final int expected) {
        assertThat(calculator.run(value)).isEqualTo(expected);
    }

    @DisplayName("곱셈 테스트")
    @ParameterizedTest
    @CsvSource(value = {"3 * 2=6", "-1 * 2=-2", "-100 * -50=5000"}, delimiter = '=')
    void times(final String value, final int expected) {
        assertThat(calculator.run(value)).isEqualTo(expected);
    }

    @DisplayName("나눗셈 테스트")
    @ParameterizedTest
    @CsvSource(value = {"4 / 2=2", "40000 / 1=40000", "0 / 20=0"}, delimiter = '=')
    void divide(final String value, final int expected) {
        assertThat(calculator.run(value)).isEqualTo(expected);
    }

    @DisplayName("나눗셈 실패: 분모에 0이 들어간 경우")
    @ParameterizedTest
    @ValueSource(strings = {"1 / 0", "0 / 0", "10 * 7 / 0"})
    void failureDivide(final String value) {
        assertThatThrownBy(() -> calculator.run(value))
                .isInstanceOf(IllegalInputValueException.class)
                .hasMessage(ErrorMessage.ZERO_ON_DENOMIVATOR);
    }

    @DisplayName("지원하지 않는 연산자 포함 시 예외 처리")
    @ParameterizedTest
    @ValueSource(strings = {"4 ^ 2", "4 5 6"})
    void failureByNotSupportedOperator(final String value) {
        assertThatThrownBy(() -> calculator.run(value))
                .isInstanceOf(RuntimeException.class)
                .hasMessageContaining(ErrorMessage.NOT_SUPPORTED_OPERATOR);
    }

    @DisplayName("형식에 맞지 않는 문자열의 경우 예외 처리")
    @ParameterizedTest
    @ValueSource(strings = {"+", "* 3 *", "* 4", "* 4 4", "1+2", "+3-2", "4.5 + 5.5", "4 - 2 *"})
    void failureByNotMatchedFormat(final String value) {
        assertThatThrownBy(() -> calculator.run(value))
                .isInstanceOf(RuntimeException.class)
                .hasMessageContaining(ErrorMessage.NOT_SUPPORTED_FORMAT);
    }

    @DisplayName("기본적인 복합 연산 확인")
    @ParameterizedTest
    @MethodSource("basicCase")
    void success(final String value, final int expected) {
        assertThat(calculator.run(value)).isEqualTo(expected);
    }

    private static Stream<Arguments> basicCase() {
        return Stream.of(
                Arguments.of("30 + 10 / 2", 20),
                Arguments.of("-100 - -50 * 3", -150),
                Arguments.of("-1000 * 2 / 2 + 1000", 0)
        );
    }

    // TODO 계산 범위가 넘어가는 값 출력 시, (Integer.MAX_VALUE + 1 = INTEGER.MIN_VALUE)
}
