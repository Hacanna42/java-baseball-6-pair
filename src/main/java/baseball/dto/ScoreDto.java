package baseball.dto;

import baseball.view.Score;
import java.util.Map;

public record ScoreDto(Map<Score, Integer> scores) {
}
