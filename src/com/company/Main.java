package com.company;

public class Main {

    public static void main(String[] args) {
        App app = new App(new SportsBettingService(), new View());
        app.play();
    }
}
