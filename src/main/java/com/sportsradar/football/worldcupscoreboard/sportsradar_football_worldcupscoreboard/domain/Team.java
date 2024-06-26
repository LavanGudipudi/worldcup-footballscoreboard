package com.sportsradar.football.worldcupscoreboard.sportsradar_football_worldcupscoreboard.domain;

import java.util.Objects;

public class Team {
    private Integer id;
    private String name;
    // Constructors
    public Team(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    // Getters & Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTeamKey() {
        return this.getId().toString();
    }
    @Override
    public String toString() {
        return "Team{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Team team = (Team) o;
        return Objects.equals(id, team.id) && Objects.equals(name, team.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
