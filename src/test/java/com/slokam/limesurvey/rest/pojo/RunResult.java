package com.slokam.limesurvey.testscripts.rest;

import java.util.ArrayList;

public class RunResult {

	 private float id;
	 private float suite_id;
	 private String name;
	 private String description = null;
	 private String milestone_id = null;
	 private float assignedto_id;
	 private boolean include_all;
	 private boolean is_completed;
	 private String completed_on = null;
	 private String config = null;
	 private int  config_ids[] ;
	 private float passed_count;
	 private float blocked_count;
	 private float untested_count;
	 private float retest_count;
	 private float failed_count;
	 private float custom_status1_count;
	 private float custom_status2_count;
	 private float custom_status3_count;
	 private float custom_status4_count;
	 private float custom_status5_count;
	 private float custom_status6_count;
	 private float custom_status7_count;
	 private float project_id;
	 private String plan_id = null;
	 private float created_on;
	 private float created_by;
	 private String url;


	 // Getter Methods 

	 public float getId() {
	  return id;
	 }

	 public float getSuite_id() {
	  return suite_id;
	 }

	 public String getName() {
	  return name;
	 }

	 public String getDescription() {
	  return description;
	 }

	 public String getMilestone_id() {
	  return milestone_id;
	 }

	 public float getAssignedto_id() {
	  return assignedto_id;
	 }

	 public boolean getInclude_all() {
	  return include_all;
	 }

	 public boolean getIs_completed() {
	  return is_completed;
	 }

	 public String getCompleted_on() {
	  return completed_on;
	 }

	 public String getConfig() {
	  return config;
	 }

	 public float getPassed_count() {
	  return passed_count;
	 }

	 public float getBlocked_count() {
	  return blocked_count;
	 }

	 public float getUntested_count() {
	  return untested_count;
	 }

	 public float getRetest_count() {
	  return retest_count;
	 }

	 public float getFailed_count() {
	  return failed_count;
	 }

	 public float getCustom_status1_count() {
	  return custom_status1_count;
	 }

	 public float getCustom_status2_count() {
	  return custom_status2_count;
	 }

	 public float getCustom_status3_count() {
	  return custom_status3_count;
	 }

	 public float getCustom_status4_count() {
	  return custom_status4_count;
	 }

	 public float getCustom_status5_count() {
	  return custom_status5_count;
	 }

	 public float getCustom_status6_count() {
	  return custom_status6_count;
	 }

	 public float getCustom_status7_count() {
	  return custom_status7_count;
	 }

	 public float getProject_id() {
	  return project_id;
	 }

	 public String getPlan_id() {
	  return plan_id;
	 }

	 public float getCreated_on() {
	  return created_on;
	 }

	 public float getCreated_by() {
	  return created_by;
	 }

	 public String getUrl() {
	  return url;
	 }

	 // Setter Methods 

	 public void setId(float id) {
	  this.id = id;
	 }

	 public void setSuite_id(float suite_id) {
	  this.suite_id = suite_id;
	 }

	 public void setName(String name) {
	  this.name = name;
	 }

	 public void setDescription(String description) {
	  this.description = description;
	 }

	 public void setMilestone_id(String milestone_id) {
	  this.milestone_id = milestone_id;
	 }

	 public void setAssignedto_id(float assignedto_id) {
	  this.assignedto_id = assignedto_id;
	 }

	 public void setInclude_all(boolean include_all) {
	  this.include_all = include_all;
	 }

	 public void setIs_completed(boolean is_completed) {
	  this.is_completed = is_completed;
	 }

	 public void setCompleted_on(String completed_on) {
	  this.completed_on = completed_on;
	 }

	 public void setConfig(String config) {
	  this.config = config;
	 }

	 public void setPassed_count(float passed_count) {
	  this.passed_count = passed_count;
	 }

	 public void setBlocked_count(float blocked_count) {
	  this.blocked_count = blocked_count;
	 }

	 public void setUntested_count(float untested_count) {
	  this.untested_count = untested_count;
	 }

	 public void setRetest_count(float retest_count) {
	  this.retest_count = retest_count;
	 }

	 public void setFailed_count(float failed_count) {
	  this.failed_count = failed_count;
	 }

	 public void setCustom_status1_count(float custom_status1_count) {
	  this.custom_status1_count = custom_status1_count;
	 }

	 public void setCustom_status2_count(float custom_status2_count) {
	  this.custom_status2_count = custom_status2_count;
	 }

	 public void setCustom_status3_count(float custom_status3_count) {
	  this.custom_status3_count = custom_status3_count;
	 }

	 public void setCustom_status4_count(float custom_status4_count) {
	  this.custom_status4_count = custom_status4_count;
	 }

	 public void setCustom_status5_count(float custom_status5_count) {
	  this.custom_status5_count = custom_status5_count;
	 }

	 public void setCustom_status6_count(float custom_status6_count) {
	  this.custom_status6_count = custom_status6_count;
	 }

	 public void setCustom_status7_count(float custom_status7_count) {
	  this.custom_status7_count = custom_status7_count;
	 }

	 public void setProject_id(float project_id) {
	  this.project_id = project_id;
	 }

	 public void setPlan_id(String plan_id) {
	  this.plan_id = plan_id;
	 }

	 public void setCreated_on(float created_on) {
	  this.created_on = created_on;
	 }

	 public void setCreated_by(float created_by) {
	  this.created_by = created_by;
	 }

	 public void setUrl(String url) {
	  this.url = url;
	 }

	public int[] getConfig_ids() {
		return config_ids;
	}

	public void setConfig_ids(int config_ids[]) {
		this.config_ids = config_ids;
	}
}
