package camp.nextstep.edu.racingcar2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

public class RacingTest {

    @DisplayName("게임에 필요한 Car 를 생성자의 인자로 받아 생성한다.")
    @ParameterizedTest
    @ValueSource(ints = {0, 1, 10000})
    void create(final int value) {
        assertThatCode(() -> Racing.of(value)).doesNotThrowAnyException();
    }

    @DisplayName("게임을 한 번 수행할 때마다 만들어진 Car 는 움직이거나 정지한다.")
    @Test
    void move() {
        assertThat(Racing.of(3).run()
                .stream()
                .map(Car::getPosition)).contains(Car.DEFAULT_DISTANCE, Car.DEFAULT_DISTANCE + 1);
    }
}
