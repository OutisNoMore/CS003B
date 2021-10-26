// Board Class - creates a 2 dimensional board of characters to play Tic Tac Toe on
//               can update and return properties of the board
//
//Author: Jaemok C. Lee
//Professor: Garen Kutukian
//Class: CS 003B
//Date: 10/26/2021
public class Board{
	private char[][] board; // 2D array of characters 
	private int boardSize;  // Size of the board

	/**************
	 * CONSTRUTOR *
	 **************/

	/*
	 *	Board
	 *	Creates a new board object and initializes it as an empty board
	 *
	 *	@param numberOfPlayers(int) - determines board size
	 *	@return none
	 */
	public Board(int numberOfPlayers){
		boardSize = numberOfPlayers*2 + 4;
		board = new char[boardSize][boardSize];

		initializeBoard(boardSize);
	}

	/***********
	 * MUTATOR *
	 ***********/

	/*
	 * void initializeBoard
	 * creates an empty 2D board with given size
	 *
	 * @param boardSize(int) - size of the board to initialize
	 * @return none
	 */
	private void initializeBoard(int boardSize){
		board[0][0] = ' '; // corner piece is always empty
		// initialize first row with column numbers
		for(int i = 1; i < boardSize; i++){
			if(i%2 == 0){ 
				board[0][i] = (char)((i/2) - 1 + 48);
			} else{
				board[0][i] = '|'; 
			}
		}

		// initialize first column with row numbers
		for(int j = 1; j < boardSize; j++){
			if(j%2 == 0){
				board[j][0] = (char)((j/2) - 1 + 48);
			} else{
				board[j][0] = '-';
			}
		}

		// fill in rest of board with spaces or separators
		for(int i = 1; i < boardSize; i++){
			if(i%2 == 0){
				for(int j = 1; j < boardSize; j++){
					if(j%2 == 1){
						board[i][j] = '|';
					} else{
						board[i][j] = ' ';
					}
				}
			} 
			else{ 
				for(int j = 1; j < boardSize; j++){
					board[i][j] = '-';
				}
			}
		}
	}

	/*
	 * void updateBord
	 * Add a player move to the board if valid
	 *
	 * @param playerToken (char) - player symbol
	 * 				row (int) - player row 
	 * 				col (int) - player column
	 * @return none
	 */
	public void updateBoard(char playerToken, int row, int col){
		if(validatePosition(row, col)){
			board[row][col] = playerToken;
		}
	}

	/*************
	 * ACCESSORS *
	 *************/

	/*
	 * int getBoardSize
	 * Returns the size of the board
	 *
	 * @param none
	 * @return int - size of the board
	 */
	public int getBoardSize(){
		return boardSize;
	}

	/*
	 * boolean validatePosition
	 * Checks if given row and column is a valid move
	 *
	 * @param row (int) - given player row
	 * 				col (int) - given player column
	 */
	public boolean validatePosition(int row, int col){
		// check if another player has already made move
		if(board[row][col] != ' '){
			return false;
		}
		
		// check that given values are not out of bound
		if((row < 0 || row > boardSize) || 
			 (col < 0 || col > boardSize)){
			return false;
		}

		return true;
	}

	/*
	 * String getRow
	 * Returns the given row of the board as a string
	 *
	 * @param row (int) - index of row to return
	 * @return String - row as a string
	 */
	public String getRow(int row){
		String stringRow = "";
		// skip the separators
		for(int i = 2; i < board.length; i += 2){
			stringRow += board[row][i] + "";
		}

		// make sure that output only contains player tokens
		// strips all separators, or spaces
		return onlyTokens(stringRow);
	}

	/*
	 * String getColumn
	 * Returns the given column of the board as a string
	 *
	 * @param col (int) - index of column to return
	 * @return String - col as string
	 */
	public String getColumn(int col){
		String column = "";
		// skip all separators
		for(int i = 2; i < board.length; i += 2){
			column += board[i][col] + "";
		}

		// format output so that only player tokens remain
		return onlyTokens(column);
	}

	/*
	 * String getAntiDiagonal
	 * Returns the antidiagonal containing the given position as a string
	 *
	 * @param row (int) - index of row position
	 * 				col (int) - index of column position
	 * @return - String - anti diagonal as a string
	 */
	public String getAntiDiagonal(int row, int col){
		String antiDiagonal = "";

		// for the upper triangular half of the board
		if((row + col) <= board.length){
			int currRow = Math.abs(row + col) - 2; // fird the first row position to start at
			// get the diagonal beginning at the row
				for(int c = 2; currRow > 1 && c < board.length; c += 2, currRow -= 2){
					antiDiagonal += board[currRow][c] + "";
				}
		}
		// for the lower triangualr half of the board
		else{
			// find the first column position to begin
			int currCol = Math.abs(row - col) + 2;
			// get the diagonal starting at the column
			for(int r = board.length - 1; currCol < board.length && r > 1; currCol += 2, r -= 2){
				antiDiagonal += board[r][currCol] + "";
			}
		}

		// format output so only tokens remain
		return onlyTokens(antiDiagonal);
	}

	/*
	 * String getDiagonal
	 * Returns the diagonal containing the given position as a string
	 *
	 * @param row (int) - index of row position
	 * 				col (int) - index of column position
	 * @return - String - diagonal as a string
	 */
	public String getDiagonals(int row, int col){
		String diagonal = "";

		// for the upper triangular half of board
		if(col >= row){
			// position of column to start at
			int currCol = (col-row) + 2; 
			// get the diagonal starting at the calculated column
			for(int r = 2; currCol < board.length; r += 2, currCol += 2){
				diagonal += board[r][currCol] + "";
			}
		} 
		// for the lower triangular half of the board
		else{
			// calculate first row index to start at
			int currRow = (row-col) + 2;
			// get diagonal starting at calculated row
			for(int c = 2; currRow < board.length; c += 2, currRow += 2){
				diagonal += board[currRow][c] + "";
			}
		}

		// format output so that only player tokens remain
		return onlyTokens(diagonal);
	}

	/*
	 * String onlyTokens
	 * Formats string so that no more separators or empty spaces are returned
	 *
	 * @param str (String) - string to format
	 * @return String - formatted string
	 */
	private String onlyTokens(String str){
		String output = "";
		// ignore all separators or spaces
		for(int i = 0; i < str.length(); i++){
			if(str.charAt(i) != '|' && 
				 str.charAt(i) != '-' && 
				 str.charAt(i) != ' ' ){
				output += str.substring(i, i+1) + "";
			}
		}

		return output;
	}

	/*
	 * String toString
	 * Override toString function so that board gets printed
	 *
	 * @param none
	 * @return String - board as a string
	 */
	@Override
	public String toString(){
		String output = "";

		for(int i = 0; i < boardSize; i++){
			for(int j = 0; j < boardSize; j++){
				output += board[i][j] + "";
			}
			output += "\n";
		}

		return output;
	}
}
