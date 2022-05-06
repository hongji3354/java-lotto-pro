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

        final String[] splitText = text.split("[,|:]");

        int sum = 0;

        for (String str : splitText) {
            sum += Integer.parseInt(str);
        }

        return sum;
    }
}
