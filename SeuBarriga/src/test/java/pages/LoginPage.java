package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import utils.WebDriverFactory;

public class LoginPage {
	
	WebDriverFactory webDriverFactory = new WebDriverFactory();
	
	public static final String XPATH_INPUT_EMAIL = "//input[@id = 'email']";
	public static final String XPATH_INPUT_SENHA = "//input[@id = 'senha']";
	public static final String XPATH_BUTTON_ENTRAR = "//button[text() = 'Entrar']";
	public static final String XPATH_MSG_LOGIN_SUCCESS = "//div[contains(text(), 'Bem vindo')]";
	public static final String XPATH_MSG_LOGIN_FAILED = "//div[@class='alert alert-danger']";
	public static final String XPATH_MSG_CAMPO_OBRIGATORIO = "//div[contains(text(), 'campo obrigatório')]";
	
	public void acessarPagina(String URL) {
		webDriverFactory.getWebDriver().get(URL);
	}
	
	public WebElement getInputEmail() {
		return webDriverFactory.getWebDriver().findElement(By.xpath(XPATH_INPUT_EMAIL));
	}
	
	public void setInputEmail(String value) {
		getInputEmail().sendKeys(value);
	}
	
	public WebElement getInputSenha() {
		return webDriverFactory.getWebDriver().findElement(By.xpath(XPATH_INPUT_SENHA));
	}
	
	public void setInputSenha(String value) {
		getInputSenha().sendKeys(value);
	} 
	
	public WebElement getButtonEntrar() {
		return webDriverFactory.getWebDriver().findElement(By.xpath(XPATH_BUTTON_ENTRAR));
	}
	
	public void clickButtonEntrar() {
		getButtonEntrar().click();
	}
	
	public WebElement getMensagem(String xpath) {
		return webDriverFactory.getWebDriver().findElement(By.xpath(xpath));
	}
}
