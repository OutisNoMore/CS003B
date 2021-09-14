public class UsingCashRegister{
	public static void main(String[] args){
		CashRegister testRegister1 = new CashRegister();
		CashRegister testRegister2 = new CashRegister();

		testRegister1.addItem(4.99);
		testRegister1.addItem(1.95);
		System.out.println(testRegister1.getCashRegisterTotal()); // should be 6.94
		System.out.println(testRegister1.getCount()); // should be 2

		testRegister1.removeItem(0.50);
		System.out.println(testRegister1.getCashRegisterTotal()); // should be 6.44
		System.out.println(testRegister1.getCount()); // should be 1
	}
}
