package funcionalidades;

import java.io.IOException;
import java.net.MalformedURLException;

import pages.MenuPage;

public class MenuFuncionalidades {

	MenuPage menuPage = new MenuPage();

	public void adicionarContas() {
		menuPage.clickMenuContas();
		menuPage.clickMenuAddConta();
	}

	public void listarContas() {
		menuPage.clickMenuContas();
		menuPage.clickMenuListarContas();
	}

	public void clicarMenuHome() {
		menuPage.clickMenuHome();
	}

	public void clicarMenuCriarMovimentacao() {
		menuPage.clickMenuCriarMovimentacao();
	}

	public void clicarMenuResumoMensal() {
		menuPage.clickMenuResumoMensal();
	}

	public void clicarMenuSair() throws MalformedURLException, IOException {	
		menuPage.clickMenuSair();
	}
	
	public void clicarMenuNovoUsuario() {
		menuPage.clickMenuNovoUsuario();
	}


}
