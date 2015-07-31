package org.fpoyer.tddasifyoumeantit;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

import org.junit.Test;



public class TicTacToeTest {

	@Test public void 
	should_win_X_if_A_row_taken() {
		boolean Xwin = "A1, B1, A2, B2, A3".startsWith("A");
		assertThat(Xwin, is(true));
	}
	
	@Test public void 
	should_win_X_if_B_row_taken() {
		boolean Xwin = "B1, A1, B2, A2, B3".startsWith("B");
		assertThat(Xwin, is(true));
	}
}
