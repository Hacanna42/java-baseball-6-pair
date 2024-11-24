package baseball.view;

import baseball.dto.ScoreDto;
import java.util.Map;

public class OutputView {
    public static void printWelcomeMessage() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public static void printScores(ScoreDto scoreDto) {
        Map<Score, Integer> scores = scoreDto.scores();
        if (scores.isEmpty()) {
            System.out.print("낫싱");
        }
        if (scores.containsKey(Score.BALL)) {
            System.out.print(scores.get(Score.BALL) + "볼 ");
        }
        if (scores.containsKey(Score.STRIKE)) {
            System.out.print(scores.get(Score.STRIKE) + "스트라이크 ");
        }
        System.out.println();
    }

    public static void printWinMessage() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }
}
