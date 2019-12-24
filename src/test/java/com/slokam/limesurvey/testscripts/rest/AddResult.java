package com.slokam.limesurvey.testscripts.rest;

public class AddResult {

	private int status_id;
	 private String comment;
	 private String elapsed;
	 private String defects;
	 private String version;
	 StepResult[] custom_step_results ;


	 // Getter Methods 

	 public StepResult[] getCustom_step_results() {
		return custom_step_results;
	}

	public void setCustom_step_results(StepResult[] custom_step_results) {
		this.custom_step_results = custom_step_results;
	}

	public int getStatus_id() {
	  return status_id;
	 }

	 public String getComment() {
	  return comment;
	 }

	 public String getElapsed() {
	  return elapsed;
	 }

	 public String getDefects() {
	  return defects;
	 }

	 public String getVersion() {
	  return version;
	 }

	 // Setter Methods 

	 public void setStatus_id(int status_id) {
	  this.status_id = status_id;
	 }

	 public void setComment(String comment) {
	  this.comment = comment;
	 }

	 public void setElapsed(String elapsed) {
	  this.elapsed = elapsed;
	 }

	 public void setDefects(String defects) {
	  this.defects = defects;
	 }

	 public void setVersion(String version) {
	  this.version = version;
	 }
}
