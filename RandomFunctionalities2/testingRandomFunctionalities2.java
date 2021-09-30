// Class testingRandomFunctionalities2
// This class tests all functions of the RandomFunctionalities2 class
//
// Author: Jaemok C. Lee
// Professor: Garen Kutukian
// Class: CS003B
// Date: 10/09/2021
public class testingRandomFunctionalities2{
	public static void main(String args[]){
		RandomFunctionalities2 tester = new RandomFunctionalities2();
		String output;

		System.out.println("----------------Testing mixWords---------------");
		output = tester.mixWords("Test", "String");
		System.out.println("***Combining \"Test\" and \"String\"***");
		System.out.println("Expected TSetsrting --- Returned: " + output);
		output = tester.mixWords("abc", "abc");
		System.out.println("***Combining \"abc\" and \"abc\"***");
		System.out.println("Expected aabbcc --- Returned: " + output);
		output = tester.mixWords("", "");
		System.out.println("***Combining \"\" and \"\"***");
		System.out.println("Expected \"\" --- Returned: " + output);
		output = tester.mixWords("ab", "");
		System.out.println("***Combining \"ab\" and \"\"***");
		System.out.println("Expected \"ab\" --- Returned: " + output);
		output = tester.mixWords("", "a");
		System.out.println("***Combining \"\" and \"a\"***");
		System.out.println("Expected \"a\" --- Returned: " + output);
		System.out.println();

		System.out.println("----------------Testing switcheroo---------------");
		output = tester.switcheroo("");
		System.out.println("***Testing \"\"***");
		System.out.println("Expected \"\" --- Returned: " + output);
		output = tester.switcheroo("a");
		System.out.println("***Testing on \"a\"***");
		System.out.println("Expected \"a\" --- Returned: " + output);
		output = tester.switcheroo("abc");
		System.out.println("***Testing on \"abc\"***");
		System.out.println("Expected \"bca\" --- Returned: " + output);
		output = tester.switcheroo("abcdefgh");
		System.out.println("***Testing on \"abcdefgh\"***");
		System.out.println("Expected \"bcaefdgh\" --- Returned: " + output);
		output = tester.switcheroo("abcdef");
		System.out.println("***Testing on \"abcdef\"***");
		System.out.println("Expected \"bcaefd\" --- Returned: " + output);
		System.out.println();

		System.out.println("----------------Testing longestSet---------------");
	  output = tester.longestSet("abcaaaaaaaaaabc");
		System.out.println("***Testing on \"abcaaaaaaaaabc\"***");
		System.out.println("Expected abc --- Returned: " + output);
	  output = tester.longestSet("abcaaaaaaaaaabd");
		System.out.println("***Testing on \"abcaaaaaaaaabd\"***");
		System.out.println("Expected \"\" --- Returned: " + output);
	  output = tester.longestSet("abcdddabxabcdddabx");
		System.out.println("***Testing on \"abcdddabxabcdddabx\"***");
		System.out.println("Expected abcdddabx --- Returned: " + output);
	  output = tester.longestSet("abcdddabxzabcdddabx");
		System.out.println("***Testing on \"abcdddabxzabcdddabx\"***");
		System.out.println("Expected abcdddabx --- Returned: " + output);
		output = tester.longestSet("a");
		System.out.println("***Testing on \"a\"***");
		System.out.println("Expected \"a\" --- Returned: " + output);
		output = tester.longestSet("aba");
		System.out.println("***Testing on \"aba\"***");
		System.out.println("Expected \"a\" --- Returned: " + output);
		System.out.println();
	}
}
