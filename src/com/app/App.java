package com.app;

import java.util.Scanner;

public class App {
    public App(SportsBettingService sportsBettingService, View view) {
    }

    public void play() {
        Scanner scanner = new Scanner(System.in);  // Create a Scanner object

        System.out.println("What is your name?");
        String name = scanner.nextLine();
        System.out.println("How much money do you have (more than 0)??");
        String money = scanner.nextLine();
        System.out.println("What is your currency? (HUF, EUR or USD)");
        String currency = scanner.nextLine();

        System.out.println("Welcome " + name + "!");
        System.out.println("Your balance is " + money + " " + currency);
    }

    private void createPlayer() {
    }

    private void doBetting() {
    }

    private void calculateResults() {
    }

    private void printResults() {
    }
}
