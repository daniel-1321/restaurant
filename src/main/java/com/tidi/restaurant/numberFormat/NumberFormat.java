package com.tidi.restaurant.numberFormat;
/**
 * @author HO_TRONG_DAI
 * @date Nov 1, 2019
 * @tag 
 */
public class NumberFormat {
	public static String formatNumber(double number) {
		return String.format("%,.2f",number);
	}
}
