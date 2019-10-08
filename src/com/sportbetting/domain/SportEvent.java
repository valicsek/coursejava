package com.sportbetting.domain;

import java.util.Date;
import java.util.List;

public class SportEvent {
    String title;
    Date startDate;
    Date endDate;
    List<Bet> bets;
    List<Result> results;
}
