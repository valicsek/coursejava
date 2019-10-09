package com.sportbetting;

import com.sportbetting.domain.Player;
import com.sportbetting.service.ISportsBettingService;
import com.sportbetting.view.IView;

import java.util.Scanner;

public class App {

    private Player player;
    private IView view;
    private ISportsBettingService sportBettingService;


    public App(ISportsBettingService sportsBettingService, IView view) {
        this.view = view;
        this.sportBettingService = sportsBettingService;
    }

    public void play() { this.createPlayer(); }

    private void createPlayer() {
        this.player = view.readPlayerData();
        // Show welcome message
        view.printWelcomeMessage(this.player);
        // Call Betting
        this.doBetting();
    }

    private void doBetting() {
        System.out.println("What are you want to bet on? (choose a number or press q for quit)");
        // view.printOutcomeOdds();
        Scanner scanner = new Scanner(System.in);  // Create a Scanner object
        String command = scanner.nextLine();


        if (command.toLowerCase() == "q") {
            this.printResults();
            System.exit(1);
        } else {

        }
    }

    private void calculateResults() { }

    private void printResults() {
        view.printResults(this.player, null);
    }
}
