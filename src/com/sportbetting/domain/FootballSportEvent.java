package com.sportbetting.domain;

import java.time.LocalDateTime;
import java.util.List;

public class FootballSportEvent extends SportEvent {
    public FootballSportEvent(String title, LocalDateTime startDate, LocalDateTime endDate, List<Bet> bets, List<Result> results) {
        super(title, startDate, endDate, bets, results);
    }
}
