// RandomArrayFunctionalities Class
// This class is made to practice and expand our 
// knowledge of arrays in Java
//
// Author: Jaemok C. Lee
// Professor: Garen Kutukian
// Date: 20/10/2021
public class RandomArrayFunctionalities{
	/**
	 * This method returns true if set2 is a subset of set1
	 * @param set1 (integer array), set2 (integer array)
	 * @return boolean
	 **/
	public boolean isSubset(int[] set1, int[] set2){
		if(set2.length > set1.length){
			return false;
		}

		boolean[] found = new boolean[set1.length]; // keeps track of found elements in set1
		boolean isFound = false;
		for(int i = 0; i < set2.length; i++){
			for(int j = 0; j < set1.length; j++){
				// to account for duplicates in sets, we must know if an element has already been found
				if(set2[i] == set1[j] && !found[j]){
					found[j] = true;
					isFound = true;
					break; // if element has been found, no need to search rest of set1
				}
			}
			if(!isFound){
				return false; // no need to check rest of set2 if any of its elements can't be found in set1
			}
			isFound = false;
		}

		return true;
	}

	/**
	 * This functions returns a portion of the string
	 * starting from the first len number of characters
	 * @param str (String), len (int)
	 * @return String
	 **/
	public String stringLoop(String str, int len){
		String output = "";
		for(int i = len; i > 0; i--){
			output += str.substring(0, i);
		}

		return output;
	}
}
