package utils;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import utils.evidencia.Evidencia;

public class ValidateAlerts {
	
	WebDriverFactory webDriverFactory = new WebDriverFactory();
	
	public static final String XPATH_ALERT = "//div[contains(@class, 'alert')]";
	
	public void validateAlert(String textoEsperado) throws MalformedURLException, IOException {
		List<WebElement> alert = webDriverFactory.getWebDriver().findElements(By.xpath(XPATH_ALERT));
		for(int i = 0; i < alert.size(); i++) {
			String alertText = alert.get(i).getText();
			if(alertText.equals(textoEsperado)) {
				Evidencia.tirarPrint(textoEsperado + "\nPassou", webDriverFactory.getWebDriver().findElement(By.xpath(XPATH_ALERT)));
			}
			else {
				Evidencia.tirarPrint("Erro!\nAlerta esperado: " + textoEsperado + "\nAlerta recebido: " + alertText);
			}
		}
	}

}
