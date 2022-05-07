package calculator;

public class StringParse {

    private StringParse() {
    }

    public static Integer positiveParse(String str) {
        try {
            final int parseInt = Integer.parseInt(str);
            checkNumberNegative(str, parseInt);
            return parseInt;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자만 가능합니다. 입력한 문자는 : " + str + "입니다.", e);
        }
    }

    private static void checkNumberNegative(final String text, final int i) {
        if (i < 0) {
            throw new IllegalArgumentException("양수만 가능합니다. 입력한 숫자는 : " + text + "입니다.");
        }
    }
}
