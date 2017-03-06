package com.techelevator;

import org.junit.*;

public class KataRomanNumeralToNumberTest {
	KataRomanNumeralToNumber testKata;
	
	@Before
	public void setup() {
		testKata = new KataRomanNumeralToNumber();
	}
	
	@Test
	public void convert_CMXCIX_to_999() {
		int result = testKata.convertRomanNumeralToNumber("CMXCIX");
		
		Assert.assertEquals(999, result);
	}
	
	@Test
	public void convert_M_to_1000() {
		int result = testKata.convertRomanNumeralToNumber("M");
		
		Assert.assertEquals(1000, result);
	}
	
	@Test
	public void convert_MMDLXXX_to_2580() {
		int result = testKata.convertRomanNumeralToNumber("MMDLXXX");
		
		Assert.assertEquals(2580, result);
	}
	
	@Test
	public void convert_3000_to_MMM() {
		int result = testKata.convertRomanNumeralToNumber("MMM");
		
		Assert.assertEquals(3000, result);
	}
	
}
