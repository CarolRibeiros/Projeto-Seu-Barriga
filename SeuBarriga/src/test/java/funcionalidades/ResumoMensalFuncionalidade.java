package funcionalidades;

import pages.ResumoMensalPage;

public class ResumoMensalFuncionalidade {

	ResumoMensalPage resumoPage = new ResumoMensalPage();

	public void removerMovimentacao() {
		new MenuFuncionalidades().clicarMenuResumoMensal();

		resumoPage.clickBtnRemoverMovimentacao();
	}

}
