package com.dspohn;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class ChangeCalcRun {

	public static void main(String[] args) {
		
		// Formats the BigDecimal values to be displayed
		ChangeCalc cc = new ChangeCalc();
				
		// Return the map and display it unordered.
		BigDecimal change = new BigDecimal(143.56);
		System.out.println(cc.change(change).toString());
		
		// Displaying it in a more readable format.
		System.out.println();
		Map<String, Integer> display = new 	HashMap<>();
		display = cc.change(change); 
		System.out.println("Hundreds: " + display.get("Hundreds") +
				"\nFifties: " + display.get("Fifties") +
				"\nTwenties: " + display.get("Twenties") +
				"\nTens: " + display.get("Tens") +
				"\nFives: " + display.get("Fives") +
				"\nOnes: " + display.get("Ones") +
				"\nQuarters: " + display.get("Quarters") +
				"\nDimes: " + display.get("Dimes") + 
				"\nNickels: " + display.get("Nickels") +
				"\nPennies: " + display.get("Pennies"));	
	}

}
