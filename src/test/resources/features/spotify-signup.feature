Feature: Bejelentkezés a loginra

  Background:
    Given the home page is opened

  Scenario Outline: Bejelentkező ablak teszt
    When the '<field>' is filled in with '<parameter>'
      And the '<jelszo>' is filled in with '<pass>'
      And the Bejelentkezés header button is clicked
    Then the '<errorMessage>' error message of the '<error>' field should be shown

    Examples:
     |pass  |jelszo                |error         | field                         | parameter | errorMessage                                                           |
     |pobaa1|Adj meg egy jelszót. | Hiba üzenet   | Add meg a felhasználói neved  | asd       | Hibás felhasználói név és jelszó |
     |proba2|Adj meg egy jelszót. | Hiba üzenet   | Add meg a felhasználói neved  | 123       | Hibás felhasználói név és jelszó |
     |1234  |Adj meg egy jelszót. | Hiba üzenet   | Add meg a felhasználói neved  | aaa       | Hibás felhasználói név és jelszó                                                  |
