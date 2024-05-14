package model;

import java.util.Random;

public class Vanzare {
    private static final Random rand = new Random();
    private static int counter = rand.nextInt(2147483647) + 1;
    private final int id;
    private final Client client;
    private final Angajat angajat;
    private final java.util.List<Tuple> listaMedicamente;
    private double total;
    private final double discount;

    public Vanzare(Client client, Angajat angajat, java.util.List<Tuple> listaMedicamente, double discount) {
        this.id = ++counter;
        this.client = client;
        this.angajat = angajat;
        this.listaMedicamente = listaMedicamente;

        double tot = 0;
        for (Tuple t : listaMedicamente) {
            if(t.medicament().getStoc() < t.cantitate())
                System.out.println("Stoc insuficient pentru medicamentul " + t.medicament().getDenumire());
            else{
                t.medicament().scadeStoc(t.cantitate());
                tot += t.medicament().getPret() * t.cantitate() * (1 - t.discount());
            }
        }

        this.total = tot;
        this.discount = discount;
        this.total *= ((100 - discount) / 100);
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "model.Vanzare{" +
                "id=" + id +
                "client=" + client +
                ", angajat=" + angajat +
                ", listaMedicamente=" + listaMedicamente +
                ", total=" + total +
                ", discount=" + discount +
                '}';
    }

    public Client getClient() {
        return client;
    }

    public Angajat getAngajat() {
        return angajat;
    }

    public java.util.List<Tuple> getListaMedicamente() {
        return listaMedicamente;
    }

    public double getTotal() {
        return total;
    }

    public double getDiscount() {
        return discount;
    }
}
