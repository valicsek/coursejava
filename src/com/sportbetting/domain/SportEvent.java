package com.sportbetting.domain;

import java.util.Date;
import java.util.List;

public class SportEvent {
    private String title;
    private Date startDate;
    private Date endDate;
    private List<Bet> bets;
    private List<Result> results;

    public String getTitle() { return title; }
    public Date getStartDate() { return startDate; }
    public Date getEndDate() { return endDate; }
    public List<Bet> getBets() { return bets; }
    public List<Result> getResults() { return results; }

    public SportEvent(String title, Date startDate, Date endDate, List<Bet> bets, List<Result> results) {
        this.title = title;
        this.startDate = startDate;
        this.endDate = endDate;
        this.bets = bets;
        this.results = results;
    }

    public static class Builder {
        private String title;
        private Date startDate;
        private Date endDate;
        private List<Bet> bets;
        private List<Result> results;

        public Builder() { }

        public Builder setTitle(String title) {
            this.title = title;
            return this;
        }

        public SportEvent build() {
            return new SportEvent(title,startDate,endDate,bets,results);
        }

        public Builder setStartDate(Date startDate) {
            this.startDate = startDate;
            return this;
        }

        public Builder setEndDate(Date endDate) {
            this.endDate = endDate;
            return this;
        }

        public Builder setBets(List<Bet> bets) {
            this.bets = bets;
            return this;
        }

        public Builder setResults(List<Result> results) {
            this.results = results;
            return this;
        }
    }
}
