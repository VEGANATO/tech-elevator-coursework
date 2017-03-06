package com.techelevator.vehicle;

import org.junit.Before;
import org.junit.Test;

import com.techelevator.vehicle.Car;

import org.junit.Assert;

public class CarTest {
	Car testCar;
	
	@Before
	public void setup() {
		testCar = new Car(100, false);
	}
	
	@Test
	public void initialize_correctly() {
		Assert.assertEquals(100, testCar.getDistance());
		Assert.assertFalse(testCar.isPullingTrailer());
		Assert.assertEquals("Car              100                    $2.00", testCar.toString());
	}
	
	@Test
	public void calculate_toll_correctly_no_trailer() {
		double testToll = testCar.calculateToll(testCar.getDistance());
		
		Assert.assertEquals(2.0, testToll, 0.009);
	}
	
	@Test
	public void calculate_toll_correctly_with_trailer() {
		Car testCar2 = new Car(100, true);
		double testToll = testCar2.calculateToll(testCar.getDistance());
		
		Assert.assertEquals(3.0, testToll, 0.009);
	}
}
