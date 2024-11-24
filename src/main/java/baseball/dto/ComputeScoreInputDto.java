package baseball.dto;

import baseball.domain.AnswerNumbers;
import baseball.domain.UserNumbers;

public record ComputeScoreInputDto(UserNumbers userNumbers, AnswerNumbers answerNumbers) {
}
