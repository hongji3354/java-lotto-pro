package calculator;

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

        final StringSplit stringSplit = new StringSplit(text);
        final Calculator calculator = new Calculator(stringSplit.split());

        return calculator.sum();
    }
}
