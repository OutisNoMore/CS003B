import java.util.Date;

public class UsingCashRegister{

	public static void Wait(double seconds){
		Date baseTime = new Date();
		while(((new Date()).getTime() - baseTime.getTime()) < seconds*1000);
	}

	public static void main(String[] args){
		CashRegister testRegister1 = new CashRegister();
		CashRegister testRegister2 = new CashRegister();

		testRegister1.addItem(4.99);
		System.out.println("Purchasing item with price of 4.99");
		testRegister1.addItem(1.95);
		System.out.println("Purchasing item with price of 1.95");
		System.out.println("Printing Cash Register Total...");
		System.out.println("Expecting 6.94 --- Received " + testRegister1.getCashRegisterTotal()); // should be 6.94
		System.out.println("Printing total items sold");
		System.out.println("Expecting 2 ---  Received " + testRegister1.getCount());               // should be 2

		testRegister1.removeItem(0.50);
		System.out.println("Removing 0.50 from total");

		System.out.println("Printing Cash Register Total...");
		System.out.println("Expecting 6.44 ---  Received " + testRegister1.getCashRegisterTotal());    // should be 6.44
		System.out.println("Printing Cash Register Total items sold...");
		System.out.println("Expecting 1 ---  Received " + testRegister1.getCount());                   // should be 1
		System.out.println("Printing all Cash Register Total...");
		System.out.println("Expecting 6.44 ---  Received " + testRegister1.getAllCashRegisterTotal()); // should be 6.44
		System.out.println("Printing all Cash Register Total items sold...");
		System.out.println("Expecting 1 ---  Received " + testRegister1.getAllCashRegisterItem());     // should be 1
		System.out.println("Printing end of day report for first cash register");
		System.out.println(testRegister1.getEndOfDayReport());

		testRegister2.addItem(15.95);
		System.out.println("Purchasing item with price 15.95");
		testRegister2.addItem(22.99);
		System.out.println("Purchasing item with price 22.99");
		testRegister2.addItem(1.99);
		System.out.println("Purchasing item with price 1.99");
		testRegister2.addItem(33.95);
		System.out.println("Purchasing item with price 33.95");

		System.out.println("Printing Cash Register Total...");
		System.out.println("Expecting 74.88 ---  Received " + testRegister2.getCashRegisterTotal()); // should be 74.88
		System.out.println("Printing Cash Register Total items sold...");
		System.out.println("Expecting 4 ---  Received " + testRegister2.getCount());                 // should be 4

		testRegister2.removeItem(1.99);
		System.out.println("Removing 1.99 from Cash Register Total...");

		System.out.println("Printing Cash Register Total...");
		System.out.println("Expecting 72.89 ---  Received " + testRegister2.getCashRegisterTotal());    // should be 72.89
		System.out.println("Printing Cash Register Total items sold...");
		System.out.println("Expecting 3 ---  Received " + testRegister2.getCount());                    // should be 3
		System.out.println("Printing Cash Register Total...");
		System.out.println("Expecting 79.33 ---  Received " + testRegister2.getAllCashRegisterTotal()); // should be 79.33
		System.out.println("Test: " + CashRegister.getAllCashRegisterTotal());
		System.out.println("Printing Cash Register Total items sold...");
		System.out.println("Expecting 4 ---  Received " + testRegister2.getAllCashRegisterItem());      // should be 4
		System.out.println(testRegister2.getEndOfDayReport());

		System.out.printf("Waiting %.2f seconds\n", 5.00);
		Wait(5); // wait 10 seconds
		System.out.println("Updating to current time");
		testRegister2.newDay();//	check that new date changed to current date and time
		System.out.println(testRegister2.getEndOfDayReport());
	}
}
