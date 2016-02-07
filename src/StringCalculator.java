import java.util.ArrayList;
import java.util.List;

public class StringCalculator {

    public int add(String input) {
        if (input.isEmpty()) {
            return 0;
        }
        return sumOf(input);
    }

    private int sumOf(String input) {
        int sum = 0;
        List<Integer> numbers = parseNumbersFrom(input);
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

    private List<Integer> parseNumbersFrom(String input) {
        String delimiter = ",|\n";
        if (input.startsWith("//")) {
            delimiter = newDelimiter(input);
            input = input.split("\n")[1];
        }
        String[] stringNumbers = input.split(delimiter);
        List<Integer> numbers = new ArrayList<>();
        for (String number : stringNumbers) numbers.add(Integer.valueOf(number));
        return numbers;
    }

    private String newDelimiter(String input) {
        if (input.contains("[")) {
            String[] delimiters = input.split("\\[|\\]");
            return complexDelimiter(delimiters);
        }
        return String.valueOf(input.charAt(2));
    }

    private String complexDelimiter(String[] delimiters) {
        String complexDelimiter = "";
        for (int i = 1; i < delimiters.length-1; i += 2) {
            complexDelimiter += "\\" + delimiters[i] + "|";
        }
        return complexDelimiter.substring(0, complexDelimiter.length()-1);
    }


}
