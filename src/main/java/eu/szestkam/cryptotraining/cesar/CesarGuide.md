# Cesar cipher

__Opis metody:__
 
Każdą literę tekstu jawnego zamieniamy na literę przesuniętą o 3 miejsca w prawo. I tak literę A szyfrujemy jako literę D, literę B jako E itd. W przypadku litery Z wybieramy literę C. W celu odszyfrowania tekst powtarzamy operację tym razem przesuwając litery o 3 pozycje w lewo.
Zapis matematyczny tych operacji wygląda następująco:

__Szyfrowanie:__

C=E(p)=(p+3)mod 26

__Deszyfrowanie:__

p=D(c)=(c-3)mod 26

Przyjmuje się, że alfabet składa się z 26 liter. 

__Opis procedury:__ 

Szyfrowany/deszyfrowany tekst znajduje się w pliku. Dodatkowo przed uruchomieniem procedury należy stworzyć drugi plik, będący plikiem wynikowym. W programie podajemy nazwy tych plików. Następnie otwierane są oba pliki i jeżeli operacja ta powiedzie się, zaczyna się szyfrowanie/deszyfrowanie. Za każdym razem pobierana jest jedna litera tekstu. Następnie według kod ASCII przydzielana jest ona do trzech możliwych grup: duże litery, małe litery lub cyfry. W przypadku oryginalnego szyfru Cezara nie było możliwości szyfrowania cyfr. Cyfry są w procedurze szyfrowane za pomocą przesunięcia o trzy a następnie wykonywana jest operacja mod 10. Co nie jest w pełni zgodne ze standardem algorytmu Cezara. Jeżeli ktoś uważa szyfrowanie cyfr za coś niepotrzebnego wystarczy, że usunie ostatnią instrukcję else if. Wszystkie inne znaki w tym spacja podczas szyfrowania ulegają usunięciu. Jeżeli komuś zależy, aby inne znaki też były szyfrowane wystarczy, aby dodał kolejne instrukcje else if (operacja mod wystąpi tylko wtedy gdy dodajemy jeszcze jakąś grupę znaków a nie pojedyncze znaki). Należy dodać je w miejscu gdzie w programie widnieje odpowiedni komentarz. Po zamianie każdej litery zapisywana jest ona w pliku wyjściowym. Na końcu oba pliki są zamykane i procedura kończy się.

W przypadku procedury deszyfrującej zastosowałem trochę inną metodę. Ponieważ litera a ma numer zero. Zatem gdy odejmujemy wartość 3. Uzyskujemy wynik -3. Aby uzyskać poprawny wynik Wystarczy odjąć od 26 wartość bezwzględną wyniku (lub jeżeli ktoś woli dodać ten wynik).