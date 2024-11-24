package baseball.domain;

import baseball.validator.NumbersValidator;
import java.util.List;

public class UserNumbers {
    private final List<Integer> numbers;

    public UserNumbers(List<Integer> numbers) {
        NumbersValidator.validate(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return List.copyOf(numbers);
    }
}
