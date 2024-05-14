package model;

public record Tuple(Medicament medicament, int cantitate, double discount) {

    @Override
    public String toString() {
        return "model.Tuple{" +
                "medicament=" + medicament +
                ", cantitate=" + cantitate +
                ", discount=" + discount +
                '}';
    }
}
