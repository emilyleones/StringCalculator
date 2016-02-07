import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class DelimiterParserTest {

    private DelimiterParser delimiterParser;

    @Before
    public void setUp() {
        delimiterParser = new DelimiterParser();
    }

    @Test
    public void shouldReturnNewSingleCharacterDelimiterWhenChangingDelimiter() {
        String input = "//;\n1;2;3";
        String expectedDelimiterString = ";";

        String actualDelimiterString = delimiterParser.parse(input);

        assertThat(actualDelimiterString, is(expectedDelimiterString));
    }

    @Test
    public void shouldReturnNewMultiCharacterDelimiter() {
        String input = "//[&&&]\n1&&&2&&&3";
        String expectedDelimiterString = "\\&&&";

        String actualDelimiterString = delimiterParser.parse(input);

        assertThat(actualDelimiterString, is(expectedDelimiterString));
    }

    @Test
    public void shouldReturnMultipleSingleCharacterDelimiters() {
        String input = "//[*][%]\n1*2%3";
        String expectedDelimiterString = "\\*|\\%";

        String actualDelimiterString = delimiterParser.parse(input);

        assertThat(actualDelimiterString, is(expectedDelimiterString));
    }

    @Test
    public void shouldReturnSumOfNumbersWhenInputNumbersAreSeparatedMultipleMultiCharacterDelimiters() {
        String input = "//[&&][%%%]\n1&&2%%%3";
        String expectedDelimiterString = "\\&&|\\%%%";

        String actualDelimiterString = delimiterParser.parse(input);

        assertThat(actualDelimiterString, is(expectedDelimiterString));
    }
}