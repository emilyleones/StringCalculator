import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class StringCalculatorTest {
    private StringCalculator calculator;

    @Rule
    public final ExpectedException exception = ExpectedException.none();

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

    @Test
    public void shouldReturnSumOfManyNumbersWhenInputNumbersAreSeparatedByComma() {
        String input = "1,2,3";
        int expectedSum = 6;

        int actualSum = calculator.add(input);

        assertThat(actualSum, is(expectedSum));
    }

    @Test
    public void shouldReturnSumOfNumbersWhenInputNumbersAreSeparatedNewLine() {
        String input = "1\n2";
        int expectedSum = 3;

        int actualSum = calculator.add(input);

        assertThat(actualSum, is(expectedSum));
    }

    @Test
    public void shouldReturnSumOfManyNumbersWhenInputtingNumbersSeparatedByAnyValidDelimiter() {
        String input = "1\n2,3";
        int expectedSum = 6;

        int actualSum = calculator.add(input);

        assertThat(actualSum, is(expectedSum));
    }

    @Test
    public void shouldReturnSumOfManyNumbersWhenInputNumbersAreSeparatedByANewSingleCharacterDelimiter() {
        String input = "//;\n1;2";
        int expectedSum = 3;

        int actualSum = calculator.add(input);

        assertThat(actualSum, is(expectedSum));
    }

    @Test
    public void shouldThrowExceptionWhenNegativeNumberIsInInput() {
        String input = "1,2,-3";

        exception.expect(Exception.class);
        calculator.add(input);
    }

    @Test
    public void shouldThrowExceptionWithMessageAndNegativeNumberWhenNegativeNumberIsInInput() {
        String input = "1,2,-3";

        exception.expectMessage("negatives not allowed [-3]");
        calculator.add(input);
    }

    @Test
    public void shouldThrowExceptionWithMessageAndNegativeNumbersWhenMultipleNegativeNumbersAreInInput() {
        String input = "1,-2,-3";

        exception.expectMessage("negatives not allowed [-2, -3]");
        calculator.add(input);
    }

    @Test
    public void shouldIgnoreNumbersGreaterThan1000WhenAddingInput() {
        String input = "2,1001";
        int expectedSum = 2;

        int actualSum = calculator.add(input);

        assertThat(actualSum, is(expectedSum));
    }

    @Test
    public void shouldReturnSumOfNumbersWhenInputNumbersAreSeparatedByANewMultiCharacterDelimiter() {
        String input = "//[&&&]\n1&&&2&&&3";
        int expectedSum = 6;

        int actualSum = calculator.add(input);

        assertThat(actualSum, is(expectedSum));
    }

    @Test
    public void shouldReturnSumOfNumbersWhenInputNumbersAreSeparatedMultipleSingleCharacterDelimiters() {
        String input = "//[*][%]\n1*2%3";
        int expectedSum = 6;

        int actualSum = calculator.add(input);

        assertThat(actualSum, is(expectedSum));
    }

    @Test
    public void shouldReturnSumOfNumbersWhenInputNumbersAreSeparatedMultipleMultiCharacterDelimiters() {
        String input = "//[&&][%%%]\n1&&2%%%3";
        int expectedSum = 6;

        int actualSum = calculator.add(input);

        assertThat(actualSum, is(expectedSum));
    }
}