package com.techelevator;

import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;

public class HomeworkAssignmentTest {
	private HomeworkAssignment hw;
	
	@Before
	public void setup() {
		// Arrange
		hw = new HomeworkAssignment(100);
	}
	
	@Test
	public void hw_initialized_correctly() {
		// Assert
		Assert.assertEquals("possibleMarks should equal 100", 100, hw.getPossibleMarks());
		Assert.assertEquals("totalMarks should equal 0", 0, hw.getTotalMarks());
		Assert.assertEquals("submitterName should equal null", null, hw.getSubmitterName());
	}
	
	@Test
	public void hw_initialized_with_negative_value() {
		// Arrange
		HomeworkAssignment hwAss = new HomeworkAssignment(-200);
		
		// Assert
		Assert.assertEquals("possibleMarks cannot be set to a negative value, should equal 0", 0, hwAss.getPossibleMarks());
	}
	
	@Test
	public void test_setters_happy_path() {
		// Arrange, Act
		hw.setSubmitterName("Poindexter Beauregard");
		hw.setTotalMarks(100);
		
		// Assert
		Assert.assertEquals("totalMarks should equal 100", 100, hw.getTotalMarks());
		Assert.assertEquals("submitterName should equal Poindexter Beauregard", "Poindexter Beauregard", hw.getSubmitterName());
	}
	
	@Test
	public void test_setters_sad_path() {
		// Arrange, Act
		hw.setSubmitterName("Bad Apple Bobby Briggs");
		hw.setTotalMarks(-50);
		hw.setSubmitterName(null);
		
		// Assert
		Assert.assertEquals("totalMarks cannot be set less than 0, should remain 0", 0, hw.getTotalMarks());
		Assert.assertEquals("submitterName cannot be set to null, should remain Bad Apple Bobby Briggs", "Bad Apple Bobby Briggs", hw.getSubmitterName());
	}
	
	@Test
	public void test_setters_sad_path_too() {
		// Arrange, Act
		hw.setSubmitterName("Bad Apple Bobby Briggs");
		hw.setTotalMarks(120);
		hw.setSubmitterName("");
		
		// Assert
		Assert.assertEquals("totalMarks cannot be set greater than possibleMarks, should remain 0", 0, hw.getTotalMarks());
		Assert.assertEquals("submitterName cannot be empty, should remain Bad Apple Bobby Briggs", "Bad Apple Bobby Briggs", hw.getSubmitterName());
	}
	
	@Test
	public void totalMarks_50_percent_equals_F() {
		// Arrange
		hw.setTotalMarks(50);
		
		// Act
		String grade = hw.getLetterGrade();
		
		// Assert
		Assert.assertEquals("Letter grade for 50 percent should equal F", "F", grade);
	}
	
	@Test
	public void totalMarks_60_percent_equals_D() {
		// Arrange
		hw.setTotalMarks(60);
		
		// Act
		String grade = hw.getLetterGrade();
		
		// Assert
		Assert.assertEquals("Letter grade for 60 percent should equal D", "D", grade);
	}
	
	@Test
	public void totalMarks_70_percent_equals_C() {
		// Arrange
		hw.setTotalMarks(70);
		
		// Act
		String grade = hw.getLetterGrade();
		
		// Assert
		Assert.assertEquals("Letter grade for 70 percent should equal C", "C", grade);
	}
	
	@Test
	public void totalMarks_80_percent_equals_B() {
		// Arrange
		hw.setTotalMarks(80);
		
		// Act
		String grade = hw.getLetterGrade();
		
		// Assert
		Assert.assertEquals("Letter grade for 80 percent should equal B", "B", grade);
	}
	
	@Test
	public void totalMarks_90_percent_equals_A() {
		// Arrange
		hw.setTotalMarks(90);
		
		// Act
		String grade = hw.getLetterGrade();
		
		// Assert
		Assert.assertEquals("Letter grade for 90 percent should equal A", "A", grade);
	}
}
