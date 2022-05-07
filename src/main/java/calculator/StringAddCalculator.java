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
                    final int i = Integer.parseInt(token);
                    if (i<0) {
                        throw new IllegalArgumentException("양수만 가능합니다. 입력한 숫자는 : " + text + "입니다.");
                    }
                    sum += i;
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
                final int i = Integer.parseInt(str);
                if (i<0) {
                    throw new IllegalArgumentException("양수만 가능합니다. 입력한 숫자는 : " + text + "입니다.");
                }
                sum += i;
            }catch (NumberFormatException e) {
                throw new IllegalArgumentException("숫자만 가능합니다. 입력한 문자는 : " + text + "입니다.", e);
            }
        }

        return sum;
    }
}
