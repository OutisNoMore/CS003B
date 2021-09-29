// This class is made of miscellaneous functions that
// test knowledge of use of if statements
//
// Author: Jaemok C. Lee
// Professor: Garen Kutukian
// Class: CS003B
// Date: 10/04/2021
public class RandomFunctionalities{
	/**
	 * Returns a concatenated string of the two parameters
	 * If last letter of firstWord is the same as first letter of SecondWord
	 * only one instance of the letter is returned
	 * @param firstWord(String), secondWord(String)
	 * @return String
	 **/
	public String putTogether(String firstWord, String secondWord){
		if(firstWord.length() == 0 && secondWord.length() == 0){
			return "";
		}
		if(firstWord.length() == 0){
			return secondWord;
		}
		if(secondWord.length() == 0){
			return firstWord;
		}

		if(firstWord.endsWith(secondWord.substring(0,1))){
			return firstWord + secondWord.substring(1);
		}

		return firstWord + secondWord;
	}

	/**
	 * Returns a string with the last 3 letters reversed
	 * @param word(String)
	 * @return String
	 **/
	public String swapThree(String word){
		if(word.length() < 2){
			return word;
		}
		if(word.length() == 2){
			return word.substring(word.length()-1) + word.substring(0,1);
		}

		char firstChar = word.charAt(word.length()-3);
		char midChar   = word.charAt(word.length()-2);
		char lastChar  = word.charAt(word.length()-1);

		String lastThree = "" + lastChar + midChar + firstChar;

		return word.substring(0, word.length() - 3) + lastThree;
	}

	/**
	 * Returns true if any of the numbers are greater than the other numbers by 11 
	 * false otherwise
	 * @param first(int), second(int), third(int)
	 * @return boolean
	 **/
	public boolean overEleven(int first, int second, int third){
		if(Math.abs(first - second) >= 11 || 
			 Math.abs(first - third)  >= 11 ||
			 Math.abs(second - third) >= 11){
			return true;
		}

		return false;
	}

	/**
	 * Returns true if number is odd, false otherwise
	 * @param number(int)
	 * @return int
	 **/
	public boolean isOdd(int number){
		return (number % 2 == 1);
	}

	/**
	 * Returns true if the number is even, false otherwise
	 * @param number(int)
	 * @return int
	 **/
	public boolean isEven(int number){
		return !isOdd(number);
	}

	/**
	 * Returns the number closer to 21 without going over
	 * If both numbers are over 21 then -1 is returned
	 * @param firstNumber(int), secondNumber(int)
	 * @return int
	 **/
	public int twentyOne(int firstNumber, int secondNumber){
		if((firstNumber > 21 && secondNumber > 21) || (firstNumber == secondNumber)){
			return -1;
		}

		if(firstNumber > 21){
			return secondNumber;
		}
		if(secondNumber > 21){
			return firstNumber;
		}

		if(secondNumber > firstNumber){
			return secondNumber;
		} else{
			return firstNumber;
		}
	}
}
