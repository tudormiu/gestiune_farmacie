package model;

public class Angajat {
    private String nume;
    private String prenume;
    private String email;
    private String adresa;

    public Angajat() {
        this.nume = "";
        this.prenume = "";
        this.email = "";
        this.adresa = "";
    }

    public Angajat(String nume, String prenume, String email, String adresa) {
        this.nume = nume;
        this.prenume = prenume;
        this.email = email;
        this.adresa = adresa;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getPrenume() {
        return prenume;
    }

    public void setPrenume(String prenume) {
        this.prenume = prenume;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    @Override
    public String toString() {
        return "model.Angajat{" +
                "nume='" + nume + '\'' +
                ", prenume='" + prenume + '\'' +
                ", email='" + email + '\'' +
                ", adresa='" + adresa + '\'' +
                '}';
    }
}
