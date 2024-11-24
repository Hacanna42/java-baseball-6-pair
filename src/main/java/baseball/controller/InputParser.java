package baseball.controller;

import baseball.domain.UserNumbers;
import java.util.ArrayList;
import java.util.List;

public class InputParser {
    public static UserNumbers parseUserNumbers(String input) {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
            int number = parseInt(input.charAt(i));
            numbers.add(number);
        }
        return new UserNumbers(numbers);
    }

    private static int parseInt(char c) {
        try {
            return c - '0';
        } catch (NumberFormatException error) {
            throw new IllegalArgumentException(error);
        }
    }
}
