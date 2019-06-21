package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.WebDriverFactory;

public class ListarContasPage {

	WebDriverFactory DriverFactory = new WebDriverFactory();

	public static final String XPATH_A_REMOVER_CONTA = "//a[contains(@href, 'remover')]";
	public static final String XPATH_MSG_CONTA_CRIADA = "//div[@class='alert alert-success']";
	public static final String XPATH_CONTA_CRIADA = "//td[contains(text(), 'Gasolina')]";

	public WebElement getBtnRemoverConta() {
		return DriverFactory.getWebDriver().findElement(By.xpath(XPATH_A_REMOVER_CONTA));
	}

	public void clickBtnRemoverConta() {
		getBtnRemoverConta().click();
	}

	public WebElement getMsgContaCriada() {
		return DriverFactory.getWebDriver().findElement(By.xpath(XPATH_MSG_CONTA_CRIADA));
	}
	
	public WebElement getContaCriada() {
		return DriverFactory.getWebDriver().findElement(By.xpath(XPATH_CONTA_CRIADA));
	}
	
	public boolean contaCriadaComSucesso() {
		
		boolean msg = true;
		
		try {
			DriverFactory.getWebDriver().findElement(By.xpath(XPATH_MSG_CONTA_CRIADA));
			msg = true;
		}
		catch(Exception e) {
			msg = false;
		}
		
		return msg;
	}

}
