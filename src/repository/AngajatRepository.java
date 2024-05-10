package repository;

import model.Angajat;

import java.util.List;
import java.util.Optional;

public interface AngajatRepository {
    Optional<Angajat> find(String nume, String prenume);
    List<Angajat> findAll();
    void save(Angajat angajat);
    void update(Angajat angajat);
    void delete(Angajat angajat);
}
