package com.logInTest;

import org.testng.annotations.Test;
import com.base.Base;

public class LogInTest extends Base{

	@Test
	public void logInTest()   {
		logIn.logInButton(cm, driver);
		logIn.memberPortalButton();
		logIn.userNameField(driver, cm);
		logIn.passWord(driver, cm);
	}

}
