package com.example.fw;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public abstract class WebDriverHelperBase extends HelperBase {

	// protected ApplicationManager manager;
	protected WebDriver driver;
	public boolean acceptNextAlert = true;

	public WebDriverHelperBase(ApplicationManager manager) {
		super(manager);
		this.driver = manager.getDriver();
	}

	public boolean isAlertPresent() {
		try {
			driver.switchTo().alert();
			return true;
		} catch (NoAlertPresentException e) {
			return false;
		}
	}

	public String closeAlertAndGetItsText() {
		try {
			Alert alert = driver.switchTo().alert();
			String alertText = alert.getText();
			if (acceptNextAlert) {
				alert.accept();
			} else {
				alert.dismiss();
			}
			return alertText;
		} finally {
			acceptNextAlert = true;
		}
	}

	protected void type(By locator, String text) {
		if (text != null) {
			driver.findElement(locator).clear();
			driver.findElement(locator).sendKeys(text);
		}
	}

	protected WebElement findElement(By by) {
		try {
			return driver.findElement(by);
		} catch (Exception e) {
			return null;
		}
	}

	protected List<WebElement> findElements(By by) {
		return driver.findElements(by);
	}

	protected void openUrl(String string) {
		driver.get(manager.getProperty("baseUrl") + string);
	}

	protected void openAbsoluteUrl(String string) {
		driver.get(string);
	}

	protected void click(By locator) {
		driver.findElement(locator).click();
	}

	protected void selectByText(By locator, String text) {
		if (text != null) {
			new Select(driver.findElement(locator)).selectByVisibleText(text);
		}
	}

}