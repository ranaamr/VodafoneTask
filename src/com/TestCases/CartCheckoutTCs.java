package com.TestCases;


import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.Base.TestBase;
import com.Pages.CartCheckoutPage;
import com.Pages.HomePage;
import com.Pages.LoginPage;
import com.Pages.WomenShoppingPage;

public class CartCheckoutTCs extends TestBase{
	HomePage homeObj;
	LoginPage loginObj;
	CartCheckoutPage cartObj;
	WomenShoppingPage shoppingObj;
	
	@BeforeTest
	public void beforeMethod() throws InterruptedException {
		homeObj = new HomePage(driver);
		loginObj = new LoginPage(driver);
		cartObj = new CartCheckoutPage(driver);
		shoppingObj = new WomenShoppingPage(driver);
		
	}
	@Test(priority = 1)
	public void verifyUserSignedInSuccessfully() throws InterruptedException {

		logger = Logger.getLogger("verify that the user is logged in successfully");
		logger.info("============== verify that the user is logged in successfully->> Start ==============");
		homeObj.navigatetoSignInLink();
		loginObj.setEmailvalue("ra@amr.com");
		loginObj.setPassowrdvalue("1234567");
		loginObj.clickLoginButton();
		String actualTitle = loginObj.verifyTextIsDisplayed();
		String expectedTitle = "MY ACCOUNT";
		Assert.assertEquals(actualTitle, expectedTitle);
		logger.info("Text is displayed as expected");
		logger.info("============== verify that the user is logged in successfully ->> End ==============");

}
	@Test(priority = 2)
	public void verifyOrderCheckedoutSuccessfully() throws InterruptedException {

		logger = Logger.getLogger("verify that the user Check out the order successfully");
		logger.info("============== verify that the user Check out the order successfully->> Start ==============");
		shoppingObj.navigatetoWomentabLink();
		shoppingObj.addProductToCart(1);
		shoppingObj.clickProceedCheckoutButton();
		cartObj.clickCheckoutButtonSummaryTab();
		cartObj.clickCheckoutButtonAddressTab();
		cartObj.checkTermsBox();
		cartObj.clickCheckoutButtonShippingTab();
		cartObj.ChoosePayByCheck();
		cartObj.clickonConfirmMyOrder();
		String actualTitle = cartObj.verifyTextIsDisplayed();
		String expectedTitle = "Your order on My Store is complete.";
		Assert.assertEquals(actualTitle, expectedTitle);
		logger.info("Text is displayed as expected");
        logger.info("============== verify that the user Check out the order successfully ->> End ==============");

}

}
