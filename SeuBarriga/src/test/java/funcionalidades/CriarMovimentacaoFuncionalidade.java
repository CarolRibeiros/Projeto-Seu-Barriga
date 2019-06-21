package funcionalidades;

import java.io.IOException;
import java.net.MalformedURLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import pages.CriarMovimentacaoPage;
import readers.Config;
import utils.evidencia.Evidencia;

public class CriarMovimentacaoFuncionalidade {

	CriarMovimentacaoPage movimentacaoPage = new CriarMovimentacaoPage();

	public void criarMovimentacao() throws MalformedURLException, IOException {

		new MenuFuncionalidades().clicarMenuCriarMovimentacao();

		movimentacaoPage.setTipoMovimentacao(Config.getProperty("tipo.movimentacao"));

		if (Config.getProperty("data.movimentacao").equals("")) {
			movimentacaoPage.setdataMovimentacao(LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
		}

		if (Config.getProperty("data.pagamento").equals("")) {
			movimentacaoPage.setdataPagamento(LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
		}
		
		movimentacaoPage.setdescricao(Config.getProperty("descricao.barriga"));
		movimentacaoPage.setinteressado(Config.getProperty("interessado.barriga"));
		movimentacaoPage.setvalor(Config.getProperty("valor.barriga"));
		movimentacaoPage.setConta(Config.getProperty("conta.barriga"));
		movimentacaoPage.setBtnSituacao(Config.getProperty("situacao.barriga"));

		Evidencia.tirarPrint("Criando uma nova Movimentação!");
		movimentacaoPage.clickBtnOk();

		if (!movimentacaoPage.movimentacaoAdicionadaComSucesso()) {
		}
	}
}