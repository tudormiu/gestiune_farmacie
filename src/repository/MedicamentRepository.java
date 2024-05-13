package repository;

import model.Medicament;

import java.util.List;
import java.util.Optional;

public interface MedicamentRepository {
    Optional<Medicament> find(String denumire);
    List<Medicament> findAll();
    void save(Medicament medicament);
    void update(Medicament medicament);
    void delete(Medicament medicament);
}