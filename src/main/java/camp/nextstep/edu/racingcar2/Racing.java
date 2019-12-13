package camp.nextstep.edu.racingcar2;

import camp.nextstep.edu.racingcar2.moving.MovingStrategy;
import camp.nextstep.edu.racingcar2.moving.RandomMovingStrategy;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Racing {

    private List<Car> cars;
    private MovingStrategy movingStrategy;

    public static Racing of(final int numOfCar) {
        return new Racing(numOfCar);
    }

    private Racing(final int numOfCar) {
        createCars(numOfCar);
        movingStrategy = new RandomMovingStrategy();
    }

    private void createCars(final int numOfCar) {
        cars = Stream.generate(Car::of)
                .limit(numOfCar)
                .collect(Collectors.toList());
    }

    List<Car> run() {
        cars.forEach(this::moveCar);
        return cars;
    }

    private void moveCar(final Car car) {
        car.move(movingStrategy);
    }
}
