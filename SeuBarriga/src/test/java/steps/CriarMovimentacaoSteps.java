package steps;

import java.io.IOException;
import java.net.MalformedURLException;

import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;
import funcionalidades.CriarMovimentacaoFuncionalidade;
import pages.CriarMovimentacaoPage;


public class CriarMovimentacaoSteps {

	CriarMovimentacaoPage CriarMovimentacaoPage = new CriarMovimentacaoPage();
	
	@Quando("cria movimentação")
	public void cria_movimentação() throws MalformedURLException, IOException {
		new CriarMovimentacaoFuncionalidade().criarMovimentacao();
	}

	@Entao("validar mensagem de Sucesso")
	public void validar_mensagem_de_Sucesso() {
		new CriarMovimentacaoPage().getMsgSucesso();
	}

	@Entao("validar mensagem inválida  Data da Movimentação deve ser menor ou igual à data atual")
	public void validar_mensagem_inválida_Data_da_Movimentação_deve_ser_menor_ou_igual_à_data_atual() {
	new CriarMovimentacaoPage().getMsgSemSucesso();
	}

	@Entao("validar mensagem invalida quando a conta não for criada é obrigatório")
	public void validar_mensagem_invalida_quando_a_conta_não_for_criada_é_obrigatório() {
		new CriarMovimentacaoPage().getMsgSemSucesso();
	}

	@Entao("validar mensagem invalida todos os campos deve ser preenchidos")
	public void validar_mensagem_invalida_todos_os_campos_deve_ser_preenchidos() {
		new CriarMovimentacaoPage().getMsgSemSucesso();
	}

	@Entao("mensagem invalidam {string}")
	public void mensagem_invalidam(String string) {
		new CriarMovimentacaoPage().getMsgSemSucesso();
	}
}
