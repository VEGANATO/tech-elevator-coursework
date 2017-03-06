package com.techelevator;

public class Product {

	private String slot;
	private String name;
	private DollarAmount price;
	private int quantity;

	public Product(String slot, String name, DollarAmount price, int quantity) {
		this.slot = slot;
		this.name = name;
		this.price = price;
		this.quantity = quantity;
	}

	public String getSlot() {
		return slot;
	}

	public String getName() {
		return name;
	}

	public DollarAmount getPrice() {
		return price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;

	}

	public void decreaseQuantity() {
		quantity--;

	}

	public String isSoldOut() {
		if (quantity == 0) {
			return "SOLD OUT";
		} else {
			return Integer.toString(quantity);
		}
	}

	@Override
	public String toString() {
		String formattedLogLine = String.format("%1$-5s %2$-25s %3$-10s %4$-20s", slot, name, price, isSoldOut());

		return formattedLogLine;
	}

}
