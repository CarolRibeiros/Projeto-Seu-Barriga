package utils;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

public class WebDriverFactory {
static WebDriver driver;
    
    public void setNavegador(WebDriver driver) {
        WebDriverFactory.driver = driver;
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }
    
    public WebDriver getWebDriver() {
        return driver;
    }
    
    public void quitDriver() {
        driver.quit();
    }
   

}
