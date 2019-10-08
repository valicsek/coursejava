package com.sportbetting.domain;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class OutcomeOdd {
    Outcome outcome;
    BigDecimal value;
    LocalDateTime validFrom;
    LocalDateTime validUntil;
    ECurrency currency;
}
