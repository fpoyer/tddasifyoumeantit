package org.fpoyer.tddasifyoumeantit;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

import org.junit.Test;



public class TicTacToeTest {

	@Test public void 
	should_win_X_if_row_taken() {
		boolean Xwin = "A1, B1, A2, B2, A3".startsWith("A");
		assertThat(Xwin, is(true));
	}
}
