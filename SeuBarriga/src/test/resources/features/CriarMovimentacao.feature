#language: pt
#encoding: iso-8859-1
@GoogleChrome
Funcionalidade: Criar Movimenta��o

  Contexto: 
    Dado acesso ao portal Seu Barriga
    Quando login com usu�rio e senha v�lidos
    Entao cria movimenta��o

  @CriarMovimentacaoValido
  Cenario: Acessar site Seu barriga e criar movimentacoes v�lida
    E validar mensagem de Sucesso

  @CriarMovimentacaoInvalido1
  Cenario: Validar mensagem invalida do Campo Data
    Entao validar mensagem inv�lida  Data da Movimenta��o deve ser menor ou igual � data atual

  @CriarMovimentacaoInvalido2
  Cenario: Validar mensagem invalida Campo Conta
    Entao validar mensagem invalida quando a conta n�o for criada � obrigat�rio

  @CriarMovimentacaoInvalido3
  Cenario: Validar mensagem invalidas Todos os campos n�o preenchidos
    Entao validar mensagem invalida todos os campos deve ser preenchidos

  @CriarMovimentacaoInvalido4
  Cenario: Validar mensagem invalida do campo Valor
    Entao mensagem invalidam "Valor deve ser um n�mero"
