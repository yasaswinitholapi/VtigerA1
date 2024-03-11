package testScripts;

import java.util.Map;

import org.testng.annotations.Test;

import genercLibraries.BaseClass;
import genercLibraries.IConstantPath;

public class CreateContactWithExistingOrgTest extends BaseClass{
	@Test
	
	public void createContactWithOrgTest() throws InterruptedException {
		home.clickContacts();
		contact.clickPlusButton();
		
		Map<String, String>map=excel.readFromExcel("Create Contact With Organization", "ContactsTestData");
		String lastName=map.get("Last Name")+ jutil.generateRandomNum(100);
	    createContact.setLastName(lastName);
	    createContact.selectExistingOrg(web, map.get("Organzation Name"));
	    createContact.clickSave();
	    
	    Thread.sleep(3000);
	    newContact.clickContactsLink();
	    
	    if(contact.getNewContactName().equals(lastName)) {
	    	System.out.println("Test pass");
	    	excel.updateTestStatus("Create Contact With Organization", "pass", IConstantPath.EXCEL_PATH,"ContactsTestData");
	    }
	    else {
	    	System.out.println("Test Fail");
	    	excel.updateTestStatus("Create Contact With Organization", "fail", IConstantPath.EXCEL_PATH,"ContactsTestData");
	    }
	}

}
