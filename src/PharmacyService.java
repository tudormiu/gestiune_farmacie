import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PharmacyService {
    ArrayList<Medicament> medicamente = new ArrayList<>();
    ArrayList<Angajat> angajati = new ArrayList<>();
    ArrayList<Furnizor> furnizori = new ArrayList<>();
    ArrayList<Client> clienti = new ArrayList<>();
    ArrayList<Vanzare> vanzari = new ArrayList<>();

    public PharmacyService(ArrayList<Medicament> medicamente, ArrayList<Angajat> angajati, ArrayList<Furnizor> furnizori, ArrayList<Client> clienti, ArrayList<Vanzare> vanzari) {
        this.medicamente = medicamente;
        this.angajati = angajati;
        this.furnizori = furnizori;
        this.clienti = clienti;
        this.vanzari = vanzari;
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Select mode (add - a, delete - d, edit - e, display details - dd, restock - r, close - q): ");
            String mode = scanner.nextLine();

            if (mode.equals("q")) {
                return;
            }

            switch (mode) {
                case "a":
                    add(scanner);
                    break;
                case "d":
                    delete(scanner);
                    break;
                case "e":
                    edit(scanner);
                    break;
                case "r":
                    restock(scanner);
                case "dd":
                    display(scanner);
                    break;
                default:
                    System.out.println("Invalid mode.");
            }
        }
    }

    private void add(Scanner scanner) {
        System.out.print("What would you like to add:\n " +
                "add medicine - am\n" +
                "add client - ac\n" +
                "add supplier - as\n" +
                "add sale - av\n" +
                "add employee - ae\n");
        String addMode = scanner.nextLine();

        switch (addMode) {
            case "am":
                addMedicine(scanner);
                break;
            case "ac":
                addClient(scanner);
                break;
            case "as":
                addSupplier(scanner);
                break;
            case "av":
                addSale(scanner);
                break;
            case "ae":
                addEmployee(scanner);
                break;
        }
    }

    private void delete(Scanner scanner) {
        System.out.print("What would you like to delete:\n " +
                "delete medicine - dm\n" +
                "delete client - dc\n" +
                "delete supplier - ds\n" +
                "delete employee - de\n");
        String deleteMode = scanner.nextLine();

        switch (deleteMode) {
            case "dm":
                deleteMedicine(scanner);
                break;
            case "dc":
                deleteClient(scanner);
                break;
            case "ds":
                deleteSupplier(scanner);
                break;
            case "de":
                deleteEmployee(scanner);
                break;
        }
    }

    private void edit(Scanner scanner) {
        System.out.print("What would you like to edit:\n " +
                "edit medicine - em\n" +
                "edit client - ec\n" +
                "edit supplier - es\n" +
                "edit employee - ee\n");
        String editMode = scanner.nextLine();

        switch (editMode) {
            case "em":
                editMedicine(scanner);
                break;
            case "ec":
                editClient(scanner);
                break;
            case "es":
                editSupplier(scanner);
                break;
            case "ee":
                editEmployee(scanner);
                break;
        }
    }

    private void display(Scanner scanner) {
        System.out.print("What would you like to display:\n " +
                "display medicine details - dmd\n" +
                "display client details - dcd\n" +
                "display supplier details - dsd\n" +
                "display sale details - dvd\n" +
                "display employee details - ded\n");
        String displayMode = scanner.nextLine();

        switch (displayMode) {
            case "dmd":
                for (Medicament m : medicamente) {
                    System.out.println(m);
                }
                break;
            case "dcd":
                for (Client c : clienti) {
                    System.out.println(c);
                }
                break;
            case "dsd":
                for (Furnizor f : furnizori) {
                    System.out.println(f);
                }
                break;
            case "dvd":
                for (Vanzare v : vanzari) {
                    System.out.println(v);
                }
                break;
            case "ded":
                for (Angajat a : angajati) {
                    System.out.println(a);
                }
                break;
        }
    }

    private void addMedicine(Scanner scanner) {
        System.out.print("Enter the name of the medicine: ");
        String name = scanner.nextLine();
        System.out.print("Enter the name of the supplier: ");
        String supplierName = scanner.nextLine();
        System.out.print("Enter the type of the medicine (fiole, comprimate, sirop): ");
        String type = scanner.nextLine();
        System.out.print("Enter the price of the medicine: ");
        double price = scanner.nextDouble();
        System.out.print("Enter the stock of the medicine: ");
        int stock = scanner.nextInt();

        //search for the supplier
        Furnizor furnizor = null;
        for (Furnizor f : furnizori) {
            if (f.getNume().equals(supplierName)) {
                furnizor = f;
                break;
            }
        }

        if (furnizor == null) {
            System.out.println("The supplier does not exist");
            return;
        }

        switch (type) {
            case "fiole":
                System.out.print("Enter the volume of the medicine: ");
                float volume = scanner.nextFloat();
                System.out.print("Enter the number of fiole: ");
                int number = scanner.nextInt();
                medicamente.add(new Fiole(name, furnizor, price, stock, volume, number));
                break;
            case "comprimate":
                System.out.print("Enter the number of comprimate: ");
                int comprimate = scanner.nextInt();
                System.out.print("Enter the number of miligrame: ");
                int miligrame = scanner.nextInt();
                medicamente.add(new Comprimate(name, furnizor, price, stock, comprimate, miligrame));
                break;
            case "sirop":
                System.out.print("Enter the number of mililitri: ");
                int mililitri = scanner.nextInt();
                medicamente.add(new Sirop(name, furnizor, price, stock, mililitri));
                break;
            default:
                System.out.println("Invalid type");
        }
    }

    private void addClient(Scanner scanner) {
        System.out.print("Enter the surname of the client: ");
        String surname = scanner.nextLine();
        System.out.print("Enter the name of the client: ");
        String name = scanner.nextLine();
        System.out.print("Enter the address of the client: ");
        String address = scanner.nextLine();
        System.out.print("Enter the phone number of the client: ");
        String phoneNumber = scanner.nextLine();
        clienti.add(new Client(surname, name, address, phoneNumber));
    }

    private void addSupplier(Scanner scanner) {
        System.out.print("Enter the name of the supplier: ");
        String name = scanner.nextLine();
        System.out.print("Enter the address of the supplier: ");
        String address = scanner.nextLine();
        System.out.print("Enter the phone number of the supplier: ");
        String phoneNumber = scanner.nextLine();
        furnizori.add(new Furnizor(name, address, phoneNumber));
    }

    private void addSale(Scanner scanner) {
        System.out.print("Enter the name of the client: ");
        String clientName = scanner.nextLine();


        List<Tuple> lista = new ArrayList<>();

        while (true) {
            System.out.print("Add medicine by writing the name. To stop, type 'stop'.\n");
            String name = scanner.nextLine();

            if (name.equals("stop")) {
                break;
            }

            Medicament medicine = null;
            for (Medicament m : medicamente) {
                if (m.getDenumire().equals(name)) {
                    medicine = m;
                    break;
                }
            }
            if (medicine == null) {
                System.out.println("The medicine does not exist");
            } else {
                System.out.print("Enter the quantity of the medicine: ");
                int quantity1 = scanner.nextInt();
                System.out.print("Enter the discount of the medicine (X %): ");
                double discount1 = scanner.nextDouble();

                lista.add(new Tuple(medicine, quantity1, discount1));
            }
        }

        Client client = null;
        for (Client c : clienti) {
            if (c.getNume().equals(clientName)) {
                client = c;
                break;
            }
        }
        if (client == null) {
            System.out.println("The client does not exist");
            return;
        }

        Angajat ang = null;
        System.out.print("Enter the name of the employee: ");
        String employeeName = scanner.nextLine();

        for (Angajat a : angajati) {
            if (a.getNume().equals(employeeName)) {
                ang = a;
                break;
            }
        }
        if (ang == null) {
            System.out.println("The employee does not exist");
            return;
        }

        System.out.print("Enter the discount of the sale: ");
        double disc = scanner.nextDouble();

        Vanzare vanzare = new Vanzare(client, ang, lista, disc);
        vanzari.add(vanzare);
    }

    private void addEmployee(Scanner scanner) {
        System.out.print("Enter the surname of the employee: ");
        String surname = scanner.nextLine();
        System.out.print("Enter the name of the employee: ");
        String name = scanner.nextLine();
        System.out.print("Enter the address of the employee: ");
        String address = scanner.nextLine();
        System.out.print("Enter the email of the employee: ");
        String email = scanner.nextLine();
        angajati.add(new Angajat(surname, name, address, email));
    }

    private void editMedicine(Scanner scanner) {
        System.out.print("Enter the name of the medicine: ");
        String name = scanner.nextLine();
        Medicament medicament = null;
        for (Medicament m : medicamente) {
            if (m.getDenumire().equals(name)) {
                medicament = m;
                break;
            }
        }
        if (medicament == null) {
            System.out.println("The medicine does not exist");
            return;
        }

        String tip = medicament.getTip();

        System.out.print("Enter the new name of the medicine: ");
        medicament.setDenumire(scanner.nextLine());

        System.out.print("Enter the new name of the supplier: ");
        String supplierName = scanner.nextLine();
        Furnizor furnizor = null;
        for (Furnizor f : furnizori) {
            if (f.getNume().equals(supplierName)) {
                furnizor = f;
                break;
            }
        }
        if (furnizor == null) {
            System.out.println("The supplier does not exist");
            return;
        }
        medicament.setFurnizor(furnizor);

        System.out.print("Enter the new price of the medicine: ");
        medicament.setPret(scanner.nextDouble());

        System.out.print("Enter the new stock of the medicine: ");
        medicament.setStoc(scanner.nextInt());

        if (tip.equals("Fiole")) {
            System.out.print("Enter the new volume of the medicine: ");
            ((Fiole) medicament).setVolum(scanner.nextFloat());

            System.out.print("Enter the new number of fiole: ");
            ((Fiole) medicament).setNumarFiole(scanner.nextInt());
        } else if (tip.equals("Comprimate")) {
            System.out.print("Enter the new number of comprimate: ");
            ((Comprimate) medicament).setNumarComprimate(scanner.nextInt());

            System.out.print("Enter the new number of miligrame: ");
            ((Comprimate) medicament).setMiligrame(scanner.nextInt());
        } else if (tip.equals("Sirop")) {
            System.out.print("Enter the new number of mililitri: ");
            ((Sirop) medicament).setMililitri(scanner.nextInt());
        }
    }

    private void editClient(Scanner scanner) {
        System.out.print("Enter the name of the client: ");
        String name = scanner.nextLine();
        Client client = null;
        for (Client c : clienti) {
            if (c.getNume().equals(name)) {
                client = c;
                break;
            }
        }
        if (client == null) {
            System.out.println("The client does not exist");
            return;
        }

        System.out.print("Enter the new name of the client: ");
        client.setNume(scanner.nextLine());

        System.out.print("Enter the new address of the client: ");
        client.setAdresa(scanner.nextLine());

        System.out.print("Enter the new phone number of the client: ");
        client.setTelefon(scanner.nextLine());
    }

    private void editSupplier(Scanner scanner) {
        System.out.print("Enter the name of the supplier: ");
        String name = scanner.nextLine();
        Furnizor furnizor = null;
        for (Furnizor f : furnizori) {
            if (f.getNume().equals(name)) {
                furnizor = f;
                break;
            }
        }
        if (furnizor == null) {
            System.out.println("The supplier does not exist");
            return;
        }

        System.out.print("Enter the new name of the supplier: ");
        furnizor.setNume(scanner.nextLine());

        System.out.print("Enter the new address of the supplier: ");
        furnizor.setAdresa(scanner.nextLine());

        System.out.print("Enter the new phone number of the supplier: ");
        furnizor.setTelefon(scanner.nextLine());
    }

    private void editEmployee(Scanner scanner) {
        System.out.print("Enter the name of the employee: ");
        String name = scanner.nextLine();
        Angajat angajat = null;
        for (Angajat a : angajati) {
            if (a.getNume().equals(name)) {
                angajat = a;
                break;
            }
        }
        if (angajat == null) {
            System.out.println("The employee does not exist");
            return;
        }

        System.out.print("Enter the new name of the employee: ");
        angajat.setNume(scanner.nextLine());

        System.out.print("Enter the new address of the employee: ");
        angajat.setAdresa(scanner.nextLine());

        System.out.print("Enter the new email of the employee: ");
        angajat.setEmail(scanner.nextLine());
    }

    private void deleteMedicine(Scanner scanner) {
        System.out.print("Enter the name of the medicine: ");
        String name = scanner.nextLine();
        Medicament medicament = null;
        for (Medicament m : medicamente) {
            if (m.getDenumire().equals(name)) {
                medicament = m;
                break;
            }
        }
        if (medicament == null) {
            System.out.println("The medicine does not exist");
            return;
        }
        medicamente.remove(medicament);
    }

    private void deleteClient(Scanner scanner) {
        System.out.print("Enter the name of the client: ");
        String name = scanner.nextLine();
        Client client = null;
        for (Client c : clienti) {
            if (c.getNume().equals(name)) {
                client = c;
                break;
            }
        }
        if (client == null) {
            System.out.println("The client does not exist");
            return;
        }
        clienti.remove(client);
    }

    private void deleteSupplier(Scanner scanner) {
        System.out.print("Enter the name of the supplier: ");
        String name = scanner.nextLine();
        Furnizor furnizor = null;
        for (Furnizor f : furnizori) {
            if (f.getNume().equals(name)) {
                furnizor = f;
                break;
            }
        }
        if (furnizor == null) {
            System.out.println("The supplier does not exist");
            return;
        }
        furnizori.remove(furnizor);
    }

    private void deleteEmployee(Scanner scanner) {
        System.out.print("Enter the name of the employee: ");
        String name = scanner.nextLine();
        Angajat angajat = null;
        for (Angajat a : angajati) {
            if (a.getNume().equals(name)) {
                angajat = a;
                break;
            }
        }
        if (angajat == null) {
            System.out.println("The employee does not exist");
            return;
        }
        angajati.remove(angajat);
    }

    private void restock(Scanner scanner) {
        System.out.print("Enter the name of the medicine: ");
        String name = scanner.nextLine();
        Medicament medicament = null;
        for (Medicament m : medicamente) {
            if (m.getDenumire().equals(name)) {
                medicament = m;
                break;
            }
        }
        if (medicament == null) {
            System.out.println("The medicine does not exist");
            return;
        }

        System.out.print("Enter the quantity of the medicine: ");
        int quantity = scanner.nextInt();
        medicament.adaugaStoc(quantity);
    }
}
