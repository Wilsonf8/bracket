package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
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
import static tournament.FIFASoccerTeam.SLOVAKIA;
import static tournament.FIFASoccerTeam.RUSSIA;
import static tournament.FIFASoccerTeam.PORTUGAL;
import static tournament.FIFASoccerTeam.SWITZERLAND;
import static tournament.FIFASoccerTeam.URUGUAY;
import static tournament.FIFASoccerTeam.USA;


import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

import tournament.Bracket;
import tournament.BracketImpl_Flores;
import tournament.FIFASoccerTeam;

public class IndvTests
{
	protected String TEST_GOAL_MESSAGE;
	
	@Rule public Timeout globalTimeout= new Timeout(300000);
	
	protected static Bracket<FIFASoccerTeam> worldCup2014KnockoutResults;
	protected static Bracket<FIFASoccerTeam> worldCup2014KnockoutResults_ALT;
	protected static Bracket<FIFASoccerTeam> worldCup2014KnockoutResults_NETHERLANDS_WINS_INSTEAD;
	protected static Bracket<FIFASoccerTeam> worldCup_DEGENERATE;
	
	@Before
	public void setUp()
	{
		//System.out.println("SUBSET_FOR_STUDENTS.setUp()");
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
		
		List<FIFASoccerTeam> worldCup2014KnockoutRoundMatchups_ALT = Arrays.asList(USA, BELGIUM, SWITZERLAND, ARGENTINA, GREECE, COSTA_RICA, MEXICO, NETHERLANDS, ALGERIA, GERMANY, NIGERIA, FRANCE, URUGUAY, COLOMBIA, CHILE, BRAZIL);
		
		worldCup2014KnockoutResults_ALT = new BracketImpl_Flores<FIFASoccerTeam>(worldCup2014KnockoutRoundMatchups_ALT);
		worldCup2014KnockoutResults_ALT.setWinCount(GERMANY, 4);
		worldCup2014KnockoutResults_ALT.setWinCount(NETHERLANDS, 3);
		worldCup2014KnockoutResults_ALT.setWinCount(BRAZIL, 2);
		worldCup2014KnockoutResults_ALT.setWinCount(ARGENTINA, 2);
		worldCup2014KnockoutResults_ALT.setWinCount(COLOMBIA, 1);
		worldCup2014KnockoutResults_ALT.setWinCount(FRANCE, 1);
		worldCup2014KnockoutResults_ALT.setWinCount(COSTA_RICA, 1);
		worldCup2014KnockoutResults_ALT.setWinCount(BELGIUM, 1);
		
		worldCup2014KnockoutResults_NETHERLANDS_WINS_INSTEAD = new BracketImpl_Flores<FIFASoccerTeam>(worldCup2014KnockoutRoundMatchups_ALT);
		worldCup2014KnockoutResults_NETHERLANDS_WINS_INSTEAD.setWinCount(GERMANY, 4);
		worldCup2014KnockoutResults_NETHERLANDS_WINS_INSTEAD.setWinCount(NETHERLANDS, 3);
		worldCup2014KnockoutResults_NETHERLANDS_WINS_INSTEAD.setWinCount(BRAZIL, 2);
		worldCup2014KnockoutResults_NETHERLANDS_WINS_INSTEAD.setWinCount(ARGENTINA, 2);
		worldCup2014KnockoutResults_NETHERLANDS_WINS_INSTEAD.setWinCount(COLOMBIA, 1);
		worldCup2014KnockoutResults_NETHERLANDS_WINS_INSTEAD.setWinCount(FRANCE, 1);
		worldCup2014KnockoutResults_NETHERLANDS_WINS_INSTEAD.setWinCount(COSTA_RICA, 1);
		worldCup2014KnockoutResults_NETHERLANDS_WINS_INSTEAD.setWinCount(BELGIUM, 1);

		//Netherlands wins instead:
		worldCup2014KnockoutResults_NETHERLANDS_WINS_INSTEAD.setWinCount(NETHERLANDS, 4);
		
		List<FIFASoccerTeam> matchups_DEGENERATE = Arrays.asList(USA);

		worldCup_DEGENERATE = new BracketImpl_Flores<FIFASoccerTeam>(matchups_DEGENERATE);
	}
	
	@Points(value = 10)
	@Test
	public void testSettingNullIndexZeroAfterUpdate() {
		System.out.println();
		TEST_GOAL_MESSAGE = "Test SettingNullIndexZeroAfterUpdate ---------->";
		System.out.println(TEST_GOAL_MESSAGE);
	    List<FIFASoccerTeam> worldCup2014KnockoutRoundMatchups = Arrays.asList(BRAZIL, CHILE, COLOMBIA, URUGUAY, FRANCE, NIGERIA, GERMANY, ALGERIA, NETHERLANDS, MEXICO, COSTA_RICA, GREECE, ARGENTINA, SWITZERLAND, BELGIUM, USA);
	    worldCup2014KnockoutResults = new BracketImpl_Flores<FIFASoccerTeam>(worldCup2014KnockoutRoundMatchups);
	    worldCup2014KnockoutResults.setWinCount(GERMANY, 4);
	    worldCup2014KnockoutResults.setWinCount(BRAZIL, 2);
	    worldCup2014KnockoutResults.setWinCount(BRAZIL, 1);
	    worldCup2014KnockoutResults.setWinCount(BRAZIL, 3);
	
	    

	    // Validate if GERMANY is the winner
	    FIFASoccerTeam winner = ((BracketImpl_Flores<FIFASoccerTeam>) worldCup2014KnockoutResults).getWinner();
	    Object expected = null; 
	    assertEquals("Index 0 should be null", expected, winner);
	}
	
	@Points(value = 10)
	@Test
	public void testSettingNullIndexZeroAfterUpdate2() {
		System.out.println();
		TEST_GOAL_MESSAGE = "Test SettingNullIndexZeroAfterUpdate ---------->";
		System.out.println(TEST_GOAL_MESSAGE);
	    List<FIFASoccerTeam> worldCup2014KnockoutRoundMatchups = Arrays.asList(BRAZIL, CHILE, COLOMBIA, URUGUAY, FRANCE, NIGERIA, GERMANY, ALGERIA, NETHERLANDS, MEXICO, COSTA_RICA, GREECE, ARGENTINA, SWITZERLAND, BELGIUM, USA);
	    worldCup2014KnockoutResults = new BracketImpl_Flores<FIFASoccerTeam>(worldCup2014KnockoutRoundMatchups);
	    worldCup2014KnockoutResults.setWinCount(GERMANY, 3);
	    worldCup2014KnockoutResults.setWinCount(BRAZIL, 2);
	    worldCup2014KnockoutResults.setWinCount(BRAZIL, 1);
	    worldCup2014KnockoutResults.setWinCount(BRAZIL, 3);
	    worldCup2014KnockoutResults.setWinCount(USA, 4);
	    

	    // Validate if GERMANY is the winner
	    FIFASoccerTeam winner = ((BracketImpl_Flores<FIFASoccerTeam>) worldCup2014KnockoutResults).getWinner(); 
	    assertEquals("Index 0 should be null", USA, winner);
	}
	
	@Points(value = 10)
	@Test
	public void testSettingNullIndexZeroAfterUpdate3() {
		System.out.println();
		TEST_GOAL_MESSAGE = "Test SettingNullIndexZeroAfterUpdate ---------->";
		System.out.println(TEST_GOAL_MESSAGE);
	    List<FIFASoccerTeam> worldCup2014KnockoutRoundMatchups = Arrays.asList(BRAZIL, CHILE, COLOMBIA, URUGUAY, FRANCE, NIGERIA, GERMANY, ALGERIA, NETHERLANDS, MEXICO, COSTA_RICA, GREECE, ARGENTINA, SWITZERLAND, BELGIUM, USA);
	    worldCup2014KnockoutResults = new BracketImpl_Flores<FIFASoccerTeam>(worldCup2014KnockoutRoundMatchups);
	    worldCup2014KnockoutResults.setWinCount(BRAZIL, 4);
	    worldCup2014KnockoutResults.setWinCount(GERMANY, 3);
	    worldCup2014KnockoutResults.setWinCount(USA, 3);
	    

	    // Validate if GERMANY is the winner
	    FIFASoccerTeam winner = ((BracketImpl_Flores<FIFASoccerTeam>) worldCup2014KnockoutResults).getWinner(); 
	    Object expected = null; 
	    assertEquals("Index 0 should be null", expected, winner);
	}
	
	@Points(value = 10)
	@Test
	public void testSettingNullPreviousIndexAfterUpdate() {
		System.out.println();
		TEST_GOAL_MESSAGE = "Test SettingNullPreviousIndexAfterUpdate ---------->";
		System.out.println(TEST_GOAL_MESSAGE);
	    List<FIFASoccerTeam> worldCup2014KnockoutRoundMatchups = Arrays.asList(BRAZIL, CHILE, COLOMBIA, URUGUAY, FRANCE, NIGERIA, GERMANY, ALGERIA, NETHERLANDS, MEXICO, COSTA_RICA, GREECE, ARGENTINA, SWITZERLAND, BELGIUM, USA);
	    worldCup2014KnockoutResults = new BracketImpl_Flores<FIFASoccerTeam>(worldCup2014KnockoutRoundMatchups);
	    worldCup2014KnockoutResults.setWinCount(BRAZIL, 3);
	    worldCup2014KnockoutResults.setWinCount(BRAZIL, 1);
	    
	    FIFASoccerTeam winner = ((BracketImpl_Flores<FIFASoccerTeam>) worldCup2014KnockoutResults).getWinner();
	    Object expected = null; 
	    assertEquals("Index 0 should be null", expected, winner);
	}
	
	
	
	

	

	@Points(value = 10)
	@Test
	public void testWinsGermany() {
		TEST_GOAL_MESSAGE = "Test SetWinsGermany --> (Germany, 4) --> getWinner() = Germany";
		System.out.println(TEST_GOAL_MESSAGE);
	    List<FIFASoccerTeam> worldCup2014KnockoutRoundMatchups = Arrays.asList(BRAZIL, CHILE, COLOMBIA, URUGUAY, FRANCE, NIGERIA, GERMANY, ALGERIA, NETHERLANDS, MEXICO, COSTA_RICA, GREECE, ARGENTINA, SWITZERLAND, BELGIUM, USA);
	    worldCup2014KnockoutResults = new BracketImpl_Flores<FIFASoccerTeam>(worldCup2014KnockoutRoundMatchups);
	    worldCup2014KnockoutResults.setWinCount(GERMANY, 4);

	    // Validate if GERMANY is the winner
	    FIFASoccerTeam winner = ((BracketImpl_Flores<FIFASoccerTeam>) worldCup2014KnockoutResults).getWinner();
	    assertEquals("GERMANY should be the winner", GERMANY, winner);
	}
	
	@Points(value = 10)
	@Test
	public void testWinsNetherlans() {
		TEST_GOAL_MESSAGE = "Test SetWinsNetherlans --> (Netherlans, 4) --> getWinner() = Netherlans";
		System.out.println(TEST_GOAL_MESSAGE);
	    List<FIFASoccerTeam> worldCup2014KnockoutRoundMatchups = Arrays.asList(BRAZIL, CHILE, COLOMBIA, URUGUAY, FRANCE, NIGERIA, GERMANY, ALGERIA, NETHERLANDS, MEXICO, COSTA_RICA, GREECE, ARGENTINA, SWITZERLAND, BELGIUM, USA);
	    worldCup2014KnockoutResults = new BracketImpl_Flores<FIFASoccerTeam>(worldCup2014KnockoutRoundMatchups);
	    worldCup2014KnockoutResults.setWinCount(NETHERLANDS, 4);

	    // Validate if Netherlands is the winner
	    FIFASoccerTeam winner = ((BracketImpl_Flores<FIFASoccerTeam>) worldCup2014KnockoutResults).getWinner();
	    assertEquals("NETHERLANDS should be the winner", NETHERLANDS, winner);
	}
	
	@Points(value = 10)
	@Test
	public void testWinsUSAInsteadOfGermany() {
		TEST_GOAL_MESSAGE = "Test SetWinsUSAInsteadOfGermany --> (USA, 4) --> getWinner() = USA";
		System.out.println(TEST_GOAL_MESSAGE);
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
		
		worldCup2014KnockoutResults.setWinCount(USA, 4);
		

	    // Validate if Netherlands is the winner
	    FIFASoccerTeam winner = ((BracketImpl_Flores<FIFASoccerTeam>) worldCup2014KnockoutResults).getWinner();
	    assertEquals("USA should be the winner instead", USA, winner);
	}
	
	@Points(value = 10)
	@Test
	public void testWinsMexicoInsteadOfUSA() {
		TEST_GOAL_MESSAGE = "Test SetWinsMexicoInsteadOfUSA --> (Mexico, 4) --> getWinner() = Mexico";
		System.out.println(TEST_GOAL_MESSAGE);
	    List<FIFASoccerTeam> worldCup2014KnockoutRoundMatchups = Arrays.asList(BRAZIL, CHILE, COLOMBIA, URUGUAY, FRANCE, NIGERIA, GERMANY, ALGERIA, NETHERLANDS, MEXICO, COSTA_RICA, GREECE, ARGENTINA, SWITZERLAND, BELGIUM, USA);
	    worldCup2014KnockoutResults = new BracketImpl_Flores<FIFASoccerTeam>(worldCup2014KnockoutRoundMatchups);
	    worldCup2014KnockoutResults.setWinCount(USA, 4);
		worldCup2014KnockoutResults.setWinCount(NETHERLANDS, 3);
		worldCup2014KnockoutResults.setWinCount(BRAZIL, 2);
		worldCup2014KnockoutResults.setWinCount(ARGENTINA, 2);
		worldCup2014KnockoutResults.setWinCount(COLOMBIA, 1);
		worldCup2014KnockoutResults.setWinCount(FRANCE, 1);
		worldCup2014KnockoutResults.setWinCount(COSTA_RICA, 1);
		worldCup2014KnockoutResults.setWinCount(BELGIUM, 1);
		
		worldCup2014KnockoutResults.setWinCount(MEXICO, 4);
		

	    // Validate if Netherlands is the winner
	    FIFASoccerTeam winner = ((BracketImpl_Flores<FIFASoccerTeam>) worldCup2014KnockoutResults).getWinner();
	    assertEquals("USA should be the winner instead", MEXICO, winner);
	}
	
	@Points(value = 10)
	@Test
	public void testWinsBrazil() {
		TEST_GOAL_MESSAGE = "Test SetWinsBrazil --> (Brazil, 4) --> getWinner() = Brazil";
		System.out.println(TEST_GOAL_MESSAGE);
	    List<FIFASoccerTeam> worldCup2014KnockoutRoundMatchups = Arrays.asList(BRAZIL, CHILE, COLOMBIA, URUGUAY, FRANCE, NIGERIA, GERMANY, ALGERIA, NETHERLANDS, MEXICO, COSTA_RICA, GREECE, ARGENTINA, SWITZERLAND, BELGIUM, USA);
	    worldCup2014KnockoutResults = new BracketImpl_Flores<FIFASoccerTeam>(worldCup2014KnockoutRoundMatchups);
	    worldCup2014KnockoutResults.setWinCount(BRAZIL, 4);

	    // Validate if Netherlands is the winner
	    FIFASoccerTeam winner = ((BracketImpl_Flores<FIFASoccerTeam>) worldCup2014KnockoutResults).getWinner();
	    assertEquals("BRAZIL should be the winner", BRAZIL, winner);
	}
	
	@Points(value = 10)
	@Test
	public void testWinsUSA() {
		TEST_GOAL_MESSAGE = "Test SetWinsUSA --> (USA, 4) --> getWinner() = USA";
		System.out.println(TEST_GOAL_MESSAGE);
	    List<FIFASoccerTeam> worldCup2014KnockoutRoundMatchups = Arrays.asList(BRAZIL, CHILE, COLOMBIA, URUGUAY, FRANCE, NIGERIA, GERMANY, ALGERIA, NETHERLANDS, MEXICO, COSTA_RICA, GREECE, ARGENTINA, SWITZERLAND, BELGIUM, USA);
	    worldCup2014KnockoutResults = new BracketImpl_Flores<FIFASoccerTeam>(worldCup2014KnockoutRoundMatchups);
	    worldCup2014KnockoutResults.setWinCount(USA, 4);

	    // Validate if Netherlands is the winner
	    FIFASoccerTeam winner = ((BracketImpl_Flores<FIFASoccerTeam>) worldCup2014KnockoutResults).getWinner();
	    assertEquals("GERMANY should be the winner", USA, winner);
	}
	//--------------------------------------->
	
	//CHECKS IF SETWINCOUNT HANDLE NULLS AND COUNTRIES NOT IN THE ORIGINAL SET
	//--------------------------------------->
	@Points(value = 10)
	@Test(expected=AssertionError.class)
	public void testSetPredictedWinCountNullParticipant() {
		TEST_GOAL_MESSAGE = "Test setPredictedWinCount() precondition violation (null)";
		System.out.println(TEST_GOAL_MESSAGE);
		worldCup2014KnockoutResults.setWinCount(null, 0);
	}
	
	@Points(value = 10)
	@Test(expected=AssertionError.class)
	public void testSetPredictedWinCountParticipantNotInTournament() {
		TEST_GOAL_MESSAGE = "Test setPredictedWinCount() precondition violation (" + SLOVAKIA + ")";
		System.out.println(TEST_GOAL_MESSAGE);
		worldCup2014KnockoutResults.setWinCount(SLOVAKIA, 0);
	}
	
	@Points(value = 10)
	@Test(expected=AssertionError.class)
	public void testSetPredictedWinCountParticipantNotInTournament2() {
		TEST_GOAL_MESSAGE = "Test setPredictedWinCount() precondition violation (" + RUSSIA + ")";
		System.out.println(TEST_GOAL_MESSAGE);
		worldCup2014KnockoutResults.setWinCount(RUSSIA, 0);
	}
	
	@Points(value = 10)
	@Test(expected=AssertionError.class)
	public void testSetPredictedWinCountParticipantNotInTournament3() {
		TEST_GOAL_MESSAGE = "Test setPredictedWinCount() precondition violation (" + PORTUGAL + ")";
		System.out.println(TEST_GOAL_MESSAGE);
		worldCup2014KnockoutResults.setWinCount(PORTUGAL, 2);
	}
	//--------------------------------------->
	
	//TEST MAX LEVEL
	//--------------------------------------->
	@Points(value = 10)
	@Test
	public void testMaxLevel() {
		TEST_GOAL_MESSAGE = "Test getMaxLevel() --> " + worldCup2014KnockoutResults.getMaxLevel();
		System.out.println(TEST_GOAL_MESSAGE);
		assertEquals(4, worldCup2014KnockoutResults.getMaxLevel());
	}
	
	@Points(value = 10)
	@Test
	public void testGetGroupings0(){
		Set<Set<FIFASoccerTeam>> groupingsLevel0 = worldCup2014KnockoutResults.getGroupings(0);
		TEST_GOAL_MESSAGE = "Test getGroupings Level 0 = " + groupingsLevel0;
		System.out.println(TEST_GOAL_MESSAGE);
		assertTrue(groupingsLevel0.contains(new HashSet<FIFASoccerTeam>(Arrays.asList(BRAZIL))));
		assertTrue(groupingsLevel0.contains(new HashSet<FIFASoccerTeam>(Arrays.asList(CHILE))));
		assertTrue(groupingsLevel0.contains(new HashSet<FIFASoccerTeam>(Arrays.asList(COLOMBIA))));
		assertTrue(groupingsLevel0.contains(new HashSet<FIFASoccerTeam>(Arrays.asList(URUGUAY))));
		assertTrue(groupingsLevel0.contains(new HashSet<FIFASoccerTeam>(Arrays.asList(FRANCE))));
		assertTrue(groupingsLevel0.contains(new HashSet<FIFASoccerTeam>(Arrays.asList(NIGERIA))));
		assertTrue(groupingsLevel0.contains(new HashSet<FIFASoccerTeam>(Arrays.asList(GERMANY))));
		assertTrue(groupingsLevel0.contains(new HashSet<FIFASoccerTeam>(Arrays.asList(ALGERIA))));
		assertTrue(groupingsLevel0.contains(new HashSet<FIFASoccerTeam>(Arrays.asList(NETHERLANDS))));
		assertTrue(groupingsLevel0.contains(new HashSet<FIFASoccerTeam>(Arrays.asList(MEXICO))));
		assertTrue(groupingsLevel0.contains(new HashSet<FIFASoccerTeam>(Arrays.asList(COSTA_RICA))));
		assertTrue(groupingsLevel0.contains(new HashSet<FIFASoccerTeam>(Arrays.asList(GREECE))));
		assertTrue(groupingsLevel0.contains(new HashSet<FIFASoccerTeam>(Arrays.asList(ARGENTINA))));
		assertTrue(groupingsLevel0.contains(new HashSet<FIFASoccerTeam>(Arrays.asList(SWITZERLAND))));
		assertTrue(groupingsLevel0.contains(new HashSet<FIFASoccerTeam>(Arrays.asList(BELGIUM))));
		assertTrue(groupingsLevel0.contains(new HashSet<FIFASoccerTeam>(Arrays.asList(USA))));
		
		int expected = 16;
		int actual = groupingsLevel0.size();
		assertEquals(expected, actual);
	}
	
	@Points(value = 10)
	@Test
	public void testGetGroupings1(){
		Set<Set<FIFASoccerTeam>> groupingsLevel1 = worldCup2014KnockoutResults.getGroupings(1);
		TEST_GOAL_MESSAGE = "Test getGroupings Level 1 = " + groupingsLevel1;
		System.out.println(TEST_GOAL_MESSAGE);
		assertTrue(groupingsLevel1.contains(new HashSet<FIFASoccerTeam>(Arrays.asList(BRAZIL, CHILE))));
		assertTrue(groupingsLevel1.contains(new HashSet<FIFASoccerTeam>(Arrays.asList(COLOMBIA, URUGUAY))));
		assertTrue(groupingsLevel1.contains(new HashSet<FIFASoccerTeam>(Arrays.asList(FRANCE, NIGERIA))));
		assertTrue(groupingsLevel1.contains(new HashSet<FIFASoccerTeam>(Arrays.asList(GERMANY, ALGERIA))));
		assertTrue(groupingsLevel1.contains(new HashSet<FIFASoccerTeam>(Arrays.asList(NETHERLANDS, MEXICO))));
		assertTrue(groupingsLevel1.contains(new HashSet<FIFASoccerTeam>(Arrays.asList(COSTA_RICA, GREECE))));
		assertTrue(groupingsLevel1.contains(new HashSet<FIFASoccerTeam>(Arrays.asList(ARGENTINA, SWITZERLAND))));
		assertTrue(groupingsLevel1.contains(new HashSet<FIFASoccerTeam>(Arrays.asList(BELGIUM, USA))));
		
		int expected = 8;
		int actual = groupingsLevel1.size();
		assertEquals(expected, actual);
	}
	
	@Test
	public void testGetGroupings2() {
	    Set<Set<FIFASoccerTeam>> groupingsLevel2 = worldCup2014KnockoutResults.getGroupings(2);
	    TEST_GOAL_MESSAGE = "Test getGroupings Level 2 = " + groupingsLevel2;
		System.out.println(TEST_GOAL_MESSAGE);
	    assertTrue(groupingsLevel2.contains(new HashSet<FIFASoccerTeam>(Arrays.asList(BRAZIL, CHILE,COLOMBIA, URUGUAY))));
		assertTrue(groupingsLevel2.contains(new HashSet<FIFASoccerTeam>(Arrays.asList(FRANCE, NIGERIA, GERMANY, ALGERIA))));
		assertTrue(groupingsLevel2.contains(new HashSet<FIFASoccerTeam>(Arrays.asList(NETHERLANDS, MEXICO, COSTA_RICA, GREECE))));
		assertTrue(groupingsLevel2.contains(new HashSet<FIFASoccerTeam>(Arrays.asList(ARGENTINA, SWITZERLAND, BELGIUM, USA))));
	}
	
	@Points(value = 10)
	@Test
	public void testGetGroupings3(){
		Set<Set<FIFASoccerTeam>> groupingsLevel3 = worldCup2014KnockoutResults.getGroupings(3);
		TEST_GOAL_MESSAGE = "Test getGroupings Level 3 = " + groupingsLevel3;
		System.out.println(TEST_GOAL_MESSAGE);
		assertTrue(groupingsLevel3.contains(new HashSet<FIFASoccerTeam>(Arrays.asList(BRAZIL, CHILE, COLOMBIA, URUGUAY, FRANCE, NIGERIA, GERMANY, ALGERIA))));
		assertTrue(groupingsLevel3.contains(new HashSet<FIFASoccerTeam>(Arrays.asList(NETHERLANDS, MEXICO, COSTA_RICA, GREECE, ARGENTINA, SWITZERLAND, BELGIUM, USA))));
	}
	
	@Points(value = 10)
	@Test
	public void testGetGroupings4(){
		Set<Set<FIFASoccerTeam>> groupingsLevel4 = worldCup2014KnockoutResults.getGroupings(4);
		TEST_GOAL_MESSAGE = "Test getGroupings Level 4 = " + groupingsLevel4;
		System.out.println(TEST_GOAL_MESSAGE);
		assertTrue(groupingsLevel4.contains(new HashSet<FIFASoccerTeam>(Arrays.asList(BRAZIL, CHILE, COLOMBIA, URUGUAY, FRANCE, NIGERIA, GERMANY, ALGERIA, NETHERLANDS, MEXICO, COSTA_RICA, GREECE, ARGENTINA, SWITZERLAND, BELGIUM, USA))));
	}
	
	@Points(value = 10)
	@Test
	public void testGetGroupingsLEVEL4_ALT(){
		Set<Set<FIFASoccerTeam>> groupingsLevel4ALT = worldCup2014KnockoutResults_ALT.getGroupings(4);
		TEST_GOAL_MESSAGE = "Test getGroupings Level 4 ALT = " + groupingsLevel4ALT;
		System.out.println(TEST_GOAL_MESSAGE);
		assertTrue(groupingsLevel4ALT.contains(new HashSet<FIFASoccerTeam>(Arrays.asList(USA, BELGIUM, SWITZERLAND, ARGENTINA, GREECE, COSTA_RICA, MEXICO, NETHERLANDS, ALGERIA, GERMANY, NIGERIA, FRANCE, URUGUAY, COLOMBIA, CHILE, BRAZIL))));
	}
	
	@Points(value = 10)
	@Test
	public void testGetGroupingsNETHERLAND_WINS(){
		Set<Set<FIFASoccerTeam>> groupingsLevel4NETH = worldCup2014KnockoutResults_NETHERLANDS_WINS_INSTEAD.getGroupings(1);
		TEST_GOAL_MESSAGE = "Test getGroupings Level 4 Netherlands_Win = " + groupingsLevel4NETH;
		System.out.println(TEST_GOAL_MESSAGE);
		assertTrue(groupingsLevel4NETH.contains(new HashSet<FIFASoccerTeam>(Arrays.asList(BRAZIL, CHILE))));
		assertTrue(groupingsLevel4NETH.contains(new HashSet<FIFASoccerTeam>(Arrays.asList(COLOMBIA, URUGUAY))));
		assertTrue(groupingsLevel4NETH.contains(new HashSet<FIFASoccerTeam>(Arrays.asList(FRANCE, NIGERIA))));
		assertTrue(groupingsLevel4NETH.contains(new HashSet<FIFASoccerTeam>(Arrays.asList(GERMANY, ALGERIA))));
		assertTrue(groupingsLevel4NETH.contains(new HashSet<FIFASoccerTeam>(Arrays.asList(NETHERLANDS, MEXICO))));
		assertTrue(groupingsLevel4NETH.contains(new HashSet<FIFASoccerTeam>(Arrays.asList(COSTA_RICA, GREECE))));
		assertTrue(groupingsLevel4NETH.contains(new HashSet<FIFASoccerTeam>(Arrays.asList(ARGENTINA, SWITZERLAND))));
		assertTrue(groupingsLevel4NETH.contains(new HashSet<FIFASoccerTeam>(Arrays.asList(BELGIUM, USA))));
	}
	
	@Points(value = 10)
	@Test
	public void testGetGroupingsMAX_SIZE(){
		Set<Set<FIFASoccerTeam>> groupingsLevel4 = worldCup2014KnockoutResults.getGroupings(4);
		TEST_GOAL_MESSAGE = "Test getGroupings MAX_SIZE = " + groupingsLevel4.size();
		System.out.println(TEST_GOAL_MESSAGE);
		int expected = 1;
		int actual = groupingsLevel4.size();
		assertEquals(expected, actual);
		assertTrue(groupingsLevel4.contains(new HashSet<FIFASoccerTeam>(Arrays.asList(BRAZIL, CHILE, COLOMBIA, URUGUAY, FRANCE, NIGERIA, GERMANY, ALGERIA, NETHERLANDS, MEXICO, COSTA_RICA, GREECE, ARGENTINA, SWITZERLAND, BELGIUM, USA))));
	}
	//--------------------------------------->
	
	//RETURNS SET 
	protected <P> Set<P> getSet(P[] participants) {
		Set<P> set = new HashSet<P>();
		for(int i = 0; i < participants.length; i++) {
			set.add(participants[i]);
		}
		return set;
	}

	//TEST GETVAIBLEPARTICIPANTS
	//--------------------------------------->
	@Points(value = 10)
	@Test
	public void testGetViableParticpantsLevel1(){
		TEST_GOAL_MESSAGE = "Test getViableParticipants Level 1";
		System.out.println("\n" + TEST_GOAL_MESSAGE);
		assertEquals(getSet(new FIFASoccerTeam[]{BRAZIL}), worldCup2014KnockoutResults.getViableParticipants(new HashSet<FIFASoccerTeam>(getSet(new FIFASoccerTeam[] {BRAZIL, CHILE}))));
		assertEquals(getSet(new FIFASoccerTeam[]{COLOMBIA}), worldCup2014KnockoutResults.getViableParticipants(new HashSet<FIFASoccerTeam>(getSet(new FIFASoccerTeam[] {COLOMBIA, URUGUAY}))));
		assertEquals(getSet(new FIFASoccerTeam[]{FRANCE}), worldCup2014KnockoutResults.getViableParticipants(new HashSet<FIFASoccerTeam>(getSet(new FIFASoccerTeam[] {FRANCE, NIGERIA}))));
		assertEquals(getSet(new FIFASoccerTeam[]{NETHERLANDS}), worldCup2014KnockoutResults.getViableParticipants(new HashSet<FIFASoccerTeam>(getSet(new FIFASoccerTeam[] {NETHERLANDS, MEXICO}))));
		assertEquals(getSet(new FIFASoccerTeam[]{COSTA_RICA}), worldCup2014KnockoutResults.getViableParticipants(new HashSet<FIFASoccerTeam>(getSet(new FIFASoccerTeam[] {COSTA_RICA, GREECE}))));
		assertEquals(getSet(new FIFASoccerTeam[]{ARGENTINA}), worldCup2014KnockoutResults.getViableParticipants(new HashSet<FIFASoccerTeam>(getSet(new FIFASoccerTeam[] {ARGENTINA, SWITZERLAND}))));
		assertEquals(getSet(new FIFASoccerTeam[]{BELGIUM}), worldCup2014KnockoutResults.getViableParticipants(new HashSet<FIFASoccerTeam>(getSet(new FIFASoccerTeam[] {BELGIUM, USA}))));
		assertEquals(getSet(new FIFASoccerTeam[]{GERMANY}), worldCup2014KnockoutResults.getViableParticipants(new HashSet<FIFASoccerTeam>(getSet(new FIFASoccerTeam[] {GERMANY, ALGERIA}))));
	}
	
	@Points(value = 10)
	@Test
	public void testGetViableParticpantsLevel2(){
		TEST_GOAL_MESSAGE = "Test getViableParticipants Level 2";
		System.out.println("\n" + TEST_GOAL_MESSAGE);
		assertEquals(getSet(new FIFASoccerTeam[]{BRAZIL}), worldCup2014KnockoutResults.getViableParticipants(new HashSet<FIFASoccerTeam>(getSet(new FIFASoccerTeam[] {BRAZIL, CHILE, COLOMBIA, URUGUAY}))));
		assertEquals(getSet(new FIFASoccerTeam[]{GERMANY}), worldCup2014KnockoutResults.getViableParticipants(new HashSet<FIFASoccerTeam>(getSet(new FIFASoccerTeam[] {GERMANY, ALGERIA, FRANCE, NIGERIA}))));
		assertEquals(getSet(new FIFASoccerTeam[]{NETHERLANDS}), worldCup2014KnockoutResults.getViableParticipants(new HashSet<FIFASoccerTeam>(getSet(new FIFASoccerTeam[] {NETHERLANDS, MEXICO, COSTA_RICA, GREECE}))));
		assertEquals(getSet(new FIFASoccerTeam[]{ARGENTINA}), worldCup2014KnockoutResults.getViableParticipants(new HashSet<FIFASoccerTeam>(getSet(new FIFASoccerTeam[] {ARGENTINA, SWITZERLAND, BELGIUM, USA}))));
	
	}

	@Points(value = 10)
	@Test
	public void testGetViableParticpantsLevel3(){
		TEST_GOAL_MESSAGE = "Test getViableParticipants Level 3";
		System.out.println("\n" + TEST_GOAL_MESSAGE);
		assertEquals(getSet(new FIFASoccerTeam[]{NETHERLANDS}), worldCup2014KnockoutResults.getViableParticipants(new HashSet<FIFASoccerTeam>(getSet(new FIFASoccerTeam[] {NETHERLANDS, MEXICO, COSTA_RICA, GREECE, ARGENTINA, SWITZERLAND, BELGIUM, USA}))));
		assertEquals(getSet(new FIFASoccerTeam[]{GERMANY}), worldCup2014KnockoutResults.getViableParticipants(new HashSet<FIFASoccerTeam>(getSet(new FIFASoccerTeam[] {BRAZIL, CHILE, COLOMBIA, URUGUAY, FRANCE, NIGERIA, GERMANY, ALGERIA}))));
	}
	
	@Points(value = 10)
	@Test
	public void testGetViableParticpantsLevel4(){
		TEST_GOAL_MESSAGE = "Test getViableParticipants Level 4";
		System.out.println("\n" + TEST_GOAL_MESSAGE);
		assertEquals(getSet(new FIFASoccerTeam[]{GERMANY}), worldCup2014KnockoutResults.getViableParticipants(new HashSet<FIFASoccerTeam>(getSet(new FIFASoccerTeam[] {BRAZIL, CHILE, COLOMBIA, URUGUAY, FRANCE, NIGERIA, GERMANY, ALGERIA, NETHERLANDS, MEXICO, COSTA_RICA, GREECE, ARGENTINA, SWITZERLAND, BELGIUM, USA}))));
	}
	
	@Points(value = 10)
	@Test
	public void testGetViableParticpantsLevel5(){
		TEST_GOAL_MESSAGE = "Test getViableParticipants Level 4 ALT";
		System.out.println("\n" + TEST_GOAL_MESSAGE);
		assertEquals(getSet(new FIFASoccerTeam[]{NETHERLANDS}), worldCup2014KnockoutResults_NETHERLANDS_WINS_INSTEAD.getViableParticipants(new HashSet<FIFASoccerTeam>(getSet(new FIFASoccerTeam[] {USA, BELGIUM, SWITZERLAND, ARGENTINA, GREECE, COSTA_RICA, MEXICO, NETHERLANDS, ALGERIA, GERMANY, NIGERIA, FRANCE, URUGUAY, COLOMBIA, CHILE, BRAZIL}))));
	}

	@Points(value = 10)
	@Test(expected=AssertionError.class)
	public void testGetViableParticpantsBadGrouping(){
		TEST_GOAL_MESSAGE = "Test bad grouping";
		System.out.println("\n" + TEST_GOAL_MESSAGE);
		worldCup2014KnockoutResults.getViableParticipants(new HashSet<FIFASoccerTeam>(getSet(new FIFASoccerTeam[] {BRAZIL, COLOMBIA, FRANCE, GERMANY, NETHERLANDS, COSTA_RICA, CHILE, URUGUAY})));
	}
	
	@Points(value = 10)
	@Test(expected=AssertionError.class)
	public void testGetViableParticpantsBadGrouping2(){
		TEST_GOAL_MESSAGE = "Test bad grouping";
		System.out.println("\n" + TEST_GOAL_MESSAGE);
		worldCup2014KnockoutResults.getViableParticipants(new HashSet<FIFASoccerTeam>(getSet(new FIFASoccerTeam[] {BRAZIL, CHILE, USA})));
	}

	//TEST EQUALS
	//--------------------------------------->
	@Test
	@Points(value = 10)
	public void testEquals()
	{
		TEST_GOAL_MESSAGE = "Test equals";
		System.out.println(TEST_GOAL_MESSAGE);
		assert worldCup2014KnockoutResults != null : "worldCup2014KnockoutResults is null!";
		assert worldCup2014KnockoutResults_ALT != null : "worldCup2014KnockoutResults_ALT is null!";
		assertTrue(worldCup2014KnockoutResults.equals(worldCup2014KnockoutResults));
		assertTrue(worldCup2014KnockoutResults_ALT.equals(worldCup2014KnockoutResults_ALT));
	}

	@Test
	@Points(value = 10)
	public void testEquals2()
	{
		TEST_GOAL_MESSAGE = "Test equals 2";
		System.out.println(TEST_GOAL_MESSAGE);
		assertTrue(worldCup2014KnockoutResults.equals(worldCup2014KnockoutResults_ALT));
		assertTrue(worldCup2014KnockoutResults_ALT.equals(worldCup2014KnockoutResults));
	}

	@Test
	@Points(value = 10)
	public void testEquals3()
	{
		TEST_GOAL_MESSAGE = "Test equals 3";
		System.out.println(TEST_GOAL_MESSAGE);
		assertTrue(!worldCup2014KnockoutResults.equals(worldCup2014KnockoutResults_NETHERLANDS_WINS_INSTEAD));
		assertTrue(!worldCup2014KnockoutResults_ALT.equals(worldCup2014KnockoutResults_NETHERLANDS_WINS_INSTEAD));
	}

	@Test
	@Points(value = 10)
	public void testEquals4()
	{
		TEST_GOAL_MESSAGE = "Test equals against null";
		System.out.println(TEST_GOAL_MESSAGE);
		assertTrue(!worldCup2014KnockoutResults.equals(null));
	}

	@Test
	@Points(value = 10)
	public void testEquals5()
	{
		TEST_GOAL_MESSAGE = "Test equals against null bracket";
		System.out.println(TEST_GOAL_MESSAGE);
		assertTrue(!worldCup2014KnockoutResults.equals(worldCup_DEGENERATE));
		assertTrue(!worldCup_DEGENERATE.equals(worldCup2014KnockoutResults));
	}
	//--------------------------------------->
}

