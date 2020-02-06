package com.dspohn;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.HashMap;
import java.util.Map;

public class ChangeCalc {
	// Used MathContext to set the decimal places and the type of rounding to be used.
	private static MathContext mc = new MathContext(2, RoundingMode.HALF_UP);
	
	NumberFormat format = new DecimalFormat("0.###");
	
	// Set the default values for the currency
	private static final BigDecimal HUNDRED_DOLLAR = new BigDecimal(100.0, mc);
	private static final BigDecimal FIFTY_DOLLAR = new BigDecimal(50.0, mc);
	private static final BigDecimal TWENTY_DOLLAR = new BigDecimal(20.0, mc);
	private static final BigDecimal TEN_DOLLAR = new BigDecimal(10.0, mc);
	private static final BigDecimal FIVE_DOLLAR = new BigDecimal(5.0, mc);
	private static final BigDecimal ONE_DOLLAR = new BigDecimal(1.0, mc);
	private static final BigDecimal QUARTER = new BigDecimal(0.25, mc);
	private static final BigDecimal DIME = new BigDecimal(0.10, mc);
	private static final BigDecimal NICKEL = new BigDecimal(0.05, mc);
	private static final BigDecimal PENNY = new BigDecimal(0.01, mc);
	
	/**
	 * A function which takes a monetary amount, less than $1.00, and 
	 * determines the combination of highest value coins needed.
	 * 
	 * @param monetary amount as type BigDecimal
	 * @return coins as type Map<String, Integer>
	 */
	public Map<String, Integer> change(BigDecimal originalAmount) {
		Map<String, Integer> change = new HashMap<>();
		BigDecimal remainingAmount = new BigDecimal(0, mc);
		Integer numberOfHundreds = 0;
		Integer numberOfFifties = 0;
		Integer numberOfTwenties = 0;
		Integer numberOfTens = 0;
		Integer numberOfFives = 0;
		Integer numberOfOnes = 0;
		Integer numberOfQuarters = 0;
		Integer numberOfDimes = 0;
		Integer numberOfNickels = 0;
		Integer numberOfPennies = 0;
		
		numberOfHundreds = originalAmount.divide(HUNDRED_DOLLAR).intValue();
		remainingAmount = originalAmount.remainder(HUNDRED_DOLLAR);
		change.put("Hundreds", numberOfHundreds);
		
		numberOfFifties = remainingAmount.divide(FIFTY_DOLLAR).intValue();
		remainingAmount = remainingAmount.remainder(FIFTY_DOLLAR);
		change.put("Fifties", numberOfFifties);
		
		numberOfTwenties = remainingAmount.divide(TWENTY_DOLLAR).intValue();
		remainingAmount = remainingAmount.remainder(TWENTY_DOLLAR);
		change.put("Twenties", numberOfTwenties);
		
		numberOfTens = remainingAmount.divide(TEN_DOLLAR).intValue();
		remainingAmount = remainingAmount.remainder(TEN_DOLLAR);
		change.put("Tens", numberOfTens);
		
		numberOfFives = remainingAmount.divide(FIVE_DOLLAR).intValue();
		remainingAmount = remainingAmount.remainder(FIVE_DOLLAR);
		change.put("Fives", numberOfFives);
		
		numberOfOnes = remainingAmount.divide(ONE_DOLLAR).intValue();
		remainingAmount = remainingAmount.remainder(ONE_DOLLAR);
		change.put("Ones", numberOfOnes);
		
		numberOfQuarters = remainingAmount.divide(QUARTER).intValue();
		remainingAmount = remainingAmount.remainder(QUARTER);
		change.put("Quarters", numberOfQuarters);
		
		numberOfDimes = remainingAmount.divide(DIME).intValue();
		remainingAmount = remainingAmount.remainder(DIME);
		change.put("Dimes", numberOfDimes);
		
		numberOfNickels = remainingAmount.divide(NICKEL).intValue();
		remainingAmount = remainingAmount.remainder(NICKEL);
		change.put("Nickels", numberOfNickels);
		
		numberOfPennies = remainingAmount.divide(PENNY).intValue();
		remainingAmount = remainingAmount.remainder(PENNY);
		change.put("Pennies", numberOfPennies);
		

		return change;
	}
}
