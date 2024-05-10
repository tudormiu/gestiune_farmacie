package repository;

import model.Client;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ClientRepositoryImpl implements ClientRepository {
    private List<Client> clienti = new ArrayList<>();

    @Override
    public Optional<Client> find(String nume, String prenume) {
        return clienti.stream()
                .filter(client -> client.getNume().equals(nume) && client.getPrenume().equals(prenume))
                .findFirst();
    }

    @Override
    public List<Client> findAll() {
        return new ArrayList<>(clienti);
    }

    @Override
    public void save(Client client) {
        clienti.add(client);
    }

    @Override
    public void update(Client client) {
        clienti.stream()
                .filter(c -> c.getNume().equals(client.getNume()) && c.getPrenume().equals(client.getPrenume()))
                .findFirst()
                .ifPresent(existingClient -> {
                    existingClient.setTelefon(client.getTelefon());
                    existingClient.setAdresa(client.getAdresa());
                });
    }

    @Override
    public void delete(Client client) {
        clienti.removeIf(c -> c.getNume().equals(client.getNume()) && c.getPrenume().equals(client.getPrenume()));
    }
}