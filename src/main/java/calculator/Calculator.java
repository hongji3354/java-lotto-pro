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
        final Integer parse = StringParse.positiveParse(token);
        sum += parse;

        return sum;
    }
}
