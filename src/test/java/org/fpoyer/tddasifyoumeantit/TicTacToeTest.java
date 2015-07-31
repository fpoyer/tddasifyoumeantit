package org.fpoyer.tddasifyoumeantit;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

import org.junit.Test;



public class TicTacToeTest {

	@Test public void 
	should_win_X_if_A_row_taken() {
		String sequencePlayed = "A1, B1, A2, B2, A3, ";
		String row = "A";
		boolean Xwin = xWinsRowOrCol(sequencePlayed, row);
		assertThat(Xwin, is(true));
	}

	@Test public void 
	should_win_X_if_B_row_taken() {
		String sequencePlayed = "B1, A1, B2, A2, B3, ";
		String row = "B";
		boolean Xwin = xWinsRowOrCol(sequencePlayed, row);
		assertThat(Xwin, is(true));
	}

	@Test public void 
	should_win_X_if_C_row_taken() {
		String sequencePlayed = "C1, A1, C2, A2, C3, ";
		String row = "C";
		boolean Xwin = xWinsRowOrCol(sequencePlayed, row);
		assertThat(Xwin, is(true));
	}

	@Test public void 
	should_not_win_X_if_not_all_row_taken() {
		String sequencePlayed = "A1, ";
		String row = "A";
		boolean Xwin = xWinsRowOrCol(sequencePlayed, row);
		assertThat(Xwin, is(false));
	}
	
	@Test public void 
	should_win_X_if_column_1_taken() {
		String sequencePlayed = "A1, A2, B1, B2, C1, ";
		String column = "1";
		boolean Xwin = xWinsRowOrCol(sequencePlayed, column);
		assertThat(Xwin, is(true));
	}
	
	@Test public void 
	should_win_X_if_column_2_taken() {
		String sequencePlayed = "A2, A1, B2, B1, C2, ";
		String column = "2";
		boolean Xwin = xWinsRowOrCol(sequencePlayed, column);
		assertThat(Xwin, is(true));
	}
	
	@Test public void 
	should_win_X_if_column_3_taken() {
		String sequencePlayed = "A3, A2, B3, B2, C3, ";
		String column = "3";
		boolean Xwin = xWinsRowOrCol(sequencePlayed, column);
		assertThat(Xwin, is(true));
	}
	
	@Test public void 
	should_not_win_X_if_not_all_column_taken() {
		String sequencePlayed = "A1, ";
		String column = "1";
		boolean Xwin = xWinsRowOrCol(sequencePlayed, column);
		assertThat(Xwin, is(false));
	}
	
	@Test public void 
	should_not_win_X_if_row_taken_by_O() {
		String sequencePlayed = "A1, A2, A3, ";
		String row = "A";
		boolean Xwin = xWinsRowOrCol(sequencePlayed, row);
		assertThat(Xwin, is(false));
		sequencePlayed = "A1, B2, A2, A3, ";
		row = "A";
		Xwin = xWinsRowOrCol(sequencePlayed, row);
		assertThat(Xwin, is(false));
		sequencePlayed = "A1, B2, A2, B1, C1, A3, ";
		row = "A";
		Xwin = xWinsRowOrCol(sequencePlayed, row);
		assertThat(Xwin, is(false));
		sequencePlayed = "B2, A1, A2, C2, A3, ";
		row = "A";
		Xwin = xWinsRowOrCol(sequencePlayed, row);
		assertThat(Xwin, is(false));
	}
	
	@Test public void 
	should_not_win_X_if_col_taken_by_O() {
		String sequencePlayed = "A1, B1, C1, ";
		String column = "1";
		boolean Xwin = xWinsRowOrCol(sequencePlayed, column);
		assertThat(Xwin, is(false));
		sequencePlayed = "A1, B2, B1, C1, ";
		column = "1";
		Xwin = xWinsRowOrCol(sequencePlayed, column);
		assertThat(Xwin, is(false));
		sequencePlayed = "A1, B2, B1, A2, A3, C1, ";
		column = "1";
		Xwin = xWinsRowOrCol(sequencePlayed, column);
		assertThat(Xwin, is(false));
		sequencePlayed = "B2, A1, B1, C2, C1, ";
		column = "1";
		Xwin = xWinsRowOrCol(sequencePlayed, column);
		assertThat(Xwin, is(false));
	}
	
	@Test public void 
	should_win_O_if_A_row_taken() {
		String sequencePlayed = "B1, A1, B2, A2, C1, A3, ";
		String row = "A";
		boolean Owin = oWinsRowOrCol(sequencePlayed, row);
		assertThat(Owin, is(true));
	}
	
	@Test public void 
	should_not_win_O_if_row_taken_by_X() {
		String sequencePlayed = "A1, B1, A2, B2, A3, ";
		String row = "A";
		boolean Owin = oWinsRowOrCol(sequencePlayed, row);
		assertThat(Owin, is(false));
	}
	
	@Test public void
	should_win_X_if_diagonal_taken() {
		String sequencePlayed = "A1, B1, B2, C2, C3, ";
		boolean Xwin = xWinDiagonal(sequencePlayed);
		assertThat(Xwin, is(true));

		sequencePlayed = "A3, B1, B2, C2, C1, ";
		Xwin = xWinDiagonal(sequencePlayed);
		assertThat(Xwin, is(true));
	}

	private boolean xWinDiagonal(String sequencePlayed) {
		return checkOneDiagonal(sequencePlayed) || checkTheOtherDiagonal(sequencePlayed);
	}

	private boolean checkOneDiagonal(String sequencePlayed) {
		return checkFor(sequencePlayed, "A1") && checkFor(sequencePlayed, "B2") && checkFor(sequencePlayed, "C3");
	}

	private boolean checkTheOtherDiagonal(String sequencePlayed) {
		return checkFor(sequencePlayed, "A3") && checkFor(sequencePlayed, "B2") && checkFor(sequencePlayed, "C1");
	}

	private boolean checkFor(String sequencePlayed, String position) {
		boolean c3Found = sequencePlayed.indexOf(position) != -1;
		boolean c3NotTakenByOpponent = sequencePlayed.indexOf(position) % 8 != 4;
		boolean c3Checked = c3Found && c3NotTakenByOpponent;
		return c3Checked;
	}

	private boolean xWinsRowOrCol(String sequencePlayed, String searchedChar) {
		return foundFirst(sequencePlayed, searchedChar) 
				&& firstNotTakenByOpponent(sequencePlayed, searchedChar)
				&& foundSecond(sequencePlayed, searchedChar) 
				&& secondNotTakenByOpponent(sequencePlayed, searchedChar) 
				&& foundThird(sequencePlayed, searchedChar) 
				&& thirdNotTakenByOpponent(sequencePlayed, searchedChar);
	}
	
	private boolean oWinsRowOrCol(String sequencePlayed, String searchedChar) {
		return !xWinsRowOrCol(sequencePlayed, searchedChar) && xWinsRowOrCol(sequencePlayed.substring(4), searchedChar);
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
