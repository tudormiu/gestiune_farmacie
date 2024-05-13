package model;

public class Comprimate extends Medicament {
    private int idComprimate;
    private int numarComprimate;
    private int miligrame;

    public Comprimate(String denumire, Furnizor furnizor, double pret, int stoc, int numarComprimate, int miligrame) {
        super(denumire, furnizor, pret, stoc, "Comprimate");
        this.numarComprimate = numarComprimate;
        this.miligrame = miligrame;
    }

    public Comprimate(int id, String denumire, Furnizor furnizor, double pret, int stoc, int numarComprimate, int miligrame) {
        super(id, denumire, furnizor, pret, stoc, "Comprimate");
        this.idComprimate = id;
        this.numarComprimate = numarComprimate;
        this.miligrame = miligrame;
    }

    public int getNumarComprimate() {
        return numarComprimate;
    }

    public void setNumarComprimate(int numarComprimate) {
        this.numarComprimate = numarComprimate;
    }

    public int getMiligrame() {
        return miligrame;
    }

    public void setMiligrame(int miligrame) {
        this.miligrame = miligrame;
    }

    @Override
    public String toString() {
        return "model.Comprimate{" +
                "numarComprimate=" + numarComprimate +
                ", miligrame=" + miligrame +
                "} " + super.toString();
    }

    @Override
    public String getTip() {
        return "model.Comprimate";
    }
}
