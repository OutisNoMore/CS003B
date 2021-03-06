// GameLogic Class
// Contains any logic specific to the Tic Tac Toe game
//
//Author: Jaemok C. Lee
//Professor: Garen Kutukian
//Class: CS 003B
//Date: 10/26/2021
public class GameLogic{
	/*
	 * boolean boardHasWinner
	 * Static method that allows user to check if the board has a winner
	 *
	 * @param board (Board) - board object to check
	 * 				playerToken (char) - player to check if won
	 * 				winningNumber (int) - number in a row required to win
	 * 				row (int) - row position to check
	 * 				col (int) - col position to check
	 * 	@return boolean - true if player has won, false otherwise
	 */
	public static boolean boardHasWinner(Board board, char playerToken, int winningNumber, int row, int col){
		String antiDiagonal = board.getAntiDiagonal(row, col); 
		String diagonal = board.getDiagonals(row, col);
		String column   = board.getColumn(col);
		String currRow  = board.getRow(row);

		// string to check against
		String winningAnswer = "";
		for(int i = 0; i < winningNumber; i++){
			winningAnswer += playerToken + "";
		}

		// check if any of hte diagonals, row, column, or anti diagonals are a winner
		if(antiDiagonal.contains(winningAnswer) ||
			 diagonal.contains(winningAnswer)     ||
			 column.contains(winningAnswer)       ||
			 currRow.contains(winningAnswer)){
			return true;
		}

		return false;
	}

	/*
	 * boolean isDraw
	 * Returns true if there are no more possible moves to make
	 *
	 * @param board (Board) - Tic Tac Toe board to check
	 * @return boolean - true if game is a draw, false otherwise
	 */
	public static boolean isDraw(Board board){
    return board.isFull();
	}
}
