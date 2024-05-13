package repository;

import model.Client;

import java.util.List;
import java.util.Optional;

public interface ClientRepository {
    Optional<Client> find(String nume, String prenume);
    List<Client> findAll();
    void save(Client client);
    void update(Client client);
    void delete(Client client);
}