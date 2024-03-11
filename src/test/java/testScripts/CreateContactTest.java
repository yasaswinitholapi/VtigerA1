package testScripts;

import java.util.Map;

import org.testng.annotations.Test;

import genercLibraries.BaseClass;
import genercLibraries.IConstantPath;

public class CreateContactTest extends BaseClass {
	@Test
	public void createNewContactTest() throws InterruptedException {
		home.clickContacts();
		soft.assertEquals(contact.getPageHeader(), "Contacts");
		Thread.sleep(3000);
		contact.clickPlusButton();
		soft.assertEquals(createContact.getPageHeader(),"Create New Contact");

		Map<String, String> map = excel.readFromExcel("Create Contact", "ContactsTestData");
		String contactName = map.get("Last Name") + jutil.generateRandomNum(100);
		createContact.setLastName(contactName);
		createContact.clickSave();
		Thread.sleep(3000);
		soft.assertTrue(newContact.getPageHeader().contains(contactName));
		newContact.clickContactsLink();
		if (contact. getNewContactName().equals(contactName)) {
			System.out.println("test pass");
			excel.updateTestStatus("Create Contact", "pass", IConstantPath.EXCEL_PATH, "ContactsTestData");
		} else {
			System.out.println("test fail");
			excel.updateTestStatus("Create Contact", "Fail", IConstantPath.EXCEL_PATH, "ContactsTestData");
		}
		soft.assertEquals(contact.getNewContactName(), contactName);
		soft.assertAll();
	}

}
