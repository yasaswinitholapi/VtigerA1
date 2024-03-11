package genercLibraries;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;

import pomPages.ContactsPage;
import pomPages.CreateNewEventPage;
import pomPages.CreateNewLeadPage;
import pomPages.CreateNewOrganizationPage;
import pomPages.DuplicatingleadPage;
import pomPages.HomePage;
import pomPages.LeadsPage;
import pomPages.LoginPage;
import pomPages.NewContactsDetailPage;
import pomPages.NewEventDetailPage;
import pomPages.NewLeadDetailsPage;
import pomPages.NewOrgDetailsPage;
import pomPages.OganizationPage;
import pomPages.createNewContactPage;

public class BaseClass {
	//@BeforeSuite
	//@BeforeTest
	protected PropertiesUtility property;
	protected ExcelUtility excel;
	protected WebDriverUtility web;
	protected JavaUtility jutil;
	 
	protected WebDriver driver;
	protected SoftAssert soft;
	protected LoginPage login;
	protected HomePage home;
	protected OganizationPage org;
	protected ContactsPage contact;
    protected LeadsPage lead;
    protected CreateNewOrganizationPage createorg;
    protected createNewContactPage createContact;
    protected CreateNewLeadPage  createLead;
    protected CreateNewEventPage createEvent;
    protected DuplicatingleadPage duplicateLead;
    protected  NewOrgDetailsPage newOrg;
    protected NewContactsDetailPage newContact;
    protected NewLeadDetailsPage newLead;
    protected NewEventDetailPage newEvent;
    
	
	@BeforeClass
	public void classSetup() {
		property=new PropertiesUtility();
		excel=new ExcelUtility();
		web=new WebDriverUtility();
		jutil= new JavaUtility();
		
		
		property.propertiesInit(IConstantPath.PROPERTIES_PATH);
		driver=web.launchBrowserAndMaximize(property.readFromProperties("browser"));
		web.waitTillElementFound(Long.parseLong(property.readFromProperties("timeouts")));
	}
	@BeforeMethod
	public void methodsetup() {
		login=new LoginPage(driver);
		home=new HomePage(driver);
		org=new OganizationPage(driver);
		contact=new ContactsPage(driver);
		lead=new LeadsPage(driver);
		createorg=new CreateNewOrganizationPage(driver);
		createContact=new createNewContactPage(driver);
		createLead=new CreateNewLeadPage(driver);
		createEvent=new CreateNewEventPage(driver);
	    newOrg=new NewOrgDetailsPage(driver);
	    newContact=new NewContactsDetailPage(driver);
	    newLead=new NewLeadDetailsPage(driver);
	    newEvent=new NewEventDetailPage(driver);
	    duplicateLead=new DuplicatingleadPage(driver);
	    soft=new SoftAssert();
	    excel.excelInit(IConstantPath.EXCEL_PATH);
	    
	    web.navigateToApp(property.readFromProperties("url"));
	    Assert.assertEquals(login.getPageHeader(), "vtiger");
	    login.loginToVtiger(property.readFromProperties("username"),property.readFromProperties("password"));
	Assert.assertTrue(home.getPageHeader().contains("Home"));
	}
	
	@AfterMethod
	public void methodTeardown() {
		home.signOutOfApp(web);
		excel.closeExcel();
	}
	@AfterClass
	public void classTeardown() {
		web.quitAllWindows();
	}

}
