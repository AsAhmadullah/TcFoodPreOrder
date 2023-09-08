package com.tcartSite;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.baseClass.BaseClass;
import com.helper.FileReaderManager;
import com.helper.PageObjectManager;

public class Users extends BaseClass {

	public static WebDriver driver = BaseClass.openBrowser("firefox");
	public static PageObjectManager pom = new PageObjectManager(driver);
	public static Logger log = Logger.getLogger(Users.class);

	@Test(priority = 1)
	public void BrowserLaunch() throws Throwable {

		PropertyConfigurator.configure("log4j.properties");

		log.info("Browser Launch");

		getUrl("https://tcfoodapp.sumanas.xyz/login");
		implicitwait();

		String url = driver.getCurrentUrl();
		Assert.assertTrue(url.contains("https://tcfoodapp.sumanas.xyz/login"));

		log.info("Login");

		String email = FileReaderManager.getInstanceFRM().getInstanceCR().getEmail();
		sendkeys(pom.getInstanceli().getUsername(), email);

		String password = FileReaderManager.getInstanceFRM().getInstanceCR().getPassword();
		sendkeys(pom.getInstanceli().getPassword(), password);

		clickon(pom.getInstanceli().getSignin());
	}

	@Test(priority = 2)
	public void student() throws Throwable {

		log.info("Users-Student");

		click(pom.getInstancedb().getUsers());
		staticwait();
		click(pom.getInstancedb().getStudent());
		staticwait();

		log.info("Student-Create User");

		clickonelement(pom.getInstanceco().getCreate());
		staticwait();
		clickonelement(pom.getInstanceco().getSave());
		staticwait();

		sendkeys(pom.getInstancestl().getFirstname(), "Abdul");
		sendkeys(pom.getInstancestl().getLastname(), "K");
		sendkeys(pom.getInstancestl().getEmail(), "ms10@gmail.com");
		sendkeys(pom.getInstancestl().getRegno(), "0010");
		staticwait();
		radiobutton(pom.getInstancestl().getMale());

		sendkeys(pom.getInstancestl().getDeptname(), "B.A Tamil");

		sendkeys(pom.getInstancestl().getPhonenumber(), "9171737482");
		sendkeys(pom.getInstancestl().getAlternatenumber(), "9873844718");

		clickonelement(pom.getInstanceco().getSave());
		staticwait();

		log.info("Edit & Search");

		clickonelement(pom.getInstanceco().getPopup());
		sendkeys(pom.getInstanceco().getSearch(), "Abdul");
		staticwait();

		clickonelement(pom.getInstanceco().getEdit());
		staticwait();
		clear(pom.getInstancestl().getFirstname());
		sendkeys(pom.getInstancestl().getFirstname(), "Ahmad");

		clickonelement(pom.getInstanceco().getSave());
		staticwait();

		clickonelement(pom.getInstanceco().getPopup());
		clickonelement(pom.getInstanceco().getRefresh());
		staticwait();

		log.info("View & Delete Canteen");

		sendkeys(pom.getInstanceco().getSearch(), "Ahmad");
		staticwait();

		clickonelement(pom.getInstanceco().getView());
		staticwait();
		clickonelement(pom.getInstanceco().getCloseview());
		staticwait();

		clickonelement(pom.getInstanceco().getDelete());
		staticwait();
		clickonelement(pom.getInstanceco().getDeleteit());
		clickonelement(pom.getInstanceco().getOk());
		staticwait();

		clickonelement(pom.getInstanceco().getRefresh());

	}

	@Test(priority = 3)
	public void staff() throws Throwable {

		log.info("Users-Staff");

		click(pom.getInstancedb().getUsers());
		click(pom.getInstancedb().getStaff());
		staticwait();

		log.info("Staff-Create User");

		clickonelement(pom.getInstanceco().getCreate());
		staticwait();
		clickonelement(pom.getInstanceco().getSave());
		staticwait();

		sendkeys(pom.getInstancesl().getStaffname(), "Aaaaaa");
		staticwait();
		clickonelement(pom.getInstanceco().getReset());
		staticwait();
		sendkeys(pom.getInstancesl().getStaffname(), "Ashik");
		sendkeys(pom.getInstancesl().getStaffemail(), "rajanish@gmail.com");
		sendkeys(pom.getInstancesl().getMobile(), "9171757885");

		clickonelement(pom.getInstanceco().getSave());
		staticwait();

		log.info("Edit & Search");

		clickonelement(pom.getInstanceco().getPopup());
		sendkeys(pom.getInstanceco().getSearch(), "Ashik");
		staticwait();

		clickonelement(pom.getInstanceco().getEdit());
		staticwait();
		clear(pom.getInstancesl().getStaffname());
		sendkeys(pom.getInstancesl().getStaffname(), "Anish Raj");

		clickonelement(pom.getInstanceco().getSave());
		staticwait();

		clickonelement(pom.getInstanceco().getPopup());
		clickonelement(pom.getInstanceco().getRefresh());
		staticwait();

		log.info("View & Delete Canteen");

		sendkeys(pom.getInstanceco().getSearch(), "Anish Raj");
		staticwait();

		clickonelement(pom.getInstanceco().getView());
		staticwait();
		clickonelement(pom.getInstanceco().getCloseview());
		staticwait();

		clickonelement(pom.getInstanceco().getDelete());
		staticwait();
		clickonelement(pom.getInstanceco().getDeleteit());
		clickonelement(pom.getInstanceco().getOk());
		staticwait();

		clickonelement(pom.getInstanceco().getRefresh());

	}

	@Test(priority = 4)
	public void canteenStaff() throws Throwable {

		log.info("Users-Canteen Staff");

		click(pom.getInstancedb().getUsers());
		staticwait();
		click(pom.getInstancedb().getCanteenstaff());
		staticwait();

//		log.info("Create-Canteen Staff");
//
//		clickonelement(pom.getInstanceco().getCreate());
//		staticwait();
//		clickonelement(pom.getInstanceco().getSave());
//		staticwait();
//
//		sendkeys(pom.getInstancecsl().getCanteenstaffname(), "Aaa");
//
//		clickonelement(pom.getInstanceco().getReset());
//		staticwait();
//
//		sendkeys(pom.getInstancecsl().getCanteenstaffname(), "Arull");
//		sendkeys(pom.getInstancecsl().getCanteenstaffmail(), "arul@gmail.com");
//		staticwait();
//		driver.findElement(By.xpath("//label[@for='01h3vpwsy891y98rmbjxtpx5m7']")).click();
//
//		clickonelement(pom.getInstanceco().getSave());
//		staticwait();
//		clickonelement(pom.getInstanceco().getPopup());

		log.info("Edit & Search");

		sendkeys(pom.getInstanceco().getSearch(), "Arun");
		staticwait();

		clickonelement(pom.getInstanceco().getEdit());
		staticwait();
		clear(pom.getInstancecsl().getCanteenstaffname());
		sendkeys(pom.getInstancecsl().getCanteenstaffname(), "Arul");

		clickonelement(pom.getInstanceco().getSave());
		staticwait();

		clickonelement(pom.getInstanceco().getPopup());
		clickonelement(pom.getInstanceco().getRefresh());
		staticwait();

		log.info("View & Delete Canteen");

		sendkeys(pom.getInstanceco().getSearch(), "Arul");
		staticwait();

		clickonelement(pom.getInstanceco().getView());
		staticwait();
		clickonelement(pom.getInstanceco().getCloseview());
		staticwait();

		clickonelement(pom.getInstanceco().getDelete());
		staticwait();
		clickonelement(pom.getInstanceco().getDeleteit());
		driver.findElement(By.xpath("//button[normalize-space()='Cancel']")).click();
//		clickonelement(pom.getInstanceco().getOk());
		staticwait();

//		clickonelement(pom.getInstanceco().getRefresh());

	}

	@Test(priority = 5)
	public void guest() throws Throwable {

		log.info("Users-Guest");

		click(pom.getInstancedb().getUsers());
		staticwait();
		click(pom.getInstancedb().getGuest());
		staticwait();

		sendkeys(pom.getInstanceugl().getSearch(), "Kathir");
		staticwait();
		clickonelement(pom.getInstanceugl().getView());
		staticwait();
		clickonelement(pom.getInstanceugl().getCloseview());
		staticwait();
		clickonelement(pom.getInstanceugl().getRefresh());

	}

}
