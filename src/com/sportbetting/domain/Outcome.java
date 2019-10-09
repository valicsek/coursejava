package com.sportbetting.domain;

import java.util.List;

public class Outcome {

    private String description;
    private List<Outcome> outcomes;
    private Bet bet;

    public String getDescription() {
        return description;
    }
    public List<Outcome> getOutcomes() {
        return outcomes;
    }
    public Bet getBet() {
        return bet;
    }

    public Outcome(String description, List<Outcome> outcomes, Bet bet) {
        this.description = description;
        this.outcomes = outcomes;
        this.bet = bet;
    }

    public static class Builder {

        private String description;
        private List<Outcome> outcomes;
        private Bet bet;

        public Builder() { }

        public Builder setDescription(String description) {
            this.description = description;
            return this;
        }

        public Builder setOutcomes(List<Outcome> outcomes) {
            this.outcomes = outcomes;
            return this;
        }

        public Builder setBet(Bet bet) {
            this.bet = bet;
            return this;
        }

    }
}
