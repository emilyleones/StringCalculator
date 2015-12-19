import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class StringCalculatorTest {

    private StringCalculator calculator;

    @Before
    public void setUp() {
        calculator = new StringCalculator();
    }

    @Test
    public void shouldReturnZeroWhenInputIsEmpty() {
        String input = "";
        int expectedSum = 0;

        int actualSum = calculator.add(input);

        assertThat(actualSum, is(expectedSum));
    }

    @Test
    public void shouldReturnInputNumberWhenOneNumberIsInputted() {
        String input = "1";
        int expectedSum = 1;

        int actualSum = calculator.add(input);

        assertThat(actualSum, is(expectedSum));
    }

    @Test
    public void shouldReturnSumOfTwoNumbersWhenInputtingTwoNumbersSeparatedByComma() {
        String input = "1,2";
        int expectedSum = 3;

        int actualSum = calculator.add(input);

        assertThat(actualSum, is(expectedSum));
    }

}