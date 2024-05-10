package repository;

import model.Furnizor;

import java.util.List;

public interface FurnizorRepository {
    Furnizor find(String nume);
    List<Furnizor> findAll();
    void save(Furnizor furnizor);
    void update(Furnizor furnizor);
    void delete(Furnizor furnizor);
}
