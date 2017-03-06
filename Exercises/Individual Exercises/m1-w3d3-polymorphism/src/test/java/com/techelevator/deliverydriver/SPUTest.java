package com.techelevator.deliverydriver;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SPUTest {
	SPU testSPU;
	
	@Before
	public void setup() {
		testSPU =  new SPU(340, 15, 1);
	}
	
	@Test
	public void initialize_correctly() {
		Assert.assertEquals(340, testSPU.getDistanceInMiles());
		Assert.assertEquals(15, testSPU.getWeightInOunces());
		Assert.assertEquals(1, testSPU.getMailClass());
		Assert.assertEquals("SPU (next-day)                  $23.91", testSPU.toString());
	}
	
	@Test
	public void calculate_rate_next_day_shipping() {
		Assert.assertEquals(23.90, testSPU.calculateRate(testSPU.getDistanceInMiles(), testSPU.getWeightInOunces()), 0.009);
	}
	
	@Test
	public void calculate_rate_2_day_business() {
		SPU testSPUToo = new SPU(340, 15, 2);
		
		Assert.assertEquals(15.93, testSPUToo.calculateRate(testSPUToo.getDistanceInMiles(), testSPUToo.getWeightInOunces()), 0.009);
		Assert.assertEquals("SPU (2-day business)            $15.93", testSPUToo.toString());
	}
	
	@Test
	public void calculate_rate_4_day_ground() {
		SPU testSPUToo = new SPU(340, 15, 3);
		
		Assert.assertEquals(1.59, testSPUToo.calculateRate(testSPUToo.getDistanceInMiles(), testSPUToo.getWeightInOunces()), 0.009);
		Assert.assertEquals("SPU (4-day ground)              $1.59", testSPUToo.toString());
	}
	
	
}
