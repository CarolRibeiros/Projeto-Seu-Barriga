package steps;

import java.io.IOException;
import java.net.MalformedURLException;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;
import funcionalidades.AddContaFuncionalidade;
import funcionalidades.CriarMovimentacaoFuncionalidade;
import funcionalidades.ListarContasFuncionalidades;
import funcionalidades.LoginFuncionalidades;
import funcionalidades.MenuFuncionalidades;
import funcionalidades.ResumoMensalFuncionalidade;
import readers.Config;

public class Step {

	@Dado("login no portal com usuario e senha validos")
	public void loginNoPortalComUsuarioESenhaValidos() throws Exception {
		new LoginFuncionalidades().acessarPortal();
		new LoginFuncionalidades().realizarLogin(Config.getProperty("email.barriga"), Config.getProperty("senha.barriga"));
	}
 
	@Quando("criar uma nova conta")
	public void criarUmaNovaConta() throws MalformedURLException, IOException {
		new AddContaFuncionalidade().addNovoUsuario();
	}

	@Entao("validar que a conta foi adicionada com sucesso")
	public void validarQueAContaFoiAdicionadaComSucesso() {
		new ListarContasFuncionalidades().validarContaCriada();
	}
	
	@Quando("criar movimentacao")
    public void criarMovimentacao() throws MalformedURLException, IOException {
        new CriarMovimentacaoFuncionalidade().criarMovimentacao();
    }

	
	@Entao("verificar se a movimentacao foi criada")
	public void verificarSeAMovimentacaoFoiCriada() throws MalformedURLException, IOException {
		new ResumoMensalFuncionalidade().removerMovimentacao();
	}

	@Entao("deslogar do portal")
	public void deslogarDoPortal() throws MalformedURLException, IOException {
		new ListarContasFuncionalidades().removerContas();
		new MenuFuncionalidades().clicarMenuSair();
	}

}
