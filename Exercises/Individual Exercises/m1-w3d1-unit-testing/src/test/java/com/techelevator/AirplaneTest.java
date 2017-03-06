package com.techelevator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AirplaneTest {
	private Airplane plane;
	
	@Before
	public void setup() {
		plane = new Airplane(20, 80);
	}
	
	@Test
	public void plane_initialized_correctly() {
		// Assert
		Assert.assertEquals("planeNumber should initialize to null", null, plane.getPlaneNumber());
		Assert.assertEquals("totalFirstClassSeat should equal 20", 20, plane.getTotalFirstClassSeats());
		Assert.assertEquals("bookedFirstClassSeats should initialize to 0", 0, plane.getBookedFirstClassSeats());
		Assert.assertEquals("totalCoachSeats should equal 80", 80, plane.getTotalCoachSeats());
		Assert.assertEquals("bookedCoachSeats should initialize to 0", 0, plane.getBookedCoachSeats());
	}
	
	@Test
	public void set_plane_number_happy_path() {
		// Act
		plane.setPlaneNumber("123456");
		
		// Assert
		Assert.assertEquals("planeNumber should equal 123456", "123456", plane.getPlaneNumber());
	}
	
	@Test
	public void set_plane_number_to_empty_string() {
		// Act
		plane.setPlaneNumber("");
		
		// Assert
		Assert.assertEquals("planeNumber cannot be set to empty string, should equal null", null, plane.getPlaneNumber());
	}
	
	@Test
	public void plane_initialized_sad_path() {
		// Arrange
		Airplane planeToo = new Airplane(-20, -80);
		
		// Act
		planeToo.setPlaneNumber("1"); 
		
		// Assert
		Assert.assertEquals("planeNumber must be 6 digits, should default to null", null, planeToo.getPlaneNumber());
		Assert.assertEquals("totalFirstClassSeats cannot be negative number, should default to 0", 0, planeToo.getTotalFirstClassSeats());
		Assert.assertEquals("totalCoachSeats cannot be negative number, should default to 0", 0, planeToo.getTotalCoachSeats());
	}
	
	@Test
	public void reserve_first_class_seats() {
		// Act
		boolean success = plane.reserve(true, 10);
		
		// Assert
		Assert.assertTrue("Reservation should be successful, return true", success);
		Assert.assertEquals("bookedFirstClassSeats should equal 10", 10, plane.getBookedFirstClassSeats());
		Assert.assertEquals("availableFirstClassSeats should equal 10", 10, plane.getAvailableFirstClassSeats());
	}
	
	@Test
	public void attempt_to_reserve_too_many_first_class_seats() {
		// Arrange
		plane.reserve(true, 10);
		// Act
		boolean success = plane.reserve(true, 11); 
		
		// Assert
		Assert.assertFalse("Reservation should be unsuccessful(not enough available seats), return false", success);
		Assert.assertEquals("bookedFirstClassSeats should not change with unsuccessful reservations, equal 10", 10, plane.getBookedFirstClassSeats());
		Assert.assertEquals("availableFirstClassSeats should not change with unsuccessful reservations, equal 10", 10, plane.getAvailableFirstClassSeats());
	}
	
	@Test
	public void reserve_coach_seats() {
		// Act
		boolean success = plane.reserve(false, 40);
		
		// Assert
		Assert.assertTrue("Reservation should be successful, return true", success);
		Assert.assertEquals("bookedCoachSeats should equal 40", 40, plane.getBookedCoachSeats());
		Assert.assertEquals("availableCoachSeats should equal 40", 40, plane.getAvailableCoachSeats());
	}
	
	@Test
	public void attempt_to_reserve_too_many_coach_seats() {
		// Arrange
		plane.reserve(false, 40);
		
		// Act
		boolean success = plane.reserve(false, 41);
		
		// Assert
		Assert.assertFalse("Reservation should be unsuccessful, return false", success);
		Assert.assertEquals("bookedCoachSeats should not change with unsuccessful reservations, equal 40", 40, plane.getBookedCoachSeats());
		Assert.assertEquals("availableCoachSeats should not change with unsuccessful reservations, equal 40", 40, plane.getAvailableCoachSeats());
	}
}
