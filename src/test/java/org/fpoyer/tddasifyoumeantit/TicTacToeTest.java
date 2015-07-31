package org.fpoyer.tddasifyoumeantit;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

import org.junit.Test;



public class TicTacToeTest {

	@Test public void 
	should_win_X_if_any_row_taken() {
		String sequencePlayed = "A1, B1, A2, B2, A3, ";
		boolean Xwin = VictoryChecker.xWinsRowOrCol(sequencePlayed);
		assertThat(Xwin, is(true));
		sequencePlayed = "B1, A1, B2, A2, B3, ";
		Xwin = VictoryChecker.xWinsRowOrCol(sequencePlayed);
		assertThat(Xwin, is(true));
		sequencePlayed = "C1, A1, C2, A2, C3, ";
		Xwin = VictoryChecker.xWinsRowOrCol(sequencePlayed);
		assertThat(Xwin, is(true));
	}

	@Test public void 
	should_not_win_X_if_not_all_row_taken() {
		String sequencePlayed = "A1, ";
		boolean Xwin = VictoryChecker.xWinsRowOrCol(sequencePlayed);
		assertThat(Xwin, is(false));
	}
	
	@Test public void 
	should_win_X_if_any_column_taken() {
		String sequencePlayed = "A1, A2, B1, B2, C1, ";
		boolean Xwin = VictoryChecker.xWinsRowOrCol(sequencePlayed);
		assertThat(Xwin, is(true));
		sequencePlayed = "A2, A1, B2, B1, C2, ";
		Xwin = VictoryChecker.xWinsRowOrCol(sequencePlayed);
		sequencePlayed = "A3, A2, B3, B2, C3, ";
		Xwin = VictoryChecker.xWinsRowOrCol(sequencePlayed);
		assertThat(Xwin, is(true));
	}
	
	@Test public void 
	should_not_win_X_if_not_all_column_taken() {
		String sequencePlayed = "A1, ";
		boolean Xwin = VictoryChecker.xWinsRowOrCol(sequencePlayed);
		assertThat(Xwin, is(false));
	}
	
	@Test public void 
	should_not_win_X_if_row_taken_by_O() {
		String sequencePlayed = "A1, A2, A3, ";
		boolean Xwin = VictoryChecker.xWinsRowOrCol(sequencePlayed);
		assertThat(Xwin, is(false));
		sequencePlayed = "A1, B2, A2, A3, ";
		Xwin = VictoryChecker.xWinsRowOrCol(sequencePlayed);
		assertThat(Xwin, is(false));
		sequencePlayed = "A1, B2, A2, B1, C1, A3, ";
		Xwin = VictoryChecker.xWinsRowOrCol(sequencePlayed);
		assertThat(Xwin, is(false));
		sequencePlayed = "B2, A1, A2, C2, A3, ";
		Xwin = VictoryChecker.xWinsRowOrCol(sequencePlayed);
		assertThat(Xwin, is(false));
	}
	
	@Test public void 
	should_not_win_X_if_col_taken_by_O() {
		String sequencePlayed = "A1, B1, C1, ";
		boolean Xwin = VictoryChecker.xWinsRowOrCol(sequencePlayed);
		assertThat(Xwin, is(false));
		sequencePlayed = "A1, B2, B1, C1, ";
		Xwin = VictoryChecker.xWinsRowOrCol(sequencePlayed);
		assertThat(Xwin, is(false));
		sequencePlayed = "A1, B2, B1, A2, A3, C1, ";
		Xwin = VictoryChecker.xWinsRowOrCol(sequencePlayed);
		assertThat(Xwin, is(false));
		sequencePlayed = "B2, A1, B1, C2, C1, ";
		Xwin = VictoryChecker.xWinsRowOrCol(sequencePlayed);
		assertThat(Xwin, is(false));
	}
	
	@Test public void 
	should_win_O_if_A_row_taken() {
		String sequencePlayed = "B1, A1, B2, A2, C1, A3, ";
		boolean Owin = VictoryChecker.oWinsRowOrCol(sequencePlayed);
		assertThat(Owin, is(true));
	}
	
	@Test public void 
	should_not_win_O_if_row_taken_by_X() {
		String sequencePlayed = "A1, B1, A2, B2, A3, ";
		boolean Owin = VictoryChecker.oWinsRowOrCol(sequencePlayed);
		assertThat(Owin, is(false));
	}
	
	@Test public void
	should_win_X_if_diagonal_taken() {
		String sequencePlayed = "A1, B1, B2, C2, C3, ";
		boolean Xwin = VictoryChecker.winDiagonal(sequencePlayed);
		assertThat(Xwin, is(true));

		sequencePlayed = "A3, B1, B2, C2, C1, ";
		Xwin = VictoryChecker.winDiagonal(sequencePlayed);
		assertThat(Xwin, is(true));
	}
		
	@Test public void 
	should_declare_draw_if_9_rounds_and_no_winner() {
		String sequencePlayed = "B2, A1, A3, C1, B1, B3, A2, C2, C3, ";
		boolean isDraw = !sequencePlayed.isEmpty()
				&& sequencePlayed.length()
						% VictoryChecker.ROUND_LENGTH_IN_CHAR >= 0
				&& !VictoryChecker.xWinsRowOrCol(sequencePlayed)
				&& !VictoryChecker.winDiagonal(sequencePlayed)
				&& !VictoryChecker.oWinsRowOrCol(sequencePlayed)
				&& !VictoryChecker.winDiagonal(sequencePlayed
						.substring(VictoryChecker.ROUND_LENGTH_IN_CHAR));
		assertThat(isDraw, is(true));
	}
	
	@Test public void 
	should_switch_turn_if_no_winner_and_not_yet_draw() {
		String sequencePlayed = "B2, A1, A3, C1, ";
		boolean isTurnX = false;
		assertThat(isTurnX, is(true));

//		sequencePlayed = "B2, A1, A3, C1, B1, ";
//		boolean isTurnO = false;
//		assertThat(isTurnO, is(true));
	}

}