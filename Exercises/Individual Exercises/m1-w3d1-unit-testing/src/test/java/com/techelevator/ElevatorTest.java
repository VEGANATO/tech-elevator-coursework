package com.techelevator;

import org.junit.Before;
import org.junit.Test;

import org.junit.Assert;

public class ElevatorTest {
	Elevator el;
	
	@Before
	public void setup() {
		el = new Elevator(1, 50);
	}
	
	@Test
	public void initialize_elevator_happy_path() {
		Assert.assertEquals("shaftNumber should equal 1", 1, el.getShaftNumber());
		Assert.assertEquals("currentLevel should equal 1", 1, el.getCurrentLevel());
		Assert.assertEquals("numberOfLevels should equal 50", 50, el.getNumberOfLevels());
		Assert.assertTrue("doorOpen should equal true", el.isDoorOpen());
		Assert.assertFalse("moving should equal false", el.isMoving());
	}
	
	@Test
	public void initialize_elevator_sad_path() {
		Elevator elToo = new Elevator(-8, -8);
		
		Assert.assertEquals("shaftNumber cannot be negative number, should default to 0", 0, elToo.getShaftNumber());
		Assert.assertEquals("numberOfLevels cannot be negative number, should default to 0", 0, elToo.getNumberOfLevels());
	}
	
	@Test
	public void close_door() {
		el.closeDoor();
		
		Assert.assertFalse("isDoorOpen should equal false", el.isDoorOpen());
	}
	
	@Test
	public void close_and_open_door() {
		el.closeDoor(); 
		el.openDoor();
		
		Assert.assertTrue("isDoorOpen should equal true", el.isDoorOpen());
	}
	
	@Test
	public void go_up_successful() {
		el.closeDoor();
		boolean success = el.goUp(50);
		
		Assert.assertTrue("goUp should return true", true);
		Assert.assertEquals("currentLevel should equal 50", 50, el.getCurrentLevel());
	}
	
	@Test
	public void go_up_failure_door_not_closed() {
		boolean success = el.goUp(25);
		
		Assert.assertFalse("Door not closed, should return false", false);
		Assert.assertEquals("currentLevel should equal 1", 1, el.getCurrentLevel());
	}
	
	@Test
	public void go_up_failure_not_enough_levels() {
		el.closeDoor();
		boolean success = el.goUp(51);
		
		Assert.assertFalse("goUp cannot go beyond numberOfLevels, should return false", false);
		Assert.assertEquals("currentLevel should equal 1", 1, el.getCurrentLevel());
	}
	
	@Test
	public void go_up_failure_desired_floor_below_current_level() {
		el.closeDoor();
		el.goUp(25);
		
		boolean success = el.goUp(20);
		
		Assert.assertFalse("Cannot goUp, desiredLevel below currentLevel, should return false", false);
		Assert.assertEquals("currentLevel should equal 25", 25, el.getCurrentLevel());
	}
	
	@Test
	public void go_down_successful() {
		el.closeDoor();
		el.goUp(25);
		boolean success = el.goDown(10);
		
		Assert.assertTrue("goDown should return true", success);
		Assert.assertEquals("currentLevel should equal 10", 10, el.getCurrentLevel());
	}
	
	@Test
	public void go_down_failure_door_open() {
		el.closeDoor();
		el.goUp(25);
		el.openDoor();
		
		boolean success = el.goDown(10);
		
		Assert.assertFalse("Door open, goDown should return false", success);
		Assert.assertEquals("currentLevel should equal 25", 25, el.getCurrentLevel());
	}
	
	@Test
	public void go_down_failure_desired_level_below_1() {
		el.closeDoor();
		el.goUp(25);
		
		boolean success = el.goDown(0);
		boolean successer = el.goDown(-1);
		
		Assert.assertFalse("desiredFloor below 1, goDown should return false", success);
		Assert.assertFalse("desiredFloor negative number, goDown should return false", successer);
		Assert.assertEquals("currentLevel should equal 25", 25, el.getCurrentLevel());
	}
	
	@Test
	public void go_down_failure_desired_level_above_current_level() {
		el.closeDoor();
		
		boolean success = el.goDown(33);
		
		Assert.assertFalse("desiredFloor above current floor, goDown should return false", success);
		Assert.assertEquals("currentLevel should equal 1", 1, el.getCurrentLevel());
	}
}
