import calculator.StringAddCalculator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class StringAddCalculatorTest {

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("null 또는 빈 문자열은 0을 반환한다")
    void splitAndSum_null_또는_empty(String text) {
        // when
        int sum = StringAddCalculator.splitAndSum(text);

        // then
        assertThat(sum).isZero();
    }

    @Test
    @DisplayName("숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환한다")
    void splitAndSum_숫자하나() {
        // given
        String text = "1";

        // when
        int sum = StringAddCalculator.splitAndSum(text);

        // then
        assertThat(sum).isEqualTo(1);
    }


    @Test
    @DisplayName("쉼표를 구분자로 가지는 문자열을 전달할 경우 쉼표를 기준으로 분리한 각 숫자의 합을 반환한다.")
    void splitAndSum_쉼표() {
        // given
        String text = "1,2";

        // when
        int sum = StringAddCalculator.splitAndSum(text);

        // then
        assertThat(sum).isEqualTo(3);
    }

    @Test
    @DisplayName("콜론을 구분자로 가지는 문자열을 전달할 경우 콜론을 기준으로 분리한 각 숫자의 합을 반환한다.")
    void splitAndSum_콜론() {
        // given
        String text = "1,2";

        // when
        int sum = StringAddCalculator.splitAndSum(text);

        // then
        assertThat(sum).isEqualTo(3);
    }

    @Test
    @DisplayName("쉼표 또는 콜론을 구분자로 가지는 문자열을 전달할 경우 콜론을 기준으로 분리한 각 숫자의 합을 반환한다.")
    void splitAndSum_쉼표_또는_콜론() {
        // given
        String text = "1,2:3";

        // when
        int sum = StringAddCalculator.splitAndSum(text);

        // then
        assertThat(sum).isEqualTo(6);
    }

    @Test
    @DisplayName("커스텀 구분자를 가질 수 있다")
    void splitAndSum_커스텀_구분자() {
        // given
        String text = "//;\n1;2;3";

        // when
        int sum = StringAddCalculator.splitAndSum(text);

        // then
        assertThat(sum).isEqualTo(6);
    }

    @Test
    @DisplayName("숫자 이외의 값이 들어올 경우 RuntimeException 예외를 발생시킨다.")
    void splitAndSum_숫자_아닌_문자_예외() {
        // given
        String text = "1,2:가";

        // when and then
        assertThatIllegalArgumentException().isThrownBy(() -> StringAddCalculator.splitAndSum(text));
    }

    @Test
    @DisplayName("음수가 들어올 경우 RuntimeException 예외를 발생시킨다.")
    void splitAndSum_음수_예외() {
        // given
        String text = "1,2:-3";

        // when
        assertThatIllegalArgumentException().isThrownBy(() -> StringAddCalculator.splitAndSum(text));
    }
}
