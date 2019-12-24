package com.slokam.limesurvey.commons.pages;

import java.io.File;
import java.util.LinkedHashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.slokam.limesurvey.commons.pages.base.BasePage;
import com.slokam.limesurvey.commons.pojo.GNPMData;
import com.slokam.limesurvey.commons.utilites.autoit.AutoItUtil;
import com.slokam.limesurvey.commons.enums.Category;
import com.slokam.limesurvey.commons.enums.Choice;
import com.slokam.limesurvey.commons.enums.Constants;
import com.slokam.limesurvey.commons.enums.Questionnaire;
import com.slokam.limesurvey.commons.enums.SelectOptions;
import com.slokam.limesurvey.commons.enums.USERS;
import com.slokam.limesurvey.testscripts.base.Assert;

public class MakeAClaimPage extends BasePage {
	private final Logger logger = LoggerFactory.getLogger(MakeAClaimPage.class);
	public static final String MAKE_A_CLAIM_TITLE = "Make a claim | GroupNet for Plan Members";

	// locators

	String titleHeading = ".generalTitle .title";
	String documentsHandy = ".claim-main-begin h3";
	String supportingDocumentsMessageEle = ".claim-main-begin p.lowWeight";
	String beginClaimEle = ".claimBegin";
	String usersNameEle = ".claim-for-person .claim-options-title";

	public void waitForPageToLoad() {
		waitForPageReady();
		String headerTitle = waitForElement(By.id("headerTitle")).getText();
		logger.debug("header title - " + headerTitle);
	}

	public boolean verifyCurrentUrl() {
		String redirectedUrl = appProps.getProperty("redirectedUrl");
		String expectedUrl = redirectedUrl + Constants.MAKE_A_CLAIM_URL.getName();
		String actualUrl = driver.getCurrentUrl();
		logger.debug("expected url  = " + expectedUrl);
		logger.debug("actual url  = " + actualUrl);
		return expectedUrl.equals(actualUrl);
	}

	public void beginyourClaim() {
		logger.trace("in beginyourClaim method");
		String makeAClaimMessage = waitForElement(By.cssSelector(titleHeading)).getText().trim();
		String haveYourReceiptsHandyMessage = waitForElement(By.cssSelector(documentsHandy)).getText().trim();
		String supportingDocumentsMessage = waitForElement(By.cssSelector(supportingDocumentsMessageEle)).getText()
				.trim();
		
		logger.debug("makeAClaimMessage : " + makeAClaimMessage);
		Assert.assertEquals(makeAClaimMessage, bundle.getProperty("makeAClaimMessage"));
		extentTest.pass("Verification Success - makeAClaimMessage" + makeAClaimMessage);
		logger.debug("haveYourReceiptsHandyMessage : " + haveYourReceiptsHandyMessage);
		Assert.assertEquals(haveYourReceiptsHandyMessage, bundle.getProperty("haveYourReceiptsHandyMessage"));
		extentTest.pass("Verification Success - haveYourReceiptsHandyMessage " + haveYourReceiptsHandyMessage);
		logger.debug("supportingDocumentsMessage : " + supportingDocumentsMessage);
		Assert.assertEquals(supportingDocumentsMessage, bundle.getProperty("supportingDocumentsMessage"));
		extentTest.pass("Verification Success - supportingDocumentsMessage " + supportingDocumentsMessage);
		waitForElement(By.cssSelector(beginClaimEle)).click();
	}

	public void selectAPlan(String plan) {
		String element = "//div[@class='claim-options-title' and contains(text(),'"+plan+"')]";
		Assert.assertTrue(isElementPresent(By.xpath(element)));
		waitForElement(By.xpath(element)).click();
	}
	
	public void clickOnMember(USERS user) {

		String userName = user.getFirstName() + " " + user.getLastName();
		List<String> usersList = getElementsTextAreaInList(By.cssSelector(usersNameEle));
		logger.debug("userName : " + userName);
		Assert.assertTrue(usersList.contains(userName), userName + " is not available in the UI");
		extentTest.pass("Verification Success - userName " + userName);
		/*
		 * String memberName = waitForElement(By.xpath("")).getText();
		 * Assert.assertEquals(memberName, user.getName());
		 */
		String userClickBtn = "//button[contains(@data-currentcoveredperson,'" + user.getFirstName()
				+ "') and contains(@data-currentcoveredperson,'" + user.getLastName() + "')]";
		waitForElement(By.xpath(userClickBtn)).click();
	}

	String claimTypeMessageEle = "//legend[@id='claimTypeSelectionLegend']/h2/span[1]";
	String whatIsTheClaimMessageEle = ".claim-cont-list.claim-type.active-step .claim-header";
	String selectAClaimMessageEle = ".claim-type-code-instructions p";

	public void verifyClaimTypeOptions() {
		String claimTypeMessage = waitForElement(By.xpath(claimTypeMessageEle)).getText().trim();
		String whatIsTheClaimMessage = waitForElement(By.cssSelector(whatIsTheClaimMessageEle)).getText().trim();
		String selectAClaimMessage = waitForElement(By.cssSelector(selectAClaimMessageEle)).getText().trim();
		
		logger.debug("Verify claimTypeMessage : " + claimTypeMessage);
		Assert.assertEquals(claimTypeMessage, bundle.getProperty("claimType"));
		extentTest.pass("Verification Success - claim type " + claimTypeMessage);
		
		logger.debug("verify whatIsTheClaimMessage : " + whatIsTheClaimMessage);
		Assert.assertEquals(whatIsTheClaimMessage, bundle.getProperty("whatIsTheClaimForMessage"));
		extentTest.pass("Verification Success - whatIsTheClaimMessage " + whatIsTheClaimMessage);
		
		logger.debug("Verify selectAClaimMessage : " + selectAClaimMessage);
		Assert.assertEquals(selectAClaimMessage, bundle.getProperty("selectAClaimMessage"));
		extentTest.pass("Verification Success - selectAClaimMessage " + selectAClaimMessage);
	
		
	}

	String openAllCategoryEle = "#A_ALL_CATEGORIES";
	String closeAllCategoryEle = "#A_ALL_CATEGORIES";

	public void clickOnOpenAllCategories() {
		String openAllText = waitForElement(By.cssSelector(openAllCategoryEle)).getText().trim();
		logger.debug("Verify openAll categories : " + openAllText);
		Assert.assertEquals(openAllText, bundle.getProperty("openAll"));
		extentTest.pass("Verification Success - openAllText " + openAllText);
		waitForElement(By.cssSelector(openAllCategoryEle)).click();
	}

	public void verifyCloseAllCategories() {
		String closeAllText = waitForElement(By.cssSelector(closeAllCategoryEle)).getText().trim();
		logger.debug("Verify closeAllText categories : " + closeAllText);
		Assert.assertEquals(closeAllText, bundle.getProperty("closeAll"));
		extentTest.pass("Verification Success - closeAllText " + closeAllText);
	}

	public void clickOnCategory(Category category) {
		String firstHeading = category.getItem();
		String secondService = category.getSubItem();
		String thirdService = category.getMiniItem();
		if (!firstHeading.equals("")) {
			waitForElement(By.xpath(
					"//div[@class='claim-type-code-category-title']/a[contains(text(),'" + firstHeading + "')]"));
		}
		if (!secondService.equals("")) {
			waitForElement(By.xpath("//div[@class='claim-type-code-category-title']/a[contains(text(),'" + firstHeading
					+ "')]//following::button[contains(@class,'claim-list-item')]//p[contains(text(),'"
					+ secondService + "')]")).click();
		}
		
		if (thirdService != null && !thirdService.equals("")) {
			waitForElement(By
					.xpath("//button[@class='claim-options-simple claim-list-item claim-type-subcategory claim-list-claim-type']//p[text()='"
							+ thirdService + "']")).click();
		}

	}

	public void addProviderDetails(GNPMData pojo) {
		//waitForElement(By.cssSelector("#firstName")).sendKeys(pojo.);
		waitForElement(By.cssSelector("#lastName")).sendKeys(pojo.getServiceProvider());
		//waitForElement(By.cssSelector("#clinicName")).sendKeys(pojo.getClinicName());
		waitForElement(By.cssSelector("#phoneNumber")).sendKeys(pojo.getPhoneNumber());
		//waitForElement(By.cssSelector("#streetAddress")).sendKeys(pojo.getStreetAddress());
		//waitForElement(By.cssSelector("#postalCode")).sendKeys(pojo.getPostalCode());
		waitForElement(By.cssSelector("#cityOrTown")).sendKeys(pojo.getCity());

		selectOption(By.cssSelector("#provinceCode"), pojo.getProvince(), SelectOptions.TEXT);
		// selectOption(By.cssSelector("#country"), pojo.getCountry(),
		// SelectOptions.TEXT);
	}

	String addProvider = ".add-new-provider-submit button.btn-large-print";

	public void clickAddProvider() {
		waitForElement(By.cssSelector(addProvider)).click();
	}

	public void clickAddedProvider(GNPMData pojo) {
		waitForElement(By.xpath("//ul[@class='select-provider-list']/li//button[contains(@data-currentprovider,'"
				+ pojo.getServiceProvider() + "')]")).click();
		;
	}
	public void selectQuestionnaire(LinkedHashMap<Questionnaire, Choice> questions) {
		selectQuestionnaire(questions,null);
	}

	public void selectQuestionnaire(LinkedHashMap<Questionnaire, Choice> questions, GNPMData data) {
		try {
			questions.forEach((questionaire, choice) -> {
				WebElement element = getElementWithText(
						By.xpath(
								"//div[@class='claim-options-details claim-options-details-expense-questions']//fieldset//legend"),
						questionaire.getQuestion());
				if (choice.name().equals("Yes")) {
					if(element!=null){
						element.findElement(By.xpath("./following::input[@type='radio'][1]")).click();
					}else{
						waitForElement(By.xpath("//div[@class='claim-options-details claim-options-details-expense-questions']//fieldset//legend[contains(text(),'"+questionaire.getQuestion()+"')]/following::input[@type='radio'][2]")).click();
					}
					
				} else if(choice.name().equals("No")){
					if(element!=null){
						element.findElement(By.xpath("./following::input[@type='radio'][2]")).click();
					}else{
						waitForElement(By.xpath("//div[@class='claim-options-details claim-options-details-expense-questions']//fieldset//legend[contains(text(),'"+questionaire.getQuestion()+"')]/following::input[@type='radio'][2]")).click();
					}
					
				} else if(choice.name().equals("Date")){
					if(data!=null){
						selectOption(By.xpath("//div[@class='claim-options-details claim-options-details-expense-questions']//div[contains(@class,'details-options')]//*[contains(text(),'"+questionaire.getQuestion()+"')]//following::select[@data-parsley-month-required-with-day-message='Select a month']"),data.getMonth1(),SelectOptions.TEXT);
						waitForElement(By.xpath("//div[@class='claim-options-details claim-options-details-expense-questions']//div[contains(@class,'details-options')]//*[contains(text(),'"+questionaire.getQuestion()+"')]//following::input[@id='placementDateDay']")).sendKeys(data.getDate1());
						waitForElement(By.xpath("//div[@class='claim-options-details claim-options-details-expense-questions']//div[contains(@class,'details-options')]//*[contains(text(),'"+questionaire.getQuestion()+"')]//following::input[@id='placementDateYear']")).sendKeys(data.getYear1());
					}
				}
				
				sleep(2);

			}

			);
		} catch (NullPointerException ex) {
			logger.error("Problem in questions",ex);
		}
	}

	public void addExpenseDetails(GNPMData pojo,String totalCharge,String testAmountOthers) {

		selectOption(By.xpath("//select[@data-parsley-required-message='Select a month']"), pojo.getMonth(), SelectOptions.TEXT);
		selectOption(By.xpath("//select[starts-with(@id,'expenses') and contains(@name,'serviceType')]"), pojo.getServiceType(), SelectOptions.TEXT);
		waitForElement(By.xpath("//input[@data-parsley-required-message='Enter a valid day']")).clear();
		waitForElement(By.xpath("//input[@data-parsley-required-message='Enter a valid day']")).sendKeys(pojo.getDate());
		waitForElement(By.xpath("//input[@data-parsley-required-message='Enter a valid year']")).clear();
		waitForElement(By.xpath("//input[@data-parsley-required-message='Enter a valid year']")).sendKeys(pojo.getYear());
		waitForElement(By.cssSelector(".lengthOfServiceHours")).clear();
		waitForElement(By.cssSelector(".lengthOfServiceHours")).sendKeys(pojo.getHours());
		waitForElement(By.cssSelector(".lengthOfServiceMinutes")).clear();
		waitForElement(By.cssSelector(".lengthOfServiceMinutes")).sendKeys(pojo.getMinutes());
		sleep(2);
		waitForElement(By.cssSelector(".totalCharge")).clear();
		waitForElement(By.cssSelector(".totalCharge")).sendKeys(totalCharge);
		waitForElement(By.cssSelector(".otherInsurancePaid")).clear();
		waitForElement(By.cssSelector(".otherInsurancePaid")).sendKeys(testAmountOthers);
		sleep(2);
		scrollDown();
		
	}
	
	public void addExpenseDetailsEquipment(GNPMData pojo,String totalCharge,String testAmountOthers) {

		selectOption(By.xpath("//select[@data-parsley-required-message='Select a month']"), pojo.getMonth(), SelectOptions.TEXT);
		//selectOption(By.xpath("//[@id='expenses[0]=serviceType']"),pojo.getServiceType();
		//*[@id="expenses[0].serviceType"]
		selectOption(By.xpath("//select[starts-with(@id,'expenses') and contains(@name,'serviceType')]"), pojo.getServiceType(), SelectOptions.TEXT);
		waitForElement(By.xpath("//input[@data-parsley-required-message='Enter a valid day']")).clear();
		waitForElement(By.xpath("//input[@data-parsley-required-message='Enter a valid day']")).sendKeys(pojo.getDate());
		waitForElement(By.xpath("//input[@data-parsley-required-message='Enter a valid year']")).clear();
		waitForElement(By.xpath("//input[@data-parsley-required-message='Enter a valid year']")).sendKeys(pojo.getYear());
		
		sleep(2);
		waitForElement(By.cssSelector(".totalCharge")).clear();
		waitForElement(By.cssSelector(".totalCharge")).sendKeys(totalCharge);
		waitForElement(By.cssSelector(".otherInsurancePaid")).clear();
		waitForElement(By.cssSelector(".otherInsurancePaid")).sendKeys(testAmountOthers);
		sleep(2);
		scrollDown();
		
	}
	public void addExpenseDetailsDental(GNPMData pojo,String dentalfee,String labfee) {

		selectOption(By.xpath("//select[@data-parsley-required-message='Select a month']"), pojo.getMonth(), SelectOptions.TEXT);
		waitForElement(By.xpath("//div[contains(@class,'expenseOriginal')]//input[contains(@data-parsley-required-message,'Enter a valid day')]")).clear();
		waitForElement(By.xpath("//div[contains(@class,'expenseOriginal')]//input[contains(@data-parsley-required-message,'Enter a valid day')]")).sendKeys(pojo.getDate());
		waitForElement(By.xpath("//div[contains(@class,'expenseOriginal')]//input[contains(@data-parsley-required-message,'Enter a valid year')]")).clear();
		waitForElement(By.xpath("//div[contains(@class,'expenseOriginal')]//input[contains(@data-parsley-required-message,'Enter a valid year')]")).sendKeys(pojo.getYear());
		waitForElement(By.xpath("//div[contains(@class,'expenseOriginal')]//input[contains(@data-parsley-required-message,'That procedure code is invalid. Please check your receipt and try again.')]")).clear();
		waitForElement(By.xpath("//div[contains(@class,'expenseOriginal')]//input[contains(@data-parsley-required-message,'That procedure code is invalid. Please check your receipt and try again.')]")).sendKeys(pojo.getProcedureCode());
		waitForElement(By.xpath("//div[contains(@class,'expenseOriginal')]//input[contains(@data-parsley-at-least-one-required-if-cob-primary-message,'Enter at least one of dental fee or lab charge')]")).clear();
		waitForElement(By.xpath("//div[contains(@class,'expenseOriginal')]//input[contains(@data-parsley-at-least-one-required-if-cob-primary-message,'Enter at least one of dental fee or lab charge')]")).sendKeys(dentalfee);

		waitForElement(By.xpath("//div[contains(@class,'expenseOriginal')]//input[contains(@id,'laboratoryCharge')]")).clear();
		waitForElement(By.xpath("//div[contains(@class,'expenseOriginal')]//input[contains(@id,'laboratoryCharge')]")).sendKeys(labfee);
		waitForElement(By.xpath("//div[contains(@class,'expenseOriginal')]//input[contains(@id,'otherInsurancePaidAmt')]")).clear();
		waitForElement(By.xpath("//div[contains(@class,'expenseOriginal')]//input[contains(@id,'otherInsurancePaidAmt')]")).sendKeys(pojo.getOthers());
		
		sleep(2);
		scrollDown();
		
	}

	
	public void verifyClaimDetailsMessage() {
		sleep(4);
		String claimDetails = waitForElement(By.cssSelector(".attachReceipts .claim-title")).getText().trim();
		logger.debug("Verify claimDetails : " + claimDetails);
		Assert.assertEquals(claimDetails, bundle.getProperty("claimDetailsMessage"));
		extentTest.pass("Verification Success - claimDetails " + claimDetails);
	}
	
	public void verifyAttachmentMessages(String whatToAttachMessage) {
		sleep(4);
		
		String whatToAttach = waitForElement(By.cssSelector(".attach-receipts-container h3")).getText().trim();
		String receiptsandSupportingDoc = waitForElement(By.cssSelector(".attach-receipts-container div p")).getText().trim();
		String claimReceipts = waitForElement(By.cssSelector(".attach-receipts-container div ol li:nth-child(1)")).getText().trim();
		String provincial = waitForElement(By.cssSelector(".attach-receipts-container div ol li:nth-child(2)")).getText().trim();
		String additionalProvider = waitForElement(By.cssSelector(".attach-receipts-container div ol li:nth-child(3)")).getText().trim();
		String addDocument = waitForElement(By.cssSelector(".addReceipts")).getText().trim();
		String attachments = waitForElement(By.cssSelector(".attachAccount")).getText();
		String howToAttach = waitForElement(By.cssSelector("#instructionsContentHeading1")).getText();
		String fileSize = waitForElement(By.cssSelector("#instructionsContentHeading2")).getText();
		
		Assert.assertEquals(whatToAttach, whatToAttachMessage);
		Assert.assertEquals(receiptsandSupportingDoc, bundle.getProperty("supportDocMessage"));
		Assert.assertEquals(claimReceipts, bundle.getProperty("receipts"));
		Assert.assertEquals(provincial, bundle.getProperty("provincial"));
		Assert.assertEquals(additionalProvider, bundle.getProperty("additionalProvider"));
		Assert.assertEquals(addDocument, bundle.getProperty("addDoc"));
		Assert.assertEquals(attachments, bundle.getProperty("attachment"));
		Assert.assertEquals(howToAttach, bundle.getProperty("howToAttach"));
		Assert.assertEquals(fileSize, bundle.getProperty("fileSize"));
	}
	
	public void verifyAttachmentMessagesBreathAids(String whatToAttachMessage) {
		sleep(4);
		
		String whatToAttach = waitForElement(By.cssSelector(".attach-receipts-container h3")).getText().trim();
		String receiptsandSupportingDoc = waitForElement(By.cssSelector(".attach-receipts-container div p")).getText().trim();
		String claimReceipts = waitForElement(By.cssSelector(".attach-receipts-container div ol li:nth-child(1)")).getText().trim();
		String provincial = waitForElement(By.cssSelector(".attach-receipts-container div ol li:nth-child(2)")).getText().trim();
		String prescription = waitForElement(By.cssSelector(".attach-receipts-container div ol li:nth-child(3)")).getText().trim();
		String medicalCondition = waitForElement(By.cssSelector(".attach-receipts-container div ol li:nth-child(4)")).getText().trim();
		
		String addDocument = waitForElement(By.cssSelector(".addReceipts")).getText().trim();
		String attachments = waitForElement(By.cssSelector(".attachAccount")).getText();
		String howToAttach = waitForElement(By.cssSelector("#instructionsContentHeading1")).getText();
		String fileSize = waitForElement(By.cssSelector("#instructionsContentHeading2")).getText();
		
		Assert.assertEquals(whatToAttach, whatToAttachMessage);
		Assert.assertEquals(receiptsandSupportingDoc, bundle.getProperty("supportDocMessage"));
		Assert.assertEquals(claimReceipts, bundle.getProperty("receipts"));
		Assert.assertEquals(provincial, bundle.getProperty("provincial"));
		Assert.assertEquals(prescription, bundle.getProperty("prescription"));
		Assert.assertEquals(medicalCondition, bundle.getProperty("medicalCondition"));
		Assert.assertEquals(addDocument, bundle.getProperty("addDoc"));
		Assert.assertEquals(attachments, bundle.getProperty("attachment"));
		Assert.assertEquals(howToAttach, bundle.getProperty("howToAttach"));
		Assert.assertEquals(fileSize, bundle.getProperty("fileSize"));
	}
	
	public void verifyAttachmentMessagesBrace(String whatToAttachMessage) {
		sleep(4);
		
		String whatToAttach = waitForElement(By.cssSelector(".attach-receipts-container h3")).getText().trim();
		String receiptsandSupportingDoc = waitForElement(By.cssSelector(".attach-receipts-container div p")).getText().trim();
		String claimReceipts = waitForElement(By.cssSelector(".attach-receipts-container div ol li:nth-child(1)")).getText().trim();
		String provincial = waitForElement(By.cssSelector(".attach-receipts-container div ol li:nth-child(2)")).getText().trim();
		String medicalCondition = waitForElement(By.cssSelector(".attach-receipts-container div ol li:nth-child(3)")).getText().trim();
		String examination = waitForElement(By.cssSelector(".attach-receipts-container div ol li:nth-child(4)")).getText().trim();
		String prescription = waitForElement(By.cssSelector(".attach-receipts-container div ol li:nth-child(5)")).getText().trim();
		
		String addDocument = waitForElement(By.cssSelector(".addReceipts")).getText().trim();
		String attachments = waitForElement(By.cssSelector(".attachAccount")).getText();
		String howToAttach = waitForElement(By.cssSelector("#instructionsContentHeading1")).getText();
		String fileSize = waitForElement(By.cssSelector("#instructionsContentHeading2")).getText();
		
		Assert.assertEquals(whatToAttach, whatToAttachMessage);
		Assert.assertEquals(receiptsandSupportingDoc, bundle.getProperty("supportDocMessage"));
		Assert.assertEquals(claimReceipts, bundle.getProperty("receipts"));
		Assert.assertEquals(provincial, bundle.getProperty("provincial"));
		Assert.assertEquals(examination, bundle.getProperty("examination"));
		Assert.assertEquals(medicalCondition, bundle.getProperty("medicalCondition"));
		Assert.assertEquals(prescription, bundle.getProperty("prescription"));
		Assert.assertEquals(addDocument, bundle.getProperty("addDoc"));
		Assert.assertEquals(attachments, bundle.getProperty("attachment"));
		Assert.assertEquals(howToAttach, bundle.getProperty("howToAttach"));
		Assert.assertEquals(fileSize, bundle.getProperty("fileSize"));
	}
	public void verifyAttachmentMessagesPrescription(String whatToAttachMessage) {
		sleep(4);
		
		String whatToAttach = waitForElement(By.cssSelector(".attach-receipts-container h3")).getText().trim();
		String receiptsandSupportingDoc = waitForElement(By.cssSelector(".attach-receipts-container div p")).getText().trim();
		String claimReceipts = waitForElement(By.cssSelector(".attach-receipts-container div ol li:nth-child(1)")).getText().trim();
		String provincial = waitForElement(By.cssSelector(".attach-receipts-container div ol li:nth-child(2)")).getText().trim();
		String prescription = waitForElement(By.cssSelector(".attach-receipts-container div ol li:nth-child(3)")).getText().trim();
		//String medicalCondition = waitForElement(By.cssSelector(".attach-receipts-container div ol li:nth-child(3)")).getText().trim();
		
		String addDocument = waitForElement(By.cssSelector(".addReceipts")).getText().trim();
		String attachments = waitForElement(By.cssSelector(".attachAccount")).getText();
		String howToAttach = waitForElement(By.cssSelector("#instructionsContentHeading1")).getText();
		String fileSize = waitForElement(By.cssSelector("#instructionsContentHeading2")).getText();
		
		Assert.assertEquals(whatToAttach, whatToAttachMessage);
		Assert.assertEquals(receiptsandSupportingDoc, bundle.getProperty("supportDocMessage"));
		Assert.assertEquals(claimReceipts, bundle.getProperty("receipts"));
		Assert.assertEquals(provincial, bundle.getProperty("provincial"));
		Assert.assertEquals(prescription, bundle.getProperty("prescription"));
		//Assert.assertEquals(medicalCondition, bundle.getProperty("medicalCondition"));
		Assert.assertEquals(addDocument, bundle.getProperty("addDoc"));
		Assert.assertEquals(attachments, bundle.getProperty("attachment"));
		Assert.assertEquals(howToAttach, bundle.getProperty("howToAttach"));
		Assert.assertEquals(fileSize, bundle.getProperty("fileSize"));
	}
	public void verifyAttachmentMessagesInvoice(String whatToAttachMessage) {
		sleep(4);
		
		String whatToAttach = waitForElement(By.cssSelector(".attach-receipts-container h3")).getText().trim();
		String receiptsandSupportingDoc = waitForElement(By.cssSelector(".attach-receipts-container div p")).getText().trim();
		String claimReceiptsOrInvoice = waitForElement(By.cssSelector(".attach-receipts-container div ol li:nth-child(1)")).getText().trim();
		String provincial = waitForElement(By.cssSelector(".attach-receipts-container div ol li:nth-child(2)")).getText().trim();
		//String additionalProvider = waitForElement(By.cssSelector(".attach-receipts-container div ol li:nth-child(3)")).getText().trim();
		String addDocument = waitForElement(By.cssSelector(".addReceipts")).getText().trim();
		String attachments = waitForElement(By.cssSelector(".attachAccount")).getText();
		String howToAttach = waitForElement(By.cssSelector("#instructionsContentHeading1")).getText();
		String fileSize = waitForElement(By.cssSelector("#instructionsContentHeading2")).getText();
		
		Assert.assertEquals(whatToAttach, whatToAttachMessage);
		Assert.assertEquals(receiptsandSupportingDoc, bundle.getProperty("supportDocMessage"));
		Assert.assertEquals(claimReceiptsOrInvoice, bundle.getProperty("receiptsOrInvoice"));
		Assert.assertEquals(provincial, bundle.getProperty("provincial"));
		//Assert.assertEquals(additionalProvider, bundle.getProperty("additionalProvider"));
		Assert.assertEquals(addDocument, bundle.getProperty("addDoc"));
		Assert.assertEquals(attachments, bundle.getProperty("attachment"));
		Assert.assertEquals(howToAttach, bundle.getProperty("howToAttach"));
		Assert.assertEquals(fileSize, bundle.getProperty("fileSize"));
	}

	public void verifyAttachmentMessagesTwo(String whatToAttachMessage) {
		sleep(4);
		
		String whatToAttach = waitForElement(By.cssSelector(".attach-receipts-container h3")).getText().trim();
		String receiptsandSupportingDoc = waitForElement(By.cssSelector(".attach-receipts-container div p")).getText().trim();
		String claimReceipts = waitForElement(By.cssSelector(".attach-receipts-container div ol li:nth-child(1)")).getText().trim();
		String provincial = waitForElement(By.cssSelector(".attach-receipts-container div ol li:nth-child(2)")).getText().trim();
		//String additionalProvider = waitForElement(By.cssSelector(".attach-receipts-container div ol li:nth-child(3)")).getText().trim();
		String addDocument = waitForElement(By.cssSelector(".addReceipts")).getText().trim();
		String attachments = waitForElement(By.cssSelector(".attachAccount")).getText();
		String howToAttach = waitForElement(By.cssSelector("#instructionsContentHeading1")).getText();
		String fileSize = waitForElement(By.cssSelector("#instructionsContentHeading2")).getText();
		
		Assert.assertEquals(whatToAttach, whatToAttachMessage);
		Assert.assertEquals(receiptsandSupportingDoc, bundle.getProperty("supportDocMessage"));
		Assert.assertEquals(claimReceipts, bundle.getProperty("receipts"));
		Assert.assertEquals(provincial, bundle.getProperty("provincial"));
		//Assert.assertEquals(additionalProvider, bundle.getProperty("additionalProvider"));
		Assert.assertEquals(addDocument, bundle.getProperty("addDoc"));
		Assert.assertEquals(attachments, bundle.getProperty("attachment"));
		Assert.assertEquals(howToAttach, bundle.getProperty("howToAttach"));
		Assert.assertEquals(fileSize, bundle.getProperty("fileSize"));
	}
	public void verifyAttachmentMessagesOne(String whatToAttachMessage) {
		sleep(4);
		
		String whatToAttach = waitForElement(By.cssSelector(".attach-receipts-container h3")).getText().trim();
		String receiptsandSupportingDoc = waitForElement(By.cssSelector(".attach-receipts-container div p")).getText().trim();
		String claimReceipts = waitForElement(By.cssSelector(".attach-receipts-container div ol li:nth-child(1)")).getText().trim();
		//String provincial = waitForElement(By.cssSelector(".attach-receipts-container div ol li:nth-child(2)")).getText().trim();
		//String additionalProvider = waitForElement(By.cssSelector(".attach-receipts-container div ol li:nth-child(3)")).getText().trim();
		String addDocument = waitForElement(By.cssSelector(".addReceipts")).getText().trim();
		String attachments = waitForElement(By.cssSelector(".attachAccount")).getText();
		String howToAttach = waitForElement(By.cssSelector("#instructionsContentHeading1")).getText();
		String fileSize = waitForElement(By.cssSelector("#instructionsContentHeading2")).getText();
		
		Assert.assertEquals(whatToAttach, whatToAttachMessage);
		Assert.assertEquals(receiptsandSupportingDoc, bundle.getProperty("supportDocMessage"));
		Assert.assertEquals(claimReceipts, bundle.getProperty("receipts"));
		//Assert.assertEquals(provincial, bundle.getProperty("provincial"));
		//Assert.assertEquals(additionalProvider, bundle.getProperty("additionalProvider"));
		Assert.assertEquals(addDocument, bundle.getProperty("addDoc"));
		Assert.assertEquals(attachments, bundle.getProperty("attachment"));
		Assert.assertEquals(howToAttach, bundle.getProperty("howToAttach"));
		Assert.assertEquals(fileSize, bundle.getProperty("fileSize"));
	}
	
	public void verifyDocumentsWithMinimumAmountMessages() {
		
		String whyToAttach =  waitForElement(By.cssSelector(".attachReceipts .claim-expense h3")).getText().trim();
		String efficientProcess = waitForElement(By.xpath("//div[contains(@class,'row claim-expense attach-receipts-option')]//div[2]/div/p[1]")).getText().trim();
		String quikAndEasy = waitForElement(By.xpath("//div[contains(@class,'row claim-expense attach-receipts-option')]//div[2]/div/p[2]")).getText();
		String attachingDoc = waitForElement(By.cssSelector(".attach-receipts-option-question legend")).getText();
		String yes = waitForElement(By.xpath("//div[@class='attach-receipts-option-question']//label[@for='attach-receipts-option-question1']")).getText();
		String no = waitForElement(By.xpath("//div[@class='attach-receipts-option-question']//label[@for='attach-receipts-option-question2']")).getText();

		Assert.assertEquals(whyToAttach, bundle.getProperty("whyToAttachMessage"));
		Assert.assertEquals(efficientProcess, bundle.getProperty("efficientProcessMessage"));
		Assert.assertEquals(quikAndEasy, bundle.getProperty("quikAndEasyMessage"));
		Assert.assertEquals(attachingDoc, bundle.getProperty("attachingDocToThis"));
		Assert.assertEquals(yes, bundle.getProperty("yes"));
		Assert.assertEquals(no, bundle.getProperty("no"));
		
	}
	
	public void clickYesForAttachingDocuments(){
		waitForElement(By.xpath("//div[@class='attach-receipts-option-question']//input[@id='attach-receipts-option-question1']")).click();
	}
	public void clickNoForAttachingDocuments(){
		waitForElement(By.xpath("//div[@class='attach-receipts-option-question']//input[@id='attach-receipts-option-question2']")).click();
	}

	public void uploadDocument(String filePath){
		addDocument(filePath);
	}
	public void verifyAttachedFile() {
		
		Assert.assertTrue(isElementPresent(By.cssSelector(".attachImageName")), "Element Not available");
	}
	
	public void verifySingleAttachmentMessage(){
		sleep(3);
		String attachment1 = waitForElement(By.cssSelector(".attachAccount")).getText();
		Assert.assertEquals(attachment1, bundle.getProperty("attachment1"));
	}
	
	String attachmentReciteContinueButton = ".attachReceipts .claimDetailSubmit";
	public void verifyAttachRecitesContinueButton(){
		Assert.assertTrue(isElementPresent(By.cssSelector(attachmentReciteContinueButton)),attachmentReciteContinueButton + " Element Not available");
	}
	
	public void clickAttachRecitesContinueButton(){
		waitForElement(By.cssSelector(attachmentReciteContinueButton)).click();
	}
	
	public void clickClaimContinueButton(){
		waitForElement(By.cssSelector("button.claimDetailSubmit")).click();
	}

	public void addDocument(String filePath) {
		
		waitForElement(By.cssSelector(".addReceipts")).click();
		File  file = new File(filePath);
		sleep(4);
		AutoItUtil autoit = new AutoItUtil();
		autoit.uploadFile(file.getAbsolutePath().replace("\\.\\", "\\"));
	}


	public void verifyConfirmYourClaimDetails(GNPMData data,String total){
		
		/*String confirmHeaderMessage1 = waitForElement(By.cssSelector(".confirm-container div.header")).getText().trim();
		String confirmHeaderMessage1 = waitForElement(By.cssSelector(".confirm-container div:nth-child(2) span")).getText().trim();
		String submission = waitForElement(By.cssSelector(".confirm-container div:nth-child(3) span")).getText().trim();
		String learnMore = waitForElement(By.cssSelector(".confirm-container div:nth-child(3) span:nth-child(2)")).getText().trim();
		String confirmHeaderMessage5 = waitForElement(By.cssSelector(".confirm-container div:nth-child(5) span")).getText().trim();
		String termsModel = waitForElement(By.xpath("//a[@data-target='#termsModal']/span")).getText().trim();
		*/
		String confirmYourClaimText = waitForElement(By.cssSelector(".confirm-them h2")).getText().trim();
		String claimAmountTitle = waitForElement(By.cssSelector(".claimAmountTitle")).getText().trim();
		Assert.assertEquals(confirmYourClaimText, bundle.getProperty("confirmClaim"));
		Assert.assertEquals(claimAmountTitle, bundle.getProperty("claimAmountText"));
		//dynamic
		String claimAmountvalue = waitForElement(By.cssSelector(".claimAmountDiscrip")).getText().trim();
		String serviceDateValue = waitForElement(By.cssSelector(".expense .row:nth-child(2) .discrip")).getText().trim();
		String serviceTypeValue = waitForElement(By.cssSelector(".expense .row:nth-child(3) .discrip")).getText().trim();
		String lengthOfVisitValue = waitForElement(By.cssSelector(".expense .row:nth-child(4) .discrip")).getText().trim();
		String totalChargeValue = waitForElement(By.cssSelector(".expense .row:nth-child(5) .discrip")).getText().trim();
		String otherInsuranceValue = waitForElement(By.cssSelector(".expense .row:nth-child(6) .discrip")).getText().trim();
		String oneAttachment = waitForElement(By.cssSelector("#claimSummaryReceiptsValue")).getText().trim();
				
		/*System.out.println("claimAmountvalue  " + claimAmountvalue);
		System.out.println("serviceDateValue  " + serviceDateValue);
		System.out.println("serviceTypeValue  " + serviceTypeValue);
		System.out.println("lengthOfVisitValue  " + lengthOfVisitValue);
		System.out.println("totalChargeValue  " + totalChargeValue);
		System.out.println("otherInsuranceValue  " + otherInsuranceValue);
		System.out.println("oneAttachment  " + oneAttachment);*/
		
		String expectedClaimAmountValue = "$"+total;
		String expectedServiceDate = data.getMonth()+" "+data.getDate()+", "+ data.getYear();
		String expectedServiceType = data.getServiceType();
		String expectedLengthOfVisit = data.getHours()  +" hours"+"  "+data.getMinutes() +" minutes";
		String expectedTotalCharge = "$"+data.getTestAmount();
		String expectedOtherInsurance = "$" +data.getTestAmountOthers();
		String expectedOneAttachment = data.getAttachments();
		
		/*System.out.println("expectedClaimAmountValue  " + expectedClaimAmountValue);
		System.out.println("expectedServiceDate :  " + expectedServiceDate);
		System.out.println("expectedServiceType : " + expectedServiceType);
		System.out.println("expectedLengthOfVisit :  " + expectedLengthOfVisit);
		System.out.println("expectedTotalCharge : " + expectedTotalCharge);
		System.out.println("expectedOtherInsurance : " + expectedOtherInsurance);
		System.out.println("expectedOneAttachment : " + expectedOneAttachment);*/
		
		Assert.assertEquals(claimAmountvalue,expectedClaimAmountValue);
		Assert.assertEquals(serviceDateValue, expectedServiceDate);
		Assert.assertEquals(serviceTypeValue,expectedServiceType);
		Assert.assertEquals(lengthOfVisitValue,expectedLengthOfVisit);
		Assert.assertEquals(totalChargeValue, expectedTotalCharge);
		Assert.assertEquals(otherInsuranceValue,expectedOtherInsurance);
		Assert.assertEquals(oneAttachment, expectedOneAttachment);
	
		Assert.assertEquals(confirmYourClaimText, bundle.getProperty("confirmClaim"));
	}
	
	public void verifyConfirmYourClaim(){
		
		String confirmYourClaimText = waitForElement(By.cssSelector(".confirm-them h2")).getText().trim();
		Assert.assertEquals(confirmYourClaimText, bundle.getProperty("confirmClaim"));
		
	}
	public void clickConfirmYourClaimDetailsButton(){
		waitForElement(By.cssSelector(".confirm-submit")).click();
	}
	
	
	public void verifyPostSubmitDetails_ClaimSummary(String expectedDocumentAttachedStatus,String total){
		String claimSubmitted = waitForElement(By.cssSelector(".confirm-them h2")).getText().trim();
		String claimSummary = waitForElement(By.cssSelector(".confirm-claim-summary-title")).getText().trim();
		String pdf = waitForElement(By.cssSelector(".successPdf a")).getText().trim();
		String amountSubmitted = waitForElement(By.cssSelector(".row.amout div:nth-child(1)")).getText().trim();
		String amountSubmittedValue = waitForElement(By.cssSelector(".row.amout div:nth-child(2)")).getText().trim();
		String confirmationNumber = waitForElement(By.cssSelector(".row.amout div:nth-child(3)")).getText().trim();
		String documentAttached = waitForElement(By.cssSelector(".row.amout div:nth-child(5)")).getText().trim();
		String documentAttachedStatus = waitForElement(By.cssSelector(".row.amout div:nth-child(6)")).getText().trim();
	
		Assert.assertEquals(claimSubmitted, bundle.getProperty("claimSubmitted"));
		Assert.assertEquals(claimSummary, bundle.getProperty("claimSummary"));
		Assert.assertTrue(pdf.contains(bundle.getProperty("pdf")));
		Assert.assertEquals(amountSubmitted, bundle.getProperty("amountSubmitted"));
		Assert.assertEquals(confirmationNumber, bundle.getProperty("confirmationNumber"));
		Assert.assertEquals(documentAttached, bundle.getProperty("documentsAttached"));
		
		String expectedAmountSubmittedValue = "$"+total;
		Assert.assertEquals(amountSubmittedValue, expectedAmountSubmittedValue);
		Assert.assertEquals(documentAttachedStatus, expectedDocumentAttachedStatus);
	}
	
	public void verifyPostSubmitDetails_Plan_Services(USERS user,GNPMData data){
		String planText = waitForElement(By.cssSelector(".summary-content.success .row:nth-child(1) div:nth-child(1)")).getText().trim();
		String planName = waitForElement(By.cssSelector(".summary-content.success .row:nth-child(1) div:nth-child(2)")).getText().trim();
		String nameText = waitForElement(By.cssSelector(".summary-content.success .row:nth-child(2) div:nth-child(1)")).getText().trim();
		String nameValue = waitForElement(By.cssSelector(".summary-content.success .row:nth-child(2) div:nth-child(2)")).getText().trim();
		String claimTypeText = waitForElement(By.cssSelector(".summary-content.success .row:nth-child(3) div:nth-child(1)")).getText().trim();
		String claimTypeValue = waitForElement(By.cssSelector(".summary-content.success .row:nth-child(3) div:nth-child(2)")).getText().trim();
		String serviceProviderText = waitForElement(By.cssSelector(".summary-content.success .row:nth-child(4) div:nth-child(1)")).getText().trim();
		String serviceProviderValue = waitForElement(By.cssSelector(".summary-content.success .row:nth-child(4) div:nth-child(2)")).getText().trim();
		Assert.assertEquals(planText, bundle.getProperty("plan"));
		Assert.assertEquals(nameText, bundle.getProperty("name"));
		Assert.assertEquals(claimTypeText, bundle.getProperty("claimType"));
		Assert.assertEquals(serviceProviderText, bundle.getProperty("serviceProvider"));

		String expectedPlanName = data.getPlanName();
		String expectedNameValue = user.getFirstName()+ " "+ user.getLastName(); 
		String expectedClaimTypeValue = data.getClaimType();
		String expectedServiceProviderValue = data.getServiceProvider();
		
		Assert.assertEquals(planName, expectedPlanName);
		Assert.assertEquals(nameValue, expectedNameValue);
		Assert.assertEquals(claimTypeValue, expectedClaimTypeValue);
		Assert.assertEquals(serviceProviderValue, expectedServiceProviderValue);
	}
	
	public void verifyPostSubmitDetails_Plan_Services_WithClaimTypeSubCat(USERS user,GNPMData data){
		String planText = waitForElement(By.cssSelector(".summary-content.success .row:nth-child(1) div:nth-child(1)")).getText().trim();
		String planName = waitForElement(By.cssSelector(".summary-content.success .row:nth-child(1) div:nth-child(2)")).getText().trim();
		String nameText = waitForElement(By.cssSelector(".summary-content.success .row:nth-child(2) div:nth-child(1)")).getText().trim();
		String nameValue = waitForElement(By.cssSelector(".summary-content.success .row:nth-child(2) div:nth-child(2)")).getText().trim();
		String claimTypeText = waitForElement(By.cssSelector(".summary-content.success .row:nth-child(3) div:nth-child(1)")).getText().trim();
		String claimTypeValue = waitForElement(By.cssSelector(".summary-content.success .row:nth-child(3) div:nth-child(2)")).getText().trim();
		String subCategoryValue = waitForElement(By.cssSelector(".summary-content.success .row:nth-child(4) div:nth-child(2)")).getText().trim();
		String serviceProviderText = waitForElement(By.cssSelector(".summary-content.success .row:nth-child(5) div:nth-child(1)")).getText().trim();
		String serviceProviderValue = waitForElement(By.cssSelector(".summary-content.success .row:nth-child(5) div:nth-child(2)")).getText().trim();
		Assert.assertEquals(planText, bundle.getProperty("plan"));
		Assert.assertEquals(nameText, bundle.getProperty("name"));
		Assert.assertEquals(claimTypeText, bundle.getProperty("claimType"));
		Assert.assertEquals(serviceProviderText, bundle.getProperty("serviceProvider"));
		

		String expectedPlanName = data.getPlanName();
		String expectedNameValue = user.getFirstName()+ " "+ user.getLastName(); 
		String expectedClaimTypeValue = data.getClaimType();
		String expectedSubCategoryValue = data.getSubCategory();
		String expectedServiceProviderValue = data.getServiceProvider();
		
		Assert.assertEquals(planName, expectedPlanName);
		Assert.assertEquals(nameValue, expectedNameValue);
		Assert.assertEquals(claimTypeValue, expectedClaimTypeValue);
		Assert.assertEquals(subCategoryValue, expectedSubCategoryValue);
		Assert.assertEquals(serviceProviderValue, expectedServiceProviderValue);
	}
	
	public void verifyPostSubmitDetails_Expense(GNPMData data,String total){
		String expenseDetails = waitForElement(By.xpath(".//div[text()='Expense details']")).getText().trim();
		//div[text()='Expense details']
		String expense = waitForElement(By.xpath("//div[@class='expense']//div[contains(text(),'Expense')]")).getText().trim();
		String serviceDateText = waitForElement(By.xpath("//div[@class='expense']//div[contains(text(),'Service date')]")).getText().trim();
		String serviceDateValue = waitForElement(By.xpath("//div[@class='expense']//div[contains(text(),'Service date')]/following-sibling::div")).getText().trim();
		String serviceTypeText = waitForElement(By.xpath("//div[@class='expense']//div[contains(text(),'Service type')]")).getText().trim();
		String serviceTypeValue = waitForElement(By.xpath("//div[@class='expense']//div[contains(text(),'Service type')]/following-sibling::div")).getText().trim();
		String totalChargeText = waitForElement(By.xpath("//div[@class='expense']//div[contains(text(),'Total charge')]")).getText().trim();
		String totalChargeValue = waitForElement(By.xpath("//div[@class='expense']//div[contains(text(),'Total charge')]/following-sibling::div")).getText().trim();
		String oneAttachment = waitForElement(By.cssSelector("#claimSummaryReceiptsValue")).getText().trim();
	
		Assert.assertEquals(expenseDetails, bundle.getProperty("expenseDetails"));
		Assert.assertEquals(expense, bundle.getProperty("expense"));
		Assert.assertEquals(serviceDateText, bundle.getProperty("serviceDate"));
		Assert.assertEquals(serviceTypeText, bundle.getProperty("serviceType"));
		Assert.assertEquals(totalChargeText, bundle.getProperty("totalCharge"));
		
		String expectedServiceDateValue = data.getMonth()+" "+data.getDate()+", "+ data.getYear();
		String expectedServiceTypeValue = data.getServiceType();
		String expectedTotalChargeValue = "$"+total;
		String expectedOneAttachment = data.getAttachments();

		Assert.assertEquals(serviceDateValue, expectedServiceDateValue);
		Assert.assertEquals(serviceTypeValue, expectedServiceTypeValue);
		Assert.assertEquals(totalChargeValue, expectedTotalChargeValue);
		Assert.assertEquals(oneAttachment, expectedOneAttachment);

		
	}
	
}
