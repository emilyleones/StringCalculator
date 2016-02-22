import java.util.ArrayList;
import java.util.List;

public class NumberParser {

    private DelimiterParser delimiterParser;

    public NumberParser() {
        delimiterParser = new DelimiterParser();
    }

    public List<Integer> parse(String input) {
        String delimiter = ",|\n";
        if (changingDelimiter(input)) {
            delimiter = delimiterParser.parse(input);
            input = input.split("\n")[1];
        }
        String[] stringNumbers = input.split(delimiter);
        return convertToNumberList(stringNumbers);
    }

    private List<Integer> convertToNumberList(String[] stringNumbers) {
        List<Integer> numbers = new ArrayList<>();
        for (String number : stringNumbers) numbers.add(Integer.valueOf(number));
        return numbers;
    }

    private boolean changingDelimiter(String input) {
        return input.startsWith("//");
    }
}
