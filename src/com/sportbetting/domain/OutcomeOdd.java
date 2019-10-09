package com.sportbetting.domain;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class OutcomeOdd {

    private Outcome outcome;
    private BigDecimal value;
    private LocalDateTime validFrom;
    private LocalDateTime validUntil;
    private ECurrency currency;

    public Outcome getOutcome() { return outcome; }
    public BigDecimal getValue() { return value; }
    public LocalDateTime getValidFrom() { return validFrom; }
    public LocalDateTime getValidUntil() { return validUntil; }
    public ECurrency getCurrency() { return currency; }

    public OutcomeOdd(Outcome outcome, BigDecimal value, LocalDateTime validFrom, LocalDateTime validUntil, ECurrency currency) {
        this.outcome = outcome;
        this.value = value;
        this.validFrom = validFrom;
        this.validUntil = validUntil;
        this.currency = currency;
    }

    public static class Builder {

        private Outcome outcome;
        private BigDecimal value;
        private LocalDateTime validFrom;
        private LocalDateTime validUntil;
        private ECurrency currency;

        public Builder() {}

        public OutcomeOdd build() {
            return new OutcomeOdd(outcome, value, validFrom, validUntil, currency);
        }

        public void setOutcome(Outcome outcome) {
            this.outcome = outcome;
        }

        public void setValue(BigDecimal value) {
            this.value = value;
        }

        public void setValidFrom(LocalDateTime validFrom) {
            this.validFrom = validFrom;
        }

        public void setValidUntil(LocalDateTime validUntil) {
            this.validUntil = validUntil;
        }

        public void setCurrency(ECurrency currency) {
            this.currency = currency;
        }
    }

}
