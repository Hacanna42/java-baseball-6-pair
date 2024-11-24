package baseball.validator;

import java.util.List;

public class NumbersValidator {
    public static void validate(List<Integer> numbers) {
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
}
