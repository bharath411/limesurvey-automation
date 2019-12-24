package com.slokam.limesurvey.commons.enums;

public enum Constants {

	MAKE_A_CLAIM_URL("/app/en/make-a-claim"),
	AFTER_SUBMIT_URL("/app/en/make-a-claim/submission-response"),
	COVERAGE_AND_BALANCES("/app/en/coverage-and-balances"),
	/*CLAIM_HISTORY("/app/en/claim-history?tab=processed-submissions"),
	ONLINE_SUBMISSIONS("/app/en/claim-history?tab=online-submissions"),
	SUMMARY_REPORT("/app/en/claim-history?tab=summary-report"),*/
	BENEFIT_CARDS_FORMS("/app/en/forms-and-benefit-cards"),			
	/*BENEFIT_CARDS("/app/en/forms-and-benefit-cards?tab=Cards"),	
	CLAIM("/app/en/forms-and-benefit-cards?tab=Claim"),	
	PRIOR_AUTHORIZATION("/app/en/forms-and-benefit-cards?tab=PriorAuthorization"),	
	ADMINISTRATIVE("/app/en/forms-and-benefit-cards?tab=Administration"),	*/	
	//profile,help,contact Us
	PROFILE("/app/en/profile"),
	HELP_CENTRE("https://qa.pma.greatwestlife.com/app/en/help-centre"),
	CONTACT_US("https://qa.pma.greatwestlife.com/app/en/contact-us");
			
	private String name;
	Constants(String name){
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
}
