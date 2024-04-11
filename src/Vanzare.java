// lista de medicamente salvata ca tupluri - medicament, cantitate, discount
public class Vanzare {
    private Client client;
    private Angajat angajat;

    private java.util.List<Tuple> listaMedicamente;

    private double total;

    private double discount;

    public Vanzare(Client client, Angajat angajat, java.util.List<Tuple> listaMedicamente, double discount) {
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

    @Override
    public String toString() {
        return "Vanzare{" +
                "client=" + client +
                ", angajat=" + angajat +
                ", listaMedicamente=" + listaMedicamente +
                ", total=" + total +
                ", discount=" + discount +
                '}';
    }
}
