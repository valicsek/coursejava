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
    public Player readPlayerData() {
        System.out.println("What is your name?");
        String name = this.scanner.nextLine();

        try {
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
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public void printWelcomeMessage(Player player) {
        System.out.println("Welcome " + player.getName() + "!");
        this.printBalance(player);
    }

    @Override
    public void printBalance(Player player) {
        System.out.println("Your balance is " + player.getBalance() + " " + player.getCurrency());
    }

    @Override
    public void printOutcomeOdds(List<SportEvent> sportEvents) {
        int index = 1;
        for (SportEvent sportEvent: sportEvents) {
            System.out.println("> " + index + ": Sport event: " + sportEvent.getTitle() + " (start: " + sportEvent.getStartDate() + "), Bet: player Oliver Giroud score, Outcome: 1, Actual odd: 2, Valid between 2000-01-01 12:00:00 and 2020-01-01 12:00:00.\n");
            index++;
        }
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
        System.out.println("Wager 'number of scored goals=3' of Arsenal vs Chelsea [odd: 3, amount: 200] saved!");
    }

    @Override
    public void printNotEnoughBalance(Player player) {
        System.out.println("You don't have enough money, your balance is" + player.getBalance() + "HUF\n");
    }

    @Override
    public void printResults(Player player, List<Wager> wager) {
        System.out.println("Results:");
        System.out.println("" +
                "> Wager 'player Oliver Giroud score=1' of Arsenal vs Chelsea [odd: 2, amount: 100], win: true\n" +
                "                > Wager 'number of scored goals=3' of Arsenal vs Chelsea [odd: 3, amount: 200], win: false\n" +
                "                > Your new balance is 900 HUF."
        );
    }
}
