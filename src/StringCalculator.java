
public class StringCalculator {

    public int add(String numbers) {
        if (numbers.isEmpty()) {
            return 0;
        }
        if (numbers.contains(",")) {
            String[] numberList = numbers.split(",");
            int sum = Integer.valueOf(numberList[0]) + Integer.valueOf(numberList[1]);
            return sum;
        }
        return Integer.valueOf(numbers);
    }
}
