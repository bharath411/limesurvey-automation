package com.slokam.limesurvey.testscripts.admin;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.slokam.limesurvey.commons.pages.HomePage;
import com.slokam.limesurvey.commons.pages.LoginPage;
import com.slokam.limesurvey.commons.pages.MakeAClaimPage;
import com.slokam.limesurvey.commons.enums.Navigation;
import com.slokam.limesurvey.commons.enums.USERS;
import com.slokam.limesurvey.testscripts.base.TestBase;

public class TestClaimDependent_JHON extends TestBase {

	LoginPage loginPage;
	HomePage homePage;
	MakeAClaimPage makeAClaimPage;
	
	@Test(groups= {"regression"},description="Verify MAKE A CLAIM url ")
	public void verifyAddedDependentDetails() {
		
		loginPage  = new LoginPage();
		loginPage.login(USERS.JHON_BLACK);
		
		homePage = new HomePage();
		homePage.waitForPageToLoad();
		homePage.clickLeftNavigation(Navigation.MAKE_A_CLAIM);
		
		makeAClaimPage = new MakeAClaimPage();
		makeAClaimPage.waitForPageToLoad();
		boolean status = makeAClaimPage.verifyCurrentUrl();
		Assert.assertTrue(status, "Currently not on claim page.");
		
	}
		
}
