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


    public Player getPlayer() {
        return player;
    }

    public OutcomeOdd getOutcomeOdd() {
        return outcomeOdd;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public ECurrency getCurrency() {
        return currency;
    }

    public LocalDateTime getTimestampCreated() {
        return timestampCreated;
    }

    public Boolean getProcessed() {
        return processed;
    }

    public Boolean getWin() {
        return win;
    }

    public Wager(Player player, OutcomeOdd outcomeOdd, BigDecimal amount, ECurrency currency, LocalDateTime timestampCreated, Boolean processed, Boolean win) {
        this.player = player;
        this.outcomeOdd = outcomeOdd;
        this.amount = amount;
        this.currency = currency;
        this.timestampCreated = timestampCreated;
        this.processed = processed;
        this.win = win;
    }

    public static class Builder {
        Player player;
        OutcomeOdd outcomeOdd;
        BigDecimal amount;
        ECurrency currency;
        LocalDateTime timestampCreated;
        Boolean processed;
        Boolean win;

        public Builder() { }

        public Wager build() {
            return new Wager(player, outcomeOdd, amount, currency, timestampCreated, processed, win);
        }

        public Builder setPlayer(Player player) {
            this.player = player;
            return this;
        }

        public Builder setOutcomeOdd(OutcomeOdd outcomeOdd) {
            this.outcomeOdd = outcomeOdd;
            return this;
        }

        public Builder setAmount(BigDecimal amount) {
            this.amount = amount;
            return this;
        }

        public Builder setCurrency(ECurrency currency) {
            this.currency = currency;
            return this;
        }

        public Builder setTimestampCreated(LocalDateTime timestampCreated) {
            this.timestampCreated = timestampCreated;
            return this;
        }

        public Builder setProcessed(Boolean processed) {
            this.processed = processed;
            return this;
        }

        public Builder setWin(Boolean win) {
            this.win = win;
            return this;
        }
    }
}
