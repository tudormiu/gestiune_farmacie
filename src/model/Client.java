package model;

import java.util.Random;

public class Client {
    private static Random rand = new Random();
    private static int id = rand.nextInt(2147483647) + 1;
    private int idClient;
    private String nume;
    private String prenume;
    private String telefon;
    private String adresa;

    public Client(String nume, String prenume, String telefon, String adresa) {
        id = id + 1;
        System.out.println("id = " + id);
        this.idClient = id;
        this.nume = nume;
        this.prenume = prenume;
        this.telefon = telefon;
        this.adresa = adresa;
    }

    public Client(int id, String nume, String prenume, String telefon, String adresa) {
        this.idClient = id;
        this.nume = nume;
        this.prenume = prenume;
        this.telefon = telefon;
        this.adresa = adresa;
    }

    public int getId() {
        return idClient;
    }

    public void setId(int id) {
        this.idClient = id;
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

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    @Override
    public String toString() {
        return "model.Client{" +
                "nume='" + nume + '\'' +
                ", prenume='" + prenume + '\'' +
                ", telefon='" + telefon + '\'' +
                ", adresa='" + adresa + '\'' +
                '}';
    }

    public static Client defaultClient = new Client("-","-","-","-");

}
