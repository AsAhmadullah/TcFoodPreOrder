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

public class Task extends BaseClass {
	public static WebDriver driver = BaseClass.openBrowser("firefox");
	public static PageObjectManager pom = new PageObjectManager(driver);
	public static Logger log = Logger.getLogger(Task.class);

	@Test
	public void BrowserLaunch() throws Throwable {

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

	@Test
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

	@Test
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
	@Test(groups = { "Smoke" })
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
}
//-----------------------------------------------------------------------------------------------------------
//		log.info("Settings-Timeframes");
//		
//		click(pom.getInstancedb().getSettings());
//		staticwait();
//		click(pom.getInstancedb().getTimeframes());
//		staticwait();
//		clickonelement(pom.getInstanceco().getCreate());
//		sendkeys(pom.getInstancetfl().getTfname(), "Dinner");
//		clickonelement(pom.getInstancetfl().getSttime());
//		staticwait();
//		WebElement timeBox = driver.findElement(By.xpath("//input[@id='start_time']"));
//		timeBox.sendKeys(Keys.TAB);
//		timeBox.sendKeys("0800PM");
