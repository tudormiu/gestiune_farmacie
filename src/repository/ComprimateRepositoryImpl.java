package repository;

import model.Comprimate;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ComprimateRepositoryImpl implements ComprimateRepository {
    private final List<Comprimate> comprimateList = new ArrayList<>();

    @Override
    public Optional<Comprimate> find(String denumire) {
        return comprimateList.stream()
                .filter(comprimate -> comprimate.getDenumire().equals(denumire))
                .findFirst();
    }

    @Override
    public List<Comprimate> findAll() {
        return new ArrayList<>(comprimateList);
    }

    @Override
    public void save(Comprimate comprimate) {
        comprimateList.add(comprimate);
    }

    @Override
    public void update(Comprimate comprimate) {
        comprimateList.stream()
                .filter(c -> c.getDenumire().equals(comprimate.getDenumire()))
                .findFirst()
                .ifPresent(existingComprimate -> {
                    existingComprimate.setPret(comprimate.getPret());
                    existingComprimate.setMiligrame(comprimate.getMiligrame());
                    existingComprimate.setDenumire(comprimate.getDenumire());
                    existingComprimate.setNumarComprimate(comprimate.getNumarComprimate());
                    existingComprimate.setFurnizor(comprimate.getFurnizor());
                    existingComprimate.setStoc(comprimate.getStoc());
                });
    }

    @Override
    public void delete(Comprimate comprimate) {
        comprimateList.removeIf(c -> c.getDenumire().equals(comprimate.getDenumire()));
    }
}