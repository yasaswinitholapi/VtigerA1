package pomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewContactsDetailPage {
//Declaration
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement pageHeader;
	
	@FindBy(xpath="//a[@class='hdrLn']")
	private WebElement contactsLink;
	
	//Initialization
	public NewContactsDetailPage(WebDriver driver) {
		PageFactory.initElements( driver, this);
	}
	//Utilization
	public String getPageHeader() {
		return pageHeader.getText();
	}
	public void clickContactsLink() {
		contactsLink.click();
	}
}
