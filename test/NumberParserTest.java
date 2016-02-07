import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class NumberParserTest {

    private NumberParser numberParser;
    private List<Integer> expectedNumbers;

    @Before
    public void setUp() {
        numberParser = new NumberParser();
    }

    @Test
    public void shouldReturnNumberInputtedWhenInputContainsOneNumber() {
        String input = "1";
        expectedNumbers = Arrays.asList(1);

        List<Integer> actualNumbers = numberParser.parse(input);

        assertThat(actualNumbers, is(expectedNumbers));
    }

    @Test
    public void shouldReturnTwoNumbersWhenInputtingTwoNumbersSeparatedByComma() {
        String input = "1,2";
        expectedNumbers = Arrays.asList(1, 2);

        List<Integer> actualNumbers = numberParser.parse(input);

        assertThat(actualNumbers, is(expectedNumbers));
    }

    @Test
    public void shouldReturnAllNumbersSeparatedByComma() {
        String input = "1,2,3";
        expectedNumbers = Arrays.asList(1, 2, 3);

        List<Integer> actualNumbers = numberParser.parse(input);

        assertThat(actualNumbers, is(expectedNumbers));
    }

    @Test
    public void shouldReturnAllNumbersSeparatedNewLine() {
        String input = "1\n2\n3";
        expectedNumbers = Arrays.asList(1, 2, 3);

        List<Integer> actualNumbers = numberParser.parse(input);

        assertThat(actualNumbers, is(expectedNumbers));
    }

    @Test
    public void shouldReturnAllNumbersSeparatedByAnyValidDelimiter() {
        String input = "1\n2,3";
        expectedNumbers = Arrays.asList(1, 2, 3);

        List<Integer> actualNumbers = numberParser.parse(input);

        assertThat(actualNumbers, is(expectedNumbers));
    }

    @Test
    public void shouldReturnAllNumbersSeparatedByANewSingleCharacterDelimiter() {
        String input = "//;\n1;2;3";
        expectedNumbers = Arrays.asList(1, 2, 3);

        List<Integer> actualNumbers = numberParser.parse(input);

        assertThat(actualNumbers, is(expectedNumbers));
    }

    @Test
    public void shouldReturnSumOfNumbersWhenInputNumbersAreSeparatedByANewMultiCharacterDelimiter() {
        String input = "//[&&&]\n1&&&2&&&3";
        expectedNumbers = Arrays.asList(1, 2, 3);

        List<Integer> actualNumbers = numberParser.parse(input);

        assertThat(actualNumbers, is(expectedNumbers));
    }

    @Test
    public void shouldReturnSumOfNumbersWhenInputNumbersAreSeparatedMultipleSingleCharacterDelimiters() {
        String input = "//[*][%]\n1*2%3";
        expectedNumbers = Arrays.asList(1, 2, 3);

        List<Integer> actualNumbers = numberParser.parse(input);

        assertThat(actualNumbers, is(expectedNumbers));
    }

    @Test
    public void shouldReturnSumOfNumbersWhenInputNumbersAreSeparatedMultipleMultiCharacterDelimiters() {
        String input = "//[&&][%%%]\n1&&2%%%3";
        expectedNumbers = Arrays.asList(1, 2, 3);

        List<Integer> actualNumbers = numberParser.parse(input);

        assertThat(actualNumbers, is(expectedNumbers));
    }


}