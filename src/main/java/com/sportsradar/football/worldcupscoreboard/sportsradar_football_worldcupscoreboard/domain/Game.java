package com.sportsradar.football.worldcupscoreboard.sportsradar_football_worldcupscoreboard.domain;

import java.util.Date;
import java.util.Objects;

public class Game {

    private Long id;

    public Game() {
    }

    private Team home;
    private Team away;
    private Integer homeTeamScore;
    private Integer awayTeamScore;
    private Date startDate;


    public Game(Long id, Team home, Team away, Integer homeTeamScore, Integer awayTeamScore, Date startDate) {
        this.id = id;
        this.home = home;
        this.away = away;
        this.homeTeamScore = homeTeamScore;
        this.awayTeamScore = awayTeamScore;
        this.startDate = startDate;
    }

    public Game(Team home, Team away, Date date) {
        this.home = home;
        this.away = away;
        this.homeTeamScore = 0;
        this.awayTeamScore = 0;
        this.startDate = date;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setHome(Team home) {
        this.home = home;
    }

    public void setAway(Team away) {
        this.away = away;
    }

    public void setHomeTeamScore(Integer homeTeamScore) {
        this.homeTeamScore = homeTeamScore;
    }

    public void setAwayTeamScore(Integer awayTeamScore) {
        this.awayTeamScore = awayTeamScore;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Team getHome() {
        return home;
    }

    public Team getAway() {
        return away;
    }

    public Integer getHomeTeamScore() {
        return homeTeamScore;
    }

    public Integer getAwayTeamScore() {
        return awayTeamScore;
    }

    public Date getStartDate() {
        return startDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Game game = (Game) o;
        return Objects.equals(id, game.id) && Objects.equals(home, game.home) && Objects.equals(away, game.away) && Objects.equals(homeTeamScore, game.homeTeamScore) && Objects.equals(awayTeamScore, game.awayTeamScore) && Objects.equals(startDate, game.startDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, home, away, homeTeamScore, awayTeamScore, startDate);
    }

    @Override
    public String toString() {
        return "Game{" +
                "id=" + id +
                ", home=" + home +
                ", away=" + away +
                ", homeTeamScore=" + homeTeamScore +
                ", awayTeamScore=" + awayTeamScore +
                ", startDate=" + startDate +
                '}';
    }


}
