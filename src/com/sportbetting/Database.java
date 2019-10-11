package com.sportbetting;

import com.sportbetting.domain.*;

import java.util.ArrayList;
import java.util.List;

public class Database {

    private ArrayList<Bet> bet;
    private ArrayList<Outcome> outcome;
    private ArrayList<OutcomeOdd> outcomeOdd;
    private Player player;
    private ArrayList<Result> result;
    private ArrayList<SportEvent> sportEvent;
    private ArrayList<User> user;
    private ArrayList<Wager> wager;

    public Database() {
        bet = new ArrayList<Bet>();
        outcome = new ArrayList<Outcome>();
        outcomeOdd = new ArrayList<OutcomeOdd>();
        result = new ArrayList<>();
        sportEvent = new ArrayList<SportEvent>();
        user = new ArrayList<User>();
        wager = new ArrayList<Wager>();
    }

    public List<Bet> getBet() {
        return bet;
    }

    public void setBet(Bet bet) {
        this.bet.add(bet);
    }

    public List<Outcome> getOutcome() {
        return outcome;
    }

    public void setOutcome(Outcome outcome) {
        this.outcome.add(outcome);
    }

    public List<OutcomeOdd> getOutcomeOdd() {
        return outcomeOdd;
    }

    public void setOutcomeOdd(OutcomeOdd outcomeOdd) {
        this.outcomeOdd.add(outcomeOdd);
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public List<Result> getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result.add(result);
    }

    public List<SportEvent> getSportEvent() {
        return sportEvent;
    }

    public void setSportEvent(SportEvent sportEvent) {
        this.sportEvent.add(sportEvent);
    }

    public List<User> getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user.add(user);
    }

    public List<Wager> getWager() {
        return wager;
    }

    public void setWager(Wager wager) {
        this.wager.add(wager);
    }

}

