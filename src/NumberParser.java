import java.util.ArrayList;
import java.util.List;

public class NumberParser {

    public List<Integer> parse(String input) {
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
