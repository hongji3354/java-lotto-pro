import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class StringTest {

    @Test
    void splitTest() {
        // given
        String input = "1,2";

        // when
        final String[] inputSplit = input.split(",");

        // then
        assertThat(inputSplit).containsExactly("1", "2");
    }

    @Test
    void splitTestInNoDelimiter() {
        // given
        String input = "1";

        // when
        final String[] inputSplit = input.split(",");

        // then
        assertThat(inputSplit).containsExactly("1");
    }

    @Test
    void substringTest() {
        // given
        String input = "(1,2)";

        // when
        final String inputSubstring = input.substring(1, input.length() - 1);

        // then
        assertThat(inputSubstring).isEqualTo("1,2");
    }

    @Test
    @DisplayName("특정 문자를 가져올 시 문자열 범위를 벗어나면 예외가 발생한다.")
    void charAtStringIndexOutOfBoundsException() {
        // given
        String input = "abc";

        // when and Then
        assertThatThrownBy(() -> input.charAt(4))
                .isInstanceOf(StringIndexOutOfBoundsException.class);
    }
}
