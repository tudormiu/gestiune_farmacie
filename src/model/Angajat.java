package model;

import java.util.Random;

public class Angajat {
    private static Random rand = new Random();
    private static int id = rand.nextInt(2147483647) + 1;
    private int idAngajat;
    private String nume;
    private String prenume;
    private String email;
    private String adresa;

    public Angajat(String nume, String prenume, String email, String adresa) {
        id = id+1;
        this.idAngajat = id;
        this.nume = nume;
        this.prenume = prenume;
        this.email = email;
        this.adresa = adresa;
    }

    public Angajat(int id, String nume, String prenume, String email, String adresa) {
        this.idAngajat = id;
        this.nume = nume;
        this.prenume = prenume;
        this.email = email;
        this.adresa = adresa;
    }

    public int getId() {
        return idAngajat;
    }

    public void setId(int id) {
        this.idAngajat = id;
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
