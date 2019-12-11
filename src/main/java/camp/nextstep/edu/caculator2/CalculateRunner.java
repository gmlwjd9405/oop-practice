package camp.nextstep.edu.caculator2;

import camp.nextstep.edu.caculator2.calculator.Calculator;

import java.util.Scanner;

public class CalculateRunner {

    private static final String INPUT_MESSAGE = "계산할 문자열 입력: ";
    private static final String RESULT_MESSAGE = "문자열 계산 결과: ";

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.print(INPUT_MESSAGE);
        String input = scanner.nextLine();

        System.out.println(RESULT_MESSAGE + Calculator.of().run(input));
    }
}
