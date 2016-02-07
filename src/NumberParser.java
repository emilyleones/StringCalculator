import java.util.ArrayList;
import java.util.List;

public class NumberParser {

    private DelimiterParser delimiterParser;

    public NumberParser() {
        delimiterParser = new DelimiterParser();
    }

    public List<Integer> parse(String input) {
        String delimiter = ",|\n";
        if (changingDelimiterFrom(input)) {
            delimiter = delimiterParser.parse(input);
            input = input.split("\n")[1];
        }
        String[] stringNumbers = input.split(delimiter);
        return convertedListOf(stringNumbers);
    }

    private List<Integer> convertedListOf(String[] stringNumbers) {
        List<Integer> numbers = new ArrayList<>();
        for (String number : stringNumbers) numbers.add(Integer.valueOf(number));
        return numbers;
    }

    private boolean changingDelimiterFrom(String input) {
        return input.startsWith("//");
    }
}
