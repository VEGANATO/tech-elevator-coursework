package com.techelevator;

import java.util.HashMap;
import java.util.Map;

public class KataRomanNumeralToNumber {
	
	Map<String, Integer> romanNumeralToNumbersMap;
	
	public KataRomanNumeralToNumber() {
		romanNumeralToNumbersMap = new HashMap<String, Integer>();
		
		romanNumeralToNumbersMap.put("I", 1);
		romanNumeralToNumbersMap.put("II", 2);
		romanNumeralToNumbersMap.put("III", 3);
		romanNumeralToNumbersMap.put("IV", 4);
		romanNumeralToNumbersMap.put("V", 5);
		romanNumeralToNumbersMap.put("VI", 6);
		romanNumeralToNumbersMap.put("VII", 7);
		romanNumeralToNumbersMap.put("VIII", 8);
		romanNumeralToNumbersMap.put("IX", 9);
		romanNumeralToNumbersMap.put("X", 10);
		
		romanNumeralToNumbersMap.put("XL", 40);
		romanNumeralToNumbersMap.put("L", 50);
		romanNumeralToNumbersMap.put("XC", 90);
		romanNumeralToNumbersMap.put("C", 100);
		
		romanNumeralToNumbersMap.put("CD", 400);
		romanNumeralToNumbersMap.put("D", 500);
		romanNumeralToNumbersMap.put("CM", 900);
		romanNumeralToNumbersMap.put("M", 1000);
	}
	
	public int convertRomanNumeralToNumber(String romanNumeral) {
		int convertedSum = 0;
		
		if (romanNumeral.contains("CM")) {
			convertedSum += 900;
			romanNumeral = romanNumeral.replace("CM", "");
		}
		
		if (romanNumeral.contains("CD")) {
			convertedSum += 400;
			romanNumeral = romanNumeral.replace("CD", "");
		}
		
		if (romanNumeral.contains("XC")) {
			convertedSum += 90;
			romanNumeral = romanNumeral.replace("XC", "");
		}
		
		if (romanNumeral.contains("XL")) {
			convertedSum += 40;
			romanNumeral = romanNumeral.replace("XL", "");
		}
		
		
		String[] romanNumeralSplit = romanNumeral.split("");
		
		for (String numeral : romanNumeralSplit) {
			convertedSum += romanNumeralToNumbersMap.get(numeral);
			
			
//			if (numeral.equals("M")) {
//				convertedSum += 1000;
//			} else if (numeral.equals("D")) {
//				convertedSum += 500;
//			} else if (numeral.equals("C")) {
//				convertedSum += 100;
//			} else if (numeral.equals("L")) {
//				convertedSum += 50;
//			} else {
//				convertedSum += 500;
//			} 
		}
		
		return convertedSum;
	}

}
