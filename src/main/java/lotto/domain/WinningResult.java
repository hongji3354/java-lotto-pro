package lotto.domain;

import java.util.Map;
import java.util.Set;

public class WinningResult {

    private Map<Rank, Integer> result;

    public WinningResult(Map<Rank, Integer> result) {
        this.result = result;
    }

    public int winnerPerRank(Rank winningRank) {
        Integer winnerPerRank = result.get(winningRank);
        if (winnerPerRank == null) {
            return 0;
        }
        return winnerPerRank;
    }

    //TODO 질문3
    protected double profitRate(int purchaseAmount, int profitAmount) {
        return profitAmount / (double) purchaseAmount;
    }

    //TODO 질문3
    public double profitRate(int purchaseAmount) {
        return profitAmount() / (double) purchaseAmount;
    }

    public long profitAmount() {
        Set<Map.Entry<Rank, Integer>> resultEntrySet = this.result.entrySet();
        long profitAmount = 0L;

        for (Map.Entry<Rank, Integer> winningRanks : resultEntrySet) {
            Rank key = winningRanks.getKey();
            Integer winningCount = winningRanks.getValue();

            profitAmount += key.prizeMoneyCalculation(winningCount);
        }

        return profitAmount;
    }
}