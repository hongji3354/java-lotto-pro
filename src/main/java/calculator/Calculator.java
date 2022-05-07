package calculator;
public class Calculator {

    private int sum;
    private final String[] tokens;

    public Calculator(final String[] tokens) {
        this.tokens = tokens;
    }

    public int sum() {
        for (String token : tokens) {
            sum += StringParse.positiveParse(token);
        }
        return sum;
    }
}
