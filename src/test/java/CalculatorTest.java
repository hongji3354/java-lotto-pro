import calculator.Calculator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CalculatorTest {

    @Test
    @DisplayName("숫자의 합을 계산한다.")
    void sumTest() {
        // given
        String[] tokens = {"1","2","3"};

        // when
        final Calculator calculator = new Calculator(tokens);

        // then
        assertThat(calculator.sum()).isEqualTo(6);
    }
}
