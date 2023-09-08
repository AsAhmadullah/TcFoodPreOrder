package com.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Sales_OrderReceiptList {
	
	public WebDriver driver;

	@FindBy(xpath = "//i[@class='glyphicon glyphicon-plus-sign fs-16 details-control']")
	private WebElement viewitem;
	
	@FindBy(xpath = "//i[@class='glyphicon glyphicon-plus-sign fs-16 order-item-control']")
	private WebElement itemstatus;
	
	public Sales_OrderReceiptList(WebDriver driver2) {
		this.driver = driver2;
		PageFactory.initElements(driver, this);

	}

	public WebElement getViewitem() {
		return viewitem;
	}

	public WebElement getItemstatus() {
		return itemstatus;
	}
	
	

}
