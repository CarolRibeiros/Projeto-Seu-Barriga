package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.WebDriverFactory;

public class MenuPage {
	
	WebDriverFactory webDriverFactory = new WebDriverFactory();
	
	public static final String XPATH_MENU_HOME = "//a[contains(text(), 'Home')]";
	public static final String XPATH_MENU_CONTAS = "//a[contains(text(), 'Contas')]";
	public static final String XPATH_MENU_ADD_CONTA = "//a[contains(text(), 'Adicionar')]";
	public static final String XPATH_MENU_LISTAR_CONTAS = "//a[contains(text(), 'Listar')]";
	public static final String XPATH_MENU_CRIAR_MOVIMENTACAO = "//a[contains(text(), 'Criar Movimentação')]";
	public static final String XPATH_MENU_RESUMO_MENSAL = "//a[contains(text(), 'Resumo Mensal')]";
	public static final String XPATH_MENU_SAIR = "//a[contains(text(), 'Sair')]";
	public static final String XPATH_MENU_NOVO_USUARIO = "//a[contains(text(), 'Novo usuário?')]";
	
	
	public WebElement getMenuHome() {
		return webDriverFactory.getWebDriver().findElement(By.xpath(XPATH_MENU_HOME));
	}
	
	public void clickMenuHome() {
		getMenuHome().click();
	}
	
	public WebElement getMenuContas() {
		return webDriverFactory.getWebDriver().findElement(By.xpath(XPATH_MENU_CONTAS));
	}
	
	public void clickMenuContas() {
		getMenuContas().click();
	}
	
	public WebElement getMenuAddConta() {
		return webDriverFactory.getWebDriver().findElement(By.xpath(XPATH_MENU_ADD_CONTA));
	}
	
	public void clickMenuAddConta() {
		getMenuAddConta().click();
	}
	
	public WebElement getMenuListarContas() {
		return webDriverFactory.getWebDriver().findElement(By.xpath(XPATH_MENU_LISTAR_CONTAS));
	}
	
	public void clickMenuListarContas() {
		getMenuListarContas().click();
	}
	
	public WebElement getMenuCriarMovimentacao() {
		return webDriverFactory.getWebDriver().findElement(By.xpath(XPATH_MENU_CRIAR_MOVIMENTACAO));
	}
	
	public void clickMenuCriarMovimentacao() {
		getMenuCriarMovimentacao().click();
	}
	
	public WebElement getMenuResumoMensal() {
		return webDriverFactory.getWebDriver().findElement(By.xpath(XPATH_MENU_RESUMO_MENSAL));
	}
	
	public void clickMenuResumoMensal() {
		getMenuResumoMensal().click();
	}
	
	public WebElement getMenuSair() {
		return webDriverFactory.getWebDriver().findElement(By.xpath(XPATH_MENU_SAIR));
	}
	
	public void clickMenuSair() {
		getMenuSair().click();
	}
	
	public WebElement getMenuNovoUsuario() {
		return webDriverFactory.getWebDriver().findElement(By.xpath(XPATH_MENU_NOVO_USUARIO));
	}
	
	public void clickMenuNovoUsuario() {
		getMenuNovoUsuario().click();
	}
	
}
