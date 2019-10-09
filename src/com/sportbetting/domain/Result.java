package com.sportbetting.domain;

import java.util.List;

public class Result {
    private List<Outcome> outcomes;

    public Result(List<Outcome> outcomes) {
        this.outcomes = outcomes;
    }

    public static class Builder {
        private List<Outcome> outcomes;

        public Builder() { }

        public Result build() {
            return new Result(outcomes);
        }

        public void setOutcomes(List<Outcome> outcomes) {
            this.outcomes = outcomes;
        }
    }
}
