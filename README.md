Această aplicație este un serviciu de farmacie care oferă următoarele funcționalități:

1. **Adăugare (Add):**
   - Adăugare medicament (add medicine - am)
   - Adăugare client (add client - ac)
   - Adăugare furnizor (add supplier - as)
   - Adăugare vânzare (add sale - av)
   - Adăugare angajat (add employee - ae)

2. **Ștergere (Delete):**
   - Ștergere medicament (delete medicine - dm)
   - Ștergere client (delete client - dc)
   - Ștergere furnizor (delete supplier - ds)
   - Ștergere angajat (delete employee - de)

3. **Editare (Edit):**
   - Editare medicament (edit medicine - em)
   - Editare client (edit client - ec)
   - Editare furnizor (edit supplier - es)
   - Editare angajat (edit employee - ee)

4. **Afișare (Display):**
   - Afișare detalii medicamente (display medicine details - dmd)
   - Afișare detalii clienți (display client details - dcd)
   - Afișare detalii furnizori (display supplier details - dsd)
   - Afișare detalii vânzări (display sale details - dvd)
   - Afișare detalii angajați (display employee details - ded)

5. **Reîmprospătare stoc (Restock):**
   - Reîmprospătare stoc (restock - r)

Aceste acțiuni permit gestionarea stocului de medicamente, clienților, furnizorilor, angajaților și a vânzărilor în cadrul unei farmacii. Utilizatorul poate interacționa cu aplicația introducând comenzile corespunzătoare în linia de comandă.


În cadrul acestei aplicații, sunt folosite următoarele tipuri de obiecte:

1. **Medicament:** Acestea sunt obiecte care reprezintă diferite tipuri de medicamente, cum ar fi fiole, comprimate sau sirop. Există clase specifice pentru fiecare tip de medicament, cum ar fi **`Fiole`**, **`Comprimate`** și **`Sirop`**.

2. **Angajat:** Obiectele de tip `Angajat` reprezintă membrii personalului farmaciei. Aceste obiecte conțin informații precum nume, prenume, adresă și email ale angajatului.

3. **Client:** Obiectele de tip `Client` reprezintă clienții care cumpără medicamente de la farmacie. Aceste obiecte conțin informații despre nume, prenume, adresă și număr de telefon al clientului.

4. **Furnizor:** Obiectele de tip `Furnizor` reprezintă companiile sau persoanele care furnizează medicamente farmaciei. Aceste obiecte conțin informații despre nume, adresă și număr de telefon al furnizorului.

5. **Vânzare:** Obiectele de tip `Vanzare` reprezintă tranzacțiile de vânzare efectuate la farmacie. Aceste obiecte conțin informații despre clientul care a efectuat achiziția, angajatul care a înregistrat vânzarea și detaliile despre medicamentele achiziționate, inclusiv cantitatea și discountul aplicat.

Aceste tipuri de obiecte sunt utilizate pentru a modela diferite aspecte ale operațiunilor unei farmacii și pentru a permite interacțiunea și gestionarea acestora în cadrul aplicației.
