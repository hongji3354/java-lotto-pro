package calculator;
public class Calculator {

    private int sum;
    private final String[] tokens;

    public Calculator(final String[] tokens) {
        this.tokens = tokens;
    }

    public int sum() {
        return getSum(tokens);
    }

    private int getSum(final String[] tokens) {
        for (String token : tokens) {
            sum += StringParse.positiveParse(token);
        }
        return sum;
    }
}
