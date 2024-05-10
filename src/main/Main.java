package main;

import repository.*;
import service.PharmacyService;


public class Main {
    public static void main(String[] args) {
        MedicamentRepository medicamente = new MedicamentRepositoryImpl();
        AngajatRepository angajati = new AngajatRepositoryImpl();
        FurnizorRepository furnizori = new FurnizorRepositoryImpl();
        ClientRepository clienti = new ClientRepositoryImpl();
        VanzareRepository vanzari = new VanzareRepositoryImpl();

        PharmacyService pharmacyService = new PharmacyService(medicamente, angajati, furnizori, clienti, vanzari);

        pharmacyService.start();
    }
}
