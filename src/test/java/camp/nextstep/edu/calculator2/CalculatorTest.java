package camp.nextstep.edu.calculator2;

import camp.nextstep.edu.caculator2.Calculator;
import camp.nextstep.edu.caculator2.Operator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

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
    void isNullOrEmpty(String value) {
        assertThatExceptionOfType(RuntimeException.class)
                .isThrownBy(() -> calculator.calculate(value))
                .withMessageContaining(Calculator.IS_NULL_OR_EMPTY);
    }

    @DisplayName("0을 입력하면 0을 반환")
    @Test
    void zeroValue() {
        assertThat(calculator.calculate("0")).isZero();
    }

    @DisplayName("덧셈 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"2 + 3", "1 + 3 + 1", "5"})
    void plus(String value) {
        assertThat(calculator.calculate(value)).isEqualTo(5);
    }

    @DisplayName("뺄셈 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"3 - 2"})
    void minus(String value) {
        assertThat(calculator.calculate(value)).isEqualTo(1);
    }

    @DisplayName("곱셈 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"2 * 3"})
    void multiply(String value) {
        assertThat(calculator.calculate(value)).isEqualTo(6);
    }

    @DisplayName("나눗셈 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"4 / 2"})
    void divide(String value) {
        assertThat(calculator.calculate(value)).isEqualTo(2);
    }

    @DisplayName("지원하지 않는 연산자 포함 시 예외 처리")
    @ParameterizedTest
    @ValueSource(strings = {"4 ^ 2", "4 5 6"})
    void failureByNotSupportedDOperator(String value) {
        assertThatThrownBy(() -> calculator.calculate(value))
                .isInstanceOf(RuntimeException.class)
                .hasMessageContaining(Operator.NOT_SUPPORTED_OPERATOR);
    }

    @DisplayName("형식에 맞지 않는 문자열의 경우 예외 처리")
    @ParameterizedTest
    @ValueSource(strings = {"* 3 *", "* 4", "* 4 4", "1+2", "+3-2"})
    void failureByNotNumericValue(String value) {
        assertThatThrownBy(() -> calculator.calculate(value))
                .isInstanceOf(RuntimeException.class)
                .hasMessageContaining(Calculator.NOT_SUPPORTED_FORMAT);
    }

    // 3/1 0/3 3/0
    // 3 - 100
    // 범위가 넘어가는 값 출력 시,
    // 4 - 2 *
    // ...
}
