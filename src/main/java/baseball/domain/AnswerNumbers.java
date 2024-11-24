package baseball.domain;

import baseball.validator.NumbersValidator;
import baseball.view.Score;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AnswerNumbers {
    private final List<Integer> numbers;

    public AnswerNumbers(List<Integer> numbers) {
        NumbersValidator.validate(numbers);
        this.numbers = numbers;
    }

    public Optional<Score> computeScore(int index, int number) {
        if (!(index >= 0 && index < numbers.size())) {
            throw new IllegalArgumentException();
        }
        if (numbers.get(index) == number) {
            return Optional.of(Score.STRIKE);
        }
        if (numbers.contains(number)) {
            return Optional.of(Score.BALL);
        }

        return Optional.empty();
    }

    public static AnswerNumbers createRandomBallNumbers() {
        List<Integer> numbers = new ArrayList<>();
        while (numbers.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!numbers.contains(randomNumber)) {
                numbers.add(randomNumber);
            }
        }
        return new AnswerNumbers(numbers);
    }
}
