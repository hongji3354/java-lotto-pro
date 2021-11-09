package lotto.domain;

import lotto.exception.BonusNumberDuplicateException;

import java.util.*;

public class Lottos {

    private List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public WinningResult winningResult(Lotto winningNumber, LottoNumber bonusNumber) {
        duplicateWinningNumberAndBonusNumberValid(winningNumber, bonusNumber);
        Map<Rank, Integer> winningResult = new EnumMap<>(Rank.class);

        for (Lotto lotto : lottos) {
            WinningNumberMatchResult winningNumberMatchResult = lotto.winningNumberMatch(winningNumber, bonusNumber);
            Rank rank = winningNumberMatchResult.rank();
            winningResultAccumulate(winningResult, rank);
        }
        return new WinningResult(winningResult);
    }

    private void duplicateWinningNumberAndBonusNumberValid(Lotto winningNumber, LottoNumber bonusNumber) {
        List<LottoNumber> winningNumbers = winningNumber.lottoNumbers();
        if (winningNumbers.contains(bonusNumber)) {
            throw new BonusNumberDuplicateException();
        }
    }

    private void winningResultAccumulate(Map<Rank, Integer> winningResult, Rank rank) {
        if (rank.isPrize()) {
            Integer winsNumberCount = winningResult.computeIfAbsent(rank, key -> 0);
            winningResult.put(rank, winsNumberCount + 1);
        }
    }

    public int purchaseNumber() {
        return this.lottos.size();
    }

    public List<Lotto> purchaseList() {
        return new ArrayList<>(this.lottos);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lottos lottos1 = (Lottos) o;
        return Objects.equals(lottos, lottos1.lottos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottos);
    }
}
