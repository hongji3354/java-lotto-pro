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
        final String[] split = stringSplit.split();

        int sum = 0;

        sum = getSum(text, split, sum);

        return sum;
    }

    private static int getSum(final String text, final String[] tokens, int sum) {
        for (String token : tokens) {
            sum = getSum(text, sum, token);
        }
        return sum;
    }

    private static int getSum(final String text, int sum, final String token) {
        try {
            final int i = Integer.parseInt(token);
            checkNumberNegetive(text, i);
            sum += i;
        }catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자만 가능합니다. 입력한 문자는 : " + text + "입니다.", e);
        }
        return sum;
    }

    private static void checkNumberNegetive(final String text, final int i) {
        if (i < 0) {
            throw new IllegalArgumentException("양수만 가능합니다. 입력한 숫자는 : " + text + "입니다.");
        }
    }
}
