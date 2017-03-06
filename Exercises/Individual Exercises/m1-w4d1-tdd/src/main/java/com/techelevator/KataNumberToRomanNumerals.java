package com.techelevator;

import java.util.HashMap;
import java.util.Map;

public class KataNumberToRomanNumerals {
	Map<Integer, String> numberToRomanNumeralMap;
	
	public KataNumberToRomanNumerals() {
		numberToRomanNumeralMap = new HashMap<Integer, String>();
		
		numberToRomanNumeralMap.put(1, "I");
		numberToRomanNumeralMap.put(2, "II");
		numberToRomanNumeralMap.put(3, "III");
		numberToRomanNumeralMap.put(4, "IV");
		numberToRomanNumeralMap.put(5, "V");
		numberToRomanNumeralMap.put(6, "VI");
		numberToRomanNumeralMap.put(7, "VII");
		numberToRomanNumeralMap.put(8, "VIII");
		numberToRomanNumeralMap.put(9, "IX");
		numberToRomanNumeralMap.put(10, "X");
		
		numberToRomanNumeralMap.put(40, "XL");
		numberToRomanNumeralMap.put(50, "L");
		numberToRomanNumeralMap.put(90, "XC");
		numberToRomanNumeralMap.put(100, "C");
		
		numberToRomanNumeralMap.put(400, "CD");
		numberToRomanNumeralMap.put(500, "D");
		numberToRomanNumeralMap.put(900, "CM");
		numberToRomanNumeralMap.put(1000, "M");
	}
	
	public String convertNumberToRomanNumeral(int number) {
		String convertedNumeral = "";
		int trackingNumber = number;
		
		while (trackingNumber > 0) {
			if (trackingNumber >= 1000) {
				convertedNumeral += numberToRomanNumeralMap.get(1000);
				trackingNumber -= 1000;
			} else if (trackingNumber >= 900) {
				convertedNumeral += numberToRomanNumeralMap.get(900);
				trackingNumber -= 900;
			} else if (trackingNumber >= 500) {
				convertedNumeral += numberToRomanNumeralMap.get(500);
				trackingNumber -= 500;
			} else if (trackingNumber >= 400) {
				convertedNumeral += numberToRomanNumeralMap.get(400);
				trackingNumber -= 400;
			} else if (trackingNumber >= 100) {
				convertedNumeral += numberToRomanNumeralMap.get(100);
				trackingNumber -= 100;
			} else if (trackingNumber >= 90) {
				convertedNumeral += numberToRomanNumeralMap.get(90);
				trackingNumber -= 90;
			} else if (trackingNumber >= 50) {
				convertedNumeral += numberToRomanNumeralMap.get(50);
				trackingNumber -= 50;
			} else if (trackingNumber >= 40) {
				convertedNumeral += numberToRomanNumeralMap.get(40);
				trackingNumber -= 40;
			} else if (trackingNumber >= 10) {
				convertedNumeral += numberToRomanNumeralMap.get(10);
				trackingNumber -= 10;
			} else if (trackingNumber > 0) {
				convertedNumeral += numberToRomanNumeralMap.get(trackingNumber);
				trackingNumber -= trackingNumber;
			}
		}
		
		return convertedNumeral;
	}
}
