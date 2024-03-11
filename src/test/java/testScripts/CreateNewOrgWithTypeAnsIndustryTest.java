package testScripts;

import java.util.Map;

import org.testng.annotations.Test;

import genercLibraries.BaseClass;
import genercLibraries.IConstantPath;

public class CreateNewOrgWithTypeAnsIndustryTest  extends BaseClass{
	@Test
	public void createNewOrgWithTypeAndIndustryTest() throws InterruptedException {
		home.clickOrganizations();
		soft.assertEquals(org.getNewOrgName(), "Organizations");
		org.clickPlusButton();
		soft.assertEquals(createorg.getPageHeader(), "Create New  Organization");

		Map<String, String> map = excel.readFromExcel("Create Organization With Industry And Type",
				"OrganizationsTestData");
		String orgName = map.get("Organization Name") + jutil.generateRandomNum(100);
		createorg.setOrgName(orgName);
		createorg.selectIndustry(web, map.get("Industry"));
		createorg.selectType(web, map.get("Type"));
		createorg.clickSave();
		Thread.sleep(3000);
		soft.assertTrue(newOrg.getPageHeader().contains(orgName));
		newOrg.clickOrgLink();
		if (org.getNewOrgName().equals(orgName)) {
			System.out.println("test pass");
			excel.updateTestStatus("Create Organization With Industry And Type", "pass", IConstantPath.EXCEL_PATH,"OrganizationsTestData");
		} else {
			System.out.println("test fail");
			excel.updateTestStatus("Create Organization With Industry And Type", "Fail", IConstantPath.EXCEL_PATH,
					"OrganizationsTestData");
		}
		soft.assertEquals(org.getNewOrgName(), orgName);
		soft.assertAll();
	}

}
