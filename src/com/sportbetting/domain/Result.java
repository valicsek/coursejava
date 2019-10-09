package com.sportbetting.domain;

import java.util.List;

public class Result {
    public List<Outcome> getOutcomes() {
        return outcomes;
    }

    public void setOutcomes(List<Outcome> outcomes) {
        this.outcomes = outcomes;
    }

    List<Outcome> outcomes;
}
