package com.slokam.limesurvey.testscripts.admin;

import org.testng.annotations.Test;

import com.slokam.limesurvey.commons.pages.AdminLoginPage;
import com.slokam.limesurvey.commons.pages.AdminUserControlPage;
import com.slokam.limesurvey.commons.pages.DashboardPage;
import com.slokam.limesurvey.commons.utilites.data.AutomationUtils;
import com.slokam.limesurvey.testscripts.base.TestBase;

public class TestUserPermissions extends TestBase{

	
	@Test( groups = {"regression"} , description = "Test Global Settings Permission for New user")
	public void testGlobalSettingsPermissionForNewUser() {
		launchAdminApp();
		
		AdminLoginPage adminLoginPage = new AdminLoginPage();
		adminLoginPage.login(username, password);
		
		DashboardPage dashboardPage = new DashboardPage();
		dashboardPage.clickConfiguration();
		dashboardPage.clickManageAdministrators();
		
		String randomSt = AutomationUtils.randomAlphaNumeric(7);
		String email = randomSt+ "@example.com";
		AdminUserControlPage adminUserControlPage = new AdminUserControlPage();
		adminUserControlPage.addAdminUser(randomSt, email, randomSt);
		
		
	}
	
}
