package com.sportbetting.view;

import com.sportbetting.domain.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;

public class View implements IView {

    private Scanner scanner;

    public View() {
        this.scanner = new Scanner(System.in);  // Create a Scanner object
    }

    @Override
    public Player readPlayerData() throws Exception {
        System.out.println("What is your name?");
        String name = this.scanner.nextLine();

        System.out.println("How much money do you have (more than 0)??");
        BigDecimal money = new BigDecimal(this.scanner.nextLine());

        if (money.compareTo(new BigDecimal(0.0)) < 0) throw new Exception("Balance cannot be smaller than 0");

        System.out.println("What is your currency? (HUF, EUR or USD)");
        String currency = this.scanner.nextLine();

            // Create Player
        Player player = new Player.Builder()
                .setName(name)
                .setBalance(money)
                .setCurrency(ECurrency.valueOf(currency.toUpperCase()))
                .build();

        return player;
    }

    @Override
    public void printWelcomeMessage(Player player) {
        System.out.println("Welcome " + player.getName() + "!");
        this.printBalance(player);
    }

    @Override
    public void printBalance(Player player) {
        System.out.println("Your balance is  " + player.getBalance() + " " + player.getCurrency());
    }

    @Override
    public void printOutcomeOdds(List<SportEvent> sportEvents) {
        int index = 0;
        for (SportEvent sportEvent : sportEvents) {
            for (Bet bet : sportEvent.getBets()) {
                for (Outcome outcome : bet.getOutcomes()) {
                    for (OutcomeOdd outcomeOdd : outcome.getOutcomeOdds()) {
                        index++;
                        System.out.println(index + ": Sport event: " + sportEvent.getTitle()
                                + "(start: " + sportEvent.getStartDate() + "), Bet: " + bet.getDescription() + ", Outcome: " + outcome.getDescription()
                                + ", Actual odd: " + outcomeOdd.getValue() + ", Valid between " + outcomeOdd.getValidFrom()
                                + " and " + outcomeOdd.getValidUntil() + ".");
                    }
                }
            }
        }
    }

    @Override
    public OutcomeOdd selectOutcomeOdd(List<SportEvent> sportEvents) throws Exception {
        String input = this.scanner.nextLine();
        if ("q".equals(input)) {
            throw new Exception("You pressed q, Good bye!");
        }
        int index = 0;
        int choosen = Integer.parseInt(input);
        for (SportEvent sportEvent : sportEvents) {
            for (Bet bet : sportEvent.getBets()) {
                for (Outcome outcome : bet.getOutcomes()) {
                    for (OutcomeOdd outcomeOdd : outcome.getOutcomeOdds()) {
                        index++;
                        if (index == choosen) {
                            return outcomeOdd;
                        }
                    }
                }
            }
        }

        return null;
    }

    @Override
    public BigDecimal readWagerAmount() {
        System.out.println("What amount do you wish to bet on it?");
        return new BigDecimal(this.scanner.nextLine());
    }

    @Override
    public void printWagerSaved(Wager wager) {
        System.out.println("Wager '" + wager.getOutcomeOdd().getOutcome().getBet().getDescription() + "="
                + wager.getOutcomeOdd().getOutcome().getDescription() + " of " + wager.getOutcomeOdd().getOutcome().getBet().getEvent().getTitle()
                + " [odd: " + wager.getOutcomeOdd().getValue() + ", amount: " + wager.getAmount() + "] saved");    }

    @Override
    public void printNotEnoughBalance(Player player) {
        System.out.println("You don't have enough money, your balance is " + player.getBalance() + " " + player.getCurrency());
    }

    @Override
    public void printResults(Player player, List<Wager> wagers) {
        for (Wager wager : wagers) {
            System.out.println("Wager ' " + wager.getOutcomeOdd().getOutcome().getDescription() + "' of " + wager.getOutcomeOdd().getOutcome().getBet().getEvent().getTitle()
                    + "[odd: " + wager.getOutcomeOdd().getValue() + ", amount: " + wager.getAmount() + "] win:" + wager.getWin());
        }
        System.out.println("Your new balance is " + player.getBalance() + " " + player.getCurrency());
    }
}
