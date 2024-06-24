package com.sportsradar.football.worldcupscoreboard.sportsradar_football_worldcupscoreboard;

import com.sportsradar.football.worldcupscoreboard.sportsradar_football_worldcupscoreboard.domain.Game;
import com.sportsradar.football.worldcupscoreboard.sportsradar_football_worldcupscoreboard.domain.Team;
import com.sportsradar.football.worldcupscoreboard.sportsradar_football_worldcupscoreboard.domain.TeamList;
import com.sportsradar.football.worldcupscoreboard.sportsradar_football_worldcupscoreboard.service.ApplicatonService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.stubbing.OngoingStubbing;

import java.util.Date;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.fail;

@RunWith(MockitoJUnitRunner.class)
public class WorldCupBoardTest {

    @Mock
    ApplicatonService applicatonService;
    public Team team;
    public Game game1;
    @Before
    public void setup() {
       game1= new Game();
       // Game game2 =  new Game(TeamList.SPAIN,TeamList.BRAZIL,new Date());
        game1.setId(1L);
        game1.setHome(TeamList.MEXICO);
        game1.setHome(TeamList.CANADA);
        game1.setHomeTeamScore(0);
        game1.setAwayTeamScore(5);

    }
    /**
     * Passed test scenario
     */
    @Test
    public  void startNewGame(){
        Game game1 =  new Game(TeamList.MEXICO,TeamList.CANADA,new Date());
        try {
            applicatonService.startGame(game1.getHome(), game1.getAway());
        } catch (Exception e) {
            assertEquals("Error while starting the game", e.getMessage());
        }
    }
    @Test
    public  void Update(){
        Game game1 =  new Game(TeamList.MEXICO,TeamList.CANADA,new Date());
        applicatonService.updateScore(game1.getHome(),game1.getAway(),10,2);
        Assert.assertEquals(10, game1.getHomeTeamScore().intValue());
        Assert.assertEquals(2, game1.getAwayTeamScore().intValue());

    }

    /**
     * failed test scenario
     */
    @Test
    public  void startNewGameWithEmptyteam(){
        Game game1 =  new Game(null,TeamList.CANADA,new Date());
        try {
            applicatonService.startGame(game1.getHome(), game1.getAway());
            fail("Expected RuntimeCamelException");
        } catch (Exception e) {
            assertEquals("Error while starting the game", e.getMessage());
        }
    }

}
