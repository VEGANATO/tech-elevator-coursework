package com.techelevator;

import org.junit.*;
import static org.junit.Assert.*;

public class KataRomanNumeralsTest {
	KataNumberToRomanNumerals numeralTest;
	
	@Before
	public void setup() {
		numeralTest = new KataNumberToRomanNumerals();
	}
	
	@Test
	public void convert_1_to_I() {
		String result = numeralTest.convertNumberToRomanNumeral(1);
		
		Assert.assertEquals("I", result);
	}
	
	@Test
	public void convert_7_to_VII() {
		String result = numeralTest.convertNumberToRomanNumeral(7);
		
		Assert.assertEquals("VII", result);
	}
	
	@Test
	public void convert_10_to_X() {
		String result = numeralTest.convertNumberToRomanNumeral(10);
		
		Assert.assertEquals("X", result);
	}
	
	@Test
	public void convert_15_to_XV() {
		String result = numeralTest.convertNumberToRomanNumeral(15);
		
		Assert.assertEquals("XV", result);
	}
	
	@Test
	public void convert_20_to_XX() {
		String result = numeralTest.convertNumberToRomanNumeral(20);
		
		Assert.assertEquals("XX", result);
	}
	
	@Test
	public void convert_35_to_XXXV() {
		String result = numeralTest.convertNumberToRomanNumeral(35);
		
		Assert.assertEquals("XXXV", result);
	}
	
	@Test
	public void convert_40_to_XL() {
		String result = numeralTest.convertNumberToRomanNumeral(40);
		
		Assert.assertEquals("XL", result);
	}
	
	@Test
	public void convert_49_to_XLIX() {
		String result = numeralTest.convertNumberToRomanNumeral(49);
		
		Assert.assertEquals("XLIX", result);
	}
	
	@Test
	public void convert_50_to_L() {
		String result = numeralTest.convertNumberToRomanNumeral(50);
		
		Assert.assertEquals("L", result);
	}
	
	@Test
	public void convert_70_to_LXX() {
		String result = numeralTest.convertNumberToRomanNumeral(70);
		
		Assert.assertEquals("LXX", result);
	}
	
	@Test
	public void convert_89_to_LXXXIX() {
		String result = numeralTest.convertNumberToRomanNumeral(89);
		
		Assert.assertEquals("LXXXIX", result);
	}
	
	@Test
	public void convert_90_to_XC() {
		String result = numeralTest.convertNumberToRomanNumeral(90);
		
		Assert.assertEquals("XC", result);
	}
	
	@Test
	public void convert_100_to_C() {
		String result = numeralTest.convertNumberToRomanNumeral(100);
		
		Assert.assertEquals("C", result);
	}
	
	@Test
	public void convert_300_to_CCC() {
		String result = numeralTest.convertNumberToRomanNumeral(300);
		
		Assert.assertEquals("CCC", result);
	}
	
	@Test
	public void convert_400_to_CD() {
		String result = numeralTest.convertNumberToRomanNumeral(400);
		
		Assert.assertEquals("CD", result);
	}
	
	@Test
	public void convert_457_to_CDLVII() {
		String result = numeralTest.convertNumberToRomanNumeral(457);
		
		Assert.assertEquals("CDLVII", result);
	}
	
	@Test
	public void convert_499_to_CDXCIX() {
		String result = numeralTest.convertNumberToRomanNumeral(499);
		
		Assert.assertEquals("CDXCIX", result);
	}
	
	@Test
	public void convert_500_to_D() {
		String result = numeralTest.convertNumberToRomanNumeral(500);
		
		Assert.assertEquals("D", result);
	}
	
	@Test
	public void convert_689_to_DCLXXXIX() {
		String result = numeralTest.convertNumberToRomanNumeral(689);
		
		Assert.assertEquals("DCLXXXIX", result);
	}
	
	@Test
	public void convert_946_to_CMXLVI() {
		String result = numeralTest.convertNumberToRomanNumeral(946);
		
		Assert.assertEquals("CMXLVI", result);
	}
	
	@Test
	public void convert_999_to_CMXCIX() {
		String result = numeralTest.convertNumberToRomanNumeral(999);
		
		Assert.assertEquals("CMXCIX", result);
	}
	
	@Test
	public void convert_1000_to_M() {
		String result = numeralTest.convertNumberToRomanNumeral(1000);
		
		Assert.assertEquals("M", result);
	}
	
	@Test
	public void convert_2580_to_MMDLXXX() {
		String result = numeralTest.convertNumberToRomanNumeral(2580);
		
		Assert.assertEquals("MMDLXXX", result);
	}
	
	@Test
	public void convert_3000_to_MMM() {
		String result = numeralTest.convertNumberToRomanNumeral(3000);
		
		Assert.assertEquals("MMM", result);
	}
	

}
