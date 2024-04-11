Această aplicație este un serviciu de farmacie care oferă următoarele funcționalități:

1. **Adăugare (Add):**
   - [1] Adăugare medicament (add medicine - am)
   - [2] Adăugare client (add client - ac)
   - [3] Adăugare furnizor (add supplier - as)
   - [4] Adăugare vânzare (add sale - av)
   - [5] Adăugare angajat (add employee - ae)

2. **Ștergere (Delete):**
   - [6] Ștergere medicament (delete medicine - dm)
   - [7] Ștergere client (delete client - dc)
   - [8] Ștergere furnizor (delete supplier - ds)
   - [9] Ștergere angajat (delete employee - de)

3. **Editare (Edit):**
   - [10] Editare medicament (edit medicine - em)
   - [11] Editare client (edit client - ec)
   - [12] Editare furnizor (edit supplier - es)
   - [13] Editare angajat (edit employee - ee)

4. **Afișare (Display):**
   - [14] Afișare detalii medicamente (display medicine details - dmd)
   - [15] Afișare detalii clienți (display client details - dcd)
   - [16] Afișare detalii furnizori (display supplier details - dsd)
   - [17] Afișare detalii vânzări (display sale details - dvd)
   - [18] Afișare detalii angajați (display employee details - ded)

5. **Reîmprospătare stoc (Restock):**
   - [19] Reîmprospătare stoc (restock - r)

Aceste acțiuni permit gestionarea stocului de medicamente, clienților, furnizorilor, angajaților și a vânzărilor în cadrul unei farmacii. Utilizatorul poate interacționa cu aplicația introducând comenzile corespunzătoare în linia de comandă.


În cadrul acestei aplicații, sunt folosite următoarele tipuri de obiecte:

1. **`Medicament`:** Acestea sunt obiecte care reprezintă diferite tipuri de medicamente, cum ar fi fiole, comprimate sau sirop. Există clase specifice pentru fiecare tip de medicament, cum ar fi **`Fiole`**, **`Comprimate`** și **`Sirop`**.

2. **`Angajat`:** Obiectele de tip `Angajat` reprezintă membrii personalului farmaciei. Aceste obiecte conțin informații precum nume, prenume, adresă și email ale angajatului.

3. **`Client`:** Obiectele de tip `Client` reprezintă clienții care cumpără medicamente de la farmacie. Aceste obiecte conțin informații despre nume, prenume, adresă și număr de telefon al clientului.

4. **`Furnizor`:** Obiectele de tip `Furnizor` reprezintă companiile sau persoanele care furnizează medicamente farmaciei. Aceste obiecte conțin informații despre nume, adresă și număr de telefon al furnizorului.

5. **`Vânzare`:** Obiectele de tip `Vanzare` reprezintă tranzacțiile de vânzare efectuate la farmacie. Aceste obiecte conțin informații despre clientul care a efectuat achiziția, angajatul care a înregistrat vânzarea și detaliile despre medicamentele achiziționate, inclusiv cantitatea și discountul aplicat.

Aceste tipuri de obiecte sunt utilizate pentru a modela diferite aspecte ale operațiunilor unei farmacii și pentru a permite interacțiunea și gestionarea acestora în cadrul aplicației.
