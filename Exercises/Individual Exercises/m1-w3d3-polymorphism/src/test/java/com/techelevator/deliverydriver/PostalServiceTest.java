package com.techelevator.deliverydriver;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PostalServiceTest {
	PostalService testPost;
	
	@Before
	public void setup() {
		testPost =  new PostalService(340, 15, 1);
	}
	
	@Test
	public void initialize_correctly_first_class() {
		Assert.assertEquals(340, testPost.getDistanceInMiles());
		Assert.assertEquals(15, testPost.getWeightInOunces());
		Assert.assertEquals(1, testPost.getMailClass());
		Assert.assertEquals("Postal Service (1st Class)      $15.98", testPost.toString());
	}
	
	@Test
	public void initialize_correctly_second_class() {
		PostalService testPostToo = new PostalService(340, 15, 2);
		
		Assert.assertEquals(340, testPostToo.getDistanceInMiles());
		Assert.assertEquals(15, testPostToo.getWeightInOunces());
		Assert.assertEquals(2, testPostToo.getMailClass());
		Assert.assertEquals("Postal Service (2nd Class)      $1.65", testPostToo.toString());
	} 
	
	@Test
	public void initialize_correctly_third_class() {
		PostalService testPostToo = new PostalService(340, 15, 3);
		
		Assert.assertEquals(340, testPostToo.getDistanceInMiles());
		Assert.assertEquals(15, testPostToo.getWeightInOunces());
		Assert.assertEquals(3, testPostToo.getMailClass());
		Assert.assertEquals("Postal Service (3rd Class)      $0.84", testPostToo.toString());
	}
	
	@Test
	public void calculate_rate_first_class_2_ounces() {
		PostalService testPostToo = new PostalService(340, 2, 1);

		Assert.assertEquals(11.90, testPostToo.calculateRate(testPostToo.getDistanceInMiles(), testPostToo.getWeightInOunces()), 0.009);
	}
	
	@Test
	public void calculate_rate_first_class_8_ounces() {
		PostalService testPostToo = new PostalService(340, 8, 1);

		Assert.assertEquals(13.60, testPostToo.calculateRate(testPostToo.getDistanceInMiles(), testPostToo.getWeightInOunces()), 0.009);
	}
	
	@Test
	public void calculate_rate_first_class_15_ounces() {
		PostalService testPostToo = new PostalService(340, 15, 1);

		Assert.assertEquals(15.98, testPostToo.calculateRate(testPostToo.getDistanceInMiles(), testPostToo.getWeightInOunces()), 0.009);
	}
	
	@Test
	public void calculate_rate_first_class_16_ounces() {
		PostalService testPostToo = new PostalService(340, 16, 1);

		Assert.assertEquals(66.30, testPostToo.calculateRate(testPostToo.getDistanceInMiles(), testPostToo.getWeightInOunces()), 0.009);
	}
	
	@Test
	public void calculate_rate_first_class_142_ounces() {
		PostalService testPostToo = new PostalService(340, 142, 1);

		Assert.assertEquals(153.00, testPostToo.calculateRate(testPostToo.getDistanceInMiles(), testPostToo.getWeightInOunces()), 0.009);
	}
	
	@Test
	public void calculate_rate_first_class_144_ounces() {
		PostalService testPostToo = new PostalService(340, 144, 1);

		Assert.assertEquals(170.00, testPostToo.calculateRate(testPostToo.getDistanceInMiles(), testPostToo.getWeightInOunces()), 0.009);
	}
	
	@Test
	public void calculate_rate_second_class_2_ounces() {
		PostalService testPostToo = new PostalService(340, 2, 2);

		Assert.assertEquals(1.19, testPostToo.calculateRate(testPostToo.getDistanceInMiles(), testPostToo.getWeightInOunces()), 0.009);
	}
	
	@Test
	public void calculate_rate_second_class_8_ounces() {
		PostalService testPostToo = new PostalService(340, 8, 2);

		Assert.assertEquals(1.36, testPostToo.calculateRate(testPostToo.getDistanceInMiles(), testPostToo.getWeightInOunces()), 0.009);
	}
	
	@Test
	public void calculate_rate_second_class_15_ounces() {
		PostalService testPostToo = new PostalService(340, 15, 2);

		Assert.assertEquals(1.59, testPostToo.calculateRate(testPostToo.getDistanceInMiles(), testPostToo.getWeightInOunces()), 0.009);
	}
	
	@Test
	public void calculate_rate_second_class_16_ounces() {
		PostalService testPostToo = new PostalService(340, 16, 2);

		Assert.assertEquals(6.63, testPostToo.calculateRate(testPostToo.getDistanceInMiles(), testPostToo.getWeightInOunces()), 0.009);
	}
	
	@Test
	public void calculate_rate_second_class_142_ounces() {
		PostalService testPostToo = new PostalService(340, 142, 2);

		Assert.assertEquals(15.30, testPostToo.calculateRate(testPostToo.getDistanceInMiles(), testPostToo.getWeightInOunces()), 0.009);
	}
	
	@Test
	public void calculate_rate_second_class_144_ounces() {
		PostalService testPostToo = new PostalService(340, 144, 2);

		Assert.assertEquals(17.00, testPostToo.calculateRate(testPostToo.getDistanceInMiles(), testPostToo.getWeightInOunces()), 0.009);
	}
	
	@Test
	public void calculate_rate_third_class_2_ounces() {
		PostalService testPostToo = new PostalService(340, 2, 3);

		Assert.assertEquals(0.68, testPostToo.calculateRate(testPostToo.getDistanceInMiles(), testPostToo.getWeightInOunces()), 0.009);
	}
	
	@Test
	public void calculate_rate_third_class_8_ounces() {
		PostalService testPostToo = new PostalService(340, 8, 3);

		Assert.assertEquals(0.74, testPostToo.calculateRate(testPostToo.getDistanceInMiles(), testPostToo.getWeightInOunces()), 0.009);
	}
	
	@Test
	public void calculate_rate_third_class_15_ounces() {
		PostalService testPostToo = new PostalService(340, 15, 3);

		Assert.assertEquals(0.81, testPostToo.calculateRate(testPostToo.getDistanceInMiles(), testPostToo.getWeightInOunces()), 0.009);
	}
	
	@Test
	public void calculate_rate_third_class_16_ounces() {
		PostalService testPostToo = new PostalService(340, 16, 3);

		Assert.assertEquals(5.10, testPostToo.calculateRate(testPostToo.getDistanceInMiles(), testPostToo.getWeightInOunces()), 0.009);
	}
	
	@Test
	public void calculate_rate_third_class_142_ounces() {
		PostalService testPostToo = new PostalService(340, 142, 3);

		Assert.assertEquals(5.44, testPostToo.calculateRate(testPostToo.getDistanceInMiles(), testPostToo.getWeightInOunces()), 0.009);
	}
	
	@Test
	public void calculate_rate_third_class_144_ounces() {
		PostalService testPostToo = new PostalService(340, 144, 3);

		Assert.assertEquals(5.78, testPostToo.calculateRate(testPostToo.getDistanceInMiles(), testPostToo.getWeightInOunces()), 0.009);
	}
	

}
