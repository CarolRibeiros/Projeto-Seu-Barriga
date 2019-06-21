package steps;

import java.io.IOException;
import java.net.MalformedURLException;

import org.junit.Rule;
import org.junit.rules.TestName;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import utils.WebDriverFactory;
import utils.evidencia.Evidencia;

public class Hooks {

	WebDriverFactory webDriverFactory = new WebDriverFactory();

	@Rule
	public TestName testName = new TestName();

	@Before("@GoogleChrome")
	public void setGoogleChromeDriver() throws MalformedURLException, IOException {
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/drivers/chromedriver.exe");
		webDriverFactory.setNavegador(new ChromeDriver());
		
		new Evidencia(testName.getMethodName());
	}

	@After
	public void finalizaDrivers() {
		webDriverFactory.quitDriver();
		Evidencia.fecharDocumento();
	}

}
