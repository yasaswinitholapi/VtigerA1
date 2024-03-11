package testScripts;

import java.util.Map;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import genercLibraries.BaseClass;
import genercLibraries.IConstantPath;

public class createOrgTest extends BaseClass{

	@Test
	public  void createNewOrgTest() throws InterruptedException{
		SoftAssert soft=new SoftAssert();
		home.clickOrganizations();
		soft.assertEquals(org.getPageHeader(), "Organizatoins");
		org.clickPlusButton();
		soft.assertEquals(createorg.getPageHeader(),"Create New Organization","Organization Test Date");
		Map<String,String> map=excel.readFromExcel("Create Organization","OrganizationsTestData");
		String orgName=map.get("Organization Name")+jutil.generateRandomNum(100);
		createorg.setOrgName(orgName);
		createorg.clickSave();
		Thread.sleep(3000);
		soft.assertTrue(newOrg.getPageHeader().contains(orgName));
		newOrg.clickOrgLink();
		if(org.getNewOrgName().equals(orgName)) {
			System.out.println("test pass");
			excel.updateTestStatus("Create Organization","Pass",IConstantPath.EXCEL_PATH, "OrganizationTestData");
		}
		else {
			System.out.println("testfail");
			excel.updateTestStatus("Create Organization", "Fail",IConstantPath.EXCEL_PATH , "OrganizationTestData");
			
		}
		soft.assertEquals(org.getNewOrgName(), orgName);
		soft.assertAll();

	}

	
}
