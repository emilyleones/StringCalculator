
public class StringCalculator {

    public int add(String numbers) {
        if (numbers.isEmpty()) {
            return 0;
        }
        if (numbers.contains(",")) {
            return sum(numbers);
        }
        return Integer.valueOf(numbers);
    }

    private int sum(String numbers) {
        String[] numberList = numbers.split(",|\n");
        int sum = 0;
        for (String number : numberList) {
            sum += Integer.valueOf(number);
        }
        return sum;
    }
}
