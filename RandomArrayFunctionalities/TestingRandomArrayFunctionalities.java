import java.util.Scanner;

public class TestingRandomArrayFunctionalities{
	/**
	 * Returns the number of integers in the given string
	 * @param str (String)
	 * @return int
	 **/
	public static int numberOfInts(String str){
		int count = 0;
		for(int i = 0; i < str.length(); i++){
			if(Character.isDigit(str.charAt(i))){
				count++;
			}
		}

		return count;
	}

	/**
	 * Fill array with numbers from string
	 * @param string (String), arr(int[])
	 * @return none
	 **/
	public static void stringToInt(String string, int[] arr){
		int arrayIndex = 0;
		for(int i = 0; i < string.length() && arrayIndex < arr.length; i++){
			if(Character.isDigit(string.charAt(i))){
				arr[arrayIndex++] = string.charAt(i) - '0';
			}
		}
	}

	public static void main(String args[]){
		RandomArrayFunctionalities tester1 = new RandomArrayFunctionalities();
		Scanner sc = new Scanner(System.in);

		System.out.println("-------------------Testing Random Array Functionalities------------\n");
		System.out.println("Please enter a set of integers");
		String stringSet1 = sc.nextLine();
		int[] set1 = new int[numberOfInts(stringSet1)];
		stringToInt(stringSet1, set1); // initialize array

		System.out.println("Please enter another set of integers");
		String stringSet2 = sc.nextLine();
		int[] set2 = new int[numberOfInts(stringSet2)];
		stringToInt(stringSet2, set2); // initialize array
		System.out.println();

		System.out.println(stringSet2);
		if(tester1.isSubset(set1, set2)){
			System.out.print("is a ");
		} else{
			System.out.print("is not a ");
		}
		System.out.println("subset of\n" + stringSet1);

		System.out.println("\nPlease enter a string");
		String string = sc.nextLine();
		System.out.println("Please enter a number less than the length of the string given");
		int length = sc.nextInt();

		if(length > 0 && length <= string.length()){
			System.out.println("Iteratively looping down starting from the first " + length + " characters of " + string);
			System.out.println(tester1.stringLoop(string, length));
		} else if (length <= 0){
			System.out.println("Invalid input: Number cannot be negative\nQuitting program...");
		} else{
			System.out.println("Invalid input: Number is greater than string length\nQuitting program...");
		}
		
		sc.close();
	}
}
