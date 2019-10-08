package com.sportbetting;

import com.sportbetting.service.SportsBettingService;
import com.sportbetting.view.View;

public class Main {

    public static void main(String[] args) {
        App app = new App(new SportsBettingService(), new View());
        app.play();
    }
}
