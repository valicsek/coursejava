package com.sportbetting.domain;

import java.util.List;

public class Bet {

    private SportEvent event;
    private String description;
    private EBetType betType;
    private List<Outcome> outcomes;

    public SportEvent getEvent() {
        return event;
    }
    public String getDescription() {
        return description;
    }
    public EBetType getBetType() {
        return betType;
    }
    public List<Outcome> getOutcomes() {
        return outcomes;
    }

    public Bet(SportEvent event, String description, EBetType betType, List<Outcome> outcomes) {
        this.event = event;
        this.description = description;
        this.betType = betType;
        this.outcomes = outcomes;
    }

    public static class Builder {

        private SportEvent event;
        private String description;
        private EBetType betType;
        private List<Outcome> outcomes;

        public Builder() { }

        public Builder setEvent(SportEvent event) {
            this.event = event;
            return this;
        }

        public Builder setDescription(String description) {
            this.description = description;
            return this;
        }

        public Builder setBetType(EBetType betType) {
            this.betType = betType;
            return this;
        }

        public Builder setOutcomes(List<Outcome> outcomes) {
            this.outcomes = outcomes;
            return this;
        }
    }
}
