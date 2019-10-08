package com.sportbetting.domain;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Wager {
    Player player;
    OutcomeOdd outcomeOdd;
    BigDecimal amount;
    ECurrency currency;
    LocalDateTime timestampCreated;
    Boolean processed;
    Boolean win;
}
