#language: pt
#encoding: iso-8859-1
@GoogleChrome
Funcionalidade: Criar Movimentação

  Contexto: 
    Dado acesso ao portal Seu Barriga
    Quando login com usuário e senha válidos
    Entao cria movimentação

  @CriarMovimentacaoValido
  Cenario: Acessar site Seu barriga e criar movimentacoes válida
    E validar mensagem de Sucesso

  @CriarMovimentacaoInvalido1
  Cenario: Validar mensagem invalida do Campo Data
    Entao validar mensagem inválida  Data da Movimentação deve ser menor ou igual à data atual

  @CriarMovimentacaoInvalido2
  Cenario: Validar mensagem invalida Campo Conta
    Entao validar mensagem invalida quando a conta não for criada é obrigatório

  @CriarMovimentacaoInvalido3
  Cenario: Validar mensagem invalidas Todos os campos não preenchidos
    Entao validar mensagem invalida todos os campos deve ser preenchidos

  @CriarMovimentacaoInvalido4
  Cenario: Validar mensagem invalida do campo Valor
    Entao mensagem invalidam "Valor deve ser um número"
