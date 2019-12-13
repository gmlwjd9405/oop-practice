package camp.nextstep.edu.racingcar2;

import java.util.Scanner;

public class InputView {

    private static final String NUM_OF_CAR_MESSAGE = "자동차 대수는 몇 대 인가요?";
    private static final String LOOP_COUNT = "시도할 횟수는 몇 회 인가요?";

    private static final Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println(NUM_OF_CAR_MESSAGE);
        int numOfCar = SCANNER.nextInt();
        System.out.println(LOOP_COUNT);
        int loopCount = SCANNER.nextInt();

        Racing.of().run(numOfCar, loopCount);
    }
}
