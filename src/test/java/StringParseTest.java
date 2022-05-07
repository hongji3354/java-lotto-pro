import calculator.StringAddCalculator;
import calculator.StringParse;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class StringParseTest {

    @Test
    @DisplayName("음수가 들어올 경우 RuntimeException 예외를 발생시킨다.")
    void 음수_예외() {
        // given
        String str = "-1";

        // when And Then
        assertThatIllegalArgumentException().isThrownBy(() -> StringParse.positiveParse(str));
    }

    @Test
    @DisplayName("숫자 이외의 값이 들어올 경우 RuntimeException 예외를 발생시킨다.")
    void 숫자_아닌_문자_예외() {
        // given
        String str = "가";

        // when And Then
        assertThatIllegalArgumentException().isThrownBy(() -> StringParse.positiveParse(str));
    }
}
