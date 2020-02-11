package com.dspohn;

import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.Map;

public class ChangeCalc {
	
	/**
	 * A function which takes a monetary amount, less than $1,000.00, and 
	 * determines the combination of highest value coins needed.
	 * 
	 * @param monetary amount as type BigDecimal
	 * @return coins as type Map<String, Integer>
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
	
	private Integer divideAmount(BigDecimal amount, BigDecimal denomination) {
		return amount.divide(denomination).intValue();
	}
	
	private BigDecimal reduceAmount(BigDecimal amount, BigDecimal denomination) {
		return amount.remainder(denomination);
	}
}
