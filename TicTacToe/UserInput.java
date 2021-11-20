// UserInput class
// Program class that calls all other dependencies. 
// This class is in charge of all user input and output
//
// Author: Jaemok C. Lee
// Professor: Garen Kutukian
// Class: CS 003B
// Date: 10/26/2021
import java.util.Scanner; // user input

public class UserInput{
	// Intro banner for aesthetic game experience
	private static final String introBanner = "----------------------------------------\n" +
									 	    		   	            "Now Playing: Multiplayer Tic-Tac-Toe\n"     +
						                                "----------------------------------------\n\n";
	// ending game banner for aesthetics
	private static final String endBanner   = "----------------------------------------\n" +
		                                        "Game Over\nGood Bye...\n"                   +
																		        "----------------------------------------\n\n";

	/*
	 * void main
	 * Main function is in charge of user input and output
	 *
	 * @param args (String[]) - any command=line parameters
	 * @return none
	 */
	public static void main(String args[]){
		Scanner input = new Scanner(System.in); // scanner to get all user input

		System.out.println(introBanner);                               // prints intro banner
		int numberOfPlayers = getNumberOfPlayers(input);               // gets number of players in the game  
		char[] playerTokens = getPlayerTokens(input, numberOfPlayers); // gets tokens for all players
		int winningNumber = getWinningNumber(input, numberOfPlayers);  // gets the amount requried to win

    // starts a new game with the given information
		Board gameBoard = new Board(numberOfPlayers); // creates new board with given number of players
		int inputRow    = -1; // user input row
		int inputCol    = -1; // user input column
		int realRow     = -1; // corresponding row index of Board
		int realCol     = -1; // corresponding column index of board
		int playerTurn  = 1;  // keeps track of which player's turn 
		while(true){
			// Check if there are no more moves to make
			if(GameLogic.isDraw(gameBoard)){
				System.out.println("\nThe game is a draw\n");
				break;
			}
			// Checks for end of a round
			if(playerTurn == (numberOfPlayers+1)){
				playerTurn = 1;
			}

			// Prints board
			System.out.println(gameBoard);
			System.out.println("Player " + playerTokens[playerTurn-1] + " turn");

      // get row number to place token
      inputRow = getBoardNumber(input, "row", numberOfPlayers);
      if(inputRow == -1){
        continue; // invalid input
      }
      // get column number to place token
      inputCol = getBoardNumber(input, "col", numberOfPlayers);
      if(inputCol == -1){
        continue; // invalid input
      }
			System.out.println();

			// convert from board number to board index
			realRow = Board.toIndex(inputRow); 
			realCol = Board.toIndex(inputCol);
			// checks that position has not been taken yet
			if(!gameBoard.validatePosition(realRow, realCol)){
				System.out.println("Error: Another player has already made that move\nPlease try again\n");
				continue;
			}
			// updates board with player move
			gameBoard.updateBoard(playerTokens[playerTurn-1], realRow, realCol);
			// checks if player is a winner
			if(GameLogic.boardHasWinner(gameBoard, playerTokens[playerTurn-1], winningNumber, realRow, realCol)){
				System.out.println("\nCongratulations!\nPlayer " + playerTokens[playerTurn-1] + " has won.\n");
				break;
			}

			// advances on to next player
			playerTurn++;
		}
		// print winning or draw board
		System.out.println(gameBoard);

		// say good bye and close scanner
		System.out.println(endBanner);
		input.close();
	}

	/*
	 * int getNumberOfPlayers
	 * Prompts user for the number of players in the game
	 *
	 * @param sc (Scanner) - input stream to get input from
	 * @return int - number of players
	 */
	private static int getNumberOfPlayers(Scanner sc){
		int numberOfPlayers;
		while(true){
			System.out.print("Number of players? (Please enter a number between 3 and 10) ");
		
			// check that input is a number
			if(!sc.hasNextInt()){
				sc.nextLine(); // clear input buffer
				System.out.println("\nError: Input must be a whole number\nPlease try again");
				continue;
			}
			numberOfPlayers = sc.nextInt();

			// check that it is the right number of players
			if(numberOfPlayers < 3 || numberOfPlayers > 10){
				sc.nextLine(); // clear input buffer
				System.out.println("\nError: Input must be between 3 and 10\nPlease try again");
				continue;
			}
			System.out.println();
			break;
		}

		return numberOfPlayers;
	}

	/*
	 * char[] getPlayerTokens
	 * Gets the tokens of all players
	 *
	 * @param sc (Scanner) - input stream to read from
	 * 				numberOfPlayers (int) - number of players
	 * @return - char[] - array of all player tokens
	 */
	private static char[] getPlayerTokens(Scanner sc, int numberOfPlayers){
		sc.nextLine(); // clear input buffer
		char [] playerTokens = new char[numberOfPlayers];
		String input = "";
		int count = 1;

		while(count <= numberOfPlayers){
			System.out.print("Player " + count + " please enter your symbol (must be a single character): ");
			
			input = sc.nextLine();

			// check that input is a single character
			if(input.length() != 1){
				System.out.println("\nError: Input must be a single character\nPlease try again");
				continue;
			}
			// check that input is not a letter
			if(!input.matches("[A-Z]|[a-z]")){
				System.out.println("\nError: Input must be a letter\nPlease try again");
				continue;
			}
			
			// check that token is not already taken
			boolean badToken = false;
			for(int i = count - 1; i > 0; i--){
				if(playerTokens[i-1] == input.charAt(0)){
					System.out.println("Error: Character has already been taken\nPlease try again");
					badToken = true;
					break;
				}
			}
			if(badToken){
				continue;
			}
			System.out.println();

			playerTokens[count-1] = input.charAt(0);
			count++;
		}

		return playerTokens;
	}

	/*
	 * int getWinningNumber
	 * Gets the number required to win the game
	 *
	 * @param sc (Scanner) - input stream to read from
	 * 				numberOfPlayers (int) - number of players in game
	 * 	@return int - continuous number of tokens required to win
	 */
	private static int getWinningNumber(Scanner sc, int numberOfPlayers){
		int winningNumber;

		while(true){
			System.out.print("Please choose how many pieces in a row, column, or diagonal are required to win (must be between 3 and " + (numberOfPlayers + 1) + ") ");
			// Check that input is a number
			if(!sc.hasNextInt()){
				sc.nextLine(); // clear input buffer
				System.out.println("\nError: Input must be a number\nPlease try again");
				continue;
			}
			winningNumber = sc.nextInt();
			// check that input is not out of bounds
			if(winningNumber <  3 || winningNumber > (numberOfPlayers + 1)){
				sc.nextLine(); // clear input buffer
				System.out.println("\nError: Input must be between 3 and " + (numberOfPlayers+1) + "\nPlease try again");
				continue;
			}
			break;
		}

		return winningNumber;
	}

	/*
	 * int getBoardNumber 
	 * Gets the row or column number to place a character's token
	 *
	 * @param sc (Scanner) - input stream to read from
   *        position (String) - row or column
	 * 				numberOfPlayers (int) - number of players in game
	 * 	@return int - row or column number
	 */
  private static int getBoardNumber(Scanner sc, String position, int numberOfPlayers){
    int input = -1;
	  // Prompts user for number
		System.out.print("Please enter " + position + " number: ");
		// checks if input is a number
		if(!sc.hasNextInt()){
			sc.nextLine(); // clear input buffer
			System.out.println("\nError: input must be a number\nPlease try again\n");
			return -1; // return error
		}
		input = sc.nextInt();
		// checks that input is not out of bounds
		if(input < 0 || input > numberOfPlayers){
			System.out.println("\nError: input is out of bounds\nPlease try again\n");
		  return -1; // return error
		}

    return input;
  }
}
