#language: pt
#encoding: iso-8859-1
@Cadastro
Funcionalidade: Cadastro

	Contexto: 
		Dado acesso ao portal Seu Barriga
		
  @CadastroValido @GoogleChrome
  Cenario: Criar nova conta no portal com email n�o cadastrado
    Quando cadastrar novo usu�rio com email n�o utilizado
    Entao validar se a conta foi criada com sucesso
    
  @CadastroInvalido @GoogleChrome
  Cenario: Criar nova conta no portal com email j� cadastrado
    Quando cadastrar novo usu�rio com email j� utilizado
    Entao validar se a conta n�o foi criada com sucesso