public class testingRandomFunctionalities{
	public static void main(String args[]){
		RandomFunctionalities tester1 = new RandomFunctionalities();
		String output;
		int result;
		boolean answer;

		System.out.println("----------------Testing putTogether---------------");
		output = tester1.putTogether("Test", "String");
		System.out.println("***Combining \"Test\" and \"String\"***");
		System.out.println("Expected TestString --- Returned: " + output);
		output = tester1.putTogether("That", "test");
		System.out.println("***Combining \"That\" and \"test\"***");
		System.out.println("Expected Thatest --- Returned: " + output);
		output = tester1.putTogether("", "");
		System.out.println("***Combining \"\" and \"\"***");
		System.out.println("Expected \"\" --- Returned: " + output);
		System.out.println();

		System.out.println("----------------Testing swapThree---------------");
		output = tester1.swapThree("");
		System.out.println("***Testing \"\"***");
		System.out.println("Expected \"\" --- Returned: " + output);
		output = tester1.swapThree("a");
		System.out.println("***Testing on \"a\"***");
		System.out.println("Expected \"a\" --- Returned: " + output);
		output = tester1.swapThree("ab");
		System.out.println("***Testing on \"ba\"***");
		System.out.println("Expected \"ba\" --- Returned: " + output);
		output = tester1.swapThree("abc");
		System.out.println("***Testing on \"cba\"***");
		System.out.println("Expected \"cba\" --- Returned: " + output);
		output = tester1.swapThree("abcd");
		System.out.println("***Testing on \"adcb\"***");
		System.out.println("Expected \"adcb\" --- Returned: " + output);
		System.out.println();

		System.out.println("----------------Testing overEleven---------------");
	  answer = tester1.overEleven(1, 6, 2);
		System.out.println("***Testing on {1, 6, 2}***");
		System.out.println("Expected false --- Returned: " + answer);
		answer = tester1.overEleven(100, 0, 2);
		System.out.println("***Testing on {100, 0 ,2}***");
		System.out.println("Expected true --- Returned: " + answer);
		answer = tester1.overEleven(-11, -1, 0);
		System.out.println("***Testing on {-11, -1 , 0}***");
		System.out.println("Expected true --- Returned: " + answer);
		System.out.println();

		System.out.println("----------------Testing isOdd---------------");
		answer = tester1.isOdd(1);
		System.out.println("***Testing on 1***");
		System.out.println("Expected true --- Returned: " + answer);
		answer = tester1.isOdd(999);
		System.out.println("***Testing on 999***");
		System.out.println("Expected true --- Returned: " + answer);
		answer = tester1.isOdd(34);
		System.out.println("***Testing on 34***");
		System.out.println("Expected false --- Returned: " + answer);
		System.out.println();

		System.out.println("----------------Testing isEven---------------");
		answer = tester1.isEven(2);
		System.out.println("***Testing on 2***");
		System.out.println("Expected true --- Returned: " + answer);
		answer = tester1.isEven(28);
		System.out.println("***Testing on 28***");
		System.out.println("Expected true --- Returned: " + answer);
		answer = tester1.isEven(1003);
		System.out.println("***Testing on 1003***");
		System.out.println("Expected false --- Returned: " + answer);
		System.out.println();

		System.out.println("----------------Testing twentyOne---------------");
		result = tester1.twentyOne(30, 50);
		System.out.println("***Testing on {30, 50}***");
		System.out.println("Expected -1 --- Returned: " + result);
		result = tester1.twentyOne(500, 0);
		System.out.println("***Testing on {500 ,0}***");
		System.out.println("Expected 0 --- Returned: " + result);
		result = tester1.twentyOne(1, 20);
		System.out.println("***Testing on {1, 20}***");
		System.out.println("Expected 20 --- Returned: " + result);
		result = tester1.twentyOne(-1, -2);
		System.out.println("***Testing on {-1, -2}***");
		System.out.println("Expected -1 --- Returned: " + result);
		result = tester1.twentyOne(1, 1);
		System.out.println("***Testing on {1, 1}***");
		System.out.println("Expected -1 --- Returned: " + result);
	}
}
