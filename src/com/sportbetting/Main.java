package com.sportbetting;

import com.sportbetting.service.SportsBettingService;
import com.sportbetting.view.View;

public class Main {

    public static void main(String[] args) {
        Database store = new Database();
        App app = new App(new SportsBettingService(store), new View());
        try {
            app.play();
        } catch (Exception err) {
            System.out.println(err.getMessage());
        }
    }
}
