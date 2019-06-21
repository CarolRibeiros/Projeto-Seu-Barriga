package funcionalidades;

import java.io.IOException;
import java.net.MalformedURLException;

import pages.AddContaPage;
import pages.ListarContasPage;
import readers.Config;
import utils.evidencia.Evidencia;

public class AddContaFuncionalidade {

	AddContaPage addContaPage = new AddContaPage();
	ListarContasPage listarContasPage = new ListarContasPage();

	public void addNovoUsuario() {
		try {
			new MenuFuncionalidades().adicionarContas();
			addContaPage.setInputPesquisa(Config.getProperty("nome.barriga"));
			Evidencia.tirarPrint("Adicionando Uma Nova Conta");
			addContaPage.clickBtnSalvar();
			Evidencia.tirarPrint("Conta Criada Com Sucesso", listarContasPage.getContaCriada());
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
