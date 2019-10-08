package com.app;

import com.sportbetting.domain.Player;
import com.sportbetting.domain.SportEvent;
import com.sportbetting.domain.Wager;

import java.math.BigDecimal;
import java.util.List;

public interface View {
    Player readPlayerData();
    void printWelcomeMessage(Player player);
    void printBalance(Player player);
    void printOutcomeOdds(List<SportEvent> sportEvents);
    void selectOutcomeOdd(List<SportEvent> sportEvent);
    BigDecimal readWagerAmount();
    void printWagerSaved(Wager wager);
    void printNotEnoughBalance(Player player);
    void printResults(Player player, List<Wager> wager);
}
