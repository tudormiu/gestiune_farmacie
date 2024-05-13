package model;

public class Fiole extends Medicament {
    private int idFiole;
    private float volum;
    int numarFiole;

    public Fiole(String denumire, Furnizor furnizor, double pret, int stoc, float volum, int numarFiole) {
        super(denumire, furnizor, pret, stoc, "Fiole");
        this.idFiole = super.getId();
        this.volum = volum;
        this.numarFiole = numarFiole;
    }

    public Fiole(int id, String denumire, Furnizor furnizor, double pret, int stoc, float volum, int numarFiole) {
        super(id, denumire, furnizor, pret, stoc, "Fiole");
        this.idFiole = id;
        this.volum = volum;
        this.numarFiole = numarFiole;
    }

    public float getVolum() {
        return volum;
    }

    public void setVolum(float volum) {
        this.volum = volum;
    }

    public int getNumarFiole() {
        return numarFiole;
    }

    public void setNumarFiole(int numarFiole) {
        this.numarFiole = numarFiole;
    }

    @Override
    public String toString() {
        return "model.Fiole{" +
                "volum=" + volum +
                ", numarFiole=" + numarFiole +
                "} " + super.toString();
    }

    @Override
    public String getTip() {
        return "model.Fiole";
    }
}
