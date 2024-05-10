package repository;

import model.Fiole;

import java.util.List;

public interface FioleRepository {
    Fiole find(String denumire);
    List<Fiole> findAll();
    void save(Fiole fiole);
    void update(Fiole fiole);
    void delete(Fiole fiole);
}
