package com.techelevator;

import org.junit.*;
import static org.junit.Assert.*;

import java.awt.List;
import java.util.ArrayList;
import java.util.Arrays;

public class KataPrimeFactorsTest {
	KataPrimeFactors primeTest;
	
	@Before
	public void setup() {
		primeTest = new KataPrimeFactors();
	}
	
	@Test
	public void input_2_output_2() {
		ArrayList<Integer> testList = primeTest.factorize(2);
		
		Assert.assertEquals(Arrays.asList(2), testList);
	}
	
	@Test
	public void input_3_output_3() {
		ArrayList<Integer> testList = primeTest.factorize(3);
		
		Assert.assertEquals(Arrays.asList(3), testList);
	}
	
	@Test
	public void input_4_output_22() {
		ArrayList<Integer> testList = primeTest.factorize(4);
		
		Assert.assertEquals(Arrays.asList(2,2), testList);
	}
	
	@Test
	public void input_6_output_32() {
		ArrayList<Integer> testList = primeTest.factorize(6);
		
		Assert.assertEquals(Arrays.asList(3,2), testList);
	}
	
	@Test
	public void input_7_output_7() {
		ArrayList<Integer> testList = primeTest.factorize(7);
		
		Assert.assertEquals(Arrays.asList(7), testList);
	}
	
	@Test
	public void input_8_output_222() {
		ArrayList<Integer> testList = primeTest.factorize(8);
		
		Assert.assertEquals(Arrays.asList(2,2,2), testList);
	}
	
	@Test
	public void input_9_output_33() {
		ArrayList<Integer> testList = primeTest.factorize(9);
		
		Assert.assertEquals(Arrays.asList(3,3), testList);
	}
	
	@Test
	public void input_10_output_52() {
		ArrayList<Integer> testList = primeTest.factorize(10);
		
		Assert.assertEquals(Arrays.asList(5,2), testList);
	}
	
	@Test
	public void input_13_output_13() {
		ArrayList<Integer> testList = primeTest.factorize(13);
		
		Assert.assertEquals(Arrays.asList(13), testList);
	}
	
	@Test
	public void input_14_output_72() {
		ArrayList<Integer> testList = primeTest.factorize(14);
		
		Assert.assertEquals(Arrays.asList(7,2), testList);
	}
	
	
	@Test
	public void input_100_output_5522() {
		ArrayList<Integer> testList = primeTest.factorize(100);
		
		Assert.assertEquals(Arrays.asList(5,5,2,2), testList);
	}
	
	@Test
	public void input_144_output_332222() {
		ArrayList<Integer> testList = primeTest.factorize(144);
		
		Assert.assertEquals(Arrays.asList(3,3,2,2,2,2), testList);
	}
	
	@Test
	public void input_1917_output_71_333() {
		ArrayList<Integer> testList = primeTest.factorize(1917);
		
		Assert.assertEquals(Arrays.asList(3,3,3,71), testList);
	}
	
	@Test
	public void input_2016_output_33_22222_7() {
		ArrayList<Integer> testList = primeTest.factorize(2016);
		
		Assert.assertEquals(Arrays.asList(7,3,3,2,2,2,2,2), testList);
	}
	
}
