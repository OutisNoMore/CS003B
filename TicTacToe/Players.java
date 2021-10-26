public class Players{
	private char[] playerTokens;
	private int numberOfPlayers;

	public Players(char[] playerTokens, int numberOfPlayers){
		this.playerTokens = playerTokens;
		this.numberOfPlayers = numberOfPlayers;
	}

	public void setPlayerToken(char newToken, int playerIndex){
		playerTokens[playerIndex] = newToken;
	}

	public char getPlayerToken(int playerIndex){
		return playerTokens[playerIndex];
	}
}
