package com.sportsradar.football.worldcupscoreboard.sportsradar_football_worldcupscoreboard.service;

import com.sportsradar.football.worldcupscoreboard.sportsradar_football_worldcupscoreboard.domain.Game;
import com.sportsradar.football.worldcupscoreboard.sportsradar_football_worldcupscoreboard.domain.Team;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class WorldCupBoardInterfaceImp implements WorldCupBoardInterface {
    private final Map<String, Game> games = new HashMap<>();



    @Override
    public Game startGame(Team home, Team away) throws Exception {
        if(!teamvalidity(home,away) &&home.getId()==away.getId()){
          System.out.println("Not possible to start the game");
            throw new Exception("Not possible to start the game");
        }
        String match=home.getTeamKey() + "_" + away.getTeamKey();
        Game  game = new Game(home, away, new Date());
        this.games.put(match,game);
        return game;
    }

    @Override
    public void finishGame(Team home, Team away) {
        String match=home.getTeamKey() + "_" + away.getTeamKey();
        this.games.remove(match);

    }

    @Override
    public void updateScore(Team home, Team away, int homeTeamScore, int awayTeamScore) {
        String match=home.getTeamKey() + "_" + away.getTeamKey();
        if(!teamvalidity(home,away) &&home.getId()==away.getId() && homeTeamScore < 0 && awayTeamScore < 0) return;

        Game updategame=this.games.get(match);
        if(updategame!=null){
            updateGameScore(updategame,homeTeamScore,awayTeamScore);
            this.games.put(match,updategame);

        }


    }

    private void updateGameScore(Game updategame, int homeTeamScore, int awayTeamScore) {
        updategame.setHomeTeamScore(homeTeamScore);
        updategame.setAwayTeamScore(awayTeamScore);
    }

    @Override
    public String getSummary() {
        List<Game> games = this.getGames();
        games.sort((game1,game2)->{
            if (getTotalScore(game1) > getTotalScore(game2)) {
                return -1;
            } else if (getTotalScore(game1) < getTotalScore(game2)) {
                return 1;
            }
            return game1.getStartDate().before(game2.getStartDate()) ? 1 : -1;
        });
        return games.stream().map(Object::toString).collect(Collectors.joining("\n"));
    }




    public static boolean teamvalidity(Team homeTeam, Team awayTeam) {
        return validTeam(homeTeam) && validTeam(awayTeam);
    }
    public static boolean validTeam(Team team) {
        return team != null && team.getId() != null && team.getName() != null;
    }
    public static int getTotalScore(Game game) {
        return game.getHomeTeamScore() + game.getAwayTeamScore();
    }
    public List<Game> getGames() {
        return new ArrayList<Game>(this.games.values());
    }
}
