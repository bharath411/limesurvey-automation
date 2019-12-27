package com.slokam.limesurvey.commons.utilites.data;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DataManager {

	private final Logger logger = LoggerFactory.getLogger(DataManager.class);
	public static boolean compareLists(List<String> actual, List<String> expected) {
		boolean flag = true;
		if(actual.size()!=expected.size()) {
			return false;
		}
		for (String type : expected) {
			if(!actual.contains(type)) {
				System.out.println(type + "is not found in actual list");
				flag =false;
				break;
			}
		}
		
		return flag;
	}
}
