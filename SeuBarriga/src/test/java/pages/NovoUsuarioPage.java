package pages;

import utils.WebDriverFactory;

public class NovoUsuarioPage {

	WebDriverFactory webDriverFactory = new WebDriverFactory();
	
	public static final String XPATH_NOVO_USUARIO = "//a[contains(text(),'Novo usuário?')]";
	public static final String XPATH_INPUT_NOME_NEW_USER = "//input[@id='nome']";
	public static final String XPATH_INPUT_EMAIL_NEW_USER = "//input[@id='email']";
	public static final String XPATH_INPUT_SENHA_NEW_USER = "//input[@id='senha']";
	public static final String XPATH_BTN_CADASTRAR = "//input[@value='Cadastrar']";
	
}
	
