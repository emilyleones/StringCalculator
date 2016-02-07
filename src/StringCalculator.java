import java.util.ArrayList;
import java.util.List;

public class StringCalculator {

    private NumberParser numberParser;

    public StringCalculator() {
        numberParser = new NumberParser();
    }

    public int add(String input) {
        if (input.isEmpty()) {
            return 0;
        }
        return sumOf(input);
    }

    private int sumOf(String input) {
        int sum = 0;
        List<Integer> numbers = numberParser.parse(input);
        List<Integer> negatives = new ArrayList<>();
        for (int number : numbers) {
            if (isNegative(number)) {
                negatives.add(number);
            } else if (number <= 1000) {
                sum += number;
            }
        }
        checkForException(negatives);
        return sum;
    }

    private void checkForException(List<Integer> negatives) {
        if (inputContainsNegativeNumbers(negatives)) {
            throw new IllegalArgumentException("negatives not allowed " + negatives);
        }
    }

    private boolean inputContainsNegativeNumbers(List<Integer> negatives) {
        return negatives.size() > 0;
    }

    private boolean isNegative(int number) {
        return number < 0;
    }
}
