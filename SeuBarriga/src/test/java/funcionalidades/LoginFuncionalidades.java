package funcionalidades;

import org.openqa.selenium.By;

import pages.LoginPage;
import utils.DataBase;
import utils.WebDriverFactory;
import utils.evidencia.Evidencia;

public class LoginFuncionalidades {

	WebDriverFactory DriverFactory = new WebDriverFactory();
	LoginPage loginPage = new LoginPage();

	public void acessarPortal() throws Exception {
		loginPage.acessarPagina(DataBase.MapBarrigaDB("URL"));

	}

	public void realizarLogin(String user, String senha) throws Exception {

		loginPage.setInputEmail(user);
		loginPage.setInputSenha(senha);

		Evidencia.tirarPrint("Tela de Login", loginPage.getInputEmail(), loginPage.getInputSenha(),
		loginPage.getButtonEntrar());

		loginPage.clickButtonEntrar();
	}

	public void validarMensagem(String xpath, String msg) throws Exception {

		try {
			loginPage.getMensagem(xpath);
			Evidencia.tirarPrint(msg, DriverFactory.getWebDriver().findElement(By.xpath(xpath)));
		} catch (Exception e) {
			Evidencia.tirarPrint("Erro!\n" + e);
		}
	}

	public boolean expressBooleanMsg() {
        boolean msgValidacao = true;
 
        try {
            DriverFactory.getWebDriver().findElement(By.xpath("//div[@class='alert alert-danger']"));
            msgValidacao = true;
        } catch (Exception e) {
            msgValidacao = false;
        }
        return msgValidacao;
    }
}
