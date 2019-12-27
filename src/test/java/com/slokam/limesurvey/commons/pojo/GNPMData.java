package com.slokam.limesurvey.commons.pojo;

import com.slokam.limesurvey.commons.utilites.data.excel.Sheet;
import com.slokam.limesurvey.commons.utilites.data.excel.SheetColumn;

@Sheet("GNPM")
public class GNPMData {
	@SheetColumn("TestCaseName")
	private String testCaseName;
	@SheetColumn("Execution")
	private String execution;
	
	@SheetColumn("User")
	private String user;
	

	@SheetColumn("ServiceProvider")
	private String serviceProvider;
	@SheetColumn("PhoneNumber")
	private String phoneNumber;
	@SheetColumn("City")
	private String city;
	@SheetColumn("Province")
	private String province;
	@SheetColumn("Month")
	private String month;
	@SheetColumn("Date")
	private String date;
	@SheetColumn("Year")
	private String year;
	@SheetColumn("ServiceType")
	private String serviceType;
	@SheetColumn("Hours")
	private String hours;
	@SheetColumn("Minutes")
	private String minutes;
	@SheetColumn("MoreThanLimit")
	private String moreThanLimit;
	@SheetColumn("Maximum")
	private String maximum;
	@SheetColumn("Others")
	private String others;
	@SheetColumn("TestAmount")
	private String testAmount;
	@SheetColumn("TestAmountOthers")
	private String testAmountOthers;
	@SheetColumn("ProcedureCode")
	private String procedureCode;
	@SheetColumn("DentalFee")
	private String dentalFee;
	@SheetColumn("LabFee")
	private String labFee;
	@SheetColumn("Lab1Fee")
	private String lab1Fee;
	@SheetColumn("Date1")
	private String date1;
	@SheetColumn("Month1")
	private String month1;
	@SheetColumn("Year1")
	private String year1;
	@SheetColumn("DIN")
	private String dIN;
	@SheetColumn("Quantity")
	private String quantity;
	@SheetColumn("DispenseFee")
	private String dispenseFee;
	@SheetColumn("PlanName")
	private String planName;
	@SheetColumn("DocumentAttached")
	private String documentAttached;
	@SheetColumn("ClaimType")
	private String claimType;
	@SheetColumn("Attachments")
	private String attachments;
	@SheetColumn("SelectPlan")
	private String selectPlan;
	@SheetColumn("ReasonForPurchase")
	private String reasonForPurchase;
	@SheetColumn("SubCategory")
	private String subCategory;
	
	
	public String getSubCategory() {
		return subCategory;
	}

	public void setSubCategory(String subCategory) {
		this.subCategory = subCategory;
	}

	public String getReasonForPurchase() {
		return reasonForPurchase;
	}

	public void setReasonForPurchase(String reasonForPurchase) {
		this.reasonForPurchase = reasonForPurchase;
	}

	public String getSelectPlan() {
		return selectPlan;
	}

	public void setSelectPlan(String selectPlan) {
		this.selectPlan = selectPlan;
	}

	public String getPlanName() {
		return planName;
	}

	public String getAttachments() {
		return attachments;
	}

	public void setAttachments(String attachments) {
		this.attachments = attachments;
	}

	public void setPlanName(String planName) {
		this.planName = planName;
	}

	public String getDocumentAttached() {
		return documentAttached;
	}

	public void setDocumentAttached(String documentAttached) {
		this.documentAttached = documentAttached;
	}

	public String getClaimType() {
		return claimType;
	}

	public void setClaimType(String claimType) {
		this.claimType = claimType;
	}

	public String getTestCaseName() {
		return testCaseName;
	}

	public void setTestCaseName(String testCaseName) {
		this.testCaseName = testCaseName;
	}

	public String getExecution() {
		return execution;
	}

	public void setExecution(String execution) {
		this.execution = execution;
	}

	public String getServiceProvider() {
		return serviceProvider;
	}

	public void setServiceProvider(String serviceProvider) {
		this.serviceProvider = serviceProvider;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getServiceType() {
		return serviceType;
	}

	public void setServiceType(String serviceType) {
		this.serviceType = serviceType;
	}

	public String getHours() {
		return hours;
	}

	public void setHours(String hours) {
		this.hours = hours;
	}

	public String getMinutes() {
		return minutes;
	}

	public void setMinutes(String minutes) {
		this.minutes = minutes;
	}

	public String getMoreThanLimit() {
		return moreThanLimit;
	}

	public void setMoreThanLimit(String moreThanLimit) {
		this.moreThanLimit = moreThanLimit;
	}

	public String getMaximum() {
		return maximum;
	}

	public void setMaximum(String maximum) {
		this.maximum = maximum;
	}

	public String getOthers() {
		return others;
	}

	public void setOthers(String others) {
		this.others = others;
	}

	public String getTestAmount() {
		return testAmount;
	}

	public void setTestAmount(String testAmount) {
		this.testAmount = testAmount;
	}

	public String getTestAmountOthers() {
		return testAmountOthers;
	}

	public void setTestAmountOthers(String testAmountOthers) {
		this.testAmountOthers = testAmountOthers;
	}

	public String getProcedureCode() {
		return procedureCode;
	}

	public void setProcedureCode(String procedureCode) {
		this.procedureCode = procedureCode;
	}

	public String getDentalFee() {
		return dentalFee;
	}

	public void setDentalFee(String dentalFee) {
		this.dentalFee = dentalFee;
	}

	public String getLabFee() {
		return labFee;
	}

	public void setLabFee(String labFee) {
		this.labFee = labFee;
	}

	public String getLab1Fee() {
		return lab1Fee;
	}

	public void setLab1Fee(String lab1Fee) {
		this.lab1Fee = lab1Fee;
	}

	public String getDate1() {
		return date1;
	}

	public void setDate1(String date1) {
		this.date1 = date1;
	}

	public String getMonth1() {
		return month1;
	}

	public void setMonth1(String month1) {
		this.month1 = month1;
	}

	public String getYear1() {
		return year1;
	}

	public void setYear1(String year1) {
		this.year1 = year1;
	}

	public String getdIN() {
		return dIN;
	}

	public void setdIN(String dIN) {
		this.dIN = dIN;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public String getDispenseFee() {
		return dispenseFee;
	}

	public void setDispenseFee(String dispenseFee) {
		this.dispenseFee = dispenseFee;
	}

	
	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public GNPMData(String testCaseName, String execution, String user,String serviceProvider, String phoneNumber, String city,
			String province, String month, String date, String year, String serviceType, String hours, String minutes,
			String moreThanLimit, String maximum, String others, String testAmount, String testAmountOthers,
			String procedureCode, String dentalFee, String labFee, String lab1Fee, String date1, String month1,
			String year1, String dIN, String quantity, String dispenseFee, String planName, String documentAttached,
			String claimType, String attachments, String reasonForPurchase) {
		super();
		this.testCaseName = testCaseName;
		this.execution = execution;
		this.user = user;
		this.serviceProvider = serviceProvider;
		this.phoneNumber = phoneNumber;
		this.city = city;
		this.province = province;
		this.month = month;
		this.date = date;
		this.year = year;
		this.serviceType = serviceType;
		this.hours = hours;
		this.minutes = minutes;
		this.moreThanLimit = moreThanLimit;
		this.maximum = maximum;
		this.others = others;
		this.testAmount = testAmount;
		this.testAmountOthers = testAmountOthers;
		this.procedureCode = procedureCode;
		this.dentalFee = dentalFee;
		this.labFee = labFee;
		this.lab1Fee = lab1Fee;
		this.date1 = date1;
		this.month1 = month1;
		this.year1 = year1;
		this.dIN = dIN;
		this.quantity = quantity;
		this.dispenseFee = dispenseFee;
		this.planName = planName;
		this.documentAttached = documentAttached;
		this.claimType = claimType;
		this.attachments = attachments;
		this.reasonForPurchase = reasonForPurchase;
	}

	

	@Override
	public String toString() {
		return "GNPMData [testCaseName=" + testCaseName + ", execution=" + execution + ", user=" + user
				+ ", serviceProvider=" + serviceProvider + ", phoneNumber=" + phoneNumber + ", city=" + city
				+ ", province=" + province + ", month=" + month + ", date=" + date + ", year=" + year + ", serviceType="
				+ serviceType + ", hours=" + hours + ", minutes=" + minutes + ", moreThanLimit=" + moreThanLimit
				+ ", maximum=" + maximum + ", others=" + others + ", testAmount=" + testAmount + ", testAmountOthers="
				+ testAmountOthers + ", procedureCode=" + procedureCode + ", dentalFee=" + dentalFee + ", labFee="
				+ labFee + ", lab1Fee=" + lab1Fee + ", date1=" + date1 + ", month1=" + month1 + ", year1=" + year1
				+ ", dIN=" + dIN + ", quantity=" + quantity + ", dispenseFee=" + dispenseFee + ", planName=" + planName
				+ ", documentAttached=" + documentAttached + ", claimType=" + claimType + ", attachments=" + attachments
				+ ", selectPlan=" + selectPlan + ", reasonForPurchase=" + reasonForPurchase + "]";
	}

	public GNPMData(){
		
	}
}
