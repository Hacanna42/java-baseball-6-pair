package baseball.controller;

import baseball.domain.AnswerNumbers;
import baseball.domain.UserNumbers;
import baseball.dto.ComputeScoreInputDto;
import baseball.dto.ScoreDto;
import baseball.service.ScoreService;
import baseball.view.InputView;
import baseball.view.OutputView;
import baseball.view.Score;

public class GameController {
    private final ScoreService scoreService;

    public GameController(ScoreService scoreService) {
        this.scoreService = scoreService;
    }

    public void run() {
        OutputView.printWelcomeMessage();
        do {
            startGame();
        } while (InputView.askRetry());
    }

    private void startGame() {
        AnswerNumbers answerNumbers = AnswerNumbers.createRandomBallNumbers();

        while (true) {
            UserNumbers userNumbers = getUserNumbers();
            ScoreDto scoreDto = scoreService.computeScore(new ComputeScoreInputDto(userNumbers, answerNumbers));
            OutputView.printScores(scoreDto);

            if (scoreDto.scores().getOrDefault(Score.STRIKE, 0) == 3) {
                OutputView.printWinMessage();
                break;
            }
        }
    }

    private UserNumbers getUserNumbers() {
        String input = InputView.getNumbers();
        return InputParser.parseUserNumbers(input);
    }
}
