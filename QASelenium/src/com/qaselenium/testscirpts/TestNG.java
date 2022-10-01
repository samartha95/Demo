package com.qaselenium.testscirpts;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNG {
	
	@BeforeSuite
	public void configBS() {
		System.out.println("Connected to DB");
	}
	
	@BeforeTest
	public void configTest() {
		System.out.println("lauched the browser in parallel execution");
	}
	
	@BeforeClass
	public void configBC() {
		System.out.println("Luached the browser in normal execution");
	}
	
	@BeforeMethod
	public void configBM() {
		System.out.println("Logged in to app");
	}
	
	@Test
	public void searchForTheProductTest() {
		System.out.println("Product has been searched");
	}
	
	@Test
	public void addToCartTest() {
		System.out.println("Product has been added to cart");
	}
	
	@AfterMethod
	public void configAM() {
		System.out.println("Logged from the app");
	}
	
	@AfterClass
	public void configAC() {
		System.out.println("Closed the browser in normal execution ");
	}
	
	@AfterTest
	public void configAT() {
		System.out.println("closed the browser in parallel execution");
	}
	
	@AfterSuite
	public void configAS() {
		System.out.println("Desconnected from DB");
	}
	
}
