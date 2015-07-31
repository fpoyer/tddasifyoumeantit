package org.fpoyer.tddasifyoumeantit;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

import org.junit.Test;



public class TicTacToeTest {

	@Test public void 
	should_win_X_if_A_row_taken() {
		String sequencePlayed = "A1, B1, A2, B2, A3, ";
		String row = "A";
		boolean Xwin = xWinsRow(sequencePlayed, row);
		assertThat(Xwin, is(true));
	}

	@Test public void 
	should_win_X_if_B_row_taken() {
		String sequencePlayed = "B1, A1, B2, A2, B3, ";
		String row = "B";
		boolean Xwin = xWinsRow(sequencePlayed, row);
		assertThat(Xwin, is(true));
	}

	@Test public void 
	should_win_X_if_C_row_taken() {
		String sequencePlayed = "C1, A1, C2, A2, C3, ";
		String row = "C";
		boolean Xwin = xWinsRow(sequencePlayed, row);
		assertThat(Xwin, is(true));
	}

	@Test public void 
	should_not_win_X_if_not_all_row_taken() {
		String sequencePlayed = "A1, ";
		String row = "A";
		boolean Xwin = xWinsRow(sequencePlayed, row);
		assertThat(Xwin, is(false));
	}
	
	@Test public void 
	should_win_X_if_column_1_taken() {
		String sequencePlayed = "A1, A2, B1, B2, C1, ";
		String column = "1";
		boolean Xwin = xWinsColumn(sequencePlayed, column);
		assertThat(Xwin, is(true));
	}
	
	@Test public void 
	should_win_X_if_column_2_taken() {
		String sequencePlayed = "A2, A1, B2, B1, C2, ";
		String column = "2";
		boolean Xwin = xWinsColumn(sequencePlayed, column);
		assertThat(Xwin, is(true));
	}
	
	@Test public void 
	should_win_X_if_column_3_taken() {
		String sequencePlayed = "A3, A2, B3, B2, C3, ";
		String column = "3";
		boolean Xwin = xWinsColumn(sequencePlayed, column);
		assertThat(Xwin, is(true));
	}
	
	@Test public void 
	should_not_win_X_if_not_all_column_taken() {
		String sequencePlayed = "A1, ";
		String column = "1";
		boolean Xwin = xWinsColumn(sequencePlayed, column);
		assertThat(Xwin, is(false));
	}
	
	@Test public void 
	should_not_win_X_if_row_taken_by_O() {
		String sequencePlayed = "A1, A2, A3, ";
		String row = "A";
		boolean Xwin = xWinsRow(sequencePlayed, row);
		assertThat(Xwin, is(false));
		sequencePlayed = "A1, B2, A2, A3, ";
		row = "A";
		Xwin = xWinsRow(sequencePlayed, row);
		assertThat(Xwin, is(false));
		sequencePlayed = "A1, B2, A2, B1, C1, A3, ";
		row = "A";
		Xwin = xWinsRow(sequencePlayed, row);
		assertThat(Xwin, is(false));
		sequencePlayed = "B2, A1, A2, C2, A3, ";
		row = "A";
		Xwin = xWinsRow(sequencePlayed, row);
		assertThat(Xwin, is(false));
	}
	
	@Test public void 
	should_not_win_X_if_col_taken_by_O() {
		String sequencePlayed = "A1, B1, C1, ";
		String column = "1";
		boolean Xwin = xWinsColumn(sequencePlayed, column);
		assertThat(Xwin, is(false));
		sequencePlayed = "A1, B2, B1, C1, ";
		column = "1";
		Xwin = xWinsColumn(sequencePlayed, column);
		assertThat(Xwin, is(false));
		sequencePlayed = "A1, B2, B1, A2, A3, C1, ";
		column = "1";
		Xwin = xWinsColumn(sequencePlayed, column);
		assertThat(Xwin, is(false));
		sequencePlayed = "B2, A1, B1, C2, C1, ";
		column = "1";
		Xwin = xWinsColumn(sequencePlayed, column);
		assertThat(Xwin, is(false));
	}
	
	private boolean xWinsRow(String sequencePlayed, String row) {
		int firstIndexOfRow = sequencePlayed.indexOf(row);
		String followingSequence = sequencePlayed.substring(firstIndexOfRow + 1);
		int secondIndexOfRow = followingSequence.indexOf(row);
		String followingSequence2 = followingSequence.substring(secondIndexOfRow + 1);
		int thirdIndexOfRow = followingSequence2.indexOf(row);
		return firstIndexOfRow != -1 && secondIndexOfRow != -1 && thirdIndexOfRow != -1 && secondIndexOfRow%8 != 3 && thirdIndexOfRow%8 != 3;
	}
	
	private boolean xWinsColumn	(String sequencePlayed, String column) {
		int firstIndexOfColumn = sequencePlayed.indexOf(column);
		String followingSequence = sequencePlayed.substring(firstIndexOfColumn + 1);
		int secondIndexOfColumn = followingSequence.indexOf(column);
		String followingSequence2 = followingSequence.substring(secondIndexOfColumn + 1);
		int thirdIndexOfColumn = followingSequence2.indexOf(column);
		return firstIndexOfColumn != -1 && secondIndexOfColumn != -1 && thirdIndexOfColumn != -1 && secondIndexOfColumn%8 != 3 && thirdIndexOfColumn%8 != 3;
	}
}
