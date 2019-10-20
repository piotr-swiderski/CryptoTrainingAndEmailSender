# ROT-13 cipher


__Opis metody:__ 

Zasada działania jest identyczna jak w przypadku szyfru Cezara - różnica polega na wartości przesunięcia. W tym przypadku każdą literę tekstu jawnego zamieniamy na literę przesuniętą o 13 miejsca w prawo. W celu odszyfrowania tekst powtarzamy operację tym razem przesuwając litery o 13 pozycje w lewo.
Zapis matematyczny tych operacji wygląda następująco:

__Szyfrowanie:__

C=E(p)=(p+13)mod 26

__Deszyfrowanie:__

p=D(c)=(c-13)mod 26

Przyjmuje się, że alfabet składa się z 26 liter.

Należy również zauważyć, że przyjmując przesunięcie o wartości 13 przy deszyfrowaniu tekstu nie ważne jest czy wykonamy operację odejmowania czy dodawania (występuje przecież operacja mod 26). Zatem jeżeli szyfrujemy jedynie litery możemy użyć tej samej procedury do szyfrowania jak i deszyfrowania.

__Opis procedury:__

Szyfrowany/deszyfrowany tekst znajduje się w pliku. Dodatkowo przed uruchomieniem procedury należy stworzyć drugi plik, będący plikiem wynikowym. W programie podajemy nazwy tych plików. Następnie otwierane są oba pliki i jeżeli operacja ta powiedzie się zaczyna się szyfrowanie/deszyfrowanie. Za każdym razem pobierana jest jedna litera tekstu. Następnie według kod ASCII przydzielana jest ona do trzech możliwych grup: duże litery, małe litery lubz cyfry. Cyfry są w procedurze szyfrowane za pomocą przesunięcia o trzy a następnie wykonywana jest operacja mod 10 (nie ma znaczenia czy przesuniemy o 3 czy 13 jeżeli następnie dokonujemy operacji mod 10). Jeżeli ktoś uważa szyfrowanie cyfr za coś niepotrzebnego wystarczy, że usunie ostatni else if. W przypadku, gdy nie bierzemy pod uwagę cyfr procedura szyfrująca nadaje się zarówno do szyfrowanie jak i odszyfrowywanie. Wszystkie inne znaki w tym spacja zostaną usunięte. Jeżeli komuś zależy, aby inne znaki również były szyfrowane wystarczy, aby dodał kolejne instrukcje else if (wtedy nie ma już operacji mod, chyba że dodajemy grupę znaków). Należy dodać je w miejscu gdzie w programie widnieje odpowiedni komentarz. Po zamianie każdej litery zapisywana jest ona w pliku wyjściowym. Na końcu oba pliki są zamykane i procedura kończy się.
W przypadku procedury deszyfrującej zastosowałem trochę inną metodę. Ponieważ litera a ma numer zero. Zatem gdy odejmujemy wartość 13. Uzyskujemy wynik -13. Aby uzyskać poprawny wynik Wystarczy odjąć od 26 wartość bezwzględną wyniku (lub jak ktoś woli dodać tą wartość).
Oto przykładowy ciąg poddany działaniu algorytmu:

__Tekst jawny:__ Algorytmy i Struktury Danych

__Tekst zaszyfrowany:__ NytbelgzlvFgehxghelQnalpu 