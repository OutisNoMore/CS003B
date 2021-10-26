import java.util.ArrayList;

public class Board{
	private ArrayList<ArrayList<Character>> board = new ArrayList<ArrayList<Character>>();
	private int boardSize;
	
	public Board(int boardSize){
		this.boardSize = boardSize;
		initializeBoard(boardSize);
	}

	private void initializeBoard(int boardSize){

	}

	public String boardToString(){
		String output = "";

		for(int i = 0; i < boardSize; i++){
			for(int j = 0; j < boardSize; j++){
				output += board.get(i).get(j) + "";
			}
			output += "\n";
		}

		return output;
	}

	public void updateBoard(char playerToken, int x, int y){
		if(validatePosition(x, y)){
			board.get(x).set(y, playerToken);
		}
	}

	private boolean validatePosition(int x, int y){
		return false;
	}

	private boolean validateXPosition(int x, int y){
		if(x < 0 || x > boardSize){
			return false;
		}
		if(board.get(x).get(y) != 0){
			return false;
		}

		return true;
	}

	private boolean validateYPosition(int y, int x){
		if(y < 0 || y > boardSize){
			return false;
		}

		if(board.get(x).get(y) != 0){
			return false;
		}

		return true;
	}
}
