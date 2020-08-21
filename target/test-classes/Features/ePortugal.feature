Feature: feature que testa a funcionalidade do site ePortugal

  Scenario: O site esta a funcionar
    Given browser aberto
    And user esta na pagina principal
    When user seleciona Servicos
    And user escreve Abono de Familia
    And carrega no enter
    Then user e levado para os resultados
