public class Furnizor {
    private String nume;
    private String adresa;
    private String telefon;

    public Furnizor(String nume, String adresa, String telefon) {
        this.nume = nume;
        this.adresa = adresa;
        this.telefon = telefon;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    @Override
    public String toString() {
        return "Furnizor{" +
                "nume='" + nume + '\'' +
                ", adresa='" + adresa + '\'' +
                ", telefon='" + telefon + '\'' +
                '}';
    }
}
