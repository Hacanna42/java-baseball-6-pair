package baseball;

import baseball.controller.GameController;
import baseball.service.ScoreService;

public class Application {
    public static void main(String[] args) {
        ScoreService scoreService = new ScoreService();
        GameController controller = new GameController(scoreService);

        controller.run();
    }
}
