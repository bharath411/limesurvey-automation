package com.slokam.limesurvey.commons.enums;

public enum Navigation {

	HOME("Home"),
	COVERAGE_BALANCES("Coverage & balances"),
	MAKE_A_CLAIM("Make a claim"),
	CLAIM_HISTORY("Claim history"),
	BENEFIT_CARDS_FORMS("Benefit cards & forms"),
	PROFILE("Profile"),
	HELP_CENTRE("Help centre"),
	CONTACT_US("Contact us"),	
	;
	
	private String item;
	private String subItem;
	
	Navigation(String item){
		this.item = item;
	}
	
	Navigation(String item,String subItem){
		this.item = item;
		this.subItem = subItem;
	}
	
	public String getItem() {
		return item;
	}
	
	public String getSubItem() {
		return subItem;
	}
	
}
