package steps;

import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;
import funcionalidades.CadastroFuncionalidades;
import funcionalidades.MenuFuncionalidades;
import utils.EmailGenerator;
import utils.ValidateAlerts;

public class CadastroSteps {
	
		CadastroFuncionalidades cadastro = new CadastroFuncionalidades();
		ValidateAlerts validateAlerts = new ValidateAlerts();
		EmailGenerator emailGenerator = new EmailGenerator();
		MenuFuncionalidades menuFuncionalidades = new MenuFuncionalidades();
		
		@Quando("cadastrar novo usuário com email não utilizado")
		public void cadastrarNovoUsuárioComEmailNãoUtilizado() throws Exception{
			menuFuncionalidades.clicarMenuNovoUsuario();
			cadastro.cadastrarNovaConta(emailGenerator.EmailGenerator());
		}

		@Entao("validar se a conta foi criada com sucesso")
		public void validarSeAContaFoiCriadaComSucesso() throws Exception{
			validateAlerts.validateAlert("Usuário inserido com sucesso");
		}

		@Quando("cadastrar novo usuário com email já utilizado")
		public void cadastrarNovoUsuárioComEmailJáUtilizado() throws Exception {
			menuFuncionalidades.clicarMenuNovoUsuario();
			cadastro.cadastrarNovaConta("tester@sempreit.com.br");
		}

		@Entao("validar se a conta não foi criada com sucesso")
		public void validarSeAContaNãoFoiCriadaComSucesso() throws Exception{
			validateAlerts.validateAlert("Endereço de email já utilizado");

	}
}
