package com.interview.shoppingbasket;

import lombok.Data;

@Data
public class Promotion {
	
	private String productCode;
	
	private String desription;

	private double discountValue;

	public Promotion(String productCode, String desription, double discountValue) {
		super();
		this.productCode = productCode;
		this.desription = desription;
		this.discountValue = discountValue;
	}
}
