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
		
		@Quando("cadastrar novo usu�rio com email n�o utilizado")
		public void cadastrarNovoUsu�rioComEmailN�oUtilizado() throws Exception{
			menuFuncionalidades.clicarMenuNovoUsuario();
			cadastro.cadastrarNovaConta(emailGenerator.EmailGenerator());
		}

		@Entao("validar se a conta foi criada com sucesso")
		public void validarSeAContaFoiCriadaComSucesso() throws Exception{
			validateAlerts.validateAlert("Usu�rio inserido com sucesso");
		}

		@Quando("cadastrar novo usu�rio com email j� utilizado")
		public void cadastrarNovoUsu�rioComEmailJ�Utilizado() throws Exception {
			menuFuncionalidades.clicarMenuNovoUsuario();
			cadastro.cadastrarNovaConta("tester@sempreit.com.br");
		}

		@Entao("validar se a conta n�o foi criada com sucesso")
		public void validarSeAContaN�oFoiCriadaComSucesso() throws Exception{
			validateAlerts.validateAlert("Endere�o de email j� utilizado");

	}
}
