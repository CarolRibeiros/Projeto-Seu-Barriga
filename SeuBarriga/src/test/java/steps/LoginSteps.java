package steps;

import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;
import funcionalidades.LoginFuncionalidades;
import pages.LoginPage;
import utils.DataBase;

public class LoginSteps {

	LoginFuncionalidades loginfuncionalidades = new LoginFuncionalidades();

	@Dado("acesso ao portal Seu Barriga")
	public void acessoAoPortalSeuBarriga() throws Exception {
		loginfuncionalidades.acessarPortal();

	}

	@Quando("login com usu�rio e senha v�lidos")
	public void loginComUsu�rioESenhaV�lidos() throws Exception {
		loginfuncionalidades.realizarLogin(DataBase.MapBarrigaDB("EMAIL"), DataBase.MapBarrigaDB("SENHA"));

	}

	@Entao("validar conta conectada com sucesso")
	public void validarContaConectadaComSucesso() throws Exception {
		loginfuncionalidades.validarMensagem(LoginPage.XPATH_MSG_LOGIN_SUCCESS, "Login realizado com sucesso!");
	}

	@Quando("login com usu�rio inv�lido e senha v�lida")
	public void loginComUsu�rioInv�lidoESenhaV�lida() throws Exception {
		loginfuncionalidades.realizarLogin(DataBase.MapBarrigaDB("EMAIL_INVALIDO"), DataBase.MapBarrigaDB("SENHA"));

	}

	@Entao("validar que a conta n�o foi conectada")
	public void validarQueAContaN�oFoiConectada() throws Exception {
		loginfuncionalidades.validarMensagem(LoginPage.XPATH_MSG_LOGIN_SUCCESS, "Problemas com o login do usu�rio");
	}

	@Quando("login com usu�rio v�lido e senha inv�lida")
	public void loginComUsu�rioV�lidoESenhaInv�lida() throws Exception {
		loginfuncionalidades.realizarLogin(DataBase.MapBarrigaDB("EMAIL"), DataBase.MapBarrigaDB("SENHA_INVALIDA"));
	}

	@Quando("login sem usu�rio")
	public void loginSemUsu�rio() throws Exception {
		loginfuncionalidades.realizarLogin(" ", DataBase.MapBarrigaDB("SENHA"));
	}

	@Quando("login sem senha")
	public void loginSemSenha() throws Exception {
		loginfuncionalidades.realizarLogin(DataBase.MapBarrigaDB("EMAIL"), " ");
	}
}
