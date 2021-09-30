// Class RandomFunctionalities2
// This class holds random functions that test our knowledge 
// of loops.
//
// Author: Jaemok C. Lee
// Professor: Garen Kutukian
// Class: CS003B
// Date: 10/09/2021
public class RandomFunctionalities2{
	/**
	 * This function accepts two strings and mixes them
	 * together. 
	 *
	 * @param String firstWord, String secondWord
	 * @return String
	 **/
	public String mixWords(String firstWord, String secondWord){
		if(firstWord.length() == 0 && secondWord.length() == 0){
			return firstWord;
		}
		if(firstWord.length() == 0){
			return secondWord;
		}
		if(secondWord.length() == 0){
			return firstWord;
		}

		return firstWord.substring(0, 1) + secondWord.substring(0, 1) + mixWords(firstWord.substring(1), secondWord.substring(1));
	}

	/**
	 * This function accepts a string and rearranes
	 * the string in groups of three. 
	 *
	 * @param String word
	 * @return String
	 **/
	public String switcheroo(String word){
		if(word.length() < 3){
			return word;
		}

		return word.substring(1, 3) + word.substring(0, 1) + switcheroo(word.substring(3));
	}

	/**
	 * This function accepts a string and returns the 
	 * longest set of letters that appears at both the
	 * beginning and end.
	 * 
	 * @param String word
	 * @return String
	 **/
	public String longestSet(String word){
		if(word.length() == 1){
			return word;
		}

		String output  = "";		
		for(int i = 1; i <= word.length()/2; i++){
			if(word.substring(0, i).equals(word.substring(word.length() - i))){
				output = word.substring(0, i);
			}
		}

		return output;
	}
}
