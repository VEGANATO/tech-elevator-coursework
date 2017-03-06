package com.techelevator.vehicle;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.techelevator.vehicle.Tank;

public class TankTest {
	Tank testTank;
	
	@Before
	public void setup() {
		testTank = new Tank(240);
	}
	
	@Test
	public void initialize_correctly() {
		Assert.assertEquals(240, testTank.getDistance());
		Assert.assertEquals(0.00, testTank.calculateToll(testTank.getDistance()), 0.009);
		Assert.assertEquals("Tank             240                    $0.00", testTank.toString());
	}
	
}
