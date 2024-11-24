package baseball.service;

import baseball.domain.AnswerNumbers;
import baseball.domain.UserNumbers;
import baseball.dto.ComputeScoreInputDto;
import baseball.dto.ScoreDto;
import baseball.view.Score;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class ScoreServiceTest {

    @Test
    void 점수_계산_테스트() {
        // given
        ScoreService service = new ScoreService();
        AnswerNumbers answerNumbers = new AnswerNumbers(List.of(1, 4, 9));
        UserNumbers userNumbers = new UserNumbers(List.of(1, 3, 4));

        // when
        ScoreDto scoreDto = service.computeScore(new ComputeScoreInputDto(userNumbers, answerNumbers));

        // then
        Assertions.assertThat(scoreDto.scores().get(Score.STRIKE)).isEqualTo(1);
        Assertions.assertThat(scoreDto.scores().get(Score.BALL)).isEqualTo(1);
    }
}