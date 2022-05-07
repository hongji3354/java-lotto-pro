package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringSplit {

    private final String str;

    public StringSplit(final String str) {
        this.str = str;
    }

    public String[] split() {
        final Pattern pattern = Pattern.compile("//(.)\n(.*)");
        final Matcher matcher = pattern.matcher(str);

        if (matcher.find()) {
            String customDelimiter = matcher.group(1);
            return matcher.group(2).split(customDelimiter);
        }

        return str.split("[,|:]");
    }
}
