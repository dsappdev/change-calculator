package com.dspohn;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.NumberFormat;

public class Denomination {
	private static MathContext mc = new MathContext(2, RoundingMode.HALF_UP);	
	NumberFormat format = new DecimalFormat("0.###");	
	public static final BigDecimal HUNDRED_DOLLAR = new BigDecimal(100.0, mc);
	public static final BigDecimal FIFTY_DOLLAR = new BigDecimal(50.0, mc);
	public static final BigDecimal TWENTY_DOLLAR = new BigDecimal(20.0, mc);
	public static final BigDecimal TEN_DOLLAR = new BigDecimal(10.0, mc);
	public static final BigDecimal FIVE_DOLLAR = new BigDecimal(5.0, mc);
	public static final BigDecimal ONE_DOLLAR = new BigDecimal(1.0, mc);
	public static final BigDecimal QUARTER = new BigDecimal(0.25, mc);
	public static final BigDecimal DIME = new BigDecimal(0.10, mc);
	public static final BigDecimal NICKEL = new BigDecimal(0.05, mc);
	public static final BigDecimal PENNY = new BigDecimal(0.01, mc);
}
