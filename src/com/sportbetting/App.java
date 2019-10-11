package com.sportbetting;

import com.sportbetting.domain.*;
import com.sportbetting.service.ISportsBettingService;
import com.sportbetting.view.IView;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class App {

    private Database database;
    private IView view;
    private ISportsBettingService sportBettingService;

    public App(ISportsBettingService sportsBettingService, IView view) {
        this.view = view;
        this.sportBettingService = sportsBettingService;
    }

    public void play() throws Exception {
        this.createPlayer();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String validFrom = "2000-01-01 12:00:00";
        LocalDateTime validFromDate = LocalDateTime.parse(validFrom, formatter);
        String validTo = "2020-01-01 12:00:00";
        LocalDateTime validToDate = LocalDateTime.parse(validTo, formatter);
        List<OutcomeOdd> outcomeOdd = new ArrayList<OutcomeOdd>();
        outcomeOdd.add(
                new OutcomeOdd.Builder()
                        .setValue(new BigDecimal(4))
                        .setValidFrom(validFromDate)
                        .setValidUntil(validToDate)
                        .build()
        );

        List<OutcomeOdd> outcomeOdd2 = new ArrayList<OutcomeOdd>();
        outcomeOdd2.add(
                new OutcomeOdd.Builder()
                        .setValue(new BigDecimal(2))
                        .setValidFrom(validFromDate)
                        .setValidUntil(validToDate)
                        .build()
        );

        List<OutcomeOdd> outcomeOdd3 = new ArrayList<OutcomeOdd>();
        outcomeOdd3.add(
                new OutcomeOdd.Builder()
                        .setValue(new BigDecimal(5))
                        .setValidFrom(validFromDate)
                        .setValidUntil(validToDate)
                        .build()
        );

        List<OutcomeOdd> outcomeOdd4 = new ArrayList<OutcomeOdd>();
        outcomeOdd4.add(
                new OutcomeOdd.Builder()
                        .setValue(new BigDecimal(3))
                        .setValidFrom(validFromDate)
                        .setValidUntil(validToDate)
                        .build()
        );

        List<Outcome> outcome = new ArrayList<Outcome>();
        outcome.add(
                new Outcome.Builder()
                        .setDescription("1")
                        .setOutcomesOdds(outcomeOdd)
                        .build()
        );

        List<Outcome> outcome2 = new ArrayList<Outcome>();
        outcome2.add(
                new Outcome.Builder()
                        .setDescription("4")
                        .setOutcomesOdds(outcomeOdd)
                        .build()
        );

        List<Outcome> outcome3 = new ArrayList<Outcome>();
        outcome3.add(
                new Outcome.Builder()
                        .setDescription("Arsenal")
                        .setOutcomesOdds(outcomeOdd)
                        .build()
        );

        List<Bet> bets = new ArrayList<Bet>();
        bets.add(
                new Bet.Builder()
                        .setDescription("player Oliver Giroud score")
                        .setBetType(EBetType.PLAYERS_SCORE)
                        .setOutcomes(outcome)
                        .build()
        );

        bets.add(
                new Bet.Builder()
                        .setDescription("Number of scored goals")
                        .setBetType(EBetType.GOALS)
                        .setOutcomes(outcome2)
                        .build()
        );

        bets.add(
                new Bet.Builder()
                        .setDescription("winner")
                        .setBetType(EBetType.WINNER)
                        .setOutcomes(outcome3)
                        .build()
        );

        String fromDate = "2020-01-01 12:00:00";

        LocalDateTime dateTime = LocalDateTime.parse(fromDate, formatter);

        FootballSportEvent footballEvent = (FootballSportEvent) new SportEvent.Builder()
                .setTitle("Arsenal vs Chelsea")
                .setStartDate(dateTime)
                .setBets(bets)
                .build();

        this.database.setSportEvent(footballEvent);
        this.createPlayer();

        Boolean tryAgain = true;

        while (tryAgain) {
            try {
                this.doBetting();
            } catch (Exception ex) {
                tryAgain = false;
            }
        }
        this.calculateResults();
        this.printResults();
    }

    private void createPlayer() throws Exception {
        Player player = view.readPlayerData();
        // Show welcome message
        view.printWelcomeMessage(player);
        sportBettingService.savePlayer(player);
        // Call Betting
        this.doBetting();
    }

    private void doBetting() throws Exception {
        this.view.printOutcomeOdds(this.sportBettingService.findAllSportEvents());
        OutcomeOdd odd = this.view.selectOutcomeOdd(this.database.getSportEvent());
        this.database.setOutcomeOdd(odd);
        BigDecimal amount = this.view.readWagerAmount();
        Player actualPlayer = this.sportBettingService.findPlayer();
        if (actualPlayer.getBalance().compareTo(amount) != -1) {
            actualPlayer.setBalance((actualPlayer.getBalance().subtract(amount)));
            Random r = new Random();
            Wager wager = new Wager.Builder()
                    .setAmount(amount)
                    .setCurrency(actualPlayer.getCurrency())
                    .setPlayer(actualPlayer)
                    .setOutcomeOdd(odd)
                    .setWin(r.nextBoolean())
                    .setTimestampCreated(LocalDateTime.now())
                    .build();
            this.view.printWagerSaved(wager);
            this.database.setWager(wager);
        } else {
            this.view.printNotEnoughBalance(actualPlayer);
        }
    }

    private void calculateResults() {
        List<Wager> wagerList = this.database.getWager();
        Player player = this.sportBettingService.findPlayer();
        for (Wager wager : wagerList) {
            if (wager.getWin()) {
                BigDecimal val = wager.getOutcomeOdd().getValue().multiply(wager.getAmount());
                player.setBalance((player.getBalance().add(val)));
            }
        }
    }

    private void printResults() {
        Player player = this.sportBettingService.findPlayer();
        this.view.printResults(player, null);
    }
}
