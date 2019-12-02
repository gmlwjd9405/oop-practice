package camp.nextstep.edu.calculator.number;

import camp.nextstep.edu.calculator.exception.NegativeNumberException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;

public class NumberTest {

    @DisplayName("NumberTest 생성")
    @ParameterizedTest
    @ValueSource(strings = {"0", "10", "1000"})
    void create(final String number) {
        assertThatCode(() -> Number.of(number))
                .doesNotThrowAnyException();
    }

    @DisplayName("NumberTest 생성 실패: 음수 - NegativeNumberException")
    @ParameterizedTest
    @ValueSource(strings = "-1")
    void createFailureByNegativeNumber(final String number) {
        assertThatExceptionOfType(NegativeNumberException.class)
                .isThrownBy(() -> Number.of(number));
    }

    @DisplayName("NumberTest 생성 실패: 숫자 이외의 값, null, empty - NumberFormatException")
    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = "숫자 이외의 값")
    void createFailureByNotNumberFormat(final String number) {
        assertThatExceptionOfType(NumberFormatException.class)
                .isThrownBy(() -> Number.of(number));
    }

    @DisplayName("Number 의 value 값 반환")
    @ParameterizedTest
    @ValueSource(strings = {"0", "10", "1000"})
    void toInt(String number) {
        assertThat(Number.of(number).toInt())
                .isEqualTo(Integer.parseInt(number));
    }

    @DisplayName("합산 후의 value 값을 가진 Number 반환")
    @ParameterizedTest
    @MethodSource("plusCase")
    void plus(String text, Number expected) {
        assertThat(Number.of(text).plus(Number.of("1")))
                .isEqualTo(expected);
    }

    private static Stream<Arguments> plusCase() {
        return Stream.of(
                Arguments.of("0", Number.of("1")),
                Arguments.of("1", Number.of("2")),
                Arguments.of("100", Number.of("101"))
        );
    }
}
