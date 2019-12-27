package com.slokam.limesurvey.commons.enums;

public enum Category {
//CLAIM CATEGORY,CLAIM TYPE,SERVICE TYPE
//DRUGS
	DRUG("Drugs","Drug"),
//DENTAL
	DENTAL("Dental","Dental"),
	ORTHODONTIC("Dental","Orthodontic"),
//VISION
	VISIONSERVICES("Vision","Vision services"),
	EYEWEAREXAMS("Vision","Vision Services","Eyewear and exams"),
	LASEREYESURGERY("Vision","Vision Services","Laser eye surgery"),
	VISUALTHERAPY("Vision","Vision Services","Visual therapy"),
//Health
	ACUPUNCTURE("Health","Acupuncture"),
	ATHLETICTHERAPY("Health","Athletic therapy"),
	CHIROPRACTIC("Health","Chiropractic"),
	MASSAGETHERAPY("Health","Massage therapy"),
	OTHERPRACTITIONERS("Health","Other practitioners"),
	PHYSIOTHERAPY("Health","Physiotherapy"),
	PSYCOLOGY("Health","Psycology"),
	PSYCHOLOGICALTESTING("Health","Psychology","Psychology services"),
	PSYCHOLOGYSERVICES("Health","Psychology","Psychological testing"),
	SOCIALWORK("Health","Social work"),
	SPEECHTHERAPY("Health","Speech therapy"),
	CHIROPODY("Health","Chiropody"),
	PODIATRIQUE("Health","Chiropody","Podiatrique"),
	CHIROPODYSERVICES("Health","Chiropody","Chiropody services"),
	DIETICIAN("Health","Dietician"),
	NATUROPATHY("Health","Naturopathy"),
	OSTEOPATHY("Health","Osteopathy"),
	PODIATRY("Health","Podiatry"),
	PODIATRYSERVICES("Health","Podiatry","Podiatry services"),
	PODIATRYSURGERY("Health","Podiatry","Podiatry Surgery"),
//Medical equipment and supplies
	//Communication Aids
	COMMUNICATIONAIDS("Medical equipment and supplies","Communication aids"),
	HEARINGAIDS("Medical equipment and supplies","Communication aids","Hearing aids"),
	SPEECHAIDS("Medical equipment and supplies","Communication aids","Speech aids"),
	//Orthopedic Equipment
	ORTHOPEDICEQUIPMENT("Medical equipment and supplies","Orthopedic equipment"),
	BRACE("Medical equipment and supplies","Orthopedic equipment","Brace"),
	CAST("Medical equipment and supplies","Orthopedic equipment","Cast"),
	ORTHOTICS("Medical equipment and supplies","Orthopedic equipment","Orthotics"),
	ORTHOPEDICESHOES("Medical equipment and supplies","Orthopedic equipment","Orthopedic shoes"),
	//Breathing Aids
	AEROCHAMBER("Medical equipment and supplies","Breathing aids","AeroChamber"),
	BREATHINGEQUIPMENT("Medical equipment and supplies","Breathing aids","Breathing equipment"),
	OXYGENANDEQUIPMENT("Medical equipment and supplies","Breathing aids","Oxygen and equipment"),
	//Diabetic Equipment
	DIABETICEQUIPMENT("Medical equipment and supplies","Diabetic equipment"),
	GLUCOSEMONITOR("Medical equipment and supplies","Diabetic equipment","Glucose monitor"),
	DIABETICINFUSIONPUMP("Medical equipment and supplies","Diabetic equipment","Diabetic infusion pump"),
	//Mobility Aids
	MOBILITYAIDS("Medical equipment and supplies","Mobility aids"),
	CANES("Medical equipment and supplies","Mobility aids","Canes"),
	CRUTCHES("Medical equipment and supplies","Mobility aids","Crutches"),
	PATIENTLIFTERS("Medical equipment and supplies","Mobility aids","Patient lifters"),
	RAMPS("Medical equipment and supplies","Mobility aids","Ramps"),
	WALKERS("Medical equipment and supplies","Mobility aids","Walkers"),
	WHEELCHAIR("Medical equipment and supplies","Mobility aids","Wheelchair"),
	//Other Medical Supplies
	OTHERMEDICALSUPPLIES("Medical equipment and supplies","Other medical supplies"),
	BATHROOMSAFETYAIDS("Medical equipment and supplies","Other medical supplies","Bathroom safety aids"),
	COLOSTOMYSUPPLY("Medical equipment and supplies","Other medical supplies","Colostomy supply"),
	COMPRESSIONHOSE("Medical equipment and supplies","Other medical supplies","Compression hose"),
	HOSPITALBEDS("Medical equipment and supplies","Other medical supplies","Hospital beds"),
	INCONTINENCESUPPLY("Medical equipment and supplies","Other medical supplies","Incontinence supply"),
	IUD("Medical equipment and supplies","Other medical supplies","IUD (Intrauterine device)"),
	OTHER("Medical equipment and supplies","Other medical supplies","Other medical supply"),
	SURGICALLENSES("Medical equipment and supplies","Other medical supplies","Surgical lenses"),
	TENSMACHINE("Medical equipment and supplies","Other medical supplies","TENS machine"),
	WIGS("Medical equipment and supplies","Other medical supplies","Wigs"),
	//Prosthetic equipment
	PROSTHETICEQUIPMENT("Medical equipment and supplies","Prosthetic equipment"),
	BREASTPROSTHESIS("Medical equipment and supplies","Prosthetic equipment","Breast prosthesis"),
	PROSTHETICLIMBSEYES("Medical equipment and supplies","Prosthetic equipment","Prosthetic limbs/eyes"),
	SURGICALBRAS("Medical equipment and supplies","Prosthetic equipment","Surgical bras"),
//MEDICAL SERVICES
	AMBULANCE("Medical services","Ambulance"),
	HOSPITAL("Medical services","Hospital"), 
	PRIVATEROOM("Medical services","Hospital","Private room"),
	SEMIPRIVATEROOM("Medical services","Hospital","Semi-private room"),
	LONGTERMCARE("Medical services","Long-term care"),
	MEDICALTESTS("Medical services","Medical tests"),
	NURSING("Medical services","Nursing"),
	;
	
	private String item;
	private String subItem;
	private String miniItem;
	
	Category(String item){
		this.item = item;
	}
	
	Category(String item,String subItem){
		this.item = item;
		this.subItem = subItem;
	}
	
	Category(String item,String subItem,String miniItem){
		this.item = item;
		this.subItem = subItem;
		this.miniItem = miniItem;
	}
	
	public String getItem() {
		return item;
	}
	
	public String getSubItem() {
		return subItem;
	}
	
	public String getMiniItem(){
		return miniItem;
	}
}
