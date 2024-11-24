package baseball.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public static String getNumbers() {
        System.out.print("숫자를 입력해주세요 : ");
        return readUserInput();
    }

    public static boolean askRetry() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String input = readUserInput();
        return input.equals("1");
    }

    private static String readUserInput() {
        return Console.readLine();
    }
}
