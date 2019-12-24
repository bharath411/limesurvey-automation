package com.slokam.limesurvey.testscripts.rest;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.response.Response;
public class TestRail {

	
	@Test
	public void gridAPITest() {
		Response response = given()
				.header("Content-Type", "application/json")
		.get("http://hyd00aah.in.oracle.com:4444/lifecycle-manager");
		System.out.println(response.getBody().asString());
		
	}
	
	
	@Test
	public void test1() {
		
		Response response = given()
				.auth()
				.preemptive()
				.basic("sample@gmail.com", "OXDLexAwYTV0TUoBwIW4-II8cSOccgvhGbWh4xpcC")
				.header("Content-Type", "application/json")
		.get("https://ct3.testrail.io/index.php?/api/v2/get_run/2");
		
		System.out.println(response.getStatusCode());
		RunResult st = response.body().as(RunResult.class);
		System.out.println(st);
		
		System.out.println(st.getId());
	}
	
	@Test
	public void test2() {
		
		AddResult add = new AddResult();
		
		add.setStatus_id(5);
		add.setComment("Sample from class");
		add.setElapsed("30s");
		add.setDefects("71df");
		add.setVersion("3.0");
		
		StepResult step1 = new StepResult();
		step1.setActual("ACB");
		step1.setExpected("ACB");
		step1.setStatus_id(2);
		step1.setContent("content1");
		
		StepResult step2 = new StepResult();
		step2.setActual("ACB");
		step2.setExpected("ACB");
		step2.setStatus_id(1);
		step2.setContent("content1");
		
		StepResult[] sr = {step1,step2};
		
		add.setCustom_step_results(sr);
		
		Response response = given()
				.auth()
				.preemptive()
				.basic("sample@gmail.com", "OXDLexAwYTV0TUoBwIW4-II8cSOccgvhGbWh4xpcC")
				.header("Content-Type", "application/json")
				.body(add)
		.post("https://ct3.testrail.io/index.php?/api/v2/add_result/3");
		
		
		System.out.println(response.getStatusCode());
		String st = response.getBody().asString();
		System.out.println(st);
	}
}
