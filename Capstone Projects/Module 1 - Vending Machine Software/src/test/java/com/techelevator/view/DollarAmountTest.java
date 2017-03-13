package com.techelevator.view;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.techelevator.DollarAmount;

public class DollarAmountTest {

	private DollarAmount dollarAmountTest;
	
	@Before
	public void setUp() {
	 DollarAmount dollarAmountTest = new DollarAmount(400);
	 }
	
	@Test
	public void returnChangeHappyPath(){
		//dollarAmountTest.returnChange();
	}//unclear how to test without refactoring just to make more testable

	@Test 
	public void isValidDollarCorrectlyReturnsTrue() {
		Assert.assertTrue(dollarAmountTest.isValidDollar("1"));
		Assert.assertTrue(dollarAmountTest.isValidDollar("2"));
		Assert.assertTrue(dollarAmountTest.isValidDollar("5"));
		Assert.assertTrue(dollarAmountTest.isValidDollar("10"));
		Assert.assertTrue(dollarAmountTest.isValidDollar("20"));
	}
	
	@Test
	public void isValidDollarCorrectlyReturnsFalse() {
		Assert.assertFalse(dollarAmountTest.isValidDollar("3"));
		Assert.assertFalse(dollarAmountTest.isValidDollar("50"));
		Assert.assertFalse(dollarAmountTest.isValidDollar("Howdy"));
		Assert.assertFalse(dollarAmountTest.isValidDollar("asdjjsdank8i239832"));
		Assert.assertFalse(dollarAmountTest.isValidDollar("1251020"));
	}

}


