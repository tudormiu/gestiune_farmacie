package model;

public class Tuple {
    private Medicament medicament;
    private int cantitate;
    private double discount;

    public Tuple(Medicament medicament, int cantitate, double discount) {
        this.medicament = medicament;
        this.cantitate = cantitate;
        this.discount = discount;
    }

    public Medicament getMedicament() {
        return medicament;
    }

    public int getCantitate() {
        return cantitate;
    }

    public double getDiscount() {
        return discount;
    }

    @Override
    public String toString() {
        return "model.Tuple{" +
                "medicament=" + medicament +
                ", cantitate=" + cantitate +
                ", discount=" + discount +
                '}';
    }
}
