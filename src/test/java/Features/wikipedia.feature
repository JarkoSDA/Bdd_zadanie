Feature: Wyszukiwanie fraz

  Scenario Outline:
    Given Uzytkownik jest na stronie "https://www.wikipedia.org"
    When Uzytkownik wpisuje <fraza> w pole wyszukiwania
    And Uzytkownik klika w przycisk Szukaj
    Then <Tekst> zostaje poprawnie wyszukany

    Examples:
    |fraza | tekst|
    |bdd   | bdd |

