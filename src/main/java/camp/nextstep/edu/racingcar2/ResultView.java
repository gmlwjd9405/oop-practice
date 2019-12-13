package camp.nextstep.edu.racingcar2;

import java.util.List;

class ResultView {

    private static final String POSITION_MARK = "-";

    static void printResult(final List<Car> cars) {
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
