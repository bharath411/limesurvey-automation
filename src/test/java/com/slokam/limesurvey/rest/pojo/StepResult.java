package com.slokam.limesurvey.testscripts.rest;

public class StepResult {

	private String content;
	 private String expected;
	 private String actual;
	 private int status_id;


	 // Getter Methods 

	 public String getContent() {
	  return content;
	 }

	 public String getExpected() {
	  return expected;
	 }

	 public String getActual() {
	  return actual;
	 }

	 public int getStatus_id() {
	  return status_id;
	 }

	 // Setter Methods 

	 public void setContent(String content) {
	  this.content = content;
	 }

	 public void setExpected(String expected) {
	  this.expected = expected;
	 }

	 public void setActual(String actual) {
	  this.actual = actual;
	 }

	 public void setStatus_id(int status_id) {
	  this.status_id = status_id;
	 }
}
