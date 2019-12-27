package com.slokam.limesurvey.testscripts.admin;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.slokam.limesurvey.commons.pages.AdminLoginPage;
import com.slokam.limesurvey.commons.pages.DashboardPage;
import com.slokam.limesurvey.commons.pages.GlobalSettingsPage;
import com.slokam.limesurvey.testscripts.base.TestBase;

public class TestLanguageUpdate extends TestBase {

	
	@Test(groups = { "regression" }, description = "verifying language change/update")
	public void verifyLanguageUpdate() {
		String language = "Thai";
		launchAdminApp();
		AdminLoginPage adminLoginPage = new AdminLoginPage();

		adminLoginPage.login(username, password);

		DashboardPage dashboardPage = new DashboardPage();
		dashboardPage.clickConfiguration();

		dashboardPage.clickOnGlobalSettings();

		GlobalSettingsPage globalSettingsPage = new GlobalSettingsPage();
		globalSettingsPage.clickLanguageTab();

		String actualDefaultLanguage = globalSettingsPage.getDefaultLanguageValue();
		String expectedDefaultLanguage = "English - English";

		Assert.assertEquals(actualDefaultLanguage, expectedDefaultLanguage);

		globalSettingsPage.moveAllVisibleLanguagesToHidden();
		String exepectedSaveMessage = "Global settings were saved.";

		globalSettingsPage.moveLanguageFromHiddenToVisible(language);

		globalSettingsPage.clickOnSaveButton();

		String actualSaveMessage = globalSettingsPage.getSaveMessage();

		Assert.assertTrue(actualSaveMessage.contains(exepectedSaveMessage));

		dashboardPage.logout();

		List<String> languages = adminLoginPage.getLanguagesAvailableInDropdown();
		boolean flag = false;
		for (String actualLanguage : languages) {
			flag = actualLanguage.contains(language);
		}

		Assert.assertTrue(flag, language + " is not available in dropdown");
	}
}
