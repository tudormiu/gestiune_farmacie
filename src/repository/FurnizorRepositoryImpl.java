package repository;

import model.Furnizor;

import java.util.ArrayList;
import java.util.List;

public class FurnizorRepositoryImpl implements FurnizorRepository {
    private List<Furnizor> furnizorList = new ArrayList<>();

    @Override
    public Furnizor find(String nume) {
        return furnizorList.stream()
                .filter(furnizor -> furnizor.getNume().equals(nume))
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Furnizor> findAll() {
        return new ArrayList<>(furnizorList);
    }

    @Override
    public void save(Furnizor furnizor) {
        furnizorList.add(furnizor);
    }

    @Override
    public void update(Furnizor furnizor) {
        furnizorList.stream()
                .filter(f -> f.getNume().equals(furnizor.getNume()))
                .findFirst()
                .ifPresent(existingFurnizor -> {
                    existingFurnizor.setAdresa(furnizor.getAdresa());
                    existingFurnizor.setTelefon(furnizor.getTelefon());
                    // todo
                });
    }

    @Override
    public void delete(Furnizor furnizor) {
        furnizorList.removeIf(f -> f.getNume().equals(furnizor.getNume()));
    }
}