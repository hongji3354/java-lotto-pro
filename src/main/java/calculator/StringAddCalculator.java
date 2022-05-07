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
                try {
                    sum += Integer.parseInt(token);
                }catch (NumberFormatException e) {
                    throw new IllegalArgumentException("숫자만 가능합니다. 입력한 문자는 : " + text + "입니다.", e);
                }
            }
            return sum;
        }


        final String[] splitText = text.split("[,|:]");

        int sum = 0;

        for (String str : splitText) {
            try {
                sum += Integer.parseInt(str);
            }catch (NumberFormatException e) {
                throw new IllegalArgumentException("숫자만 가능합니다. 입력한 문자는 : " + text + "입니다.", e);
            }
        }

        return sum;
    }
}
