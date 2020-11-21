package com.TestCases;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.Base.TestBase;
import com.Pages.HomePage;
import com.Pages.RegisterationPage;

public class RegisterationTCs extends TestBase {

	HomePage homeObj;
	RegisterationPage RegisterObj;

	@BeforeTest
	public void beforeMethod() throws InterruptedException {
		homeObj = new HomePage(driver);
		RegisterObj = new RegisterationPage(driver);
	}

	@Test(priority = 1)
	public void verifyHomeOpenedSuccessfully() throws InterruptedException {

		logger = Logger.getLogger("verify that the home page is opened successfully");
		logger.info("============== verify that the home page is opened successfully->> Start ==============");
		String actualTitle = homeObj.verifyTitleIsDisplayed();
		String expectedTitle = "My Store";
		Assert.assertEquals(actualTitle, expectedTitle);
		logger.info("Text is displayed as expected");
		logger.info("============== verify that the home page is opened successfully ->> End ==============");

	}

	@Test(priority = 2)
	public void verifythatUserRegisteredSuccessfully() throws InterruptedException {

		logger = Logger.getLogger("verify that the user is registered successfully");
		logger.info("============== verify that the user is registered successfully->> Start ==============");
		homeObj.navigatetoSignInLink();
		RegisterObj.setEmailvalue("ra@amr.com");
		RegisterObj.clickCreateAccountButton();
		RegisterObj.chooseFemaleOption();
		RegisterObj.setCustomerFnamevalue("Rana");
		RegisterObj.setCustomerLnamevalue("Amr");
		RegisterObj.setPasswordvalue("1234567");
		// RegisterObj.selectDayfromList("22");
		// RegisterObj.selectMonthfromList("July");
		// RegisterObj.selectYearfromList("2010");
		RegisterObj.setCompanyvalue("DXC");
		RegisterObj.setAddress1value("hhh");
		RegisterObj.setAddress2value("aaaa");
		RegisterObj.setCityvalue("cairo");
		RegisterObj.selectStatefromList("Florida");
		RegisterObj.setPostalCodevalue("11235");
		RegisterObj.selectCountryfromList("United States");
		RegisterObj.setAdditoionalTextvalue("Additional text");
		RegisterObj.setHomePhonevalue("234675966");
		RegisterObj.setMobileNumbervalue("01142267459");
		RegisterObj.setAliasAddressvalue("Alias Address");
		RegisterObj.clickRegisterButton();
		String actualTitle = RegisterObj.verifyTextIsDisplayed();
		String expectedTitle = "MY ACCOUNT";
		Assert.assertEquals(actualTitle, expectedTitle);
		logger.info("Text is displayed as expected");
		logger.info("============== verify that the user is registered successfully ->> End ==============");
	}

}
