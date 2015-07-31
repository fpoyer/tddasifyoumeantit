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
	should_not_win_X_if_less_than_5_rounds() {
		String sequencePlayed = "";
		String row = null;
		boolean Xwin = wins(sequencePlayed, row);
		assertThat(Xwin, is(false));
	}
	
	private boolean wins(String sequencePlayed, String row) {
		return sequencePlayed.startsWith(row);
	}
	
}
