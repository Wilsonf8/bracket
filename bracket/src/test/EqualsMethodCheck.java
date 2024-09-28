package test;

import static tournament.FIFASoccerTeam.ALGERIA;
import static tournament.FIFASoccerTeam.ARGENTINA;
import static tournament.FIFASoccerTeam.BELGIUM;
import static tournament.FIFASoccerTeam.BRAZIL;
import static tournament.FIFASoccerTeam.CHILE;
import static tournament.FIFASoccerTeam.COLOMBIA;
import static tournament.FIFASoccerTeam.COSTA_RICA;
import static tournament.FIFASoccerTeam.FRANCE;
import static tournament.FIFASoccerTeam.GERMANY;
import static tournament.FIFASoccerTeam.GREECE;
import static tournament.FIFASoccerTeam.MEXICO;
import static tournament.FIFASoccerTeam.NETHERLANDS;
import static tournament.FIFASoccerTeam.NIGERIA;
import static tournament.FIFASoccerTeam.SWITZERLAND;
import static tournament.FIFASoccerTeam.URUGUAY;
import static tournament.FIFASoccerTeam.USA;

import java.util.Arrays;
import java.util.List;

import tournament.Bracket;
import tournament.BracketImpl_Flores;
import tournament.FIFASoccerTeam;
public class EqualsMethodCheck {
	
	
protected static BracketImpl_Flores<FIFASoccerTeam> worldCup2014KnockoutResults;
protected static BracketImpl_Flores<FIFASoccerTeam> worldCup2014KnockoutResults2;
protected static BracketImpl_Flores<FIFASoccerTeam> worldCup2014KnockoutResults_NETHERLANDS_WINS_INSTEAD;
protected static BracketImpl_Flores<FIFASoccerTeam> worldCup_DEGENERATE;



	public static void main(String[] args) {
		List<FIFASoccerTeam> worldCup2014KnockoutRoundMatchups = Arrays.asList(BRAZIL, CHILE, COLOMBIA, URUGUAY, FRANCE, NIGERIA, GERMANY, ALGERIA, NETHERLANDS, MEXICO, COSTA_RICA, GREECE, ARGENTINA, SWITZERLAND, BELGIUM, USA);
		worldCup2014KnockoutResults = new BracketImpl_Flores<FIFASoccerTeam>(worldCup2014KnockoutRoundMatchups);
		worldCup2014KnockoutResults.setWinCount(GERMANY, 4);
		worldCup2014KnockoutResults.setWinCount(NETHERLANDS, 3);
		worldCup2014KnockoutResults.setWinCount(BRAZIL, 2);
		worldCup2014KnockoutResults.setWinCount(ARGENTINA, 2);
		worldCup2014KnockoutResults.setWinCount(COLOMBIA, 1);
		worldCup2014KnockoutResults.setWinCount(FRANCE, 1);
		worldCup2014KnockoutResults.setWinCount(COSTA_RICA, 1);
		worldCup2014KnockoutResults.setWinCount(BELGIUM, 1);
		
		List<FIFASoccerTeam> worldCup2014KnockoutRoundMatchups2 = Arrays.asList(BRAZIL, CHILE, COLOMBIA, URUGUAY, FRANCE, NIGERIA, GERMANY, ALGERIA, NETHERLANDS, MEXICO, COSTA_RICA, GREECE, ARGENTINA, SWITZERLAND, BELGIUM, USA);
		worldCup2014KnockoutResults2 = new BracketImpl_Flores<FIFASoccerTeam>(worldCup2014KnockoutRoundMatchups2);
		worldCup2014KnockoutResults2.setWinCount(GERMANY, 4);
		worldCup2014KnockoutResults2.setWinCount(NETHERLANDS, 3);
		worldCup2014KnockoutResults2.setWinCount(BRAZIL, 2);
		worldCup2014KnockoutResults2.setWinCount(ARGENTINA, 2);
		worldCup2014KnockoutResults2.setWinCount(COLOMBIA, 1);
		worldCup2014KnockoutResults2.setWinCount(FRANCE, 1);
		worldCup2014KnockoutResults2.setWinCount(COSTA_RICA, 1);
		worldCup2014KnockoutResults2.setWinCount(BELGIUM, 1);
		
		System.out.println(worldCup2014KnockoutResults.printBracket());
		System.out.println(worldCup2014KnockoutResults2.printBracket());
		
		
		System.out.println(worldCup2014KnockoutResults.equals(worldCup2014KnockoutResults2));
		

	}

}
