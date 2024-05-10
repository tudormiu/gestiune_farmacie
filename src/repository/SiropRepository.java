package repository;

import model.Sirop;

import java.util.List;

public interface SiropRepository {
    Sirop find(String denumire);
    List<Sirop> findAll();
    void save(Sirop sirop);
    void update(Sirop sirop);
    void delete(Sirop sirop);
}
