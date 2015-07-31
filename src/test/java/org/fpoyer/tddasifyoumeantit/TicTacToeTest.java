package org.fpoyer.tddasifyoumeantit;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

import org.junit.Test;



public class TicTacToeTest {

	@Test public void 
	should_win_X_if_A_row_taken() {
		String sequencePlayed = "A1, B1, A2, B2, A3, ";
		String row = "A";
		boolean Xwin = xWins(sequencePlayed, row);
		assertThat(Xwin, is(true));
	}

	@Test public void 
	should_win_X_if_B_row_taken() {
		String sequencePlayed = "B1, A1, B2, A2, B3, ";
		String row = "B";
		boolean Xwin = xWins(sequencePlayed, row);
		assertThat(Xwin, is(true));
	}

	@Test public void 
	should_win_X_if_C_row_taken() {
		String sequencePlayed = "C1, A1, C2, A2, C3, ";
		String row = "C";
		boolean Xwin = xWins(sequencePlayed, row);
		assertThat(Xwin, is(true));
	}

	@Test public void 
	should_not_win_X_if_not_all_row_taken() {
		String sequencePlayed = "A1, ";
		String row = "A";
		boolean Xwin = xWins(sequencePlayed, row);
		assertThat(Xwin, is(false));
	}
	
	@Test public void 
	should_win_X_if_column_1_taken() {
		String sequencePlayed = "A1, A2, B1, B2, C1, ";
		String column = "1";
		boolean Xwin = xWins(sequencePlayed, column);
		assertThat(Xwin, is(true));
	}
	
	@Test public void 
	should_win_X_if_column_2_taken() {
		String sequencePlayed = "A2, A1, B2, B1, C2, ";
		String column = "2";
		boolean Xwin = xWins(sequencePlayed, column);
		assertThat(Xwin, is(true));
	}
	
	@Test public void 
	should_win_X_if_column_3_taken() {
		String sequencePlayed = "A3, A2, B3, B2, C3, ";
		String column = "3";
		boolean Xwin = xWins(sequencePlayed, column);
		assertThat(Xwin, is(true));
	}
	
	@Test public void 
	should_not_win_X_if_not_all_column_taken() {
		String sequencePlayed = "A1, ";
		String column = "1";
		boolean Xwin = xWins(sequencePlayed, column);
		assertThat(Xwin, is(false));
	}
	
	@Test public void 
	should_not_win_X_if_row_taken_by_O() {
		String sequencePlayed = "A1, A2, A3, ";
		String row = "A";
		boolean Xwin = xWins(sequencePlayed, row);
		assertThat(Xwin, is(false));
		sequencePlayed = "A1, B2, A2, A3, ";
		row = "A";
		Xwin = xWins(sequencePlayed, row);
		assertThat(Xwin, is(false));
		sequencePlayed = "A1, B2, A2, B1, C1, A3, ";
		row = "A";
		Xwin = xWins(sequencePlayed, row);
		assertThat(Xwin, is(false));
		sequencePlayed = "B2, A1, A2, C2, A3, ";
		row = "A";
		Xwin = xWins(sequencePlayed, row);
		assertThat(Xwin, is(false));
	}
	
	@Test public void 
	should_not_win_X_if_col_taken_by_O() {
		String sequencePlayed = "A1, B1, C1, ";
		String column = "1";
		boolean Xwin = xWins(sequencePlayed, column);
		assertThat(Xwin, is(false));
		sequencePlayed = "A1, B2, B1, C1, ";
		column = "1";
		Xwin = xWins(sequencePlayed, column);
		assertThat(Xwin, is(false));
		sequencePlayed = "A1, B2, B1, A2, A3, C1, ";
		column = "1";
		Xwin = xWins(sequencePlayed, column);
		assertThat(Xwin, is(false));
		sequencePlayed = "B2, A1, B1, C2, C1, ";
		column = "1";
		Xwin = xWins(sequencePlayed, column);
		assertThat(Xwin, is(false));
	}
	
	@Test public void 
	should_win_O_if_A_row_taken() {
		String sequencePlayed = "B1, A1, B2, A2, C1, A3, ";
		String row = "A";
		boolean Owin = oWins(sequencePlayed, row);
		assertThat(Owin, is(true));
	}
	
	@Test public void 
	should_not_win_O_if_row_taken_by_X() {
		String sequencePlayed = "A1, B1, A2, B2, A3, ";
		String row = "A";
		boolean Owin = oWins(sequencePlayed, row);
		assertThat(Owin, is(false));
	}
	
	private boolean xWins(String sequencePlayed, String searchedChar) {
		return foundFirst(sequencePlayed, searchedChar) 
				&& firstNotTakenByOpponent(sequencePlayed, searchedChar)
				&& foundSecond(sequencePlayed, searchedChar) 
				&& secondNotTakenByOpponent(sequencePlayed, searchedChar) 
				&& foundThird(sequencePlayed, searchedChar) 
				&& thirdNotTakenByOpponent(sequencePlayed, searchedChar);
	}
	
	private boolean oWins(String sequencePlayed, String searchedChar) {
		return !xWins(sequencePlayed, searchedChar) && xWins(sequencePlayed.substring(4), searchedChar);
	}

	private boolean thirdNotTakenByOpponent(String sequencePlayed, String searchedChar) {
		return sequencePlayed.substring(sequencePlayed.indexOf(searchedChar) + 1).substring(sequencePlayed.substring(sequencePlayed.indexOf(searchedChar) + 1).indexOf(searchedChar) + 1).indexOf(searchedChar)%8 != 3;
	}

	private boolean secondNotTakenByOpponent(String sequencePlayed, String searchedChar) {
		int indexOfChar = sequencePlayed.indexOf(searchedChar);
		return sequencePlayed.substring(indexOfChar + 1).indexOf(searchedChar)%8 != 3;
	}

	private boolean firstNotTakenByOpponent(String sequencePlayed, String searchedChar) {
		return sequencePlayed.indexOf(searchedChar)%8 != 4;
	}

	private boolean foundThird(String sequencePlayed, String searchedChar) {
		int indexOfChar1 = sequencePlayed.indexOf(searchedChar);
		String substring1 = sequencePlayed.substring(indexOfChar1 + 1);
		int indexOfChar2 = substring1.indexOf(searchedChar);
		return substring1.substring(indexOfChar2 + 1).indexOf(searchedChar) != -1;
	}

	private boolean foundSecond(String sequencePlayed, String searchedChar) {
		int indexOfChar = sequencePlayed.indexOf(searchedChar);
		return sequencePlayed.substring(indexOfChar + 1).indexOf(searchedChar) != -1;
	}

	private boolean foundFirst(String sequencePlayed, String searchedChar) {
		return sequencePlayed.indexOf(searchedChar) != -1;
	}
	
}
