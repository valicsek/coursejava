package com.sportbetting.service;

import com.sportbetting.domain.Player;
import com.sportbetting.domain.SportEvent;
import com.sportbetting.domain.Wager;

import java.util.List;

public interface ISportsBettingService {
    void savePlayer(Player Player);
    Player findPlayer();
    List<SportEvent> findAllSportEvents();
    void saveWager(Wager Wager);
    List<Wager> findAllWagers();
    void calculateResults();
}
