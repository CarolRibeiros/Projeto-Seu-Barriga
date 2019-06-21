package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import utils.WebDriverFactory;

public class AddContaPage {

	WebDriverFactory webDriverFactory = new WebDriverFactory();
	
	public static final String XPATH_INPUT_NOME = "//input[@id='nome']";
	public static final String XPATH_BTN_SALVAR = "//button[@type='submit']";
	
	public WebElement getInputPesquisa() {
	return webDriverFactory.getWebDriver().findElement(By.xpath(XPATH_INPUT_NOME));
	}
	
	public void setInputPesquisa(String value) {
		getInputPesquisa().sendKeys(value);
	}
	
	public WebElement getBtnSalvar() {
		return webDriverFactory.getWebDriver().findElement(By.xpath(XPATH_BTN_SALVAR));
	}
	
	public void clickBtnSalvar() {
		getBtnSalvar().click();
	}
}
