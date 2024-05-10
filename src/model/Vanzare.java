package model;

public class Vanzare {
    private static int counter = 0;
    private int id;
    private Client client;
    private Angajat angajat;
    private java.util.List<Tuple> listaMedicamente;
    private double total;
    private double discount;

    public Vanzare(Client client, Angajat angajat, java.util.List<Tuple> listaMedicamente, double discount) {
        this.id = ++counter;
        this.client = client;
        this.angajat = angajat;
        this.listaMedicamente = listaMedicamente;

        double tot = 0;
        for (Tuple t : listaMedicamente) {
            tot += t.getMedicament().getPret() * t.getCantitate() * (1 - t.getDiscount());
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
