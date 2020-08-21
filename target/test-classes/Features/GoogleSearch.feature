Feature: feature que testa a funcionalidade do Google Search

  Scenario: Google search esta a funcionar
    Given browser aberto
    And user esta na google search page
    When user escreve texto na search box
    And carrega no enter
    Then user e levado para os resultados
