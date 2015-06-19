package com.example.fw;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class AccountHelper extends WebDriverHelperBase {

	public AccountHelper(ApplicationManager manager) {
		super(manager);
	}

	public void signup(User user) {
		openUrl("/");
		click(By.xpath(".//a[@href='signup_page.php']"));
		type(By.name("username"), user.login);
		type(By.name("email"), user.email);
		click(By.cssSelector("input.button"));

		if (driver.findElements(By.cssSelector("table.width50 tbody tr td p"))
				.size() > 0) {
			throw new RuntimeException("That username is already being used");
		}

		pause(5000);
		String msg = manager.getMailHelper().getNewMail(user.login,
				user.password);
		String confirmationLink = getConfirmationLink(msg);
		openAbsoluteUrl(confirmationLink);

		type(By.name("password"), user.password);
		type(By.name("password_confirm"), user.password);
		click(By.cssSelector("input.button"));

	}

	// ************************************************

	public String getConfirmationLink(String text) {
		Pattern regex = Pattern.compile("http\\S*");
		Matcher matcher = regex.matcher(text);
		if (matcher.find()) {
			return matcher.group();
		} else {
			return "";
		}
	}// 1.01.40
		// *******************************************

	public String loggedUser(User user) {
		WebElement element = findElement(By
				.cssSelector("td.login-info-left span"));
		return element.getText();

	}

	public void login(User user) {
		openUrl("/");
		type(By.name("username"), user.login);
		type(By.name("password"), user.password);
		click(By.cssSelector("input.button"));
	}

	public void logout() {

		click(By.linkText("Logout"));
	}

	public int manageUsers(User user) {

		click(By.xpath("//span[1]/a"));
		click(By.linkText(user.login));
		click(By.xpath("//input[@value='Delete User']"));
		click(By.cssSelector("input.button"));
		return driver.findElements(By.linkText(user.login)).size();
	}

}
