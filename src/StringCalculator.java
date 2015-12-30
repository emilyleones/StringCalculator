
public class StringCalculator {

    public int add(String numbers) {
        if (numbers.isEmpty()) {
            return 0;
        }
        if (numbers.length() > 1 && numbers.substring(0,2).equals("//")) {
            String delimiter = numbers.substring(2, numbers.indexOf("\n"));
            return sum(numbers.substring(numbers.indexOf("\n")+"\n".length()));
        }
        if (numbers.contains(",") || numbers.contains("\n")) {
            return sum(numbers);
        }
        return Integer.valueOf(numbers);
    }

    private int sum(String numbers) {
        String[] numberList = numbers.split(",|\n|;");
        int sum = 0;
        for (String number : numberList) {
            sum += Integer.valueOf(number);
        }
        return sum;
    }
}
