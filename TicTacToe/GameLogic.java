public class GameLogic{
	public static boolean boardHasSolution(String[][] board, String playerToken, int winningNumber, int x, int y){
		String diagonal = getDiagonals(board, x, y);
		String column   = getColumn(board, y);
		String row      = getRow(board, x);

		String winningAnswer = "";
		for(int i = 0; i < winningNumber; i++){
			winningAnswer += playerToken;
		}
		if(diagonal.contains(winningAnswer) ||
			 column.contains(winningAnswer)   ||
			 row.contains(winningAnswer)){
			return true;
		}

		return false;
	}

	public static String getDiagonals(String[][] board, int x, int y){
		

		return false;
	}

	public static String getColumn(String[][] board, int y){
		String column = "";
		for(int i = 1; i < board.size(); i++){
			column += board[i][y];
		}

		return column;
	}

	public static String getRow(String[][] board, int x){
		String row = "";
		for(int i = 1; i < board.size(); i++){
			row += board[x][i];
		}

		return row;
	}
}
