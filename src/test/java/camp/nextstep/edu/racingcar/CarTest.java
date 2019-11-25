package camp.nextstep.edu.racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CarTest {

    private static final String CAR_NAME_LESS_THAN_5 = "name";

    @DisplayName(value = "이름이 5글자가 넘거나 null 이면 IllegalArgumentException 발생")
    @ParameterizedTest
    @NullSource
    @ValueSource(strings = {"car name test"})
    public void failCreateCarTest(String name) {
        assertThrows(IllegalArgumentException.class, () -> {
            new Car(name);
        });
    }

    @DisplayName(value = "이름이 5글자 이하거나 empty string 의 경우 자동차 생성 가능")
    @ParameterizedTest
    @EmptySource
    @ValueSource(strings = {"  ", "name", "55555"})
    public void createCarTest(String name) {
        new Car(name);
    }


    @DisplayName(value = "자동차 위치 설정 메서드 확인")
    @ParameterizedTest
    @ValueSource(ints = {0, 10000})
    public void isInPositionTest(int position) {
        Car car = new Car(CAR_NAME_LESS_THAN_5, position);
        assertTrue(car.isInPosition(position));
    }

}
