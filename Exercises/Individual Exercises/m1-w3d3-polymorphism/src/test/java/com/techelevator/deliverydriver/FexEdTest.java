package com.techelevator.deliverydriver;

import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;

public class FexEdTest {
	FexEd testFexEd;
	
	@Before
	public void setup() {
		testFexEd =  new FexEd(340, 15);
	}
	
	@Test
	public void initialize_correctly() {
		Assert.assertEquals(340, testFexEd.getDistanceInMiles());
		Assert.assertEquals(15, testFexEd.getWeightInOunces());
		Assert.assertEquals(20.00, testFexEd.calculateRate(testFexEd.getDistanceInMiles(), testFexEd.getWeightInOunces()), 0.009);
		Assert.assertEquals("FexEd                           $20.00", testFexEd.toString());
	}
	
	@Test
	public void calculate_rate_under_500_miles_under_48_ounces() {
		FexEd testAgain = new FexEd(450, 30);
		
		Assert.assertEquals(20.00, testAgain.calculateRate(testAgain.getDistanceInMiles(), testAgain.getWeightInOunces()), 0.009);
	}
	
	@Test
	public void calculate_rate_under_500_miles_over_48_ounces() {
		FexEd testAgain = new FexEd(450, 50);
		
		Assert.assertEquals(23.00, testAgain.calculateRate(testAgain.getDistanceInMiles(), testAgain.getWeightInOunces()), 0.009);
	}
	
	@Test
	public void calculate_rate_over_500_miles_under_48_ounces() {
		FexEd testAgain = new FexEd(501, 47);
		
		Assert.assertEquals(25.00, testAgain.calculateRate(testAgain.getDistanceInMiles(), testAgain.getWeightInOunces()), 0.009);
	}
	
	@Test
	public void calculate_rate_over_500_miles_over_48_ounces() {
		FexEd testAgain = new FexEd(501, 49);
		
		Assert.assertEquals(28.00, testAgain.calculateRate(testAgain.getDistanceInMiles(), testAgain.getWeightInOunces()), 0.009);
	}
}
