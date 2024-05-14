package repository;

import model.Fiole;

import java.util.ArrayList;
import java.util.List;

public class FioleRepositoryImpl implements FioleRepository {
    private final List<Fiole> fioleList = new ArrayList<>();

    @Override
    public Fiole find(String denumire) {
        return fioleList.stream()
                .filter(fiole -> fiole.getDenumire().equals(denumire))
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Fiole> findAll() {
        return new ArrayList<>(fioleList);
    }

    @Override
    public void save(Fiole fiole) {
        fioleList.add(fiole);
    }

    @Override
    public void update(Fiole fiole) {
        fioleList.stream()
                .filter(f -> f.getDenumire().equals(fiole.getDenumire()))
                .findFirst()
                .ifPresent(existingFiole -> {
                    // todo
                });
    }

    @Override
    public void delete(Fiole fiole) {
        fioleList.removeIf(f -> f.getDenumire().equals(fiole.getDenumire()));
    }
}