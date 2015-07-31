package org.fpoyer.tddasifyoumeantit;

public class VictoryChecker {

	private static final String COORDINATE_TEMPLATE = "XY, ";

	private static final int ROUND_LENGTH_IN_CHAR = COORDINATE_TEMPLATE
			.length();
	private static final int TWO_ROUND_LENGTH_IN_CHAR = 2 * ROUND_LENGTH_IN_CHAR;

	private static boolean checkFor(String sequencePlayed, String position) {
		boolean found = sequencePlayed.indexOf(position) != -1;
		boolean notTakenByOpponent = sequencePlayed.indexOf(position)
				% TWO_ROUND_LENGTH_IN_CHAR != ROUND_LENGTH_IN_CHAR;
		boolean checked = found && notTakenByOpponent;
		return checked;
	}

	private static boolean checkOneDiagonal(String sequencePlayed) {
		return checkFor(sequencePlayed, "A1") && checkFor(sequencePlayed, "B2")
				&& checkFor(sequencePlayed, "C3");
	}

	private static boolean checkTheOtherDiagonal(String sequencePlayed) {
		return checkFor(sequencePlayed, "A3") && checkFor(sequencePlayed, "B2")
				&& checkFor(sequencePlayed, "C1");
	}

	private static boolean firstNotTakenByOpponent(String sequencePlayed,
			String searchedChar) {
		return sequencePlayed.indexOf(searchedChar) % TWO_ROUND_LENGTH_IN_CHAR != ROUND_LENGTH_IN_CHAR;
	}

	private static boolean foundFirst(String sequencePlayed, String searchedChar) {
		return sequencePlayed.indexOf(searchedChar) != -1;
	}

	private static boolean foundSecond(String sequencePlayed,
			String searchedChar) {
		int indexOfChar = sequencePlayed.indexOf(searchedChar);
		return sequencePlayed.substring(indexOfChar + 1).indexOf(searchedChar) != -1;
	}

	private static boolean foundThird(String sequencePlayed, String searchedChar) {
		int indexOfChar1 = sequencePlayed.indexOf(searchedChar);
		String substring1 = sequencePlayed.substring(indexOfChar1 + 1);
		int indexOfChar2 = substring1.indexOf(searchedChar);
		return substring1.substring(indexOfChar2 + 1).indexOf(searchedChar) != -1;
	}

	public static boolean oWinsRowOrCol(String sequencePlayed,
			String searchedChar) {
		return !VictoryChecker.xWinsRowOrCol(sequencePlayed, searchedChar)
				&& VictoryChecker.xWinsRowOrCol(
						sequencePlayed.substring(ROUND_LENGTH_IN_CHAR),
						searchedChar);
	}

	private static boolean secondNotTakenByOpponent(String sequencePlayed,
			String searchedChar) {
		int indexOfChar = sequencePlayed.indexOf(searchedChar);
		return sequencePlayed.substring(indexOfChar + 1).indexOf(searchedChar)
				% TWO_ROUND_LENGTH_IN_CHAR != 3;
	}

	private static boolean thirdNotTakenByOpponent(String sequencePlayed,
			String searchedChar) {
		return sequencePlayed
				.substring(sequencePlayed.indexOf(searchedChar) + 1)
				.substring(
						sequencePlayed.substring(
								sequencePlayed.indexOf(searchedChar) + 1)
								.indexOf(searchedChar) + 1)
				.indexOf(searchedChar)
				% TWO_ROUND_LENGTH_IN_CHAR != 3;
	}

	public static boolean winDiagonal(String sequencePlayed) {
		return VictoryChecker.checkOneDiagonal(sequencePlayed)
				|| VictoryChecker.checkTheOtherDiagonal(sequencePlayed);
	}

	public static boolean xWinsRowOrCol(String sequencePlayed) {
		return xWinsRowOrCol(sequencePlayed, "A")
				|| xWinsRowOrCol(sequencePlayed, "B")
				|| xWinsRowOrCol(sequencePlayed, "C")
				|| xWinsRowOrCol(sequencePlayed, "1")
				|| xWinsRowOrCol(sequencePlayed, "2")
				|| xWinsRowOrCol(sequencePlayed, "3");
	}

	private static boolean xWinsRowOrCol(String sequencePlayed,
			String searchedChar) {
		return foundFirst(sequencePlayed, searchedChar)
				&& firstNotTakenByOpponent(sequencePlayed, searchedChar)
				&& foundSecond(sequencePlayed, searchedChar)
				&& secondNotTakenByOpponent(sequencePlayed, searchedChar)
				&& foundThird(sequencePlayed, searchedChar)
				&& thirdNotTakenByOpponent(sequencePlayed, searchedChar);
	}

}
