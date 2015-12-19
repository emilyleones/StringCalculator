import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class StringCalculatorTest {

    @Test
    public void shouldReturnZeroWhenInputIsEmpty() {
        StringCalculator calculator = new StringCalculator();
        String input = "";
        int expectedSum = 0;

        int actualSum = calculator.add(input);

        assertThat(actualSum, is(expectedSum));
    }

    @Test
    public void shouldReturnInputNumberWhenOneNumberIsInputted() {
        StringCalculator calculator = new StringCalculator();
        String input = "1";
        int expectedSum = 1;

        int actualSum = calculator.add(input);

        assertThat(actualSum, is(expectedSum));
    }

}