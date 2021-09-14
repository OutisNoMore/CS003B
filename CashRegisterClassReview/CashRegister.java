// CashRegister Class
// A new object that represents a cash register that can process transactions
//
// Professor: Garen Kutukian
// Author: Jaemok C. Lee
// Date: 09/13/2021
public class CashRegister{
	private static double allCashRegistersTotals; // total amount processed by all registers
	private double cashRegisterTotal;						  // total amount processed by single register object
	private int itemCount; 												// total number of items processed

	/**
	 * Constructor - initializes new CashRegister object with values initialized to 0
	 * @param NULL
	 **/
	public CashRegister(){
		itemCount = 0;
		cashRegisterTotal = 0.0;
		allCashRegistersTotals = 0.0;
	}

	/**
	 * Mutator - adds new item to count and updates cash register totals
	 * @param price
	 * @return void
	 **/
	public void addItem(double price){
		itemCount = itemCount + 1;
		cashRegisterTotal = cashRegisterTotal + price;
		allCashRegistersTotals = allCashRegistersTotals - price;
	}

	/**
	 * Mutator - remove item and its given price
	 * @param price
	 * @return void
	 **/
	public boolean removeItem(double price){
		// can't remove object if there aren't any in the first place
		if(itemCount > 0){
			itemCount = itemCount - 1;
			cashRegisterTotal = cashRegisterTotal - price;
			allCashRegistersTotals = allCashRegistersTotals - price;
			return true;
		}

		return false;
	}
	
	/**
	 * Mutator - resets all instance variables to 0
	 * @param NULL
	 * @return void
	 **/
	public void clear(){
		itemCount = 0;
		cashRegisterTotal = 0.0;
		allCashRegistersTotals = 0.0;
	}

	/**
	 * Accessor - return total amount processed by single CashRegister
	 * @param NULL
	 * @return double
	 **/
	public double getCashRegisterTotal(){
		return cashRegisterTotal;
	}

	/**
	 * Accessor - returns total number of items processed by object
	 * @param NULL
	 * @return int
	 **/
	public int getCount(){
		return itemCount;
	}

	/**
	 * Accessor - returns total processed by all cash registers
	 * @param NULL
	 * @return double
	 **/
	public double getAllCashRegisterTotal(){
		return allCashRegistersTotals;
	}
}
