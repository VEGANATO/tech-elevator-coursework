package com.techelevator.vehicle;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.techelevator.vehicle.Truck;

public class TruckTest {
	Truck testTruck;
	
	@Before
	public void setup() {
		testTruck = new Truck(150, 6);
	}
	
	@Test
	public void initialize_correctly() {
		Assert.assertEquals(150, testTruck.getDistance());
		Assert.assertEquals(6, testTruck.getNumberOfAxels());
		Assert.assertEquals("Truck            150                    $6.75", testTruck.toString());
	}
	
	@Test
	public void calculate_toll_correctly_4_axels() {
		Truck testTruck2 = new Truck(150, 4);
		double testToll = testTruck2.calculateToll(testTruck.getDistance());
		
		Assert.assertEquals(6.00, testToll, 0.009);
	}
	
	@Test
	public void calculate_toll_correctly_6_axels() {
		double testToll = testTruck.calculateToll(testTruck.getDistance());
		
		Assert.assertEquals(6.75, testToll, 0.009);
	}
	
	@Test
	public void calculate_toll_correctly_8_axels() {
		Truck testTruck2 = new Truck(150, 8);
		double testToll = testTruck2.calculateToll(testTruck.getDistance());
		
		Assert.assertEquals(7.20, testToll, 0.009);
	}
	
	@Test
	public void calculate_toll_correctly_16_axels() {
		Truck testTruck2 = new Truck(150, 16);
		double testToll = testTruck2.calculateToll(testTruck.getDistance());
		
		Assert.assertEquals(7.20, testToll, 0.009);
	}
	
}	
