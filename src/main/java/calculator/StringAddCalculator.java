package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    private StringAddCalculator() {
    }

    public static int splitAndSum(String text) {
        if (text == null || text.isEmpty()) {
            return 0;
        }

        if (text.length() == 1) {
            return Integer.parseInt(text);
        }

        final Pattern pattern = Pattern.compile("//(.)\n(.*)");
        final Matcher matcher = pattern.matcher(text);

        if (matcher.find()) {
            String customDelimiter = matcher.group(1);
            String[] tokens= matcher.group(2).split(customDelimiter);
            int sum = 0;

            for (String token : tokens) {
                sum += Integer.parseInt(token);
            }
            return sum;
        }


        final String[] splitText = text.split("[,|:]");

        int sum = 0;

        for (String str : splitText) {
            sum += Integer.parseInt(str);
        }

        return sum;
    }
}
