package com.slokam.limesurvey.testscripts.admin;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.slokam.limesurvey.commons.pages.AdminLoginPage;
import com.slokam.limesurvey.commons.pages.AdminUserControlPage;
import com.slokam.limesurvey.commons.pages.DashboardPage;
import com.slokam.limesurvey.commons.utilites.data.AutomationUtils;
import com.slokam.limesurvey.testscripts.base.TestBase;

public class TestAdminUser extends TestBase {

	@Test(groups = { "regression" }, description = "To verify creation of admin user")
	public void verifySingleAdminUserCreation() {
		launchAdminApp();

		AdminLoginPage adminLoginPage = new AdminLoginPage();
		adminLoginPage.login(username, password);

		DashboardPage dashboardPage = new DashboardPage();
		dashboardPage.clickConfiguration();

		dashboardPage.clickManageAdministrators();

		AdminUserControlPage adminUserControlPage = new AdminUserControlPage();
		String randomString = AutomationUtils.randomAlphaNumeric(5);

		String newUserName = randomString;
		String email = randomString + "@abc.com";
		String fullname = randomString;

		adminUserControlPage.addAdminUser(newUserName, email, fullname);

		String actual = adminUserControlPage.getResultMessage();
		String expected = "Warning";

		Assert.assertEquals(actual, expected);
	}

	@Test(groups = { "regression" }, description = "To verify deletion of admin user")
	public void deleteAdminUser() {
		launchAdminApp();

		AdminLoginPage adminLoginPage = new AdminLoginPage();
		adminLoginPage.login(username, password);

		DashboardPage dashboardPage = new DashboardPage();
		dashboardPage.clickConfiguration();

		dashboardPage.clickManageAdministrators();

		AdminUserControlPage adminUserControlPage = new AdminUserControlPage();
		String randomString = AutomationUtils.randomAlphaNumeric(5);

		String newUserName = randomString;
		String email = randomString + "@abc.com";
		String fullname = randomString;

		adminUserControlPage.addAdminUser(newUserName, email, fullname);
		
		dashboardPage.clickConfiguration();
		dashboardPage.clickManageAdministrators();
		
		adminUserControlPage.searchUser(newUserName);
		adminUserControlPage.deleteSearchedUser();
		
		String expected = "Success!";
		String actual = adminUserControlPage.getResultMessage();
		Assert.assertEquals(actual, expected);
	}
	
	@Test(groups = { "regression" }, description = "To verify deletion of admin user")
	public void deleteAdminUserWithoutSearch() {
		launchAdminApp();

		AdminLoginPage adminLoginPage = new AdminLoginPage();
		adminLoginPage.login(username, password);

		DashboardPage dashboardPage = new DashboardPage();
		dashboardPage.clickConfiguration();

		dashboardPage.clickManageAdministrators();

		AdminUserControlPage adminUserControlPage = new AdminUserControlPage();
		String randomString = AutomationUtils.randomAlphaNumeric(5);

		String newUserName = randomString;
		String email = randomString + "@abc.com";
		String fullname = randomString;

		adminUserControlPage.addAdminUser(newUserName, email, fullname);
		
		dashboardPage.clickConfiguration();
		dashboardPage.clickManageAdministrators();
		
		adminUserControlPage.deleteUser(newUserName);
		
		String expected = "Success!";
		String actual = adminUserControlPage.getResultMessage();
		Assert.assertEquals(actual, expected);
	}
}
