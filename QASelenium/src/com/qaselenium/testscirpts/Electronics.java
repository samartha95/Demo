package com.qaselenium.testscirpts;

import org.testng.annotations.Test;

public class Electronics {
	
	@Test(invocationCount = 3)
	public void searchTheProductTest() {
		System.out.println("Product has been searched");
	}
	
	@Test(priority = 1 , dependsOnMethods = "searchTheProductTest")
	public void addToCartTest() {
		System.out.println("Added to cart");
	}

	@Test(priority = 2,enabled = false)
	public void makeThePayment() {
		System.out.println("Payment has been made");
	}
	
	@Test(priority = 3)
	public void placeTheOrderTest() {
		System.out.println("Order has been placed");
	}
	
}
