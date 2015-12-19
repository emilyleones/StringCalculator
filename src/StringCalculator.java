
public class StringCalculator {

    public int add(String numbers) {
        if (numbers.isEmpty()) {
            return 0;
        }
        if (numbers.contains(",")) {
            String[] numberList = numbers.split(",");
            int sum = 0;
            for (String number : numberList) {
                sum += Integer.valueOf(number);
            }
            return sum;
        }
        return Integer.valueOf(numbers);
    }
}
