//medicament class with derived classes: comprimate, sirop, fiole

abstract class Medicament {
    private String denumire;
    private Furnizor furnizor;
    private double pret;
    private int stoc;

    public Medicament(String denumire, Furnizor furnizor, double pret, int stoc) {
        this.denumire = denumire;
        this.furnizor = furnizor;
        this.pret = pret;
        this.stoc = stoc;
    }

    public String getDenumire() {
        return denumire;
    }

    public void setDenumire(String denumire) {
        this.denumire = denumire;
    }

    public Furnizor getFurnizor() {
        return furnizor;
    }

    public void setFurnizor(Furnizor furnizor) {
        this.furnizor = furnizor;
    }

    public double getPret() {
        return pret;
    }

    public void setPret(double pret) {
        this.pret = pret;
    }

    public int getStoc() {
        return stoc;
    }

    public void setStoc(int stoc) {
        this.stoc = stoc;
    }

    public void adaugaStoc(int cantitate) {
        this.stoc += cantitate;
    }

    public void scadeStoc(int cantitate) {
        this.stoc -= cantitate;
    }

    public String toString() {
        return "Medicament{" +
                "denumire='" + denumire + '\'' +
                ", furnizor=" + furnizor +
                ", pret=" + pret +
                ", stoc=" + stoc +
                '}';
    }

    public abstract String getTip();
}