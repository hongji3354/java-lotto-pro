package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringSplit {

    private static final Pattern pattern = Pattern.compile("//(.)\n(.*)");
    private static final int CUSTOM_DELIMITER_INDEX = 1;
    private static final int CUSTOM_DELIMITER_TEXT_INDEX = 2;
    private final String token;

    public StringSplit(final String token) {
        this.token = token;
    }

    public String[] split() {
        final Matcher matcher = pattern.matcher(token);

        if (matcher.find()) {
            String customDelimiter = matcher.group(CUSTOM_DELIMITER_INDEX);
            return matcher.group(CUSTOM_DELIMITER_TEXT_INDEX).split(customDelimiter);
        }

        return token.split("[,|:]");
    }
}
