package com.slokam.limesurvey.commons.enums;

public enum USERS {

	JHON_BLACK("John.black@gwldstest.ca.int","Password_12","JHON","BLACK"),
	DON_KASHANE("Don.Kashane@gwldstest.ca.int","Password_12","DON","KASHANE"),
	HOMER_SIMPSON("Homer.simpson@gwldstest.ca.int","Password_12","HOMER","SIMPSON"),
	GIL_FISH("Gil.Fish@gwldstest.ca.int","Password_12","GIL","FISH"),
	AMY_ADAM("Amy.Adam@gwldstest.ca.int","Password_12","AMY","ADAM"),
	JAMES_CROWE("James.Crowe@gwldstest.ca.int","Password_12","JAMES","CROWE"),
	TRENT_CARTER("Trent.Carter@gwldstest.ca.int","Password_12","TRENT","CARTER"),
	SUSAN_BLACK("susan.black@gwldstest.ca.int","Password_12","SUSAN","BLACK"),
	KAREN_KLINE("karen.kline@gwldstest.ca.int","Password_12","KAREN","KLINE"),
	MIKE_VANDUCO("Mike.Van-Duco@gwldstest.ca.int","Password_12","MIKE","VAN-DUCO"),
	BETTY_BOOP("betty.boop@gwldstest.ca.int","Password_12","BETTY","BOOP"),
	RYAN_JONES("ryan.jones@gwldstest.ca.int","Password_12","RYAN","JONES"),
	STEVE_COWIE("steven.cowie@gwldstest.ca.int","Password_12","STEVE","COWIE"),
	MARGARET_MEANS("Margaret.Means@gwldstest.ca.int","Password_12","MARGARET","MEANS"),
	FRANCIS_MARTIN("Francis.Martin@gwldstest.ca.int","Password_12","FRANCIS","MARTIN"),
	VICTOR_MORROW("Victor.Morrow@gwldstest.ca.int","Password_12","VICTOR","MORROW"),
	EMILY_STARK("emily.stark@gwldstest.ca.int","Password_12","EMILY","STARK"),
	PAUL_HARRISON("paul.harrison@gwldstest.ca.int","Password_12","PAUL","HARRISON"),
	DEVIN_MORRIS("devin.morris@gwldstest.ca.int","Password_12","DEVIN","MORRIS"),
	RYAN_GEORGE("Ryan.George@gwldstest.ca.int","Password_12","RYAN","GEORGE"),
	JOAN_COLLINS("Joan.Collins@gwldstest.ca.int","Password_12","JOAN","COLLINS"),
	CHAI_TEA("chai.tea@gwldstest.ca.int","Password_12","CHAI","TEA"),
	CURTIS_BARR("Curtis.Barr@gwldstest.ca.int","Password_12","CURTIS","BARR"),
	DEE_STROYER("Dee.Stroyer@gwldstest.ca.int","Password_12","DEE","STROYER"),
	DALE_PARSONS("dale.parsons@gwldstest.ca.int","Password_12","DALE","PARSONS"),
	OWEN_HUNT("owen.hunt@gwldstest.ca.int","Password_12","OWEN","HUNT");

	private String username;
	private String password;
	private String firstName;
	private String lastName;
	
	USERS(String username,String password){
		this.username = username;
		this.password = password;
	}
	USERS(String username,String password,String firstName){
		this.username = username;
		this.password = password;
		this.firstName = firstName;
	}
	USERS(String username,String password,String firstName, String lastName){
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
	}
	public String getUsername() {
		return username;
	}
	
	public String getPassword() {
		return password;
	}
	public String getFirstName() {
		return firstName;
	}
	
	public String getLastName(){
		return lastName;
	}
	public static USERS fromString(String name) {
		if (name == null) {
			return null;
		}
		for (USERS userName : USERS.values()) {
			if (name.equalsIgnoreCase(userName.name())) {
				return userName;
			}
		}
		return null;
	}
}
