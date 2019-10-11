package com.sportbetting.view;

import com.sportbetting.domain.OutcomeOdd;
import com.sportbetting.domain.Player;
import com.sportbetting.domain.SportEvent;
import com.sportbetting.domain.Wager;

import java.math.BigDecimal;
import java.util.List;

public interface IView {
    Player readPlayerData() throws Exception;
    void printWelcomeMessage(Player player);
    void printBalance(Player player);
    void printOutcomeOdds(List<SportEvent> sportEvents);
    OutcomeOdd selectOutcomeOdd(List<SportEvent> sportEvent) throws Exception;
    BigDecimal readWagerAmount();
    void printWagerSaved(Wager wager);
    void printNotEnoughBalance(Player player);
    void printResults(Player player, List<Wager> wager);
}
