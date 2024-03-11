package pomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genercLibraries.WebDriverUtility;

public class createNewContactPage {
	//Declaration-contactinformation
	@FindBy(xpath="//span[@class='lvtHeaderText']")
	private WebElement pageHeader ;
	
	@FindBy(name="lastname")
	private WebElement lastnameTF;
	@FindBy(xpath="//img[contains(@onclick,'Accounts')]")
	private WebElement orgPlusButton ;
	@FindBy(xpath="//input[normalize-space(@value)='Save']")
	private WebElement saveButton ;
	private String orgpath="//a[text()='%S']";
	
	//Initialization
	public  createNewContactPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//Utilization
	public String getPageHeader() {
		return pageHeader.getText();
	}
	public void setLastName(String contactName) {
		lastnameTF.sendKeys(contactName);
	}
	public void selectExistingOrg(WebDriverUtility web,String orgName) {
		orgPlusButton.click();
		String  parentID=web.getParentWindow();
		web.switchToChildBrowser();
		web.convertPathToWebElement(orgpath, orgName).click();
		web.switchToWindow(parentID);
	}
	
	public void clickSave() {
		saveButton.click();
	}
	

}
