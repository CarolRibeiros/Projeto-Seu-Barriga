#language: pt
#encoding: iso-8859-1
@Cadastro
Funcionalidade: Cadastro

	Contexto: 
		Dado acesso ao portal Seu Barriga
		
  @CadastroValido @GoogleChrome
  Cenario: Criar nova conta no portal com email não cadastrado
    Quando cadastrar novo usuário com email não utilizado
    Entao validar se a conta foi criada com sucesso
    
  @CadastroInvalido @GoogleChrome
  Cenario: Criar nova conta no portal com email já cadastrado
    Quando cadastrar novo usuário com email já utilizado
    Entao validar se a conta não foi criada com sucesso