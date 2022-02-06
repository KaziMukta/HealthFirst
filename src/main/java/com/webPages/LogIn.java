package com.webPages;

import java.util.Set;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.commonMethods.CommonMethods;

public class LogIn {
	
	@FindBy(xpath = "(//span[text()='Login'])[1]") public WebElement logInElement;
	@FindBy(linkText = "Member Portal") public WebElement MemberPortal;
	@FindBy(xpath = "//input[@id='username']") public WebElement UserName;
	@FindBy(xpath = "//input[@id='password']") public WebElement PassWord;
	
	public LogIn(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	public void logInButton(CommonMethods cm,WebDriver driver) {
	cm.hoverOver(driver, logInElement);
	}
	public void memberPortalButton() {
		MemberPortal.click();
	}
	public void userNameField(WebDriver driver,CommonMethods cm) {
	String parentWindow=driver.getWindowHandle();
	Set<String> childWindows=driver.getWindowHandles();
	for(String newWindow:childWindows) {
		driver.switchTo().window(newWindow);
	}
	cm.enterText(driver, UserName, "icarly");
	}
	public void passWord(WebDriver driver,CommonMethods cm) {
		cm.enterText(driver, PassWord, "sam");
	}
}
