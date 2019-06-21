#language: pt
Funcionalidade: Teste de Criar Contas

  Cenario: Criar uma conta valida
    Dado login no portal com usuario e senha validos
    Quando criar uma nova conta
    Entao validar que a conta foi adicionada com sucesso
	
  Cenario: Criar uma conta invalida
    Dado login no portal com usuario e senha validos
    Quando criar uma nova conta ja existente
    Entao validar se a mensagem de conta invalida aparece
