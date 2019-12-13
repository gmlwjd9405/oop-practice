package camp.nextstep.edu.racingcar2.view;

import camp.nextstep.edu.racingcar2.Car;

import java.util.List;

public class ResultView {

    private static final String POSITION_MARK = "-";

    public static void printResult(final List<Car> cars) {
        System.out.println("**********************");
        for (Car car : cars) {
            printPosition(car);
        }
    }

    private static void printPosition(final Car car) {
        for (int i = 0; i < car.getPosition(); i++) {
            System.out.print(POSITION_MARK);
        }
        System.out.println();
    }
}
