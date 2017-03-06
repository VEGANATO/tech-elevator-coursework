package com.techelevator;

import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;

public class TelevisionTest {
	private Television tv;
	
	@Before
	public void setup() {
		// Arrange
		tv = new Television();
	}
	
	@Test
	public void tv_is_initialized_correctly() {
		// Assert
		Assert.assertFalse("After construction, the tv should be off", tv.isOn());
		Assert.assertEquals("The default channgel is 3", 3, tv.getSelectedChannel());
		Assert.assertEquals("The volume is 0", 0, tv.getCurrentVolume());
	}
	
	@Test
	public void turn_on_tv() {
		// Act
		tv.turnOn();
		
		// Assert
		Assert.assertTrue("TV should be on", tv.isOn());
	}
	
	@Test
	public void turn_off_tv() {
		// Arrange
		tv.turnOn();
		
		// Act
		tv.turnOff();
		
		// Assert
		Assert.assertFalse("TV should be off", tv.isOn());
	}
	
	@Test
	public void change_channel_with_tv_on() {
		// Arrange
		tv.turnOn();
		
		// Act
		tv.changeChannel(4);
		
		// Assert
		Assert.assertEquals("Should have set the channel to 4", 4, tv.getSelectedChannel());
	}
	
	@Test
	public void change_channel_too_high() {
		// Arrange
		tv.turnOn();
		
		// Act
		tv.changeChannel(19);
		
		// Assert
		
		Assert.assertEquals("Channel should not have changed", 3, tv.getSelectedChannel());
	}
	
	@Test
	public void change_channel_too_low() {
		// Arrange
		tv.turnOn();
		
		// Act
		tv.changeChannel(2);
		
		// Assert
		
		Assert.assertEquals("Channel should not have changed", 3, tv.getSelectedChannel());
	}
	
	@Test
	public void change_channel_with_tv_off() {
		// Act
		tv.changeChannel(4);
		
		// Assert
		Assert.assertEquals("Channel should not change when TV is off", 3, tv.getSelectedChannel());
	}
	
	@Test
	public void raise_volume_with_tv_on() {
		// Arrange
		tv.turnOn();
		
		// Act
		for (int i = 0; i < 5; i++) {
			tv.raiseVolume();
		}
		
		// Assert
		Assert.assertEquals("Volume should be 5", 5, tv.getCurrentVolume());
	}
	
	@Test
	public void raise_volume_with_tv_off() {
		// Arrange
		
		for (int i = 0; i < 5; i++) {
			tv.raiseVolume();
		}
		
		// Assert
		Assert.assertEquals("Volume should remain 0", 0, tv.getCurrentVolume());
	}
	
	@Test
	public void raise_volume_to_11() {
		// Arrange
		tv.turnOn();
		
		// Act
		for (int i = 0; i < 11; i++) {
			tv.raiseVolume();
		}
		
		// Assert
		Assert.assertEquals("Volume should not raise past 10", 10, tv.getCurrentVolume());
	}
	
	@Test
	public void lower_volume_from_1_to_0_with_tv_on() {
		// Arrange
		tv.turnOn();
		tv.raiseVolume();
		
		// Act
		tv.lowerVolume();
		
		// Assert
		Assert.assertEquals("Volume should be back at 0", 0, tv.getCurrentVolume());
	}
	
	@Test
	public void lower_volume_from_1_to_0_with_tv_off() {
		// Arrange
		tv.raiseVolume();
		
		// Act
		tv.lowerVolume();
		
		// Assert
		Assert.assertEquals("Volume should not change with TV off", 0, tv.getCurrentVolume());
	}
	
	@Test
	public void volume_should_not_go_below_0() {
		// Arrange
		tv.turnOn();
		
		// Act
		tv.lowerVolume();
		
		// Assert
		Assert.assertEquals("Volume should not go below 0", 0, tv.getCurrentVolume());
	}
	

}
