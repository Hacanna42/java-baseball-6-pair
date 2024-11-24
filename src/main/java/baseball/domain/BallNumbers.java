package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class BallNumbers {
    private final List<Integer> numbers;

    public BallNumbers(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers == null) {
            throw new IllegalArgumentException();
        }
        if (numbers.stream().anyMatch(number -> !(1 <= number && number <= 9))) {
            throw new IllegalArgumentException();
        }
        if (numbers.size() != numbers.stream().distinct().count()) {
            throw new IllegalArgumentException();
        }
    }

    public static BallNumbers createRandomBallNumbers() {
        List<Integer> numbers = new ArrayList<>();
        while (numbers.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!numbers.contains(randomNumber)) {
                numbers.add(randomNumber);
            }
        }
        return new BallNumbers(numbers);
    }
}
