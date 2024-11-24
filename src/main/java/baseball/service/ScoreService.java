package baseball.service;

import baseball.dto.ComputeScoreInputDto;
import baseball.dto.ScoreDto;
import baseball.view.Score;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class ScoreService {

    public ScoreDto computeScore(ComputeScoreInputDto input) {
        List<Integer> userNumbers = input.userNumbers().getNumbers();

        Map<Score, Integer> scores = new HashMap<>();
        for (int i = 0; i < userNumbers.size(); i++) {
            Optional<Score> score = input.answerNumbers().computeScore(i, userNumbers.get(i));
            if (score.isPresent()) {
                scores.putIfAbsent(score.get(), 0);
                scores.put(score.get(), scores.get(score.get()) + 1);
            }
        }
        return new ScoreDto(scores);
    }
}
