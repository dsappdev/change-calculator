package com.dspohn;

import java.math.BigDecimal;
import java.util.Map;

public class ChangeCalcRun {

	public static void main(String[] args) {
				
		ChangeCalc cc = new ChangeCalc();

		// Return the map and display it ordered.
		BigDecimal amount = new BigDecimal(299.88);
		System.out.println(cc.change(amount).toString());
		System.out.println();
		Map<BigDecimal, Integer> change = cc.change(amount);
		System.out.println("Hundreds: " + change.get(Denomination.HUNDRED_DOLLAR) +
				"\nFifties: " + change.get(Denomination.FIFTY_DOLLAR) +
				"\nTwenties: " + change.get(Denomination.TWENTY_DOLLAR) +
				"\nTens: " + change.get(Denomination.TEN_DOLLAR) +
				"\nFives: " + change.get(Denomination.FIVE_DOLLAR) +
				"\nOnes: " + change.get(Denomination.ONE_DOLLAR) +
				"\nQuarters: " + change.get(Denomination.QUARTER) + 
				"\nDimes: " + change.get(Denomination.DIME) +
				"\nNickels: " + change.get(Denomination.NICKEL) +
				"\nPennies: " + change.get(Denomination.PENNY));
		
		
	}

}
