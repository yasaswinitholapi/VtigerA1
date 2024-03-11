package pomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DuplicatingleadPage {
//Declaration
	@FindBy(xpath="//span[@class='lvtHeaderText']")
	private WebElement pageHeader;
	@FindBy(name="lastname']")
	private WebElement lastNameTF;
	@FindBy(xpath="//input[normalzed-space(@value)='Save']")
	private WebElement saveButton;
	//Initialization
		public DuplicatingleadPage(WebDriver driver) {
			PageFactory.initElements(driver,this);
			
		}
		//Utilization
		public String getPageHeader() {
			return pageHeader.getText();
		}
		public void setNewLastName(String newLastName) {
			lastNameTF.clear();
			lastNameTF.sendKeys(newLastName);
		}
		public void clickSave() {
			saveButton.click();
		}
}
