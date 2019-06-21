package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import utils.WebDriverFactory;

public class ResumoMensalPage {
	
	WebDriverFactory webDriverFactory = new WebDriverFactory();

	public static final String XPATH_A_REMOVER_MOVIMENTACAO = "//a[contains(@href, 'remover')]";
	
	public WebElement getBtnRemoverMovimentacao() {
		return webDriverFactory.getWebDriver().findElement(By.xpath(XPATH_A_REMOVER_MOVIMENTACAO));
	}
	
	public void clickBtnRemoverMovimentacao() {
		getBtnRemoverMovimentacao().click();
	}
}
