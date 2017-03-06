package com.techelevator.view;

import org.junit.Before;
import org.junit.Test;

import com.techelevator.DollarAmount;
import com.techelevator.Product;

import org.junit.Assert;

public class ProductTest {
	private Product productTest;

	@Before
	public void setUp() {
		productTest = new Product("A1", "Potato Crisps", new DollarAmount((int) 3.05 * 100), 5);
	}

	@Test
	public void initializesCorrectly() {
		Assert.assertEquals("A1", productTest.getSlot());
		Assert.assertEquals("Potato Crisps", productTest.getName());
		Assert.assertEquals(new DollarAmount((int) 3.05 * 100), productTest.getPrice());
		Assert.assertEquals(5, productTest.getQuantity());

	}

	@Test
	public void setsCorrectly() {
		productTest.setQuantity(4);
		Assert.assertEquals(4, productTest.getQuantity());

	}

	@Test
	public void decreaseCorrectly() {
		productTest.decreaseQuantity();
		Assert.assertEquals(4, productTest.getQuantity());

	}

	@Test
	public void isOutOfStock() {
		String result = productTest.isSoldOut();
		Assert.assertEquals("5", result);
	}

	@Test
	public void isInStockFour() {

		productTest.decreaseQuantity();
		String result = productTest.isSoldOut();
		Assert.assertEquals("4", result);

	}
}
