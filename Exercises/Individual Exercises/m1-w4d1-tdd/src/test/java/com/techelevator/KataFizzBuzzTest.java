package com.techelevator;

import org.junit.*;
import static org.junit.Assert.*;

public class KataFizzBuzzTest {
	KataFizzBuzz fizzBuzzTest;
	
	@Before
	public void setup() {
		fizzBuzzTest = new KataFizzBuzz();
	}
	
	@Test
	public void pass_1_return_1() {
		String result = fizzBuzzTest.fizzBuzz(1);
		
		Assert.assertEquals("1", result);
	}
	
	@Test
	public void pass_2_return_2() {
		String result = fizzBuzzTest.fizzBuzz(2);
		
		Assert.assertEquals("2", result);
	}
	
	@Test
	public void pass_3_return_Fizz() {
		String result = fizzBuzzTest.fizzBuzz(3);
		
		Assert.assertEquals("Fizz", result);
	}
	
	@Test
	public void pass_4_return_4() {
		String result = fizzBuzzTest.fizzBuzz(4);
		
		Assert.assertEquals("4", result);
	}
	
	@Test
	public void pass_5_return_Buzz() {
		String result = fizzBuzzTest.fizzBuzz(5);
		
		Assert.assertEquals("Buzz", result);
	}
	
	@Test
	public void pass_10_return_Buzz() {
		String result = fizzBuzzTest.fizzBuzz(10);
		
		Assert.assertEquals("Buzz", result);
	}
	
	@Test
	public void pass_15_return_FizzBuzz() {
		String result = fizzBuzzTest.fizzBuzz(15);
		
		Assert.assertEquals("FizzBuzz", result);
	}
	
	@Test
	public void pass_28_return_28() {
		String result = fizzBuzzTest.fizzBuzz(28);
		
		Assert.assertEquals("28", result);
	}
	
	@Test
	public void pass_30_return_FizzBuzz() {
		String result = fizzBuzzTest.fizzBuzz(30);
		
		Assert.assertEquals("FizzBuzz", result);
	}
	

}
