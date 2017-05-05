package com.techelevator;

import java.util.ArrayList;
import java.util.List;

public class KataPrimeFactors {
	
	
	public KataPrimeFactors() {
	}
	
	public ArrayList<Integer> factorize(int positiveInteger) {
		ArrayList<Integer> primeFactors = new ArrayList<Integer>();
		
		while (positiveInteger > 1) {
			if (positiveInteger % 7 == 0) {
				primeFactors.add(7);
				positiveInteger /= 7;
			} else if (positiveInteger % 5 == 0) {
				primeFactors.add(5);
				positiveInteger /= 5;
			} else if (positiveInteger % 3 == 0) {
				primeFactors.add(3);
				positiveInteger /= 3;
			} else if (positiveInteger % 2 == 0) {
				primeFactors.add(2);
				positiveInteger /= 2;
			} else {
				primeFactors.add(positiveInteger);
				positiveInteger -= positiveInteger;
			}
		}
		
		return primeFactors;
	}
	
	
	
}
