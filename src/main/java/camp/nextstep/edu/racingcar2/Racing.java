package camp.nextstep.edu.racingcar2;

import camp.nextstep.edu.racingcar2.moving.MovingStrategy;
import camp.nextstep.edu.racingcar2.moving.RandomMovingStrategy;

import java.util.ArrayList;
import java.util.List;

public class Racing {

    private List<Car> cars = new ArrayList<>();

    public static Racing of() {
        return new Racing();
    }

    void run(int numOfCar, int loopCount) {
        createCars(numOfCar);
        MovingStrategy movingStrategy = new RandomMovingStrategy();

        for (int i = 0; i < loopCount; i++) {
            moveCars(movingStrategy);
            ResultView.printResult(cars);
        }
    }

    private void createCars(final int numOfCar) {
        for (int i = 0; i < numOfCar; i++) {
            cars.add(Car.of());
        }
    }

    private void moveCars(final MovingStrategy movingStrategy) {
        for (Car car : cars) {
            car.move(movingStrategy);
        }
    }
}
