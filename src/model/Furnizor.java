package model;

import java.util.Random;

public class Furnizor {
    //random id
    private static final Random rand = new Random();
    private static int id = rand.nextInt(2147483647) + 1;
    private int idFurnizor;
    private String nume;
    private String adresa;
    private String telefon;

    public Furnizor(String nume, String adresa, String telefon) {
        id = id + 1;
        this.idFurnizor = id;
        this.nume = nume;
        this.adresa = adresa;
        this.telefon = telefon;
    }

    public Furnizor(int id, String nume, String adresa, String telefon) {
        this.idFurnizor = id;
        this.nume = nume;
        this.adresa = adresa;
        this.telefon = telefon;
    }

    public int getId() {
        return idFurnizor;
    }

    public void setId(int id) {
        this.idFurnizor = id;
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
        return "model.Furnizor{" +
                "nume='" + nume + '\'' +
                ", adresa='" + adresa + '\'' +
                ", telefon='" + telefon + '\'' +
                '}';
    }
}
