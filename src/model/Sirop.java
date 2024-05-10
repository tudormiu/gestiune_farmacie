package model;

public class Sirop extends Medicament {
    private int mililitri;

    public Sirop(String denumire, Furnizor furnizor, double pret, int stoc, int mililitri) {
        super(denumire, furnizor, pret, stoc);
        this.mililitri = mililitri;
    }

    public int getMililitri() {
        return mililitri;
    }

    public void setMililitri(int mililitri) {
        this.mililitri = mililitri;
    }

    @Override
    public String toString() {
        return "model.Sirop{" +
                "mililitri=" + mililitri +
                "} " + super.toString();
    }

    @Override
    public String getTip() {
        return "model.Sirop";
    }
}
