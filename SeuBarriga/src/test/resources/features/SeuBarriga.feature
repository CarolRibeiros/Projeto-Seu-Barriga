#language: pt
Funcionalidade: Teste de Criar movimentacoes

  @Execucao @GoogleChrome
  Cenario: Acessar site Seu barriga e criar movimentacoes
    Dado login no portal com usuario e senha validos
    Quando criar uma nova conta
    Entao validar que a conta foi adicionada com sucesso
    Quando criar movimentacao
    Entao verificar se a movimentacao foi criada
    E deslogar do portal
