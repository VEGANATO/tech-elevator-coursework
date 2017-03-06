package com.techelevator.shoppingcart;

/**
 * This class represents a shopping cart that you can add different priced items to.  
 */
public class ShoppingCart {

	//
	// Add any properties, along with getters and/or setters, that may be needed to implements the class methods and/or constructors.
	//
	
	private int totalNumberOfItems;
	private double totalAmountOwed;
	private double averagePricePerItem;
	
	public ShoppingCart() {
		totalNumberOfItems = 0;
		totalAmountOwed = 0.0;
		averagePricePerItem = getAveragePricePerItem();
	}
	
	/**
	 * Adds items to the cart.
	 * 
	 * @param numberOfItems the number of items being added to the cart
	 * @param pricePerItem the price per item being added to the cart
	 */
	public void addItems(int numberOfItems, double pricePerItem) {
		if (numberOfItems > 0 || pricePerItem > 0.0) {
			int newItemTotal = totalNumberOfItems + numberOfItems;
			setTotalNumberOfItems(newItemTotal);
			
			double newAmountOwed = totalAmountOwed + (numberOfItems * pricePerItem);
			setTotalAmountOwed(newAmountOwed);
		} else {
			System.out.println("Input invalid. Please, no negative numbers!");
		}
	}
	
	/**
	 * @return the total number of items that have been added to this cart
	 */
	public int getTotalNumberOfItems() {
		return totalNumberOfItems;
	}
	
	public void setTotalNumberOfItems(int totalNumberOfItems) {
		if (totalNumberOfItems > this.totalNumberOfItems) {
			this.totalNumberOfItems = totalNumberOfItems;
		}
	}
	
	/**
	 * @return the total price of all items that have been added to the cart
	 */
	public double getTotalAmountOwed() {
		return totalAmountOwed;
	}
	
	public void setTotalAmountOwed(double totalAmountOwed) {
		if (totalAmountOwed >= 0) {
			this.totalAmountOwed = totalAmountOwed;
		}
	}
	
	/**
	 * The average price of all items that have been added to the cart.  This should be equal to 
	 * the totalAmountOwed divided by the totalNumberOfItems.
	 * 
	 * @return the average price of items added to the cart
	 */
	public double getAveragePricePerItem() {
		if (totalNumberOfItems < 1) {
			return 0.0;
		}
		
		return totalAmountOwed / totalNumberOfItems;
	}

	/**
	 * Removes all items from this cart.
	 */
	public void empty() {
		totalNumberOfItems = 0;
		totalAmountOwed = 0;
	}
}
