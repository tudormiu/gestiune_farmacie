import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Medicament> medicamente = new ArrayList<>();
        ArrayList<Angajat> angajati = new ArrayList<>();
        ArrayList<Furnizor> furnizori = new ArrayList<>();
        ArrayList<Client> clienti = new ArrayList<>();
        ArrayList<Vanzare> vanzari = new ArrayList<>();

        PharmacyService pharmacyService = new PharmacyService(medicamente, angajati, furnizori, clienti, vanzari);

        pharmacyService.start();
    }
}
