package com.sportbetting.domain;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Player {

    private String name;
    private String accountNumber;
    private BigDecimal balance;
    private LocalDate birth;
    private ECurrency currency;

    public String getName() { return name; }
    public String getAccountNumber() { return accountNumber; }
    public BigDecimal getBalance() { return balance; }
    public LocalDate getBirth() { return birth; }
    public ECurrency getCurrency() { return currency; }

    private Player(String name, String accountNumber, BigDecimal balance, LocalDate birth, ECurrency currency) {
        this.name = name;
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.birth = birth;
        this.currency = currency;
    }

    public static class Builder {

        private String name;
        private String accountNumber;
        private BigDecimal balance;
        private LocalDate birth;
        private ECurrency currency;

        public Builder() {
        }

        public Player build() {
            return new Player(name, accountNumber, balance, birth, currency);
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setAccountNumber(String accountNumber) {
            this.accountNumber = accountNumber;
            return this;
        }

        public Builder setBalance(BigDecimal balance) {
            this.balance = balance;
            return this;
        }

        public Builder setBirth(LocalDate birth) {
            this.birth = birth;
            return this;
        }

        public Builder setCurrency(ECurrency currency) {
            this.currency = currency;
            return this;
        }

    }
}
