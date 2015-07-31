package org.fpoyer.tddasifyoumeantit;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

import org.junit.Test;



public class TicTacToeTest {

	@Test public void 
	should_win_X_if_A_row_taken() {
		String sequencePlayed = "A1, B1, A2, B2, A3,";
		String row = "A";
		boolean Xwin = wins(sequencePlayed, row);
		assertThat(Xwin, is(true));
	}

	@Test public void 
	should_win_X_if_B_row_taken() {
		String sequencePlayed = "B1, A1, B2, A2, B3,";
		String row = "B";
		boolean Xwin = wins(sequencePlayed, row);
		assertThat(Xwin, is(true));
	}

	@Test public void 
	should_win_X_if_C_row_taken() {
		String sequencePlayed = "C1, A1, C2, A2, C3,";
		String row = "C";
		boolean Xwin = wins(sequencePlayed, row);
		assertThat(Xwin, is(true));
	}

	@Test public void 
	should_not_win_X_if_not_all_row_taken() {
		String sequencePlayed = "A1";
		String row = "A";
		boolean Xwin = wins(sequencePlayed, row);
		assertThat(Xwin, is(false));
	}
	
	@Test public void 
	should_win_X_if_column_1_taken() {
		String sequencePlayed = "A1, A2, B1, B2, C1";
		String column = "1";
		boolean Xwin = xWinsColumn(sequencePlayed, column);
		assertThat(Xwin, is(true));
	}
	
	private boolean wins(String sequencePlayed, String row) {
		int firstIndexOfRow = sequencePlayed.indexOf(row);
		String followingSequence = sequencePlayed.substring(firstIndexOfRow + 1);
		int secondIndexOfRow = followingSequence.indexOf(row);
		String followingSequence2 = followingSequence.substring(secondIndexOfRow + 1);
		int thirdIndexOfRow = followingSequence2.indexOf(row);
		return firstIndexOfRow != -1 && secondIndexOfRow != -1 && thirdIndexOfRow != -1;
	}
	
}
