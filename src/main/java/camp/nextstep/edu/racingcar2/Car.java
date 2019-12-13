package camp.nextstep.edu.racingcar2;

import camp.nextstep.edu.racingcar2.moving.MovingStrategy;

public class Car {

    static final int DEFAULT_DISTANCE = 0;

    private int position;

    public static Car of() {
        return new Car();
    }

    private Car() {
        this.position = DEFAULT_DISTANCE;
    }

    void move(final MovingStrategy movingStrategy) {
        if (movingStrategy.move()) {
            position++;
        }
    }

    int getPosition() {
        return this.position;
    }
}
