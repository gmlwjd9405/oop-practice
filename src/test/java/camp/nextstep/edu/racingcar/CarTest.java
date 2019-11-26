package camp.nextstep.edu.racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CarTest {

    private static final String ANY_POSSIBLE_NAME = "name";

    @NullSource
    @ValueSource(strings = {"car name test"})
    @ParameterizedTest
    @DisplayName(value = "이름이 5글자가 넘거나 null 이면 IllegalArgumentException 발생")
    void createCarFailure(String name) {
        // sol1.
        assertThrows(IllegalArgumentException.class, () -> {
            new Car(name);
        });

        // sol2.
        assertThatThrownBy(() -> new Car(name)).isInstanceOf(IllegalArgumentException.class);

        // sol3.
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> new Car(name));

        // sol4.
        assertThatIllegalArgumentException().isThrownBy(() -> new Car(name, Car.DEFAULT_POSITION));
    }

    @EmptySource
    @ValueSource(strings = {"  ", "name", "55555"})
    @ParameterizedTest
    @DisplayName(value = "이름이 5글자 이하 (empty string 포함)의 경우 자동차 생성 가능")
    void createCarSuccess(String name) {
        // sol1.
        new Car(name);

        // sol2.
        assertThatCode(() -> new Car(name)).doesNotThrowAnyException();
    }


    @DisplayName(value = "자동차 위치 설정 메서드 확인")
    @ParameterizedTest
    @ValueSource(ints = {Integer.MIN_VALUE, -1, 0, 1, Integer.MAX_VALUE})
    void isInPositionTest(int position) {
        Car car = new Car(ANY_POSSIBLE_NAME, position);
        assertTrue(car.isInPosition(position));
    }

    @Test
    @DisplayName(value = "자동차가 전략에 따라 +1 만큼 움직였는지 확인")
    void move() {
        Car car = new Car(ANY_POSSIBLE_NAME, Car.DEFAULT_POSITION);
        car.move(new TestMovingStrategy()); // car.move(() -> true); 동일한 결과
        assertThat(car.isInPosition(Car.DEFAULT_POSITION + 1)).isTrue();
    }

    // 가짜 객체 - 어떤 클래스를 테스트할 때 그 클래스의 협업 클래스를 모방하는 객체
    class TestMovingStrategy implements MovingStrategy {
        @Override
        public boolean movable() {
            return true;
        }
    }}
