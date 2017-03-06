package com.techelevator;

import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;

public class SmartPhoneTest {
	private SmartPhone phone;
	
	@Before
	public void setup() {
		// Arrange
		phone = new SmartPhone("6145555555", "Cricket Wireless");
	}
	
	@Test
	public void smartphone_is_initialized_correctly() {
		// Assert
		Assert.assertEquals("phoneNumber should equal 6145555555", "6145555555", phone.getPhoneNumber());
		Assert.assertEquals("carrier should equal Cricket Wireless", "Cricket Wireless", phone.getCarrier());
		Assert.assertEquals("operatingSystem should initialize to null", null, phone.getOperatingSystem());
		Assert.assertEquals("Battery should initialize to 100", 100, phone.getBatteryCharge());
		Assert.assertFalse("onCall should initialize to false", phone.isOnCall());
	}
	
	@Test
	public void set_phoneNumber_10_digits() {
		// Act
		phone.setPhoneNumber("6146555555");
		
		// Assert
		Assert.assertEquals("Phone number should set to 6146555555", "6146555555", phone.getPhoneNumber());
	}
	
	@Test
	public void set_phoneNumber_not_10_digits() {
		// Act
		phone.setPhoneNumber("5555555");
		
		// Assert
		Assert.assertEquals("Phone number can not be set to a number that is not 10 digits, should remain 6145555555", "6145555555", phone.getPhoneNumber());
	}
	
	@Test
	public void set_operating_system() {
		// Act
		phone.setOperatingSystem("Android");
		
		// Assert
		Assert.assertEquals("operatingSystem should set to Android", "Android", phone.getOperatingSystem());
	}
	
	@Test
	public void make_call_while_not_onCall() {
		// Act
		phone.call("6145556666", 10);
		
		// Assert
		Assert.assertTrue("onCall should return true", phone.isOnCall());
		Assert.assertEquals("batteryCharge should reduce to 90 after 10 minute call", 90, phone.getBatteryCharge());
	}
	
	@Test
	public void make_call_while_onCall() {
		// Arrange
		phone.call("6145556666", 10);
		
		// Act
		boolean success = phone.call("6145557777", 20);
		
		// Assert
		Assert.assertFalse("Call should not return true while already on a call", success);
		Assert.assertEquals("Unsuccessful call should not reduce battery", 90, phone.getBatteryCharge());
	}
	
	@Test
	public void answer_phone_while_not_onCall() {
		// Act
		phone.answerPhone();
		
		// Assert
		Assert.assertTrue("onCall should be true after answering a call", phone.isOnCall());
	}
	
//	@Test
//	public void answer_phone_while_onCall() {
//		// Arrange
//		phone.call("6145556666", 10);
//		
//		// Act
//		phone.answerPhone();
//		
//		// Assert
//		Assert.assertTrue("onCall should be true after answering a call", phone.isOnCall());
//	}
	
	@Test
	public void hang_up_while_onCall() {
		// Arrange
		phone.call("6145556666", 10);
		
		// Act
		phone.hangUp();
		
		// Assert
		Assert.assertFalse("onCall should return false", phone.isOnCall());
	}
	
	@Test
	public void hang_up_while_not_onCall() {
		// Act
		phone.hangUp();
		
		// Assert
		Assert.assertFalse("onCall should return false", phone.isOnCall());
	}
	
	@Test
	public void reduce_battery_to_zero() {
		// Act
		phone.call("6145556677", 100);
		
		// Assert
		Assert.assertEquals("batteryCharge should be 0", 0, phone.getBatteryCharge());
	}
	
	@Test
	public void try_call_with_0_battery() {
		// Arrange
		phone.call("6145556677", 100);
		phone.hangUp();
		
		// Act
		boolean success = phone.call("6145556678", 10);
		
		// Assert
		Assert.assertFalse("Phone should not allow calls at 0% battery", success);
		Assert.assertEquals("batteryCharge should be 0", 0, phone.getBatteryCharge());
	}
	
	@Test
	public void try_answer_with_battery_left() {
		// Arrange
		phone.call("6145556677", 90);
		phone.hangUp();
		
		// Act
		phone.answerPhone();
		
		// Assert
		Assert.assertTrue("Phone should be able to answer phone at 10% battery", phone.isOnCall());
		Assert.assertEquals("batteryCharge should be 10", 10, phone.getBatteryCharge());
	}
	
	@Test
	public void try_answer_with_0_battery() {
		// Arrange
		phone.call("6145556677", 100);
		phone.hangUp();
		
		// Act
		phone.answerPhone();
		
		// Assert
		Assert.assertFalse("Phone should not be able to answer phone at 0 battery", phone.isOnCall());
	}
	
	@Test
	public void recharge_battery() {
		// Arrange
		phone.call("6145556677", 100);
		phone.hangUp();

		// Act
		phone.rechargeBattery();

		// Assert
		Assert.assertEquals("Phone should be at 100% battery", 100, phone.getBatteryCharge());
	}
	
	
}
