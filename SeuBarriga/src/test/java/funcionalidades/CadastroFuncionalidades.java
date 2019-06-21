package funcionalidades;

import pages.CadastroPage;
import utils.DataBase;
import utils.WebDriverFactory;
import utils.evidencia.Evidencia;

public class CadastroFuncionalidades {
	
	WebDriverFactory webDriverFactory = new WebDriverFactory();
	CadastroPage cadastroPage = new CadastroPage();

	public void cadastrarNovaConta(String email) throws Exception{
		cadastroPage.setInputNome(DataBase.MapBarrigaDB("NOME"));
		cadastroPage.setInputEmail(email);
		cadastroPage.setInputSenha(DataBase.MapBarrigaDB("SENHA"));
		Evidencia.tirarPrint("Preencher campos novo usuário");
		cadastroPage.setInputCadastrar();
	}

}
