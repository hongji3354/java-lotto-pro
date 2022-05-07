package calculator;
public class Calculator {

    private int sum;
    private final String[] split;

    public Calculator(final String[] split) {
        this.split = split;
    }

    public int sum() {
        return getSum(split);
    }

    private int getSum(final String[] tokens) {
        for (String token : tokens) {
            sum = getSum(token);
        }
        return sum;
    }

    private int getSum(final String token) {
        try {
            final int i = Integer.parseInt(token);
            checkNumberNegative(token, i);
            sum += i;
        }catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자만 가능합니다. 입력한 문자는 : " + token + "입니다.", e);
        }
        return sum;
    }

    private void checkNumberNegative(final String text, final int i) {
        if (i < 0) {
            throw new IllegalArgumentException("양수만 가능합니다. 입력한 숫자는 : " + text + "입니다.");
        }
    }
}
