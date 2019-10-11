package com.sportbetting.service;

import com.sportbetting.Database;
import com.sportbetting.domain.Player;
import com.sportbetting.domain.SportEvent;
import com.sportbetting.domain.Wager;

import java.util.List;

public class SportsBettingService implements ISportsBettingService {

    private Database database;

    public Database getDatabase() { return database; }

    public SportsBettingService(Database store) {
        // Data Provider
        this.database = store;
    }

    @Override
    public void savePlayer(Player Player) {
        database.setPlayer(Player);
    }

    @Override
    public Player findPlayer() {
        return database.getPlayer();
    }

    @Override
    public List<SportEvent> findAllSportEvents() {
        return database.getSportEvent();
    }

    @Override
    public void saveWager(Wager Wager) {
        database.setWager(Wager);
    }

    @Override
    public List<Wager> findAllWagers() {
        return database.getWager();
    }

    @Override
    public void calculateResults() { }
}
