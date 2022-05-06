import calculator.StringAddCalculator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThat;

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

}
