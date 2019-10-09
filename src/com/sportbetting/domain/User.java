package com.sportbetting.domain;

public class User {
    private String email;
    private String password;

    public String getEmail() { return email; }
    public String getPassword() { return password; }

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public static class Builder {
        private String email;
        private String password;


        public Builder() { }

        public User build() {
            return new User(email, password);
        }

        public Builder setEmail(String email) {
            this.email = email;
            return this;
        }

        public Builder setPassword(String password) {
            this.password = password;
            return this;
        }
    }
}
