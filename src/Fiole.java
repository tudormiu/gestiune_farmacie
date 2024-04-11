public class Fiole extends Medicament{
    private float volum;
    int numarFiole;

    public Fiole(String denumire, Furnizor furnizor, double pret, int stoc, float volum, int numarFiole) {
        super(denumire, furnizor, pret, stoc);
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
        return "Fiole{" +
                "volum=" + volum +
                ", numarFiole=" + numarFiole +
                "} " + super.toString();
    }

    @Override
    public String getTip() {
        return "Fiole";
    }
}
