public class DelimiterParser {

    public String parse(String input) {
        if (input.contains("[")) {
            String[] delimiters = input.split("\\[|\\]");
            String complexDelimiter = "";
            for (int i = 1; i < delimiters.length-1; i += 2) {
                complexDelimiter += "\\" + delimiters[i] + "|";
            }
            return complexDelimiter.substring(0, complexDelimiter.length()-1);
        }
        return String.valueOf(input.charAt(2));
    }
}
