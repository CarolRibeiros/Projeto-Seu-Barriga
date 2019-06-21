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

	@Quando("login com usuário e senha válidos")
	public void loginComUsuárioESenhaVálidos() throws Exception {
		loginfuncionalidades.realizarLogin(DataBase.MapBarrigaDB("EMAIL"), DataBase.MapBarrigaDB("SENHA"));

	}

	@Entao("validar conta conectada com sucesso")
	public void validarContaConectadaComSucesso() throws Exception {
		loginfuncionalidades.validarMensagem(LoginPage.XPATH_MSG_LOGIN_SUCCESS, "Login realizado com sucesso!");
	}

	@Quando("login com usuário inválido e senha válida")
	public void loginComUsuárioInválidoESenhaVálida() throws Exception {
		loginfuncionalidades.realizarLogin(DataBase.MapBarrigaDB("EMAIL_INVALIDO"), DataBase.MapBarrigaDB("SENHA"));

	}

	@Entao("validar que a conta não foi conectada")
	public void validarQueAContaNãoFoiConectada() throws Exception {
		loginfuncionalidades.validarMensagem(LoginPage.XPATH_MSG_LOGIN_SUCCESS, "Problemas com o login do usuário");
	}

	@Quando("login com usuário válido e senha inválida")
	public void loginComUsuárioVálidoESenhaInválida() throws Exception {
		loginfuncionalidades.realizarLogin(DataBase.MapBarrigaDB("EMAIL"), DataBase.MapBarrigaDB("SENHA_INVALIDA"));
	}

	@Quando("login sem usuário")
	public void loginSemUsuário() throws Exception {
		loginfuncionalidades.realizarLogin(" ", DataBase.MapBarrigaDB("SENHA"));
	}

	@Quando("login sem senha")
	public void loginSemSenha() throws Exception {
		loginfuncionalidades.realizarLogin(DataBase.MapBarrigaDB("EMAIL"), " ");
	}
}
