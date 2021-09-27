// CashRegister Class
// A new object that represents a cash register that can process transactions
//
// Professor: Garen Kutukian
// Class: CS003B 
// Author: Jaemok C. Lee
// Date: 09/25/2021

import java.util.Date; 

public class CashRegister{
	private static double allCashRegistersTotals; // total amount processed by all registers
	private static int allCashRegistersItems;     // total number of items sold on all registers

	private double cashRegisterTotal;             // total amount processed by single register object
	private int itemCount;                        // total number of items processed

	private Date currentDate;                     // current date

	/**
	 * Constructor - initializes new CashRegister object with values initialized to 0
	 * @param NULL
	 **/
	public CashRegister(){
		itemCount = 0;
		cashRegisterTotal = 0.0;
		allCashRegistersTotals = 0.0;
		allCashRegistersItems = 0;

		currentDate = new Date();
	}

	/**
	 * Mutator - adds new item to count and updates cash register totals
	 * @param price
	 * @return void
	 **/
	public void addItem(double price){
		itemCount = itemCount + 1;
		cashRegisterTotal = cashRegisterTotal + price;
		allCashRegistersTotals = allCashRegistersTotals + price;
		allCashRegistersItems = allCashRegistersItems + 1;
	}

	/**
	 * Mutator - remove item and its given price
	 * @param price
	 * @return void
	 **/
	public void removeItem(double price){
		// can't remove object if there aren't any in the first place
		if(itemCount > 0){
			itemCount = itemCount - 1;
			cashRegisterTotal = cashRegisterTotal - price;
			allCashRegistersTotals = allCashRegistersTotals - price;
			allCashRegistersItems = allCashRegistersItems - 1;
		}
	}

	/**
	 * Mutator - resets all instance variables to 0
	 * @param NULL
	 * @return void
	 **/
	public void clear(){
		itemCount = 0;
		cashRegisterTotal = 0.0;
	}

	/**
	 * Mutator - updates date to the current date
	 * @param NULL
	 * @return void
	 **/
	public void newDay(){
		currentDate = new Date();
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

	/**
	 * Accessor - returns total items sold by all registers
	 * @param NULL
	 * @return int
	 **/
	public int getAllCashRegisterItem(){
		return allCashRegistersItems;
	}

	/**
	 * Accessor - returns a summary of the day's sales as a String
	 * @param NULL
	 * @return String
	 **/
	public String getEndOfDayReport(){
		String output;
		output = "------------------Start Report-------------------\n\n";
		output = output + "Date: " + currentDate + "\n";
		output = output + "Total Items Sold: " + itemCount + "\n";
		output = output + "Cash Register Total: " + cashRegisterTotal + "\n";
		output = output + "All Cash Register Total: " + allCashRegistersTotals + "\n";
		output = output + "All Cash Register Items Sold: " + allCashRegistersItems + "\n\n";
		output = output + "--------------------End of Report--------------------\n";

		return output;
	}
}
