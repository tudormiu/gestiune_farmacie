package model;//medicament class with derived classes: comprimate, sirop, fiole

import java.util.Random;

public class Medicament {
    private static Random rand = new Random();
    private static int id = rand.nextInt(2147483647) + 1;
    private int idMedicament;
    private String denumire;
    private Furnizor furnizor;
    private double pret;
    private int stoc;
    private String tip;

    public Medicament(String denumire, Furnizor furnizor, double pret, int stoc, String tip) {
        id = id + 1;
        this.idMedicament = id++;
        this.denumire = denumire;
        this.furnizor = furnizor;
        this.pret = pret;
        this.stoc = stoc;
        this.tip = tip;
    }

    public Medicament(int id, String denumire, Furnizor furnizor, double pret, int stoc, String tip) {
        this.idMedicament = id;
        this.denumire = denumire;
        this.furnizor = furnizor;
        this.pret = pret;
        this.stoc = stoc;
        this.tip = tip;
    }

    public int getId() {
        return idMedicament;
    }

    public void setId(int id) {
        this.idMedicament = id;
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
        return "model.Medicament{" +
                "denumire='" + denumire + '\'' +
                ", furnizor=" + furnizor +
                ", pret=" + pret +
                ", stoc=" + stoc +
                '}';
    }

    public String getTip(){
        return tip;
    };
}