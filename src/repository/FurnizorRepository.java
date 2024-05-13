package repository;

import model.Furnizor;

import java.sql.*;
import java.util.Optional;

import java.util.List;

public interface FurnizorRepository {
    Optional<Furnizor> find(String nume);

    Furnizor findFurnizorById(int id);
    List<Furnizor> findAll();
    void save(Furnizor furnizor);
    void update(Furnizor furnizor);
    void delete(Furnizor furnizor);
}
