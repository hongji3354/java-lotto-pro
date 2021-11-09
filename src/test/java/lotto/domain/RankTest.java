package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class RankTest {

    @DisplayName("당첨번호와 로또번호가 3~6개 사이 일치 일 시 당첨")
    @ParameterizedTest
    @CsvSource(value = {"0:false:true", "0:false:false", "1:false:false", "2:false:false", "3:true:false", "4:true:false", "5:true:false", "6:true:false", "7:false:false"}, delimiter = ':')
    void prizeTest(int winningNumberSameCount, boolean expectedPrize, boolean expectedBonus) {
        Rank rank = Rank.of(winningNumberSameCount, expectedBonus);
        boolean prize = rank.isPrize();
        assertThat(prize).isEqualTo(expectedPrize);
    }

    @DisplayName("번호 일치 개수 별 등수")
    @ParameterizedTest
    @MethodSource("rankParametersProvider")
    void rankTest(int winningNumberSameCount, Rank rank, boolean isBonus) {
        assertThat(Rank.of(winningNumberSameCount, isBonus)).isEqualTo(rank);
    }

    static Stream<Arguments> rankParametersProvider() {
        return Stream.of(
                arguments(3, Rank.FOURTH_PLACE, false),
                arguments(4, Rank.THIRD_PLACE, false),
                arguments(5, Rank.SECOND_PLACE, false),
                arguments(5, Rank.BONUS_SECOND_PLACE, true),
                arguments(6, Rank.FIRST_PLACE, false)
        );
    }
}
