package com.slokam.limesurvey.testscripts.admin;

import java.io.File;
import java.util.List;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.slokam.limesurvey.commons.pojo.GNPMData;
import com.slokam.limesurvey.commons.utilites.data.excel.XlsxReader;

public class SampleTest {

	

	@Test(dataProvider = "gnpm")
	public void testDataProvider(GNPMData gnpmData) {
		System.out.println(gnpmData);
	}

	@DataProvider(name = "gnpm")
	public Object[][] dataProviderForInvestor() {

		XlsxReader reader = new XlsxReader();
		List<GNPMData> gnpms = null;
		// Read
		try {
			gnpms = reader.read(GNPMData.class, new File("./src/test/resources/testdata/TestData.xlsx"),
					"GNPM");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for (GNPMData gnpmData : gnpms) {
			System.out.println(gnpmData);
		}

		Object[][] obj = new Object[gnpms.size()][1];
		for (int i = 0; i < gnpms.size(); i++) {
			obj[i][0] = gnpms.get(i);
			System.out.println(gnpms.get(i).getTestCaseName());
		}

		return obj;
	}
}
