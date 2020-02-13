package com.dspohn;

import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.Map;

public class ChangeCalc {
	
	
	/**
	 * A function which takes a monetary amount, less than $1,000.00, and 
	 * determines the least amount of denomination values needed for 
	 * that amount.
	 * 
	 * @param monetary amount.
	 * @return a map of the number of denomination values needed.
	 */
	public Map<BigDecimal, Integer> change(BigDecimal amount) {			
		Map<BigDecimal, Integer> change = new LinkedHashMap<>();
		change.put(Denomination.HUNDRED_DOLLAR, 0);
		change.put(Denomination.FIFTY_DOLLAR, 0);
		change.put(Denomination.TWENTY_DOLLAR, 0);
		change.put(Denomination.TEN_DOLLAR, 0);
		change.put(Denomination.FIVE_DOLLAR, 0);
		change.put(Denomination.ONE_DOLLAR, 0);
		change.put(Denomination.QUARTER, 0);
		change.put(Denomination.DIME, 0);
		change.put(Denomination.NICKEL, 0);
		change.put(Denomination.PENNY, 0);	
		
		for(Map.Entry<BigDecimal, Integer> entry : change.entrySet()) {
			change.replace(entry.getKey(), divideAmount(amount,  entry.getKey()));
			amount = reduceAmount(amount, entry.getKey());
		}

		return change;
	}
	
	/**
	 * Performs division of the amount to determine how many, if
	 * any, of a particular denomination is needed.
	 * 
	 * @param amount Current total amount
	 * @param denomination The denomination value being checked 
	 * @return The number of a particular denomination
	 */
	private Integer divideAmount(BigDecimal amount, BigDecimal denomination) {
		return amount.divide(denomination).intValue();
	}
	
	/**
	 * Performs modulo to determine the current total amount after
	 * denomination values, if any, have been removed.
	 * 
	 * @param amount Current total amount
	 * @param denomination The denomination value being checked 
	 * @return the total amount of the change after the removal of any denominations 
	 */
	private BigDecimal reduceAmount(BigDecimal amount, BigDecimal denomination) {		
		return amount.remainder(denomination);
	}
}
