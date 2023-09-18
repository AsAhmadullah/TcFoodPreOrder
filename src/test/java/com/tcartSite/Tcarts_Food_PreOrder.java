package com.tcartSite;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.baseClass.BaseClass;
import com.helper.FileReaderManager;
import com.helper.PageObjectManager;

public class Tcarts_Food_PreOrder extends BaseClass {

	public static WebDriver driver = BaseClass.openBrowser("firefox");
	public static PageObjectManager pom = new PageObjectManager(driver);
	public static Logger log = Logger.getLogger(Tcarts_Food_PreOrder.class);

	@Test(priority = 0)
	public void browserLaunch() throws Throwable {

		PropertyConfigurator.configure("log4j.properties");

		log.info("Browser Launch");

		getUrl("https://tcfoodapp.sumanas.xyz/login");
		implicitwait();

		String url = driver.getCurrentUrl();
		AssertJUnit.assertTrue(url.contains("https://tcfoodapp.sumanas.xyz/login"));

		log.info("Login");

		String email = FileReaderManager.getInstanceFRM().getInstanceCR().getEmail();
		sendkeys(pom.getInstanceli().getUsername(), email);

		String password = FileReaderManager.getInstanceFRM().getInstanceCR().getPassword();
		sendkeys(pom.getInstanceli().getPassword(), password);

		clickon(pom.getInstanceli().getSignin());
	}

	@Test(priority = 1)
	public void dashboard() throws Throwable {

		log.info("Dashboard");

		clickon(pom.getInstancedb().getFullscreen());
		staticwait();
		clickonelement(pom.getInstancedb().getMenu());
		clickonelement(pom.getInstancedb().getSvg());
		staticwait();
		clickonelement(pom.getInstancedb().getMenu());
		clickonelement(pom.getInstancedb().getPng());
		staticwait();
		clickonelement(pom.getInstancedb().getMenu());
		clickonelement(pom.getInstancedb().getCsv());
		staticwait();
		click(pom.getInstancedb().getIconview());
		staticwait();
		click(pom.getInstancedb().getDashboard());
		staticwait();

	}

	@Test(priority = 2)
	public void sales() throws Throwable {

		log.info("Sales-ReceiptList");

		click(pom.getInstancedb().getSales());
		staticwait();
		click(pom.getInstancedb().getReceipts());
		staticwait();
		sendkeys(pom.getInstanceco().getSearch(), "	REC1001299");
		staticwait();
		clickonelement(pom.getInstancerl().getViewitem());
		clickonelement(pom.getInstancerl().getItemstatus());
		staticwait();
		clickonelement(pom.getInstanceco().getView());
		staticwait();
		clickonelement(pom.getInstanceco().getCloseview());
		staticwait();
		clickonelement(pom.getInstanceco().getRefresh());
		staticwait();

		log.info("Sales-OrderList");

		click(pom.getInstancedb().getOrders());
		staticwait();
		sendkeys(pom.getInstanceco().getSearch(), "C2-CF0575B5");
		staticwait();
		clickonelement(pom.getInstanceol().getVieworder());
		staticwait();
		clickonelement(pom.getInstanceol().getOrder());
		staticwait();
		clickonelement(pom.getInstanceco().getRefresh());
		staticwait();

		log.info("Sales-RefundHistories");

		click(pom.getInstancedb().getRefunds());
		staticwait();
		sendkeys(pom.getInstanceco().getSearch(), "RF-S000011");
		staticwait();
		clickonelement(pom.getInstanceorl().getViewitem());
		staticwait();
		clickonelement(pom.getInstanceorl().getView());
		staticwait();
		clickonelement(pom.getInstanceco().getCloseview());
		staticwait();
		clickonelement(pom.getInstanceco().getRefresh());
		staticwait();
	}

	@Test(priority = 3)
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

	@Test(priority = 4)
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

	@Test(priority = 5)
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

	@Test(priority = 6)
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

	@Test(priority = 7)
	private void canteen() throws Throwable {

		log.info("Settings-Canteen");

		click(pom.getInstancedb().getSettings());
		staticwait();
		click(pom.getInstancedb().getCanteens());
		staticwait();

		log.info("Add New Canteen");

		clickonelement(pom.getInstanceco().getCreate());
		staticwait();

		clickonelement(pom.getInstanceco().getSave());
		staticwait();
		sendkeys(pom.getInstancecl().getCanteenname(), "Canteen");
		staticwait();
		click(pom.getInstanceco().getReset());
		staticwait();

		sendkeys(pom.getInstancecl().getCanteenname(), "ST Canteen");
		sendkeys(pom.getInstancecl().getCanteencode(), "C");
		clickonelement(pom.getInstanceco().getSave());
		staticwait();

		log.info("Search Canteen-Validate");

		clickonelement(pom.getInstanceco().getPopup());
		sendkeys(pom.getInstanceco().getSearch(), "ST Canteen");
		staticwait();

		String search = driver.findElement(By.xpath("//td[@class='fw-bold sorting_1']")).getText();
		System.out.println(search);
		AssertJUnit.assertEquals("ST Canteen", search);
		staticwait();

		log.info("Edit Canteen");

		clickonelement(pom.getInstanceco().getEdit());
		staticwait();
		clear(pom.getInstancecl().getCanteenname());
		clear(pom.getInstancecl().getCanteencode());
		sendkeys(pom.getInstancecl().getCanteenname(), "As Canteen");
		staticwait();
		sendkeys(pom.getInstancecl().getCanteencode(), "07");
		clickonelement(pom.getInstanceco().getSave());
		staticwait();

		clickonelement(pom.getInstanceco().getPopup());
		clickonelement(pom.getInstanceco().getRefresh());
		staticwait();

		log.info("Overschedule");

		sendkeys(pom.getInstanceco().getSearch(), "As Canteen");
		staticwait();

		clickonelement(pom.getInstancecl().getOverschedule());
		staticwait();
		clickonelement(pom.getInstancecl().getMorningbreak());
		clickonelement(pom.getInstancecl().getLunch());
		clickonelement(pom.getInstancecl().getEveningbreak());
		clickonelement(pom.getInstancecl().getBreakfast());
		staticwait();

		clickonelement(pom.getInstancecl().getNewdish());
		staticwait();
		clickonelement(pom.getInstancecl().getViewclose());
		staticwait();
		clickonelement(pom.getInstancecl().getNewdish());
		staticwait();
		clickonelement(pom.getInstancecl().getAdd());
		staticwait();
		clickonelement(pom.getInstancecl().getClose());
		staticwait();

		clickonelement(pom.getInstancecl().getNewdish());
		sendkeys(pom.getInstancecl().getSearch(), "Tea");
		clickonelement(pom.getInstancecl().getSelectdish());
		clickonelement(pom.getInstancecl().getAdd());
		staticwait();

		clickonelement(pom.getInstancecl().getStockqty());
		clear(pom.getInstancecl().getSearchbox());
		clickonelement(pom.getInstancecl().getCancel());
		staticwait();

		clickonelement(pom.getInstancecl().getStockqty());
		clear(pom.getInstancecl().getSearchbox());
		sendkeys(pom.getInstancecl().getSearchbox(), "100");
		clickonelement(pom.getInstancecl().getSave());
		staticwait();

		clickonelement(pom.getInstancecl().getDelete());
		clickonelement(pom.getInstancecl().getRemoveit());
		navigateback();
		staticwait();

		clickonelement(pom.getInstanceco().getPopup());

		log.info("View & Delete Canteen");

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

	@Test(priority = 8)
	public void Dishes() throws Throwable {

		log.info("Settings-Dishes");

		click(pom.getInstancedb().getSettings());
		staticwait();
		click(pom.getInstancedb().getDishes());
		staticwait();

		log.info("Add New Dish");

		clickonelement(pom.getInstanceco().getCreate());
		staticwait();

		clickonelement(pom.getInstanceco().getSave());
		staticwait();

		sendkeys(pom.getInstancedl().getDishname(), "Brinji");
		sendkeys(pom.getInstancedl().getDishprice(), "100.00");
		radiobutton(pom.getInstancedl().getVeg());
		click(pom.getInstancedl().getLunch());
		click(pom.getInstancedl().getBreakfast());
		click(pom.getInstancedl().getEveningbreak());
		click(pom.getInstancedl().getMorningbreak());
		checkbox(pom.getInstancedl().getGstexclude());
		staticwait();

		clickonelement(pom.getInstanceco().getReset());
		staticwait();

		sendkeys(pom.getInstancedl().getDishname(), "Biryani spl");
		sendkeys(pom.getInstancedl().getDishprice(), "150");
		radiobutton(pom.getInstancedl().getNonveg());
		sendkeys(pom.getInstancedl().getImage(), "/home/st/Downloads/image.jpeg");
		checkbox(pom.getInstancedl().getGstinclude());
		click(pom.getInstancedl().getLunch());

		clickonelement(pom.getInstanceco().getSave());
		staticwait();
		clickonelement(pom.getInstanceco().getPopup());
		staticwait();

		log.info("Funcionality - Next & Previous Page");

		scrollintoview(pom.getInstancedl().getNextpage());
		staticwait();
		click(pom.getInstancedl().getNextpage());
		staticwait();
		click(pom.getInstancedl().getPreviouspage());
		staticwait();

		log.info("Edit Dish");

		sendkeys(pom.getInstanceco().getSearch(), "Biryani spl");
		staticwait();
		clickonelement(pom.getInstanceco().getEdit());
		staticwait();
		clear(pom.getInstancedl().getDishname());
		clear(pom.getInstancedl().getDishprice());
		staticwait();
		sendkeys(pom.getInstancedl().getDishname(), "Biryanii");
		staticwait();
		sendkeys(pom.getInstancedl().getDishprice(), "150.00");
		staticwait();
		clickonelement(pom.getInstanceco().getSave());
		staticwait();
		clickonelement(pom.getInstanceco().getPopup());

		clickonelement(pom.getInstanceco().getRefresh());

		log.info("View & Delete Dish");

		sendkeys(pom.getInstanceco().getSearch(), "Biryanii");
		staticwait();

		clickonelement(pom.getInstanceco().getView());
		staticwait();
		clickonelement(pom.getInstanceco().getCloseview());
		staticwait();

		clickonelement(pom.getInstanceco().getDelete());
		staticwait();
		clickonelement(pom.getInstanceco().getDeleteit());
		clickonelement(pom.getInstanceco().getOk());

		clickonelement(pom.getInstanceco().getRefresh());

	}

	@Test(priority = 9)
	public void gst() throws Throwable {

		log.info("Settings-Gst");

		click(pom.getInstancedb().getSettings());
		staticwait();
		click(pom.getInstancedb().getGst());

		sendkeys(pom.getInstanceco().getSearch(), "SGST");
		staticwait();
		clickonelement(pom.getInstanceco().getEdit());
		staticwait();
		clear(pom.getInstancegl().getGstpercent());
		sendkeys(pom.getInstancegl().getGstpercent(), "1.80");
		staticwait();
		click(pom.getInstanceco().getReset());
		staticwait();
		clear(pom.getInstancegl().getGstpercent());
		sendkeys(pom.getInstancegl().getGstpercent(), "2.50");
		staticwait();
		clickonelement(pom.getInstanceco().getSave());
		staticwait();
		clickonelement(pom.getInstanceco().getRefresh());
	}

	@Test(priority = 10)
	public void stockreports() throws Throwable {

		log.info("Reports");

		click(pom.getInstancedb().getReports());
		staticwait();

		log.info("Gst Report");

		click(pom.getInstancedb().getGstreport());
		staticwait();

		log.info("Stock Report-Particular Dish");

		click(pom.getInstancedb().getStockreport());
		staticwait();

		clickonelement(pom.getInstancesr().getDaterange());
		staticwait();
		clickonelement(pom.getInstancesr().getLast7days());
		staticwait();

		checkbox(pom.getInstancesr().getSelectalltf());
		staticwait();

		sendkeys(pom.getInstancesr().getSearchselectabledishes(), "Idli");
		staticwait();
		driver.findElement(By.id("2094196567-selectable")).click();
		staticwait();
		clear(pom.getInstancesr().getSearchselectabledishes());

		sendkeys(pom.getInstancesr().getSearchselectabledishes(), "Vadai");
		staticwait();
		driver.findElement(By.id("-535951863-selectable")).click();
		staticwait();
		clear(pom.getInstancesr().getSearchselectabledishes());

		sendkeys(pom.getInstancesr().getSearchselectiondishes(), "Vadai");
		staticwait();
		driver.findElement(By.id("-535951863-selection")).click();
		staticwait();
		clear(pom.getInstancesr().getSearchselectiondishes());

		clickonelement(pom.getInstancesr().getSearchbutton());
		staticwait();
		clickonelement(pom.getInstancesr().getReset());

		log.info("Stock Report-All Dishes");

		clickonelement(pom.getInstancesr().getDaterange());
		staticwait();
		clickonelement(pom.getInstancesr().getLast30days());
		staticwait();

		checkbox(pom.getInstancesr().getSelectalltf());
		staticwait();

		clickonelement(pom.getInstancesr().getSelectall());
		staticwait();
		clickonelement(pom.getInstancesr().getDeselectall());
		staticwait();
		clickonelement(pom.getInstancesr().getSelectall());

		clickonelement(pom.getInstancesr().getSearchbutton());
		staticwait();
	}

	@Test(priority = 11)
	public void salesReport() throws Throwable {

		log.info("Reports-Sales Report");

		click(pom.getInstancedb().getReports());
		click(pom.getInstancedb().getSalesreport());
		staticwait();

		clickonelement(pom.getInstancersr().getDaterange());
		staticwait();
		clickonelement(pom.getInstancersr().getLast30days());
		staticwait();

		checkbox(pom.getInstancersr().getSelectalltf());
		staticwait();

		clickonelement(pom.getInstancersr().getSelectall());
		staticwait();
		clickonelement(pom.getInstancersr().getDeselectall());
		staticwait();
		clickonelement(pom.getInstancersr().getSelectall());

		clickonelement(pom.getInstancersr().getSearchbutton());
		staticwait();

		sendkeys(pom.getInstanceco().getSearch(), "Idli");
		staticwait();
		clickonelement(pom.getInstanceco().getRefresh());
		staticwait();
		sendkeys(pom.getInstanceco().getSearch(), "Chapati");
		staticwait();
		clickonelement(pom.getInstanceco().getRefresh());
		staticwait();
		clickonelement(pom.getInstancersr().getReset());
	}

	@Test(priority = 12)
	public void gstReport() throws Throwable {

		log.info("Reports-Gst Report");

		click(pom.getInstancedb().getReports());
		click(pom.getInstancedb().getGstreport());
		staticwait();

		click(pom.getInstancecgr().getDaterange());
		staticwait();
		driver.findElement(By.xpath("//div[@class='drp-calendar right']//tbody//tr[1]//td[6]")).click();
		staticwait();
		driver.findElement(By.xpath("//div[@class='drp-calendar right']//tbody//tr[2]//td[5]")).click();

		clickonelement(pom.getInstancecgr().getSearchbutton());
		staticwait();
		clickonelement(pom.getInstancecgr().getReset());
	}

	@Test(priority = 13)
	public void feedback() throws Throwable {

		log.info("App Feedback");

		click(pom.getInstancedb().getAppfeedback());
		staticwait();

		log.info("Tester");
		sendkeys(pom.getInstancefb().getSearch(), "Tester"); // 1
		staticwait();
		clickonelement(pom.getInstancefb().getView());
		staticwait();
		clickonelement(pom.getInstanceco().getCloseview());
		staticwait();
		clickonelement(pom.getInstancefb().getRefresh());
		staticwait();
		log.info("Developer");
		sendkeys(pom.getInstancefb().getSearch(), "Developer"); // 2
		staticwait();
		clickonelement(pom.getInstancefb().getView());
		staticwait();
		clickonelement(pom.getInstanceco().getCloseview());
		staticwait();
		clickonelement(pom.getInstancefb().getRefresh());
		staticwait();
	}

	@Test(priority = 14)
	public void logout() throws Throwable {

		log.info("Logout");

		clickonelement(pom.getInstancedb().getDashboard());
		staticwait();

		clickonelement(pom.getInstancelo().getAdmin());
		staticwait();
		clickonelement(pom.getInstancelo().getLogout());
		staticwait();
		driver.quit();

	}

}
