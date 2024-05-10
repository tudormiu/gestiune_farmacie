package repository;

import model.Medicament;

import java.util.List;

public interface MedicamentRepository {
    Medicament find(String denumire);
    List<Medicament> findAll();
    void save(Medicament medicament);
    void update(Medicament medicament);
    void delete(Medicament medicament);
}