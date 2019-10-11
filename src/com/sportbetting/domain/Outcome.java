package com.sportbetting.domain;

import java.util.List;

public class Outcome {

    private String description;
    private List<OutcomeOdd> outcomeOdds;
    private Bet bet;

    public String getDescription() {
        return description;
    }
    public List<OutcomeOdd> getOutcomeOdds() {
        return outcomeOdds;
    }
    public Bet getBet() {
        return bet;
    }

    public Outcome(String description, List<OutcomeOdd> outcomeOdds, Bet bet) {
        this.description = description;
        this.outcomeOdds = outcomeOdds;
        this.bet = bet;
    }

    public static class Builder {

        private String description;
        private List<OutcomeOdd> outcomeOdds;
        private Bet bet;

        public Outcome build() {
            return new Outcome(description, outcomeOdds, bet);
        }
        public Builder() { }

        public Builder setDescription(String description) {
            this.description = description;
            return this;
        }

        public Builder setOutcomesOdds(List<OutcomeOdd> outcomeOdds) {
            this.outcomeOdds = outcomeOdds;
            return this;
        }

        public Builder setBet(Bet bet) {
            this.bet = bet;
            return this;
        }

    }
}
