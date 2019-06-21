package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import utils.WebDriverFactory;

public class CadastroPage {
	
	WebDriverFactory webDriverFactory = new WebDriverFactory();
	
	public static final String XPATH_INPUT_NOME = "//input[@id = 'nome']";
	public static final String XPATH_INPUT_EMAIL = "//input[@id = 'email']";
	public static final String XPATH_INPUT_SENHA = "//input[@id = 'senha']";
	public static final String XPATH_INPUT_CADASTRAR = "//input[@value = 'Cadastrar']";

	
	public WebElement getInputNome() {
		return webDriverFactory.getWebDriver().findElement(By.xpath(XPATH_INPUT_NOME));
	}
	
	public void setInputNome(String value) {
		getInputNome().sendKeys(value);
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
	
	public WebElement getInputCadastrar() {
		return webDriverFactory.getWebDriver().findElement(By.xpath(XPATH_INPUT_CADASTRAR));
	}
	
	public void setInputCadastrar() {
		getInputCadastrar().click();
	}
}
