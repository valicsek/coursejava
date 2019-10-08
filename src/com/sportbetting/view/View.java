package com.sportbetting.view;

import com.sportbetting.domain.Player;
import com.sportbetting.domain.SportEvent;
import com.sportbetting.domain.Wager;

import java.math.BigDecimal;
import java.util.List;

public class View implements IView {
    @Override
    public Player readPlayerData() {
        return null;
    }

    @Override
    public void printWelcomeMessage(Player player) {

    }

    @Override
    public void printBalance(Player player) {

    }

    @Override
    public void printOutcomeOdds(List<SportEvent> sportEvents) {

    }

    @Override
    public void selectOutcomeOdd(List<SportEvent> sportEvent) {

    }

    @Override
    public BigDecimal readWagerAmount() {
        return null;
    }

    @Override
    public void printWagerSaved(Wager wager) {

    }

    @Override
    public void printNotEnoughBalance(Player player) {

    }

    @Override
    public void printResults(Player player, List<Wager> wager) {

    }
}
