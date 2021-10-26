import java.util.ArrayList;

public class Board{
	private String[][] board;
		//ArrayList<ArrayList<Character>> board = new ArrayList<ArrayList<Character>>();
	private int boardSize;
	
	public Board(int numberOfPlayers){
		boardSize = numberOfPlayers*2 + 4;
		board = new String[boardSize][boardSize];

		initializeBoard(boardSize);
	}

	private void initializeBoard(int boardSize){
		board[0][0] = " ";
		for(int i = 1; i < boardSize; i++){
			if(i%2 == 0){
				board[0][i] = Integer.toString((i/2) - 1) + " ";
			} else{
				board[0][i] = "|";
			}
		}

		for(int j = 1; j < boardSize; j++){
			if(j%2 == 0){
				board[j][0] = Integer.toString((j/2) - 1) + " ";
			} else{
				board[j][0] = "-";
			}
		}

		for(int i = 1; i < boardSize; i++){
			if(i%2 == 0){
				for(int j = 1; j < boardSize; j++){
					if(j%2 == 1){
						board[i][j] = "|";
					}
				}
			} 
			else{
				for(int j = 1; j < boardSize; j++){
					board[i][j] = "-";
				}
			}
		}
	}

	public String boardToString(){
		String output = "";

		for(int i = 0; i < boardSize; i++){
			for(int j = 0; j < boardSize; j++){
				output += board[i][j];
			}
			output += "\n";
		}

		return output;
	}

	public void updateBoard(char playerToken, int x, int y){
		if(validatePosition(x, y)){
			board[x][y] = playerToken + "";
		}
	}

	private boolean validatePosition(int x, int y){
		return false;
	}

	private boolean validateXPosition(int x, int y){
		if(x < 0 || x > boardSize){
			return false;
		}
		if(board[x][y].size != 0){
			return false;
		}

		return true;
	}

	private boolean validateYPosition(int y, int x){
		if(y < 0 || y > boardSize){
			return false;
		}

		if(board[x][y].size != 0){
			return false;
		}

		return true;
	}
}
