import java.util.Scanner;
import java.util.ArrayList;

public class UserInput{
	private final String banner = "----------------------------------------\n" +
									 	    			  "Now Playing: Multiplayer Tic-Tac-Toe\n"     +
						                    "----------------------------------------\n\n";

	public static void main(String args[]){
		Scanner input = new Scanner(System.in);
		boolean inGame = true;

		System.out.println(banner);
		int numberOfPlayers = getNumberOfPlayers(input);
		char[] playerTokens = getPlayerTokens(input, numberOfPlayers);
		int winningNumber = getWinningNumber(input, numberOfPlayers);

		Board gameBoard = new Board(numberOfPlayers);
		int playerTurn = 1;
		int x = -1;
		int y = -1;
		while(true){
			if(playerTurn > numberOfPlayers){
				playerTurn = 1;
			}

			System.out.println("Player " + playerTurn + " turn");
			System.out.print("Please enter a X coordinate: ");
			if(!input.hasNextInt()){
				input.nextLine();
				System.out.println("\nError: input must be a number\nPlease try again\n");
				continue;
			}
			x = input.nextInt();
			if(x < 0 || x > (numberOfPlayers+1)){
				System.out.println("\nError: input is out of bounds\nPlease try again\n");
				continue;
			}
			System.out.print("Please enter a Y coordinate: ");
			if(!input.hasNextInt()){
				input.nextLine();
				System.out.println("\nError: input must be a number\nPlease try again\n");
				continue;
			}
			y = input.nextInt();
			if(y < 0 || y > (numberOfPlayers+1)){
				System.out.println("\nError: input is out of bounds\nPlease try again\n");
				continue;
			}

			if(!gameBoard.validatePosition(x, y)){
				System.out.println("Error: Another player has already made that move\nPlease try again");
			}
			gameBoard.updateBoard(playerTokens[playerTurn-1], x, y);
			if(GameLogic.boardHasSolution(gameBoard, playerTokens[playerTurn-1], x, y)){
				// Game won
				break;
			}
			playerTurn++;
		}
		// Game draw

		input.close();
	}

	private static String printIntro(){
		String output = "";
		output = "----------------------------------------\n" +
						 "Now Playing: Multiplayer Tic-Tac-Toe\n"     +
						 "----------------------------------------\n\n";

		return output;
	}

	private static int getNumberOfPlayers(Scanner sc){
		while(true){
			System.out.print("Number of players? (Please enter a number between 2 and 7) ");
			
			if(!sc.hasNextInt()){
				sc.nextLine();
				System.out.println("\nError: Input must be a whole number\nPlease try again");
				continue;
			}
			int numberOfPlayers = sc.nextInt();

			if(numberOfPlayers < 2 || numberOfPlayers > 7){
				System.out.println("\nError: Input must be between 2 and 7\nPlease try again");
			}
		}
	}

	private static char[] getPlayerTokens(Scanner sc, int numberOfPlayers){
		char [] playerTokens = new char[numberOfPlayers];
		String regex = "";
		int count = 1;

		while(count <= numberOfPlayers){
			System.out.print("Player " + count + " please enter your symbol (must be a single character): ");
			
			if(!sc.hasNext(regex)){
				sc.nextLine();
				System.out.println("\nError: Input must be a character\nPlease try again");
				continue;
			}
			System.out.println();

			playerTokens[count-1] = sc.next().charAt(0);
			count++;
		}

		return playerTokens;
	}

	private static int getWinningNumber(Scanner sc, int numberOfPlayers){
		int winningNumber;

		while(true){
			System.out.print("Please choose how many pieces in a row, column, or diagonal are required to win (must be between 3 and " + (numberOfPlayers + 1) + "): ");
			if(!sc.hasNextInt()){
				sc.nextLine();
				System.out.println("\nError: Input must be a number\nPlease try again");
				continue;
			}
			winningNumber = sc.nextInt();
			if(winningNumber < 3 || winningNumber > (numberOfPlayers + 1)){
				System.out.println("\nError: Input must be between 3 and " + (numberOfPlayers + 1) + "\nPlease try again");
				continue;
			}
			break;
		}

		return winningNumber;
	}

	private static int getX(Scanner sc){

	}

	private static int getY(Scanner sc){

	}
}
