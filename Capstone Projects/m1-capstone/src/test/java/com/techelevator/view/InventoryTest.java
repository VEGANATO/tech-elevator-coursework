package com.techelevator.view;

import org.junit.Before;
import org.junit.Test;

import com.techelevator.DollarAmount;
import com.techelevator.Inventory;
import com.techelevator.Product;

import org.junit.Assert;

public class InventoryTest {
	private Inventory invTest;
	
	@Before
	public void setup() {
		invTest = new Inventory();
	}
	
	@Test
	public void initializeCorrectly() {
		
		//Assert.assertEquals(new Product("A1", "Potato Crisps", new DollarAmount(30500), 5), invTest.getProductBySlotKey("A1"));
		Assert.assertEquals(0, invTest.getInventorySize());
	}
	
	@Test
	public void stockInventoryProperly() {
		invTest.stockInventory();
		
		Assert.assertEquals("A1", invTest.getProductBySlotKey("A1").getSlot());
		Assert.assertEquals("Potato Crisps", invTest.getProductBySlotKey("A1").getName());
		Assert.assertEquals(305, invTest.getProductBySlotKey("A1").getPrice().getTotalAmountInCents());
		Assert.assertEquals(5, invTest.getProductBySlotKey("A1").getQuantity());
		Assert.assertEquals("D4", invTest.getProductBySlotKey("D4").getSlot());
		Assert.assertEquals("Triplemint", invTest.getProductBySlotKey("D4").getName());
		Assert.assertEquals(75, invTest.getProductBySlotKey("D4").getPrice().getTotalAmountInCents());
		Assert.assertEquals(5, invTest.getProductBySlotKey("D4").getQuantity());
		Assert.assertEquals(16, invTest.getInventorySize());
	}
	
	
	@Test
	public void getAttributesPotatoCrisps() {
		Product potatoCrisps = invTest.getAttributes("A1|Potato Crisps|3.05");
		
		Assert.assertEquals("Potato Crisps", potatoCrisps.getName());
		Assert.assertEquals("A1", potatoCrisps.getSlot());
		Assert.assertEquals(305, potatoCrisps.getPrice().getTotalAmountInCents());
		Assert.assertEquals(5, potatoCrisps.getQuantity());
	}
	
	@Test
	public void getAttributesMountainMelter() {
		Product mountainMelter = invTest.getAttributes("C3|Mountain Melter|1.50");
		
		Assert.assertEquals("Mountain Melter", mountainMelter.getName());
		Assert.assertEquals("C3", mountainMelter.getSlot());
		Assert.assertEquals(150, mountainMelter.getPrice().getTotalAmountInCents());
		Assert.assertEquals(5, mountainMelter.getQuantity());
	}
	
	@Test
	public void isValidProductSlotKeyWorksProperly() {
		
		Assert.assertTrue(invTest.isValidProductSlotKey("A1"));
		Assert.assertTrue(invTest.isValidProductSlotKey("B2"));
		Assert.assertTrue(invTest.isValidProductSlotKey("C3"));
		Assert.assertTrue(invTest.isValidProductSlotKey("D4"));
		
		Assert.assertFalse(invTest.isValidProductSlotKey("D5"));
		Assert.assertFalse(invTest.isValidProductSlotKey("5D"));
		Assert.assertFalse(invTest.isValidProductSlotKey("!@#$@!#%@!%"));
		Assert.assertFalse(invTest.isValidProductSlotKey("The maze is not for you..."));
		
		//AssertionError
		//Assert.assertFalse(invTest.isValidProductSlotKey("d3"));
		//Assert.assertFalse(invTest.isValidProductSlotKey("A1asdsdfas"));
	}
	
	@Test
	public void selectedProductInStockWorksProperlyWhenInStock() {
		invTest.stockInventory();
		
		Assert.assertTrue(invTest.selectedProductInStock("A1"));
		Assert.assertTrue(invTest.selectedProductInStock("B2"));
		Assert.assertTrue(invTest.selectedProductInStock("C3"));
		Assert.assertTrue(invTest.selectedProductInStock("D4"));
		
		//NullPointerExceptions
		//Assert.assertFalse(invTest.selectedProductInStock("D5"));
		//Assert.assertFalse(invTest.selectedProductInStock("c6"));
		//Assert.assertFalse(invTest.selectedProductInStock("A1sgadfshds"));
		//Assert.assertFalse(invTest.selectedProductInStock("b3"));
	}
	
	@Test
	public void selectedProductInStockWorksProperlyWhenOutOfStock() {
		invTest.stockInventory();
		Product testProduct = invTest.getProductBySlotKey("A1");
		testProduct.setQuantity(0);
		
		Assert.assertFalse(invTest.selectedProductInStock("A1"));
		
	}
	
	@Test
	public void selectProductBySlotReturnsProperDollarArmountOnSuccessfulTransaction() {
		invTest.stockInventory();
		DollarAmount testAmount = invTest.selectProductBySlot("A1", new DollarAmount(500));
		
		Assert.assertEquals(195, testAmount.getTotalAmountInCents());
		
		DollarAmount testAmount2 = invTest.selectProductBySlot("D4", testAmount);
		
		Assert.assertEquals(120, testAmount2.getTotalAmountInCents());
		
		//How to prepare test for a time when slots change, products, prices changes?
		
	}
	
}
