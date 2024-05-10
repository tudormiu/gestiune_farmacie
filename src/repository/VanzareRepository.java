package repository;

import model.Vanzare;

import java.util.List;

public interface VanzareRepository {
    List<Vanzare> findAll();
    void save(Vanzare vanzare);
    void delete(Vanzare vanzare);
}
