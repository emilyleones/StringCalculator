
public class StringCalculator {

    public int add(String numbers) {
        if (numbers.isEmpty()) {
            return 0;
        }
        if (usingDifferentDelimiter(numbers)) {
            int delimiterStart = 2;
            int delimiterEnd = numbers.indexOf("\n");
            String delimiter = numbers.substring(delimiterStart, delimiterEnd);
            return sum(numbers.substring(delimiterEnd+"\n".length()), delimiter);
        }
        if (numbers.contains(",") || numbers.contains("\n")) {
            return sum(numbers, ",|\n");
        }
        return Integer.valueOf(numbers);
    }

    private boolean usingDifferentDelimiter(String numbers) {
        return numbers.length() > 1 && numbers.substring(0,2).equals("//");
    }

    private int sum(String numbers, String delimiter) {
        String[] numberList = numbers.split(delimiter);
        int sum = 0;
        for (String number : numberList) {
            if (number.contains("-")) {
                try {
                    throw new Exception("negatives not allowed");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            sum += Integer.valueOf(number);
        }
        return sum;
    }
}
