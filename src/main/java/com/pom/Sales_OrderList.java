package com.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Sales_OrderList {
	
	public WebDriver driver;

	@FindBy(xpath = "//a[normalize-space()='View Order']")
	private WebElement vieworder;
	
	@FindBy(xpath = "//a[normalize-space()='Order']")
	private WebElement order; 
	
	public Sales_OrderList(WebDriver driver2) {
		this.driver = driver2;
		PageFactory.initElements(driver, this);

	}

	public WebElement getVieworder() {
		return vieworder;
	}

	public WebElement getOrder() {
		return order;
	}
	
}
