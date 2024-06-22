package com.sportsradar.football.worldcupscoreboard.sportsradar_football_worldcupscoreboard.service;

import com.sportsradar.football.worldcupscoreboard.sportsradar_football_worldcupscoreboard.domain.Game;
import com.sportsradar.football.worldcupscoreboard.sportsradar_football_worldcupscoreboard.domain.Team;



public class ApplicatonService {

    public ApplicatonService(WorldCupBoardInterfaceImp worldCupBoardInterfaceImp) {
        this.worldCupBoardInterfaceImp = worldCupBoardInterfaceImp;
    }

    WorldCupBoardInterfaceImp worldCupBoardInterfaceImp;


    public Game startGame(Team homeTeam, Team awayTeam) throws Exception {
        return this.worldCupBoardInterfaceImp.startGame(homeTeam, awayTeam);
    }


    public void finishGame(Game game) {
        this.worldCupBoardInterfaceImp.finishGame(game.getHome(), game.getAway());
    }

    public void finishGame(Team homeTeam, Team awayTeam) {
        this.worldCupBoardInterfaceImp.finishGame(homeTeam, awayTeam);
    }


    public void updateScore(Team homeTeam, Team awayTeam, int homeScore, int awayScore) {
        this.worldCupBoardInterfaceImp.updateScore(homeTeam, awayTeam, homeScore, awayScore);
    }




    public String getSummary() {
        return this.worldCupBoardInterfaceImp.getSummary();
    }


    public void updateScore(Game game1, int homeScore, int awayScore) {
    }
}
