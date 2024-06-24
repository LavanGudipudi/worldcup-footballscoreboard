package com.sportsradar.football.worldcupscoreboard.sportsradar_football_worldcupscoreboard;

import com.sportsradar.football.worldcupscoreboard.sportsradar_football_worldcupscoreboard.domain.Game;
import com.sportsradar.football.worldcupscoreboard.sportsradar_football_worldcupscoreboard.domain.TeamList;
import com.sportsradar.football.worldcupscoreboard.sportsradar_football_worldcupscoreboard.service.ApplicatonService;
import com.sportsradar.football.worldcupscoreboard.sportsradar_football_worldcupscoreboard.service.WorldCupBoardInterfaceImp;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SportsradarFootballWorldcupscoreboardApplication {

	public static void main(String[] args) {
		SpringApplication.run(SportsradarFootballWorldcupscoreboardApplication.class, args);
		invokeApplicationService();
	}

	private static void invokeApplicationService() {
		ApplicatonService applicatonService = new ApplicatonService(new WorldCupBoardInterfaceImp());
		try {
			Game game1 = applicatonService.startGame(TeamList.MEXICO, TeamList.CANADA);
			game1.setId(1L);
			Game game2 = applicatonService.startGame(TeamList.SPAIN, TeamList.BRAZIL);
			game2.setId(2L);
			Game game3 = applicatonService.startGame(TeamList.GERMANY, TeamList.FRANCE);
			game3.setId(3L);
			Game game4 = applicatonService.startGame(TeamList.URUGUAY, TeamList.ITALY);
			game4.setId(4L);
			Game game5 = applicatonService.startGame(TeamList.ARGENTINA, TeamList.AUSTRALIA);
			game5.setId(5L);

			applicatonService.updateScore(game1.getHome(), game1.getAway(),0, 5);
			applicatonService.updateScore(game2.getHome(), game1.getAway(), 10, 2);
			applicatonService.updateScore(game3.getHome(), game1.getAway(), 2, 2);
			applicatonService.updateScore(game4.getHome(), game1.getAway(), 6, 6);
			applicatonService.updateScore(game5.getHome(), game1.getAway(), 3, 1);
		}  catch (Exception e) {
			e.printStackTrace();
		} finally {
			System.out.println("******** SUMMARY OF CURRENT GAMES BY TOTAL SCORE ********\n" + applicatonService.getSummary());
		}

	}

}
