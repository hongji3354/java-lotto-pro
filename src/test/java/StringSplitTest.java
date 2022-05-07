import calculator.StringSplit;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class StringSplitTest {

    @ParameterizedTest
    @ValueSource(strings = {"1,2,3", "1:2:3", "1,2:3", "//;\n1;2;3"})
    @DisplayName("쉼표를 가질 수 있다.")
    void 쉼표(String text) {

        // when
        final StringSplit stringSplit = new StringSplit(text);

        // then
        assertThat(stringSplit.split()).contains("1","2","3");
    }
}
