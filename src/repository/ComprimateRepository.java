package repository;

import model.Comprimate;

import java.util.List;
import java.util.Optional;

public interface ComprimateRepository {
    Optional<Comprimate> find(String denumire);
    List<Comprimate> findAll();
    void save(Comprimate comprimate);
    void update(Comprimate comprimate);
    void delete(Comprimate comprimate);
}
