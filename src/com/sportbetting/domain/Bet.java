package com.sportbetting.domain;

import java.util.List;

public class Bet {
    SportEvent event;
    String description;
    EBetType betType;
    List<Outcome> outcomes;
}
