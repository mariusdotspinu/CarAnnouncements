In cazul in care lucram cu MySQL workbench pentru ca datele de test(imaginile) sa fie inserate fara erori:

1)Trebuie sa atribuim privilegiul de FILE utilizatorului curent (in cazul nostru 'root') - Executa grant_file_to_root.sql
2) Pornim consola mysql - MySQL 8.0 command line client
3) Executam instructiunea : SELECT @@secure_file_priv;  

Aceasta ne va indica locatia in care are acces MySQL workbench sa citeasca date, deci directorul test_images ar trebui mutat acolo.
In cazul meu locatia este : C:\ProgramData\MySQL\MySQL Server 8.0\Uploads\ ( Atentie, `ProgramData` este director ascuns, deci trebuie bifata optiunea de
a vizualiza directoarele respective).

Dupa realizarea celor de mai sus instructiunile INSERT pentru imagini ar trebui sa fie executate fara probleme.