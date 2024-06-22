package com.sportsradar.football.worldcupscoreboard.sportsradar_football_worldcupscoreboard.service;

import com.sportsradar.football.worldcupscoreboard.sportsradar_football_worldcupscoreboard.domain.Game;
import com.sportsradar.football.worldcupscoreboard.sportsradar_football_worldcupscoreboard.domain.Team;



public interface WorldCupBoardInterface {

    Game startGame(Team homeTeam, Team awayTeam) throws Exception;

    void updateScore(Team homeTeam, Team awayTeam, int homeTeamScore, int awayTeamScore);

    String getSummary();

    void finishGame(Team homeTeam, Team awayTeam);

}
