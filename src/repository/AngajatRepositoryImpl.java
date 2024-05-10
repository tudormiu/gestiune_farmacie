package repository;

import model.Angajat;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AngajatRepositoryImpl implements AngajatRepository {
    private List<Angajat> angajati = new ArrayList<>();

    @Override
    public Optional<Angajat> find(String nume, String prenume) {
        return angajati.stream()
                .filter(angajat -> angajat.getNume().equals(nume) && angajat.getPrenume().equals(prenume))
                .findFirst();
    }

    @Override
    public List<Angajat> findAll() {
        return new ArrayList<>(angajati);
    }

    @Override
    public void save(Angajat angajat) {
        angajati.add(angajat);
    }

    @Override
    public void update(Angajat angajat) {
        angajati.stream()
                .filter(a -> a.getNume().equals(angajat.getNume()) && a.getPrenume().equals(angajat.getPrenume()))
                .findFirst()
                .ifPresent(existingAngajat -> {
                    existingAngajat.setEmail(angajat.getEmail());
                    existingAngajat.setAdresa(angajat.getAdresa());
                });
    }

    @Override
    public void delete(Angajat angajat) {
        angajati.removeIf(a -> a.getNume().equals(angajat.getNume()) && a.getPrenume().equals(angajat.getPrenume()));
    }
}