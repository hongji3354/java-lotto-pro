package calculator;

public class StringAddCalculator {

    private static final int INPUT_NULL_OR_EMPTY_RETURN_VALUE = 0;
    private static final int TEXT_LENGTH_ONE = 1;
    private StringAddCalculator() {
    }

    public static int splitAndSum(String text) {
        if (isNullOrEmpty(text)) {
            return INPUT_NULL_OR_EMPTY_RETURN_VALUE;
        }

        if (isLengthOne(text)) {
            return Integer.parseInt(text);
        }

        final StringSplit stringSplit = new StringSplit(text);
        final Calculator calculator = new Calculator(stringSplit.split());

        return calculator.sum();
    }

    private static boolean isLengthOne(final String text) {
        return text.length() == TEXT_LENGTH_ONE;
    }

    private static boolean isNullOrEmpty(final String text) {
        return text == null || text.isEmpty();
    }
}
